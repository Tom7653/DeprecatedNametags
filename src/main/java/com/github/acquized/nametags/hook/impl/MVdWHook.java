/* Copyright 2016 Acquized
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.acquized.nametags.hook.impl;

import com.github.acquized.nametags.hook.Hook;

import org.bukkit.entity.Player;

public class MVdWHook implements Hook {

    // The MVdW PlaceholderAPI maven repository is offline - it looks like he also isn't active on SpigotMC
    // I will add support as soon as the maven repo is back up and there is any sign of live of maxim

    @Override
    public void setup() {
        throw new RuntimeException("MVdW PlaceholderAPI is no longer supported.");
    }

    @Override
    public String replace(Player p, String s) {
        throw new RuntimeException("MVdW PlaceholderAPI is no longer supported.");
    }

    @Override
    public void shutdown() {
        throw new RuntimeException("MVdW PlaceholderAPI is no longer supported.");
    }

}
