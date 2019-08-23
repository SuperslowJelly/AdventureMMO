package me.mrdaniel.adventuremmo.event;

import me.mrdaniel.adventuremmo.AdventureMMO;
import me.mrdaniel.adventuremmo.catalogtypes.tools.ToolType;
import me.mrdaniel.adventuremmo.io.items.BlockData;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;
import org.spongepowered.api.event.impl.AbstractEvent;
import org.spongepowered.api.util.annotation.NonnullByDefault;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@NonnullByDefault
public class BreakBlockEvent extends AbstractEvent {

	private final Player player;
	private final Location<World> location;
	private final BlockData block;
	private final ToolType tool;

	private final Cause cause;

	public BreakBlockEvent(final AdventureMMO mmo, final Player player,
			final Location<World> location, final BlockData block, final ToolType tool) {
		this.player = player;
		this.location = location;
		this.block = block;
		this.tool = tool;

		this.cause = Cause.builder().append(mmo.getContainer()).build(EventContext.empty());
	}

	@Nonnull
	public Player getPlayer() {
		return this.player;
	}

	@Nonnull
	public Location<World> getLocation() {
		return this.location;
	}

	@Nonnull
	public BlockData getBlock() {
		return this.block;
	}

	@Nullable
	public ToolType getTool() {
		return this.tool;
	}

	@Override
	public Cause getCause() {
		return this.cause;
	}
}