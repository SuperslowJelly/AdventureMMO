package me.mrdaniel.adventuremmo.io.items;

import me.mrdaniel.adventuremmo.catalogtypes.skills.SkillType;
import me.mrdaniel.adventuremmo.catalogtypes.tools.ToolType;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

public interface ItemDatabase {

	Optional<BlockData> getData(BlockType type);

	Optional<ToolData> getData(ItemType type);

	Optional<ToolData> getData(@Nullable ItemStack item);

	void set(ItemType item, @Nonnull ToolType one);

	void set(BlockType block, SkillType skill, int exp);

	void remove(ItemType item);

	void remove(BlockType block);
}