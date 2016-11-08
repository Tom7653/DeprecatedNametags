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
package com.github.acquized.nametags.config;

import net.cubespace.Yamler.Config.Comment;
import net.cubespace.Yamler.Config.ConfigMode;
import net.cubespace.Yamler.Config.Path;
import net.cubespace.Yamler.Config.YamlConfig;

import java.io.File;

public class Config extends YamlConfig {

    // v  Nametags  v

    @Comment("Set here the prefix that should be infront of every message")
    @Path("Nametags.Prefix")
    public String prefix = "&a> &7";

    @Comment("Should the updater be enabled? The updater checks every hour for a new version")
    @Path("Nametags.Updater")
    public boolean updater = true;

    @Comment("Don't change this value unless you want to reset the Config")
    @Path("Nametags.Version")
    public String version = "2.0.0-SNAPSHOT";

    // -------------------------------------------------

    public Config(File file) {
        CONFIG_FILE = file;
        CONFIG_HEADER = new String[]{
            "  _   _                      _                  ",
            " | \\ | | __ _ _ __ ___   ___| |_ __ _  __ _ ___ ",
            " |  \\| |/ _` | '_ ` _ \\ / _ \\ __/ _` |/ _` / __|",
            " | |\\  | (_| | | | | | |  __/ || (_| | (_| \\__ \\",
            " |_| \\_|\\__,_|_| |_| |_|\\___|\\__\\__,_|\\__, |___/",
            "                                      |___/     "};
        CONFIG_MODE = ConfigMode.DEFAULT;
    }

}
