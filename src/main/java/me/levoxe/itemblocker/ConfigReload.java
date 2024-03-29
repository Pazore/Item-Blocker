package me.levoxe.itemblocker;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ConfigReload implements CommandExecutor {

    private final Item_Blocker plugin;

    public ConfigReload(Item_Blocker plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can execute this command!");
            return true;
        }

        Player p = (Player) sender;

        if (!p.hasPermission("itemblocker.reload")) {
            p.sendMessage(ChatColor.RED + "You do not have permission to run this command!");
            return true;
        } else {
            if (args.length == 0){
                p.sendMessage(ChatColor.RED + "Error: /itemblocker reload");
            } else if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                p.sendMessage(ChatColor.GREEN + "Item-Blocker by Mevune has been reloaded!");
            }
        }

        plugin.reloadConfig();

        ConfigurationManager configManager = new ConfigurationManager(plugin.getConfig());
        plugin.getItemPickupListener().setConfigManager(configManager);

        return true;
    }
}
