package me.mrdaniel.adventuremmo.catalogtypes.tools;

import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.util.annotation.NonnullByDefault;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Optional;

@NonnullByDefault
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