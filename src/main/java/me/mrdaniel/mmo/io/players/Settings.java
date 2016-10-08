package me.mrdaniel.mmo.io.players;

import me.mrdaniel.mmo.enums.Setting;
import me.mrdaniel.mmo.io.Config;

public class Settings {
	
	private boolean sounds;
	private boolean effects;
	private boolean scoreboard;
	private boolean scoreboardPermanent;
	
	public Settings(boolean sounds, boolean effects, boolean scoreboard, boolean scoreboardPermanent) {
		this.sounds = sounds;
		this.effects = effects;
		this.scoreboard = scoreboard;
		this.scoreboardPermanent = scoreboardPermanent;
		
		if (Config.getInstance().FORCEDSETTINGS.containsKey(Setting.SOUNDS)) { this.sounds = Config.getInstance().FORCEDSETTINGS.get(Setting.SOUNDS); }
		if (Config.getInstance().FORCEDSETTINGS.containsKey(Setting.EFFECTS)) { this.effects = Config.getInstance().FORCEDSETTINGS.get(Setting.EFFECTS); }
		if (Config.getInstance().FORCEDSETTINGS.containsKey(Setting.SCOREBOARD)) { this.scoreboard = Config.getInstance().FORCEDSETTINGS.get(Setting.SCOREBOARD); }
		if (Config.getInstance().FORCEDSETTINGS.containsKey(Setting.SCOREBOARDPERMANENT)) { this.scoreboardPermanent = Config.getInstance().FORCEDSETTINGS.get(Setting.SCOREBOARDPERMANENT); }
	}
	
	/**
	 * Get a new default Settings instance.
	 * 
	 * @return Settings playerSettings 
	 * Default Settings
	 */
	public Settings() {
		this.sounds = true;
		this.effects = true;
		this.scoreboard = true;
		this.scoreboardPermanent = false;
		
		if (Config.getInstance().FORCEDSETTINGS.containsKey(Setting.SOUNDS)) { this.sounds = Config.getInstance().FORCEDSETTINGS.get(Setting.SOUNDS); }
		if (Config.getInstance().FORCEDSETTINGS.containsKey(Setting.EFFECTS)) { this.effects = Config.getInstance().FORCEDSETTINGS.get(Setting.EFFECTS); }
		if (Config.getInstance().FORCEDSETTINGS.containsKey(Setting.SCOREBOARD)) { this.scoreboard = Config.getInstance().FORCEDSETTINGS.get(Setting.SCOREBOARD); }
		if (Config.getInstance().FORCEDSETTINGS.containsKey(Setting.SCOREBOARDPERMANENT)) { this.scoreboardPermanent = Config.getInstance().FORCEDSETTINGS.get(Setting.SCOREBOARDPERMANENT); }
	}
	
	/**
	 * Set a setting for a player
	 * 
	 * @param Setting setting
	 * Which setting to set
	 * 
	 * @param boolean value
	 * Value of what to set the Setting
	 */
	public void setSetting(Setting setting, boolean value) {
		if (setting == Setting.EFFECTS) { effects = value; }
		else if (setting == Setting.SOUNDS) { sounds = value; }
		else if (setting == Setting.SCOREBOARD) { scoreboard = value; }
		else if (setting == Setting.SCOREBOARDPERMANENT) { scoreboardPermanent = value; }
	}
	
	/**
	 * Get a setting from a player
	 * 
	 * @param Setting setting
	 * Which setting to set
	 * 
	 * @return boolean value
	 * Value of the Setting
	 */
	public boolean getSetting(Setting setting) {
		if (setting == Setting.EFFECTS) { return effects; }
		else if (setting == Setting.SOUNDS) { return sounds; }
		else if (setting == Setting.SCOREBOARD) { return scoreboard; }
		else if (setting == Setting.SCOREBOARDPERMANENT) { return scoreboardPermanent; }
		return true;
	}
	
	/**
	 * Serialize the Settings into an boolean[].
	 * 
	 * @return boolean[] serialized Settings. 
	 * Returns the serialized Settings.
	 */
	public boolean[] serialize() {
		return new boolean[]{sounds, effects, scoreboard, scoreboardPermanent};
	}
	
	/**
	 * Deserialize the boolean[] into a Settings.
	 * Automatically updates Settings from old versions.
	 * 
	 * @return Settings deserialized boolean[].
	 * Returns the deserialized boolean[].
	 */
	public static Settings deserialize(boolean[] sRaw) {
		if (sRaw.length != new Settings().serialize().length) { return update(sRaw); }
		return new Settings(sRaw[0], sRaw[1], sRaw[2], sRaw[3]);
	}
	
	private static Settings update(boolean[] sRawOld) {
		boolean[] sRaw = new Settings().serialize();
		int lowest = (sRaw.length > sRawOld.length) ? sRawOld.length : sRaw.length;
		
		for (int i = 0; i < lowest; i++) {
			sRaw[i] = sRawOld[i];
		}
		return deserialize(sRaw);
	}
}