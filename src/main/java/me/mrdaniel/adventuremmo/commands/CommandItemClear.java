package me.mrdaniel.adventuremmo.commands;

import me.mrdaniel.adventuremmo.AdventureMMO;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import javax.annotation.Nonnull;
import java.util.Optional;

public class CommandItemClear extends PlayerCommand {

	private final AdventureMMO mmo;

	public CommandItemClear(@Nonnull final AdventureMMO mmo) {
		this.mmo = mmo;
	}

	@Override
	public void execute(final Player p, final CommandContext args) {
		Optional<ItemStack> hand = p.getItemInHand(HandTypes.MAIN_HAND);
		if (!hand.isPresent()) {
			p.sendMessage(Text.of(TextColors.RED, "You must be holding an item to use this command"));
			return;
		}

		ItemType item = hand.get().getType();

		this.mmo.getItemDatabase().remove(item);
		this.mmo.getMessages().sendItemClear(p, item);
	}
}