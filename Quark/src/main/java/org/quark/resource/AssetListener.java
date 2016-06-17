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
package org.quark.resource;

/**
 * <code>AssetListener</code> encapsulate an interface for listening to asset's event(s).
 */
public interface AssetListener {
    /**
     * <p>Indicate an asset is been requested</p>
     *
     * @param filename the name (as unique identifier) of the asset
     */
    void onAssetRequested(String filename);

    /**
     * <p>Indicate an asset has been loaded</p>
     *
     * @param filename the name (as unique identifier) of the asset
     */
    void onAssetLoaded(String filename);

    /**
     * <p>Indicate an asset has fail to load</p>
     *
     * @param filename the name (as unique identifier) of the asset
     */
    void onAssetFailed(String filename);

    /**
     * <p>Indicate an asset has been disposed</p>
     *
     * @param filename the name (as unique identifier) of the asset
     */
    void onAssetDisposed(String filename);
}
