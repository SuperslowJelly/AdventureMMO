package me.mrdaniel.adventuremmo.io.tops;

import me.mrdaniel.adventuremmo.catalogtypes.skills.SkillType;
import org.spongepowered.api.util.Tuple;

import java.util.Map;

public interface TopDatabase {

	void update(String player, SkillType skill, int level);

	Map<Integer, Tuple<String, Integer>> getTop(SkillType skill);
}