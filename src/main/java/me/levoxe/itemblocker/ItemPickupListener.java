package me.levoxe.itemblocker;

import me.levoxe.itemblocker.ConfigurationManager;
import me.levoxe.itemblocker.Item_Blocker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class ItemPickupListener implements Listener {

    private ConfigurationManager configManager;

    public ItemPickupListener(ConfigurationManager configManager) {
        this.configManager = configManager;
    }

    @EventHandler
    public void onItemPickup(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if (configManager.isItemBlocked(e.getItem().getItemStack().getType().name())) {
            String itemType = e.getItem().getItemStack().getType().name();
            if (!p.hasPermission(configManager.getItemPermission(itemType))) {
                e.setCancelled(true);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "You don't have permission to pick up this item!"));
            }
        }
    }
}
