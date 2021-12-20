package me.mrdaniel.adventuremmo.commands;

import me.mrdaniel.adventuremmo.AdventureMMO;
import me.mrdaniel.adventuremmo.MMOObject;
import me.mrdaniel.adventuremmo.io.playerdata.PlayerData;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.service.permission.SubjectData;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.util.annotation.NonnullByDefault;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

@NonnullByDefault
public class CommandSetMultiplier extends MMOObject implements CommandExecutor {

	public CommandSetMultiplier(@Nonnull final AdventureMMO mmo) {
		super(mmo);
	}

	@Override
	public CommandResult execute(final CommandSource src, final CommandContext args) throws CommandException {
		User user = args.<User>getOne("user").orElse(null);

		if (user == null) throw new CommandException(Text.of(TextColors.RED, "Invalid User!"));

		try { setMeta(user, "mcmmo-multiplier", 604800);
		} catch (ExecutionException | InterruptedException e) {
			e.printStackTrace();
		}

		src.sendMessage(Text.of(TextColors.GREEN, "Successfully set " + user.getName() + "'s MCMMO multiplier!"));

		return CommandResult.success();
	}

	static void setMeta(final User USER, final String KEY, final Object VALUE) throws ExecutionException, InterruptedException {
		USER.getSubjectData().setOption(SubjectData.GLOBAL_CONTEXT, KEY, String.valueOf(VALUE)).get();
	}
}