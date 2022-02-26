package dev.tophatcat.redpandas.common;

import net.minecraft.util.WeighedRandom;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.lang.reflect.Field;

public class MobSpawner extends MobSpawnSettings.SpawnerData {

    private static final Field ITEM_WEIGHT = ObfuscationReflectionHelper.findField(WeighedRandom.WeighedRandomItem.class, "weight");
    private final int weight;

    public MobSpawner(EntityType<?> type, int weight, int minCount, int maxCount) {
        super(type, weight, minCount, maxCount);
        this.weight = weight;
    }

    public void invalidate() {
        try {
            ITEM_WEIGHT.set(this, 0);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void validate() {
        try {
            ITEM_WEIGHT.set(this, weight);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
