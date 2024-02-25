package me.levoxe.itemblocker;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigurationManager {

    private final FileConfiguration config;

    public ConfigurationManager(FileConfiguration config) {
        this.config = config;
    }

    // Method to check if an item is blocked
    public boolean isItemBlocked(String itemName) {
        return config.getStringList("blockedItems").contains(itemName);
    }

    // Method to get the permission required for an item
    public String getItemPermission(String itemName) {
        return config.getString("permissions." + itemName);
    }

    // Method to get the no-permission message from the config
    public String getNoPermissionMessage() {
        return config.getString("no-permission");
    }
}
