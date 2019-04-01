package me.mrdaniel.adventuremmo.commands;

import me.mrdaniel.adventuremmo.AdventureMMO;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.entity.living.player.Player;

import javax.annotation.Nonnull;

public class CommandSettings extends PlayerCommand {

	private final AdventureMMO mmo;

	public CommandSettings(@Nonnull final AdventureMMO mmo) {
		this.mmo = mmo;
	}

	@Override
	public void execute(final Player p, final CommandContext args) {
		this.mmo.getMenus().sendSettingsInfo(p);
	}
}