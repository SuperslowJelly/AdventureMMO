package me.mrdaniel.adventuremmo.catalogtypes.abilities;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import javax.annotation.Nonnull;

public class PassiveAbility extends Ability {

	public PassiveAbility(@Nonnull final String name, @Nonnull final String id) {
		super(name, id);
	}

	public boolean getChance(final int level) {
		return super.getValue(level) > Math.random() * 100;
	}

	@Override
	public Text getValueLine(int level) {
		return Text.of(TextColors.YELLOW, "Chance: ", String.format("%.2f", super.getValue(level)), "%");
	}
}