package me.mrdaniel.adventuremmo.data.manipulators;

import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder;
import org.spongepowered.api.data.persistence.AbstractDataBuilder;
import org.spongepowered.api.data.persistence.InvalidDataException;

import javax.annotation.Nonnull;
import java.util.Optional;

public class MMODataBuilder extends AbstractDataBuilder<MMOData>
		implements DataManipulatorBuilder<MMOData, ImmutableMMOData> {

	public MMODataBuilder() {
		super(MMOData.class, 1);
	}

	@Override
	public MMOData create() {
		return new MMOData();
	}

	@Override
	public Optional<MMOData> createFrom(@Nonnull DataHolder dataHolder) {
		return create().fill(dataHolder);
	}

	@Override
	protected Optional<MMOData> buildContent(@Nonnull DataView view) throws InvalidDataException {
		return create().from(view);
	}
}