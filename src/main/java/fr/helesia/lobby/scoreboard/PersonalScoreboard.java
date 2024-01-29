package fr.helesia.lobby.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
 
import java.util.UUID;
 
/*
 * This file is part of SamaGamesAPI.
 *
 * SamaGamesAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SamaGamesAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SamaGamesAPI.  If not, see <http://www.gnu.org/licenses/>.
 */
public class PersonalScoreboard {
    private Player player;
    private final UUID uuid;
    private final ObjectiveSign objectiveSign;
 
    PersonalScoreboard(Player player){
        this.player = player;
        uuid = player.getUniqueId();
        objectiveSign = new ObjectiveSign("sidebar", "DevPlugin");
 
        reloadData();
        objectiveSign.addReceiver(player);
    }
 
    public void reloadData(){}
 
    public void setLines(String ip){
        objectiveSign.setDisplayName("§e❖ §6§lHelesia §e❖");
 
        objectiveSign.setLine(0, "§1");
        objectiveSign.setLine(1, "§8➵ §7Compte: §f" + player.getName());
        objectiveSign.setLine(2, "§8➵ §7Rang: §cOwner");
        objectiveSign.setLine(3, "§2");
        objectiveSign.setLine(4, "§8➵ §7Coins: §60 ⛃");
        objectiveSign.setLine(5, "§8➵ §7Cristaux: §b0 ❦");
        objectiveSign.setLine(6, "§3");
        objectiveSign.setLine(7, "§8➵ §7Lobby: §a#1 §7(§e" + Bukkit.getOnlinePlayers().size() + "§7)");
        objectiveSign.setLine(8, "§8➵ §7Connectés: §a" + Bukkit.getOnlinePlayers().size());
        objectiveSign.setLine(9, "§4");
        objectiveSign.setLine(10, ip);
 
        objectiveSign.updateLines();
    }
 
    public void onLogout(){
        objectiveSign.removeReceiver(Bukkit.getServer().getOfflinePlayer(uuid));
    }
}