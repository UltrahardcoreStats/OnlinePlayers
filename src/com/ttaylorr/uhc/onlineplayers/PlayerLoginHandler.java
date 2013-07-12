package com.ttaylorr.uhc.onlineplayers;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class PlayerLoginHandler implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerLogin(PlayerLoginEvent event) {
		boolean isBanned = false;
		for(OfflinePlayer player : OnlinePlayers.getBukkitServer().getBannedPlayers()) {
			if(event.getPlayer().equals(player)) {
				isBanned = true;
				break;
			}
		}
		if(!isBanned) {
			if (Bukkit.getOnlinePlayers().length <= OnlinePlayers.getGameMaxPlayers()) {
				if (OnlinePlayers.getBukkitServer().hasWhitelist()) {
					boolean isOnWhitelist = false;
					for (OfflinePlayer player : OnlinePlayers.getBukkitServer().getWhitelistedPlayers()) {
						if (event.getPlayer().equals(player)) {
							isOnWhitelist = true;
							break;
						}
					}
					if(isOnWhitelist) {
						event.allow();
					} else {
						event.disallow(Result.KICK_WHITELIST, "You are not whitelisted on this server!");
					}
				} else {
					event.allow();
				}
			} else {
				event.disallow(Result.KICK_FULL, "The server is full!");
			}			
		} else {
			event.disallow(Result.KICK_BANNED, "You are banned on this server!");
		}
	}
}
