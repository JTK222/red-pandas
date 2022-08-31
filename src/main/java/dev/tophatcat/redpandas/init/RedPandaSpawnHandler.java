package dev.tophatcat.redpandas.init;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class RedPandaSpawnHandler {

    public static void addSpawns(BiomeLoadingEvent event) {
        if (event.getName() != null && event.getCategory() != Biome.BiomeCategory.THEEND
            || event.getCategory() != Biome.BiomeCategory.NETHER) {
            if (RedPandaConfig.CONFIG.weightMultiplierRedPanda.get() > 0) {
                event.getSpawns().getSpawner(MobCategory.CREATURE)
                    .add(new MobSpawnSettings.SpawnerData(
                        RedPandaRegistry.RED_PANDA.get(),
                        RedPandaConfig.CONFIG.weightMultiplierRedPanda.get(),
                        RedPandaConfig.CONFIG.minSpawnGroupRedPanda.get(),
                        RedPandaConfig.CONFIG.maxSpawnGroupRedPanda.get()
                    ));
            }
        }
    }
}
