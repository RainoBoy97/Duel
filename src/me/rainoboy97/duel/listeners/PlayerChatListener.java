package me.rainoboy97.duel.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if (e.getMessage().startsWith("@") && Bukkit.getPlayer(e.getMessage().substring(1)).isOnline()) {
			Bukkit.getPlayer(e.getMessage().substring(1)).sendMessage(ChatColor.DARK_GRAY + "[From " + e.getPlayer().getDisplayName() + "] " + ChatColor.WHITE + e.getMessage().substring(Bukkit.getPlayer(e.getMessage().substring(1)).getDisplayName().length() + 1));
			e.setCancelled(true);
		}
	}

}
