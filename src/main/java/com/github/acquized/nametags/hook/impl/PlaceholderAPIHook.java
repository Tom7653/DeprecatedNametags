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

import com.github.acquized.nametags.Nametags;
import com.github.acquized.nametags.hook.Hook;

import org.bukkit.entity.Player;

import me.clip.placeholderapi.PlaceholderAPI;

public class PlaceholderAPIHook implements Hook {

    @Override
    public void setup() {
        Nametags.getInstance().getLog().info("Using PlaceholderAPI Hook as plugin has been found.");
    }

    @Override
    public String replace(Player p, String s) {
        return PlaceholderAPI.setPlaceholders(p, s);
    }

    @Override
    public void shutdown() {}

}
