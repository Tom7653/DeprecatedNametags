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
package com.github.acquized.nametags;

import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;

import static org.bukkit.ChatColor.GRAY;
import static org.bukkit.ChatColor.GREEN;

public class Nametags extends JavaPlugin {

    public static String prefix = GREEN + "> " + GRAY;
    @Getter private static Nametags instance;
    @Getter private Logger log = LoggerFactory.getLogger(Nametags.class);

    @Override
    public void onEnable() {
        instance = this;
        log.info("Nametags v{} has been enabled.", getDescription().getVersion());
    }

    @Override
    public void onDisable() {
        instance = null;
        log.info("Nametags v{} has been disabled.", getDescription().getVersion());
    }

}
