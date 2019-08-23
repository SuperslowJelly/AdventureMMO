package me.mrdaniel.adventuremmo.catalogtypes.skills;

import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.util.annotation.NonnullByDefault;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Optional;

@NonnullByDefault
public class SkillTypeRegistryModule implements CatalogRegistryModule<SkillType> {

	@Override
	public Optional<SkillType> getById(@Nonnull final String id) {
		return SkillTypes.of(id);
	}

	@Override
	public Collection<SkillType> getAll() {
		return SkillTypes.VALUES;
	}
}