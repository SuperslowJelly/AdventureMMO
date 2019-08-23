package me.mrdaniel.adventuremmo.commands;

import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.util.annotation.NonnullByDefault;

@NonnullByDefault
public abstract class PlayerCommand implements CommandExecutor {

	@Override
	public CommandResult execute(final CommandSource src, final CommandContext args) {
		if (!(src instanceof Player)) {
			src.sendMessage(Text.of(TextColors.RED, "This commands is for players only."));
			return CommandResult.success();
		}
		Player p = (Player) src;

		this.execute(p, args);
		return CommandResult.success();
	}

	public abstract void execute(Player p, CommandContext args);
}