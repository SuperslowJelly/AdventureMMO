package me.mrdaniel.adventuremmo.data.manipulators;

import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder;
import org.spongepowered.api.data.persistence.AbstractDataBuilder;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.util.annotation.NonnullByDefault;

import javax.annotation.Nonnull;
import java.util.Optional;

@NonnullByDefault
public class SuperToolDataBuilder extends AbstractDataBuilder<SuperToolData>
		implements DataManipulatorBuilder<SuperToolData, ImmutableSuperToolData> {

	public SuperToolDataBuilder() {
		super(SuperToolData.class, 1);
	}

	@Override
	public SuperToolData create() {
		return new SuperToolData();
	}

	@Override
	public Optional<SuperToolData> createFrom(@Nonnull DataHolder dataHolder) {
		return create().fill(dataHolder);
	}

	@Override
	protected Optional<SuperToolData> buildContent(@Nonnull DataView view) throws InvalidDataException {
		return create().from(view);
	}
}