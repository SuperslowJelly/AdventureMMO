package me.mrdaniel.adventuremmo.catalogtypes.skills;

import org.spongepowered.api.registry.CatalogRegistryModule;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Optional;

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