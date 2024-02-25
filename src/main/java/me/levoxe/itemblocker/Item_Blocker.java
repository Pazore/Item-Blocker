package me.levoxe.itemblocker;

import me.levoxe.itemblocker.ConfigurationManager;
import me.levoxe.itemblocker.ItemPickupListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Item_Blocker extends JavaPlugin {

    private ConfigurationManager configManager;

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        configManager = new ConfigurationManager(this);
        ItemPickupListener listener = new ItemPickupListener(configManager);
        getServer().getPluginManager().registerEvents(listener, this);
        getLogger().info("Item_Blocker has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Item_Blocker has been disabled!");
    }
}
