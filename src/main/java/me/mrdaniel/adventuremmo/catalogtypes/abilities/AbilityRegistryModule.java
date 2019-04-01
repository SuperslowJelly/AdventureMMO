package me.mrdaniel.adventuremmo.catalogtypes.abilities;

import org.spongepowered.api.registry.CatalogRegistryModule;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Optional;

public class AbilityRegistryModule implements CatalogRegistryModule<Ability> {

	@Override
	public Optional<Ability> getById(@Nonnull final String id) {
		return Abilities.of(id);
	}

	@Override
	public Collection<Ability> getAll() {
		return Abilities.VALUES;
	}
}