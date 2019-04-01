package me.mrdaniel.adventuremmo.commands;

import me.mrdaniel.adventuremmo.AdventureMMO;
import me.mrdaniel.adventuremmo.catalogtypes.skills.SkillType;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.entity.living.player.Player;

import javax.annotation.Nonnull;

public class CommandTop extends PlayerCommand {

	private final AdventureMMO mmo;

	public CommandTop(@Nonnull final AdventureMMO mmo) {
		this.mmo = mmo;
	}

	@Override
	public void execute(final Player p, final CommandContext args) {
		this.mmo.getMenus().sendSkillTop(p, args.<SkillType>getOne("skill").orElse(null));
	}
}