package me.mrdaniel.adventuremmo.catalogtypes.settings;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

import javax.annotation.Nonnull;

@CatalogedBy(Settings.class)
public class Setting implements CatalogType {

	private final String name;
	private final String id;

	Setting(@Nonnull final String name, @Nonnull final String id) {
		this.name = name;
		this.id = id;
	}

	@Override
	@Nonnull
	public String getName() {
		return this.name;
	}

	@Override
	@Nonnull
	public String getId() {
		return this.id;
	}
}