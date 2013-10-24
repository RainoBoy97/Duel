package me.rainoboy97.duel.utils;

import java.util.logging.Level;

import me.rainoboy97.duel.Duel;

public class Log {

	private static Duel duel;

	static {
		Log.duel = Duel.get();
	}

	public static void log(String... msgs) {
		log(Level.INFO, msgs);
	}

	public static void log(Level lvl, String... msgs) {
		for (String msg : msgs) {
			duel.getLogger().log(lvl, msg);
		}
	}

	public static void log(Exception e) {
		log(Level.WARNING, e.getMessage());
		e.printStackTrace();
	}

}