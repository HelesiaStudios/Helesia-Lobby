package fr.helesia.lobby.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {
    String emoji = "§8➵";
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("spawn")){
            sender.sendMessage("§8➵ §fTu as été téléporté au §bspawn§f.");
        }
        return false;
    }
}
