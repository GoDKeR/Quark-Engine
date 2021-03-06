/*
 * This file is part of Quark Framework, licensed under the APACHE License.
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
package ar.com.quark;

import ar.com.quark.audio.AudioManager;
import ar.com.quark.render.Render;
import ar.com.quark.resource.AssetManager;
import ar.com.quark.system.Display;
import ar.com.quark.input.InputManager;

/**
 * <code>Quark</code> encapsulate a singleton for the entire framework.
 */
public final class Quark {
    /**
     * Hold the {@link AudioManager} implementation.
     *
     * @see AudioManager
     */
    public static AudioManager QKAudio;

    /**
     * Hold the {@link Display} implementation.
     *
     * @see Display
     */
    public static Display QKDisplay;

    /**
     * Hold the {@link InputManager} implementation.
     *
     * @see InputManager
     */
    public static InputManager QKInput;

    /**
     * Hold the {@link Render} implementation.
     *
     * @see Render
     */
    public static Render QKRender;

    /**
     * Hold the {@link AssetManager} implementation.
     *
     * @see AssetManager
     */
    public static AssetManager QKResources;
}
