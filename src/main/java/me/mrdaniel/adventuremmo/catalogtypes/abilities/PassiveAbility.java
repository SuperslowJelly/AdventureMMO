package me.mrdaniel.adventuremmo.catalogtypes.abilities;

import me.mrdaniel.adventuremmo.utils.Texts;
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
	public String getValueLine(int level) {
		return "Chance&7: &d" + String.format("%.2f", this.getValue(level)) + "%";
	}
}