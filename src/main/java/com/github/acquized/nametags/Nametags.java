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


import com.github.acquized.nametags.config.Config;
import com.github.acquized.nametags.update.Updater;
import com.github.acquized.nametags.utils.Metrics;

import net.cubespace.Yamler.Config.InvalidConfigurationException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import lombok.Getter;

import static org.bukkit.ChatColor.GRAY;
import static org.bukkit.ChatColor.GREEN;

public class Nametags extends JavaPlugin {

    public static String prefix = GREEN + "> " + GRAY;
    @Getter private static Nametags instance;
    @Getter private Logger log = LoggerFactory.getLogger(Nametags.class);
    @Getter private Config conf;

    @Override
    public void onEnable() {
        instance = this;
        if(!areDependenciesInstalled()) {
            log.error("Could not load ProtocolLib or Vault. Please install both plugins and restart the server.");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        loadConfigs();
        prefix = ChatColor.translateAlternateColorCodes('&', conf.prefix);
        // packet setup (protocollib)
        // vault hooking
        // api setup
        registerListeners(Bukkit.getPluginManager());
        registerCommands();
        log.info("Nametags v{} has been enabled.", getDescription().getVersion());
        try {
            Metrics metrics = new Metrics(this);
            addCustomGraphs(metrics);
        } catch (Exception ex) {
            log.warn("Could not submit data to bStats.org", ex);
        }
        if(conf.updater)
            Updater.start();
    }

    @Override
    public void onDisable() {
        instance = null;
        log.info("Nametags v{} has been disabled.", getDescription().getVersion());
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void loadConfigs() {
        // config.yml
        try {
            File file = new File(getDataFolder(), "config.yml");
            conf = new Config(file);
            conf.init();
            if (!conf.version.equalsIgnoreCase(getDescription().getVersion())) {
                file.delete();
                conf.init();
            }
        } catch (InvalidConfigurationException ex) {
            log.error("Could not load config.yml file - Please check for errors", ex);
        }

    }

    private boolean areDependenciesInstalled() {
        return (Bukkit.getPluginManager().isPluginEnabled("ProtocolLib")) && (Bukkit.getPluginManager().isPluginEnabled("Vault"));
    }

    private void registerListeners(PluginManager pm) {

    }

    private void registerCommands() {

    }

    private void addCustomGraphs(Metrics metrics) {

    }

}
