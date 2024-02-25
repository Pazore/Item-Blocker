package me.levoxe.itemblocker;

import me.levoxe.itemblocker.ConfigurationManager;
import me.levoxe.itemblocker.ItemPickupListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Item_Blocker extends JavaPlugin {

    private ConfigurationManager configManager;

    @Override
    public void onEnable() {
        configManager = new ConfigurationManager(this);
        // Pass the plugin instance and configuration manager to the ItemPickupListener constructor
        getServer().getPluginManager().registerEvents(new ItemPickupListener(this, configManager), this);
        getLogger().info("Item_Blocker has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Item_Blocker has been disabled!");
    }
}
