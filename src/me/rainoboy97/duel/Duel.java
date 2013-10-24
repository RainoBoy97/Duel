package me.rainoboy97.duel;

import org.bukkit.plugin.java.JavaPlugin;

public class Duel extends JavaPlugin {

	private static Duel _i;

	public void onDisable() {

	}

	public void onEnable() {
		this.registerCommands();
	}

	private void registerCommands() {
		//Register command with this format:
		//new <classname>();
	}

	public void onLoad() {
		Duel._i = this;
	}

	public static Duel get() {
		return _i;
	}

}
