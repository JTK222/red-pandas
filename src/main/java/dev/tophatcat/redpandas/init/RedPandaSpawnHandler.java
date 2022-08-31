package dev.tophatcat.redpandas.init;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class RedPandaSpawnHandler {

    public static void addSpawns(BiomeLoadingEvent event) {
        if (event.getName() != null && event.getCategory() != Biome.Category.THEEND
            || event.getCategory() != Biome.Category.NETHER) {
            if (RedPandaConfig.CONFIG.weightMultiplierRedPanda.get() > 0) {
                event.getSpawns().getSpawner(EntityClassification.CREATURE)
                    .add(new MobSpawnInfo.Spawners(
                        RedPandaRegistry.RED_PANDA.get(),
                        RedPandaConfig.CONFIG.weightMultiplierRedPanda.get(),
                        RedPandaConfig.CONFIG.minSpawnGroupRedPanda.get(),
                        RedPandaConfig.CONFIG.maxSpawnGroupRedPanda.get()
                    ));
            }
        }
    }
}
