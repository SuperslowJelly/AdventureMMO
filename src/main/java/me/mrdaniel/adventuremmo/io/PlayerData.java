package me.mrdaniel.adventuremmo.io;

import me.mrdaniel.adventuremmo.catalogtypes.skills.SkillType;

public interface PlayerData {

	public int getLevels();
	public int getLevel(SkillType skill);
	public void setLevel(SkillType skill, int level);
	public void addLevel(SkillType skill, int level);

	public int getExp(SkillType skill);
	public void setExp(SkillType skill, int exp);
	public void addExp(SkillType skill, int exp);
}