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
package org.quark.engine.media.opengl.shader;

/**
 * <code>UniformType</code> enumerates {@link Uniform} type(s).
 *
 * @author Agustin L. Alvarez (wolftein1@gmail.com)
 */
public enum UniformType {
    /**
     * Represent an IEEE-754 single-precision floating point number.
     * <p>
     * {@since OpenGL   2.1}
     * {@since OpenGLSL 1.20}
     */
    Float,

    /**
     * Represent two IEEE-754 single-precision floating point number.
     * <p>
     * {@since OpenGL   2.1}
     * {@since OpenGLSL 1.20}
     */
    Float2,

    /**
     * Represent three IEEE-754 single-precision floating point number.
     * <p>
     * {@since OpenGL   2.1}
     * {@since OpenGLSL 1.20}
     */
    Float3,

    /**
     * Represent four IEEE-754 single-precision floating point number.
     * <p>
     * {@since OpenGL   2.1}
     * {@since OpenGLSL 1.20}
     */
    Float4,

    /**
     * Represent an array of {@linkplain #Float}
     * <p>
     * {@since OpenGL   2.1}
     * {@since OpenGLSL 1.30}
     */
    FloatArray,

    /**
     * Represent a signed, two's complement, 32-bit integer.
     * <p>
     * {@since OpenGL   2.1}
     * {@since OpenGLSL 1.20}
     */
    Integer,

    /**
     * Represent two signed, two's complement, 32-bit integer.
     * <p>
     * {@since OpenGL   2.1}
     * {@since OpenGLSL 1.20}
     */
    Integer2,

    /**
     * Represent three signed, two's complement, 32-bit integer.
     * <p>
     * {@since OpenGL   2.1}
     * {@since OpenGLSL 1.20}
     */
    Integer3,

    /**
     * Represent four signed, two's complement, 32-bit integer.
     * <p>
     * {@since OpenGL   2.1}
     * {@since OpenGLSL 1.20}
     */
    Integer4,

    /**
     * Represent an array of {@linkplain #Integer}
     * <p>
     * {@since OpenGL   2.1}
     * {@since OpenGLSL 1.20}
     */
    IntegerArray,

    /**
     * Represent a signed, two's complement, 32-bit unsigned integer.
     * <p>
     * {@since OpenGL   3.0}
     * {@since OpenGLSL 1.30}
     */
    UnsignedInteger,

    /**
     * Represent two signed, two's complement, 32-bit unsigned integer.
     * <p>
     * {@since OpenGL   3.0}
     * {@since OpenGLSL 1.30}
     */
    UnsignedInteger2,

    /**
     * Represent three signed, two's complement, 32-bit unsigned integer.
     * <p>
     * {@since OpenGL   3.0}
     * {@since OpenGLSL 1.30}
     */
    UnsignedInteger3,

    /**
     * Represent four signed, two's complement, 32-bit unsigned integer.
     * <p>
     * {@since OpenGL   3.0}
     * {@since OpenGLSL 1.30}
     */
    UnsignedInteger4,

    /**
     * Represent an array of {@linkplain #UnsignedInteger}
     * <p>
     * {@since OpenGL   3.0}
     * {@since OpenGLSL 1.30}
     */
    UnsignedIntegerArray,

    /**
     * Represent a matrix of 3x3 component(s).
     * <p>
     * {@since OpenGL   2.1}
     * {@since OpenGLSL 1.20}
     */
    Matrix3f,

    /**
     * Represent a matrix of 4x4 component(s).
     * <p>
     * {@since OpenGL   2.1}
     * {@since OpenGLSL 1.20}
     */
    Matrix4f
}