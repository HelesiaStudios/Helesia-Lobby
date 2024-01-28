package fr.helesia.lobby.listener.player;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent e){
        e.setJoinMessage(null);
    }

    @EventHandler
    public void quit(PlayerQuitEvent e){
        e.setQuitMessage(null);
    }

    @EventHandler
    public void chat(PlayerChatEvent e){
        e.setCancelled(true);
        String rank = "§cOwner";
        Bukkit.broadcastMessage(rank + " " + e.getPlayer().getName() + "§f: " + e.getMessage());
    }
}
