package me.mrdaniel.adventuremmo.catalogtypes.tools;

import org.spongepowered.api.registry.CatalogRegistryModule;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Optional;

public class ToolTypeRegistryModule implements CatalogRegistryModule<ToolType> {

	@Override
	public Optional<ToolType> getById(@Nonnull final String id) {
		return ToolTypes.of(id);
	}

	@Override
	public Collection<ToolType> getAll() {
		return ToolTypes.VALUES;
	}
}