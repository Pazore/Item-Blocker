package me.levoxe.itemblocker;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigurationManager {

    private Plugin plugin;
    private FileConfiguration config;

    public ConfigurationManager(Plugin plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
        config.options().copyDefaults(true);
        saveConfig();
    }

    public boolean isItemBlocked(String itemType) {
        return config.getStringList("blockedItems").contains(itemType);
    }

    public String getItemPermission(String itemType) {
        return config.getString("permissions." + itemType);
    }

    private void saveConfig() {
        plugin.saveConfig();
    }
}
