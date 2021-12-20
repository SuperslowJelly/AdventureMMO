package me.mrdaniel.adventuremmo.io.playerdata;

import me.mrdaniel.adventuremmo.AdventureMMO;
import me.mrdaniel.adventuremmo.catalogtypes.skills.SkillType;
import me.mrdaniel.adventuremmo.event.LevelUpEvent;
import me.mrdaniel.adventuremmo.utils.MathUtils;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.permission.SubjectData;

import javax.annotation.Nonnull;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public interface PlayerDatabase {

	void unload(UUID uuid);

	void unloadAll();

	PlayerData get(UUID uuid);

	Optional<PlayerData> getOffline(UUID uuid);

	default PlayerData addExp(@Nonnull final AdventureMMO mmo, @Nonnull final Player p, @Nonnull final SkillType skill,
			int exp) {
		PlayerData data = this.get(p.getUniqueId());

		HashMap<String, String> meta = getMeta(p);
		if (metaContainsKey(meta, "mcmmo-booster")) {
			if (ChronoUnit.SECONDS.between(Instant.now(), Instant.parse(getMetaValue(meta, "mcmmo-booster"))) > 0) {
				exp *= 2;
			} else {
				try { setMeta(p, "mcmmo-booster", null);
				} catch (ExecutionException | InterruptedException e) {
					e.printStackTrace();
					exp /= 2;
				}
			}
		}

		int current_level = data.getLevel(skill);
		int current_exp = data.getExp(skill);
		int new_exp = current_exp + exp;
		int exp_till_next_level = MathUtils.expTillNextLevel(current_level);

		if (new_exp >= exp_till_next_level) {
			if (!mmo.getGame().getEventManager()
					.post(new LevelUpEvent(mmo, p, skill, current_level, current_level + 1))) {
				data.setLevel(skill, current_level + 1);
				new_exp -= exp_till_next_level;
			}
		}
		data.setExp(skill, new_exp);
		return data;
	}

	static boolean setMeta(final Player PLAYER, final String KEY, final Object VALUE) throws ExecutionException, InterruptedException {
		return PLAYER.getSubjectData().setOption(SubjectData.GLOBAL_CONTEXT, KEY, String.valueOf(VALUE)).get();
	}

	static boolean metaContainsKey(final HashMap<String, String> META, final String KEY) {
		return META.containsKey(KEY);
	}

	public static String getMetaValue(final HashMap<String, String> META, final String KEY) {
		return META.get(KEY);
	}

	public static HashMap<String, String> getMeta(final Player PLAYER) {
		return new HashMap<>(PLAYER.getSubjectData().getOptions(SubjectData.GLOBAL_CONTEXT));
	}
}