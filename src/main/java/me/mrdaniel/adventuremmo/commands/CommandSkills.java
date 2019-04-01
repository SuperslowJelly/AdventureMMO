package me.mrdaniel.adventuremmo.commands;

import me.mrdaniel.adventuremmo.AdventureMMO;
import me.mrdaniel.adventuremmo.catalogtypes.skills.SkillType;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.entity.living.player.Player;

import javax.annotation.Nonnull;
import java.util.Optional;

public class CommandSkills extends PlayerCommand {

	private final AdventureMMO mmo;

	public CommandSkills(@Nonnull final AdventureMMO mmo) {
		this.mmo = mmo;
	}

	@Override
	public void execute(final Player p, final CommandContext args) {
		Optional<SkillType> skill = args.getOne("skill");

		if (!skill.isPresent()) {
			this.mmo.getMenus().sendSkillList(p);
		} else {
			this.mmo.getMenus().sendSkillInfo(p, skill.get());
		}
	}
}