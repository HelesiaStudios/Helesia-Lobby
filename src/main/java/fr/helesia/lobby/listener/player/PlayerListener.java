package fr.helesia.lobby.listener.player;

import fr.helesia.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent e){
        e.setJoinMessage(null);
        Player player = e.getPlayer();
        Main.getInstance().getScoreboardManager().onLogin(player);
    }

    @EventHandler
    public void quit(PlayerQuitEvent e){
        e.setQuitMessage(null);
        Player player = e.getPlayer();
        Main.getInstance().getScoreboardManager().onLogout(player);
    }

    @EventHandler
    public void chat(PlayerChatEvent e){
        e.setCancelled(true);
        String rank = "§cOwner";
        Bukkit.broadcastMessage(rank + " " + e.getPlayer().getName() + "§f: " + e.getMessage());
    }
}
