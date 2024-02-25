package me.levoxe.itemblocker;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigurationManager {

    private final FileConfiguration config;

    public ConfigurationManager(FileConfiguration config) {
        this.config = config;
    }

    public boolean isItemBlocked(String itemName) {
        return config.getStringList("blockedItems").contains(itemName);
    }

    public String getItemPermission(String itemName) {
        return config.getString("permissions." + itemName);
    }

    public String getNoPermissionMessage() {
        return config.getString("no-permission");
    }
}
