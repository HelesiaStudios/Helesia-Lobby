package fr.helesia.lobby.listener.player;

import fr.helesia.lobby.Main;
import fr.helesia.lobby.utils.ItemBuilder;
import fr.helesia.lobby.utils.TitleManager;
import fr.speccy.azclientapi.bukkit.packets.PacketConfFlag;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerListener implements Listener {

    public void setupPLSPPacketAZLauncher(Player player){
        // sidebar_scores : Permet de désactivé les chiffres dans le scoreboard.
        PacketConfFlag.setFlag(player, "sidebar_scores", true);
        // attack_cooldown : Permet de désactivé le cooldown attaque (si le joueur est en 1.9).
        PacketConfFlag.setFlag(player, "attack_cooldown", false);
        // sort_tab_list_by_names : Trier les joueurs en fonction de leur pseudo.
        PacketConfFlag.setFlag(player, "sort_tab_list_by_names", true);
    }

    public void giveItem(Player player){
        ItemStack compass = new ItemBuilder(Material.COMPASS).setName("§8❖ §cNavigateur §8❖").toItemStack();

        player.getInventory().setItem(0, compass);
    }

    @EventHandler
    public void join(PlayerJoinEvent e){
        e.setJoinMessage(null);
        Player player = e.getPlayer();
        setupPLSPPacketAZLauncher(player);
        giveItem(player);
        TitleManager.sendActionBar(player, "§8❖ §eBienvenue §cOwner " + player.getName() + " §8❖");
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
