package me.levoxe.itemblocker;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ItemPickupListener implements Listener {
    private final JavaPlugin plugin;
    private ConfigurationManager configManager;

    public ItemPickupListener(JavaPlugin plugin, ConfigurationManager configManager) {
        this.plugin = plugin;
        this.configManager = configManager;
    }

    @EventHandler
    public void onItemPickup(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        if (configManager.isItemBlocked(event.getItem().getItemStack().getType().name())) {
            String itemType = event.getItem().getItemStack().getType().name();
            if (!player.hasPermission(configManager.getItemPermission(itemType))) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', configManager.getNoPermissionMessage()));
            }
        }
    }

    public void setConfigManager(ConfigurationManager configManager) {
        this.configManager = configManager;
    }
}
