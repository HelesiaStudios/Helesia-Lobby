package fr.helesia.lobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {
    String emojiAZ = "\uD83D\uDD36";
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("aide")){
            sender.sendMessage("§6§m----------------------");
            sender.sendMessage(emojiAZ + " §b/aide §f: Ouvrir l'aide de commande.");
            sender.sendMessage("§6§m----------------------");
        }
        return false;
    }
}
