package fr.helesia.lobby.listener.player;

import fr.helesia.lobby.Main;
import fr.speccy.azclientapi.bukkit.packets.PacketConfFlag;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    public void setupPLSPPacketAZLauncher(Player player){
        // sidebar_scores : Permet de désactivé les chiffres dans le scoreboard.
        PacketConfFlag.setFlag(player, "sidebar_scores", false);
        // attack_cooldown : Permet de désactivé le cooldown attaque (si le joueur est en 1.9).
        PacketConfFlag.setFlag(player, "attack_cooldown", false);
        // sort_tab_list_by_names : Trier les joueurs en fonction de leur pseudo.
        PacketConfFlag.setFlag(player, "sort_tab_list_by_names", true);
    }

    @EventHandler
    public void join(PlayerJoinEvent e){
        e.setJoinMessage(null);
        Player player = e.getPlayer();
        setupPLSPPacketAZLauncher(player);
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
