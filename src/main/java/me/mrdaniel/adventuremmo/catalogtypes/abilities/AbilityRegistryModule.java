package me.mrdaniel.adventuremmo.catalogtypes.abilities;

import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.util.annotation.NonnullByDefault;

import java.util.Collection;
import java.util.Optional;

@NonnullByDefault
public class AbilityRegistryModule implements CatalogRegistryModule<Ability> {

	@Override
	public Optional<Ability> getById(final String id) {
		return Abilities.of(id);
	}

	@Override
	public Collection<Ability> getAll() {
		return Abilities.VALUES;
	}
}