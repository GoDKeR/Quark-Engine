/*
 * This file is part of Quark Engine, licensed under the APACHE License.
 *
 * Copyright (c) 2014-2016 Agustin L. Alvarez <wolftein1@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.quark.render;

import org.quark.render.shader.Shader;
import org.quark.render.shader.Uniform;
import org.quark.render.storage.Primitive;
import org.quark.render.storage.Storage;
import org.quark.render.storage.VertexDescriptor;
import org.quark.render.storage.VertexFormat;
import org.quark.render.texture.Texture;
import org.quark.render.texture.frame.Frame;
import org.quark.system.utility.ManageableManager;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * <code>Render</code> encapsulate the render module.
 *
 * @author Agustin L. Alvarez (wolftein1@gmail.com)
 */
public interface Render extends ManageableManager {
    /**
     * <code>GLES2</code> encapsulate all feature(s) supported by OpenGL ES 2.0.
     */
    interface GLES2 {
        int GL_ALWAYS = 0x0207;
        int GL_ARRAY_BUFFER = 0x8892;
        int GL_COLOR_ATTACHMENT0 = 0x8CE0;
        int GL_BACK = 0x0405;
        int GL_BYTE = 0x1400;
        int GL_CLAMP_TO_BORDER = 0x812D;
        int GL_CLAMP_TO_EDGE = 0x812F;
        int GL_DECREASE = 0x1E03;
        int GL_DECREASE_WRAP = 0x8508;
        int GL_DEPTH_ATTACHMENT = 0x8D00;
        int GL_DEPTH_COMPONENT16 = 0x81A5;
        int GL_DST_ALPHA = 0x0304;
        int GL_DST_COLOR = 0x0306;
        int GL_DYNAMIC_DRAW = 0x88E8;
        int GL_ELEMENT_ARRAY_BUFFER = 0x8893;
        int GL_EQUAL = 0x0202;
        int GL_FLOAT = 0x1406;
        int GL_FRAGMENT_SHADER = 0x8B30;
        int GL_FRONT = 0x0404;
        int GL_FRONT_BACK = 0x0408;
        int GL_FUNC_ADD = 0x8006;
        int GL_FUNC_REVERSE_SUBTRACT = 0x800B;
        int GL_FUNC_SUBTRACT = 0x800A;
        int GL_GREATER = 0x0204;
        int GL_GREATER_EQUAL = 0x0206;
        int GL_INCREMENT = 0x1E02;
        int GL_INCREMENT_WRAP = 0x8507;
        int GL_INVERT = 0x150A;
        int GL_KEEP = 0x1E00;
        int GL_LESS = 0x0201;
        int GL_LESS_EQUAL = 0x0203;
        int GL_LINEAR = 0x2601;
        int GL_LINEAR_MIPMAP_LINEAR = 0x2703;
        int GL_LINEAR_MIPMAP_NEAREST = 0x2701;
        int GL_LINES = 0x01;
        int GL_LINE_LOOP = 0x02;
        int GL_LINE_STRIP = 0x03;
        int GL_MIRRORED_REPEAT = 0x8370;
        int GL_NEAREST = 0x2600;
        int GL_NEAREST_MIPMAP_NEAREST = 0x2700;
        int GL_NEVER = 0x0200;
        int GL_NONE = -1;
        int GL_NOT_EQUAL = 0x0205;
        int GL_ONE = 0x0001;
        int GL_ONE_MINUS_DST_ALPHA = 0x0305;
        int GL_ONE_MINUS_DST_COLOR = 0x0307;
        int GL_ONE_MINUS_SRC_ALPHA = 0x0303;
        int GL_ONE_MINUS_SRC_COLOR = 0x0301;
        int GL_POINTS = 0x00;
        int GL_REPEAT = 0x2901;
        int GL_REPLACE = 0x1E01;
        int GL_RGB = 0x1907;
        int GL_RGBA = 0x1908;
        int GL_SHORT = 0x1402;
        int GL_SRC_ALPHA = 0x0302;
        int GL_SRC_COLOR = 0x0300;
        int GL_STATIC_DRAW = 0x88E4;
        int GL_STENCIL_ATTACHMENT = 0x8D20;
        int GL_STREAM_DRAW = 0x88E0;
        int GL_TEXTURE_2D = 0xDE1;
        int GL_TEXTURE_CUBE_MAP = 0x8513;
        int GL_TRIANGLES = 0x04;
        int GL_TRIANGLE_FAN = 0x05;
        int GL_TRIANGLE_STRIP = 0x06;
        int GL_UNSIGNED_BYTE = 0x1401;
        int GL_UNSIGNED_SHORT = 0x1403;
        int GL_VERTEX_SHADER = 0x8B31;
        int GL_ZERO = 0x0000;

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glEnable.xml"/>
         */
        void glEnable(int value);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glDisable.xml"/>
         */
        void glDisable(int value);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glBlendFunc.xml"/>
         */
        void glBlendFunc(int source, int destination);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glBlendEquationSeparate.xml"/>
         */
        void glBlendEquationSeparate(int rgb, int alpha);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glCullFace.xml"/>
         */
        void glCullFace(int mode);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glDepthMask.xml"/>
         */
        void glDepthMask(boolean activate);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glColorMask.xml"/>
         */
        void glColorMask(boolean red, boolean green, boolean blue, boolean alpha);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glScissor.xml"/>
         */
        void glScissor(int x1, int y1, int x2, int y2);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glStencilOpSeparate.xml"/>
         */
        void glStencilOpSeparate(int face, int stencilFail, int depthFail, int depthPass);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glStencilFuncSeparate.xml"/>
         */
        void glStencilFuncSeparate(int face, int func, int ref, int mask);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glClear.xml"/>
         */
        void glClear(int value);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glClearColor.xml"/>
         */
        void glClearColor(float red, float green, float blue, float alpha);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glViewport.xml"/>
         */
        void glViewport(int x, int y, int width, int height);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glGenTextures.xml"/>
         */
        int glGenTextures();

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glGenBuffers.xml"/>
         */
        int glGenBuffers();

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glCreateProgram.xml"/>
         */
        int glCreateProgram();

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glGenFramebuffers.xml"/>
         */
        int glGenFramebuffers();

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glGenRenderbuffers.xml"/>
         */
        int glGenRenderbuffers();

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glDeleteTextures.xml"/>
         */
        void glDeleteTextures(int name);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glDeleteBuffers.xml"/>
         */
        void glDeleteBuffers(int name);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glDeleteProgram.xml"/>
         */
        void glDeleteProgram(int name);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glDeleteFramebuffers.xml"/>
         */
        void glDeleteFramebuffers(int name);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glDeleteRenderbuffers.xml"/>
         */
        void glDeleteRenderbuffers(int name);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glActiveTexture.xml"/>
         */
        void glActiveTexture(int stage);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glBindTexture.xml"/>
         */
        void glBindTexture(int target, int name);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glBindBuffer.xml"/>
         */
        void glBindBuffer(int target, int name);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glUseProgram.xml"/>
         */
        void glUseProgram(int name);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glBindFramebuffer.xml"/>
         */
        void glBindFramebuffer(int type, int name);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glBindRenderbuffer.xml"/>
         */
        void glBindRenderbuffer(int type, int name);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glDrawArrays.xml"/>
         */
        void glDrawArrays(int primitive, long offset, long count);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glDrawElements.xml"/>
         */
        void glDrawElements(int primitive, long count, int format, long offset);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glBufferData.xml"/>
         */
        void glBufferData(int target, int size, ByteBuffer data, int usage);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glBufferSubData.xml"/>
         */
        void glBufferSubData(int target, int size, ByteBuffer data, int usage);

        /**
         * (OES_map_buffer)
         *
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glUnmapBuffer.xml"/>
         */
        void glUnmapBuffer(int target);

        /**
         * (OES_map_buffer)
         *
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glMapBuffer.xml"/>
         */
        ByteBuffer glMapBuffer(int target, int access);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glTexParameter.xml"/>
         */
        void glTexParameter(int target, int type, int value);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glTexParameter.xml"/>
         */
        void glTexParameter(int target, int type, float value);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glTexImage2D.xml"/>
         */
        void glTexImage2D(int target, int level, int internal, int width, int height, int border, int format,
                int type, ByteBuffer data);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glCompressedTexImage2D.xml"/>
         */
        void glCompressedTexImage2D(int target, int level, int internal, int width, int height,
                int border, ByteBuffer data);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glGenerateMipmap.xml"/>
         */
        void glGenerateMipmap(int target);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glFramebufferTexture2D.xml"/>
         */
        void glFramebufferTexture2D(int target, int attachment, int texture, int name, int level);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glEnableVertexAttribArray.xml"/>
         */
        void glEnableVertexAttribArray(int name);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glDisableVertexAttribArray.xml"/>
         */
        void glDisableVertexAttribArray(int name);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glGenerateMipmap.xml"/>
         */
        void glVertexAttribPointer(int name, int component, int type, boolean normalised, long offset);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glLinkProgram.xml"/>
         */
        void glLinkProgram(int name);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glGetProgram.xml"/>
         */
        int glGetProgram(int name, int property);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glDeleteShader.xml"/>
         */
        void glDeleteShader(int name);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glCreateShader.xml"/>
         */
        void glCreateShader(int name, int type);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glShaderSource.xml"/>
         */
        void glShaderSource(int name, String source);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glCompileShader.xml"/>
         */
        void glCompileShader(int name);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glAttachShader.xml"/>
         */
        void glAttachShader(int name, int shader);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glBindAttribLocation.xml"/>
         */
        void glBindAttribLocation(int name, int id, String attribute);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glGetUniformLocation.xml"/>
         */
        int glGetUniformLocation(int name, String uniform);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man/html/glRenderbufferStorage.xhtml"/>
         */
        void glRenderbufferStorage(int target, int format, int width, int height);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glUniform.xml"/>
         */
        void glUniform1f(int name, float i1);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glUniform.xml"/>
         */
        void glUniform2f(int name, float i1, float i2);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glUniform.xml"/>
         */
        void glUniform3f(int name, float i1, float i2, float i3);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glUniform.xml"/>
         */
        void glUniform4f(int name, float i1, float i2, float i3, float i4);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glUniform.xml"/>
         */
        void glUniform1fv(int name, FloatBuffer buffer);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glUniform.xml"/>
         */
        void glUniform1i(int name, int i1);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glUniform.xml"/>
         */
        void glUniform2i(int name, int i1, int i2);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glUniform.xml"/>
         */
        void glUniform3i(int name, int i1, int i2, int i3);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glUniform.xml"/>
         */
        void glUniform4i(int name, int i1, int i2, int i3, int i4);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glUniform.xml"/>
         */
        void glUniform1iv(int name, IntBuffer buffer);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glUniform.xml"/>
         */
        void glUniformMatrix3fv(int name, FloatBuffer buffer);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man2/xhtml/glUniform.xml"/>
         */
        void glUniformMatrix4fv(int name, FloatBuffer buffer);
    }

    /**
     * <code>GLES3</code> encapsulate all feature(s) supported by OpenGL ES 3.0.
     */
    interface GLES3 extends GLES2 {
        int GL_COPY_READ_BUFFER = 0x8F36;
        int GL_COPY_WRITE_BUFFER = 0x8F37;
        int GL_DEPTH_COMPONENT = 0x1902;
        int GL_DEPTH_COMPONENT24 = 0x81A6;
        int GL_DEPTH_COMPONENT32 = 0x81A7;
        int GL_DEPTH_STENCIL = 0x84F9;
        int GL_DYNAMIC_COPY = 0x88EA;
        int GL_DYNAMIC_READ = 0x88E9;
        int GL_HALF_FLOAT = 0x1406;
        int GL_INT = 0x1404;
        int GL_MAX = 0x8008;
        int GL_MIN = 0x8007;
        int GL_PIXEL_PACK_BUFFER = 0x88EB;
        int GL_PIXEL_UNPACK_BUFFER = 0x88EC;
        int GL_R16 = 0x822A;
        int GL_R16F = 0x822D;
        int GL_R32F = 0x822E;
        int GL_R8 = 0x8229;
        int GL_RED = 0x1903;
        int GL_RG = 0x8227;
        int GL_RG16 = 0x822C;
        int GL_RG16F = 0x822F;
        int GL_RG32F = 0x8230;
        int GL_RG8 = 0x822B;
        int GL_RGB16 = 0x8054;
        int GL_RGB16F = 0x881B;
        int GL_RGB32F = 0x8815;
        int GL_RGB8 = 0x8051;
        int GL_RGBA16 = 0x805B;
        int GL_RGBA16F = 0x881A;
        int GL_RGBA32F = 0x8814;
        int GL_RGBA8 = 0x8058;
        int GL_STATIC_COPY = 0x88E6;
        int GL_STATIC_READ = 0x88E5;
        int GL_STREAM_COPY = 0x88E2;
        int GL_STREAM_READ = 0x88E1;
        int GL_TEXTURE_3D = 0x806F;
        int GL_TRANSFORM_FEEDBACK_BUFFER = 0x8C8E;
        int GL_UNIFORM_BUFFER = 0x8A11;
        int GL_UNSIGNED_INT = 0x1405;

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man3/xhtml/glGenVertexArrays.xml"/>
         */
        int glGenVertexArrays();

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man3/xhtml/glDeleteVertexArrays.xml"/>
         */
        void glDeleteVertexArrays(int name);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man3/xhtml/glBindVertexArray.xml"/>
         */
        void glBindVertexArray(int name);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man3/xhtml/glMapBufferRange.xml"/>
         */
        ByteBuffer glMapBufferRange(int target, long offset, long size, int access);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man3/xhtml/glTexImage3D.xml"/>
         */
        void glTexImage3D(int target, int level, int internal, int width, int height, int depth, int border,
                int format, int type, ByteBuffer data);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man3/xhtml/glCompressedTexImage3D.xml"/>
         */
        void glCompressedTexImage3D(int target, int level, int internal, int width, int height, int depth,
                int border, ByteBuffer data);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man/html/glRenderbufferStorage.xhtml"/>
         */
        void glRenderbufferStorageMultisample(int target, int samples, int format, int width, int height);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man/html/glUniform.xhtml"/>
         */
        void glUniform1ui(int name, int i1);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man/html/glUniform.xhtml"/>
         */
        void glUniform2ui(int name, int i1, int i2);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man/html/glUniform.xhtml"/>
         */
        void glUniform3ui(int name, int i1, int i2, int i3);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man/html/glUniform.xhtml"/>
         */
        void glUniform4ui(int name, int i1, int i2, int i3, int i4);

        /**
         * @see <a href="https://www.opengl.org/sdk/docs/man/html/glUniform.xhtml"/>
         */
        void glUniform1uiv(int name, IntBuffer buffer);
    }

    /**
     * <code>GLES31</code> encapsulate all feature(s) supported by OpenGL ES 3.1.
     */
    interface GLES31 extends GLES3 {
    }

    /**
     * <code>GLES32</code> encapsulate all feature(s) supported by OpenGL ES 3.2.
     */
    interface GLES32 extends GLES31 {
        int GL_GEOMETRY_SHADER = 0x8DD9;
        int GL_LINES_ADJACENCY = 0x0A;
        int GL_LINE_STRIP_ADJACENCY = 0x0B;
        int GL_TEXTURE_BUFFER = 0x8C2A;
        int GL_TRIANGLES_ADJACENCY = 0x0C;
        int GL_TRIANGLE_STRIP_ADJACENCY = 0x0D;
    }

    /**
     * <code>GLESExtension</code> encapsulate all feature(s) supported by extension.
     */
    interface GLESExtension {
        int S3TC_RGBA_DXT1 = 0x83F1;
        int S3TC_RGBA_DXT3 = 0x83F2;
        int S3TC_RGBA_DXT5 = 0x83F3;
        int S3TC_RGB_DXT1 = 0x83F0;
    }

    /**
     * <p>Get the capabilities</p>
     *
     * @return the capabilities that contain(s) version and supported extension(s).
     */
    RenderCapabilities getCapabilities();

    /**
     * <p>Apply new states</p>
     *
     * @param states the new states (that should apply) of the render
     */
    void apply(RenderState states);

    /**
     * <p>Changes the clear colour of the render</p>
     *
     * @param red   the red component colour
     * @param green the green component colour
     * @param blue  the blue component colour
     * @param alpha the alpha component colour
     *
     * @see #clear(boolean, boolean, boolean)
     */
    void colour(float red, float green, float blue, float alpha);

    /**
     * <p>Clear the current buffer</p>
     *
     * @param colour  <code>true</code> if the color colour buffer should be clear, <code>false</code> otherwise
     * @param depth   <code>true</code> if the depth depth buffer should be clear, <code>false</code> otherwise
     * @param stencil <code>true</code> if the depth stencil buffer should be clear, <code>false</code> otherwise
     */
    void clear(boolean colour, boolean depth, boolean stencil);

    /**
     * <p>Changes the viewport's rectangle</p>
     *
     * @param x      the offset for the x coordinate of the rectangle (in pixel)
     * @param y      the offset for the y coordinate of the rectangle (in pixel)
     * @param width  the width of the rectangle (in pixel)
     * @param height the height of the rectangle (in pixel)
     */
    void viewport(int x, int y, int width, int height);

    /**
     * <p>Check if the given <code>Texture</code> is active</p>
     *
     * @param texture the texture
     *
     * @return <code>true</code> if the texture is active, <code>false</code> otherwise
     */
    boolean isActive(Texture texture);

    /**
     * <p>Check if the given <code>Texture</code> is active</p>
     *
     * @param texture the texture
     * @param stage   the texture stage
     *
     * @return <code>true</code> if the texture is active, <code>false</code> otherwise
     */
    boolean isActive(Texture texture, int stage);

    /**
     * <p>Check if the given <code>Storage</code> is active</p>
     *
     * @param storage the storage
     *
     * @return <code>true</code> if the storage is active, <code>false</code> otherwise
     */
    boolean isActive(Storage<?> storage);

    /**
     * <p>Check if the given <code>Shader</code> is active</p>
     *
     * @param shader the shader
     *
     * @return <code>true</code> if the shader is active, <code>false</code> otherwise
     */
    boolean isActive(Shader shader);

    /**
     * <p>Check if the given <code>VertexDescriptor</code> is active</p>
     *
     * @param descriptor the descriptor
     *
     * @return <code>true</code> if the descriptor is active, <code>false</code> otherwise
     */
    boolean isActive(VertexDescriptor descriptor);

    /**
     * <p>Check if the given <code>Frame</code> is active</p>
     *
     * @param frame the frame
     *
     * @return <code>true</code> if the frame is active, <code>false</code> otherwise
     */
    boolean isActive(Frame frame);

    /**
     * <p>Create the <code>Texture</code> given</p>
     *
     * @param texture the texture
     */
    void create(Texture texture);

    /**
     * <p>Create the <code>Storage</code> given</p>
     *
     * @param storage the storage
     */
    void create(Storage<?> storage);

    /**
     * <p>Create the <code>Shader</code> given</p>
     *
     * @param shader the shader
     */
    void create(Shader shader);

    /**
     * <p>Create the <code>VertexDescriptor</code> given</p>
     *
     * @param descriptor the descriptor
     */
    void create(VertexDescriptor descriptor);

    /**
     * <p>Create the <code>Frame</code> given</p>
     *
     * @param frame the frame
     */
    void create(Frame frame);

    /**
     * <p>Delete the <code>Texture</code> given</p>
     *
     * @param texture the texture
     */
    void delete(Texture texture);

    /**
     * <p>Delete the <code>Storage</code> given</p>
     *
     * @param storage the storage
     */
    void delete(Storage<?> storage);

    /**
     * <p>Delete the <code>Shader</code> given</p>
     *
     * @param shader the shader
     */
    void delete(Shader shader);

    /**
     * <p>Delete the <code>VertexDescriptor</code> given</p>
     *
     * @param descriptor the descriptor
     */
    void delete(VertexDescriptor descriptor);

    /**
     * <p>Delete the <code>Frame</code> given</p>
     *
     * @param frame the frame
     */
    void delete(Frame frame);

    /**
     * <p>Bind the <code>Texture</code> given</p>
     *
     * @param texture the texture
     */
    void acquire(Texture texture);

    /**
     * <p>Bind the <code>Texture</code> given</p>
     *
     * @param texture the texture
     * @param stage   the texture stage
     */
    void acquire(Texture texture, int stage);

    /**
     * <p>Bind the <code>Storage</code> given</p>
     *
     * @param storage the storage
     */
    void acquire(Storage<?> storage);

    /**
     * <p>Bind the <code>Shader</code> given</p>
     *
     * @param shader the shader
     */
    void acquire(Shader shader);

    /**
     * <p>Bind the <code>VertexDescriptor</code> given</p>
     *
     * @param descriptor the descriptor
     */
    void acquire(VertexDescriptor descriptor);

    /**
     * <p>Bind the <code>Frame</code> given</p>
     *
     * @param frame the frame
     */
    void acquire(Frame frame);

    /**
     * <p>Update the <code>Texture</code> given</p>
     *
     * @param texture the texture
     */
    void update(Texture texture);

    /**
     * <p>Update the <code>Storage</code> given</p>
     *
     * @param storage the storage
     */
    void update(Storage<?> storage);

    /**
     * <p>Update the <code>Uniform</code> given</p>
     *
     * @param uniform the uniform
     */
    void update(Uniform uniform);

    /**
     * <p>Update the <code>VertexDescriptor</code> given</p>
     *
     * @param descriptor the descriptor
     */
    void update(VertexDescriptor descriptor);

    /**
     * <p>Unbind the <code>Texture</code> given</p>
     *
     * @param texture the texture
     */
    void release(Texture texture);

    /**
     * <p>Unbind the <code>Texture</code> given</p>
     *
     * @param texture the texture
     * @param stage   the texture stage
     */
    void release(Texture texture, int stage);

    /**
     * <p>Unbind the <code>Storage</code> given</p>
     *
     * @param storage the storage
     */
    void release(Storage<?> storage);

    /**
     * <p>Unbind the <code>Shader</code> given</p>
     *
     * @param shader the shader
     */
    void release(Shader shader);

    /**
     * <p>Unbind the <code>VertexDescriptor</code> given</p>
     *
     * @param descriptor the descriptor
     */
    void release(VertexDescriptor descriptor);

    /**
     * <p>Unbind the <code>Frame</code> given</p>
     *
     * @param frame the frame
     */
    void release(Frame frame);

    /**
     * <p>Perform a draw operation</p>
     *
     * @param primitive the action's primitive
     * @param offset    the action's offset
     * @param count     the action's count
     */
    void draw(Primitive primitive, long offset, long count);

    /**
     * <p>Perform a draw operation using element(s)</p>
     *
     * @param primitive the action primitive
     * @param offset    the action offset
     * @param count     the action count
     * @param format    the action vertex's format(s)
     */
    void draw(Primitive primitive, long offset, long count, VertexFormat format);

    /**
     * <p>Map a <code>Storage</code></p>
     *
     * @param storage the storage
     *
     * @return a reference to the shared buffer expressed as <code>ByteBuffer</code>
     *
     * @see #unmap(Storage)
     */
    <T extends Buffer> T map(Storage<T> storage);

    /**
     * <p>Map a <code>Storage</code></p>
     *
     * @param storage the storage
     * @param access  the storage access
     *
     * @return a reference to the shared storage expressed as <code>T</code>
     *
     * @see #unmap(Storage)
     */
    <T extends Buffer> T map(Storage<T> storage, int access);

    /**
     * <p>Map a range of the <code>Storage</code></p>
     *
     * @param storage the storage
     * @param offset  the offset of the range
     * @param length  the length of the range
     *
     * @return a reference to the shared storage expressed as <code>T</code>
     *
     * @see #unmap(Storage)
     */
    <T extends Buffer> T map(Storage<T> storage, long offset, long length);

    /**
     * <p>Map a range of the <code>Storage</code></p>
     *
     * @param storage the storage
     * @param access  the buffer access
     * @param offset  the offset of the range
     * @param length  the length of the range
     *
     * @return a reference to the shared storage expressed as <code>T</code>
     *
     * @see #unmap(Storage)
     */
    <T extends Buffer> T map(Storage<T> storage, int access, long offset, long length);

    /**
     * <p>Un-map a <code>Storage</code></p>
     *
     * @param storage the storage
     *
     * @see #map(Storage)
     * @see #map(Storage, int)
     * @see #map(Storage, int, long, long)
     * @see #map(Storage, long, long)
     */
    <T extends Buffer> void unmap(Storage<T> storage);
}