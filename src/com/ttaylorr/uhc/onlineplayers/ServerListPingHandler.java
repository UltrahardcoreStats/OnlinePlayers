package com.ttaylorr.uhc.onlineplayers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListPingHandler implements Listener {
	@EventHandler
	public void onServerListPing(ServerListPingEvent event) {
		event.setMaxPlayers(OnlinePlayers.getServerListMaxPlayers());
	}
}