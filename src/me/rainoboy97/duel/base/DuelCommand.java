package me.rainoboy97.duel.base;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import me.rainoboy97.duel.Duel;
import me.rainoboy97.duel.utils.Log;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public abstract class DuelCommand extends Command {

	private Duel plugin;

	@SuppressWarnings("unused") private String command;

	private static String VERSION;

	static {
		String path = Bukkit.getServer().getClass().getPackage().getName();
		DuelCommand.VERSION = path.substring(path.lastIndexOf(".") + 1, path.length());
	}

	public DuelCommand(String command, String description, String... aliases) {
		super(command);
		this.plugin = Duel.get();
		this.command = command;
		super.setDescription(description);
		List<String> aliasList = new ArrayList<String>();
		for (String alias : aliases) {
			aliasList.add(alias);
		}
		super.setAliases(aliasList);
		this.registerCmd();
	}

	public void registerCmd() {
		try {
			Field f = Class.forName("org.bukkit.craftbukkit." + DuelCommand.VERSION + ".CraftServer").getDeclaredField("commandMap");
			f.setAccessible(true);
			CommandMap map = (CommandMap) f.get(Bukkit.getServer());
			map.register(this.plugin.getName(), this);
		} catch (Exception e) {
			Log.log(e);
		}
	}

	public abstract void cmd(CommandSender sender, String[] args);

	public boolean execute(CommandSender cs, String label, String[] args) {
		this.cmd(cs, args);
		return true;
	}

	public boolean isPlayer(CommandSender sender) {
		return sender instanceof Player;
	}

	public boolean isConsole(CommandSender sender) {
		return sender instanceof ConsoleCommandSender;
	}

}
