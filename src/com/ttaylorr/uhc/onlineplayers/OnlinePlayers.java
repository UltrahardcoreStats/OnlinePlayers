package com.ttaylorr.uhc.onlineplayers;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class OnlinePlayers extends JavaPlugin {
	public static OnlinePlayers instance;
	public static PluginManager pluginManager;
	public static int serverListMaxPlayers;
	public static int gameMaxPlayers;
	
	public static Server server;
	
	public static Server getBukkitServer() {
		return server;
	}
	
	public static int getServerListMaxPlayers() {
		return serverListMaxPlayers;
	}

	public static int getGameMaxPlayers() {
		return gameMaxPlayers;
	}

	public static OnlinePlayers getInstance() {
		return instance;
	}
	
	@Override
	public void onDisable() {
		
	}

	
	@Override
	public void onEnable() {
		server = this.getServer();
		
		instance = this;
		
		this.saveDefaultConfig();
		this.getConfig().options().copyDefaults(true);
		
		try {
			serverListMaxPlayers = Integer.parseInt(getConfig().getString("serverlist-maxplayers"));
			gameMaxPlayers = Integer.parseInt(getConfig().getString("game-maxplayers"));			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		pluginManager = Bukkit.getServer().getPluginManager();
		pluginManager.registerEvents(new ServerListPingHandler(), this); //
		pluginManager.registerEvents(new PlayerLoginHandler(), this); //

	}

	
}
