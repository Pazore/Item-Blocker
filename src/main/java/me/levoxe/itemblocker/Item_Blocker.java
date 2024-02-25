package me.levoxe.itemblocker;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Item_Blocker extends JavaPlugin {

    private ConfigurationManager configManager;
    private ItemPickupListener itemPickupListener;

    @Override
    public void onEnable() {
        FileConfiguration config = getConfig();

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        configManager = new ConfigurationManager(config);
        itemPickupListener = new ItemPickupListener(this, configManager);
        getServer().getPluginManager().registerEvents(itemPickupListener, this);
        getCommand("itemblocker").setExecutor(new ConfigReload(this));
        getLogger().info("Item_Blocker has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Item_Blocker has been disabled!");
    }

    public ItemPickupListener getItemPickupListener() {
        return itemPickupListener;
    }
}
