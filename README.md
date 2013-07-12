OnlinePlayers
=============

### What is OnlinePlayers?

OnlinePlayers is a Bukkit plugin written by [ttaylorr](http://reddit.com/u/ttaylorr) that allows for the spoofing of max player size on Minecraft servers that otherwise could not change their player size.  For example, Minecraft servers that are bought from from hosting companies that impose a player limit are now able to be changed.

### Configuration Options

OnlinePlayers comes with a very simple set of configuration options.  There are only two values to be set in the config.yml, which may be found in .../plugins/OnlinePlayers/config.yml.  The values are layed out below:

- 'serverlist-maxplayers': This value is the max player value that will be shown in a user's Multiplayer Tab.
- 'game-maxplayers': This value will be used ingame to calculate if a user may log in or not.  Think of this as the actual maxplayers on your server.  Typically this and the above values are the same.

### Other

Please note, the game-maxplayers may not be set above your host's limit.  However, the serverlist-maxplayers may be set to whatever you want, regardless of hosting limitations.  One thing to bear in mind, some hosting companies disallow this sort of modification in their Terms of Service.  I am not responsible for any loss, termination, or suspension of your service(s).  Use at your own risk.
