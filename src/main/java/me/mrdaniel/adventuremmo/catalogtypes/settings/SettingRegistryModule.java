package me.mrdaniel.adventuremmo.catalogtypes.settings;

import org.spongepowered.api.registry.CatalogRegistryModule;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Optional;

public class SettingRegistryModule implements CatalogRegistryModule<Setting> {

	@Override
	public Optional<Setting> getById(@Nonnull final String id) {
		return Settings.of(id);
	}

	@Override
	public Collection<Setting> getAll() {
		return Settings.VALUES;
	}
}