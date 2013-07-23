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
	public static String serverMOTD;

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

	public static String getServerMOTD() {
		return serverMOTD;
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
			serverMOTD = getConfig().getString("server-motd");

			// Special symbols
			serverMOTD = serverMOTD.replace((CharSequence) "^lpd", (CharSequence) "\u00BB");
			serverMOTD = serverMOTD.replace((CharSequence) "^rpd", (CharSequence) "\u00AB");

			// Color codes
			serverMOTD = serverMOTD.replace((CharSequence) "^4", (CharSequence) "\u00A74");
			serverMOTD = serverMOTD.replace((CharSequence) "^c", (CharSequence) "\u00A7c");
			serverMOTD = serverMOTD.replace((CharSequence) "^6", (CharSequence) "\u00A76");
			serverMOTD = serverMOTD.replace((CharSequence) "^e", (CharSequence) "\u00A7e");
			serverMOTD = serverMOTD.replace((CharSequence) "^2", (CharSequence) "\u00A72");
			serverMOTD = serverMOTD.replace((CharSequence) "^a", (CharSequence) "\u00A7a");
			serverMOTD = serverMOTD.replace((CharSequence) "^b", (CharSequence) "\u00A7b");
			serverMOTD = serverMOTD.replace((CharSequence) "^3", (CharSequence) "\u00A73");
			serverMOTD = serverMOTD.replace((CharSequence) "^1", (CharSequence) "\u00A71");
			serverMOTD = serverMOTD.replace((CharSequence) "^9", (CharSequence) "\u00A79");
			serverMOTD = serverMOTD.replace((CharSequence) "^d", (CharSequence) "\u00A7d");
			serverMOTD = serverMOTD.replace((CharSequence) "^5", (CharSequence) "\u00A75");
			serverMOTD = serverMOTD.replace((CharSequence) "^f", (CharSequence) "\u00A7f");
			serverMOTD = serverMOTD.replace((CharSequence) "^7", (CharSequence) "\u00A77");
			serverMOTD = serverMOTD.replace((CharSequence) "^8", (CharSequence) "\u00A78");
			serverMOTD = serverMOTD.replace((CharSequence) "^0", (CharSequence) "\u00A70");

			// Formatting codes
			serverMOTD = serverMOTD.replace((CharSequence) "^L", (CharSequence) "\u00A7L");
			serverMOTD = serverMOTD.replace((CharSequence) "^o", (CharSequence) "\u00A7o");
			serverMOTD = serverMOTD.replace((CharSequence) "^n", (CharSequence) "\u00A7n");
			serverMOTD = serverMOTD.replace((CharSequence) "^m", (CharSequence) "\u00A7m");
			serverMOTD = serverMOTD.replace((CharSequence) "^k", (CharSequence) "\u00A7k");
			serverMOTD = serverMOTD.replace((CharSequence) "^R", (CharSequence) "\u00A7R");

		} catch (Exception e) {
			e.printStackTrace();
		}

		pluginManager = Bukkit.getServer().getPluginManager();
		pluginManager.registerEvents(new ServerListPingHandler(), this); //
		pluginManager.registerEvents(new PlayerLoginHandler(), this); //

	}

}
