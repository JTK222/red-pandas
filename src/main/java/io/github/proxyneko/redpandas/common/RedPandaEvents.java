package io.github.proxyneko.redpandas.common;

import com.google.common.collect.Sets;
import io.github.proxyneko.redpandas.RedPandas;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = RedPandas.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RedPandaEvents {

    private static Collection<Biome> biomes = null;
    private static Biome.SpawnListEntry entry = null;

    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void onLoad(ModConfig.Loading event) {
        if (event.getConfig().getSpec() != PandasConfig.SERVER_SPECIFICATION) {
            return;
        }

        if (entry != null) {
            biomes.stream().map(biome -> biome.getSpawns(EntityClassification.MONSTER)).forEach(list ->
                    list.remove(entry));
            biomes = Collections.emptyList();
        }

        if (PandasConfig.SERVER.RedPandaSpawnNaturally.get()) {
            int currentWeight = PandasConfig.SERVER.RedPandaSpawnWeight.get();

            if (currentWeight > 0) {
                biomes = ForgeRegistries.BIOMES.getValues();
                if (PandasConfig.SERVER.BiomeWhitelist.get() != null && PandasConfig.SERVER.BiomeWhitelist.get().size() > 0) {
                    Set<String> whitelist = Sets.newHashSet(PandasConfig.SERVER.BiomeWhitelist.get());
                    biomes = biomes.stream().filter(b ->
                            whitelist.contains(b.getRegistryName().toString())).collect(Collectors.toList());
                } else {
                    if (PandasConfig.SERVER.BiomeBlacklist.get() != null && PandasConfig.SERVER.BiomeBlacklist.get().size() > 0) {
                        Set<String> blacklist = Sets.newHashSet(PandasConfig.SERVER.BiomeBlacklist.get());
                        biomes = biomes.stream().filter(b ->
                                !blacklist.contains(b.getRegistryName().toString())).collect(Collectors.toList());
                    }
                }

                entry = new Biome.SpawnListEntry(RedPandas.RED_PANDA_ENTITY,
                        PandasConfig.SERVER.RedPandaSpawnWeight.get(), 1, 5);
                biomes.stream().map(biome -> biome.getSpawns(EntityClassification.CREATURE)).forEach(list ->
                        list.add(entry));
            }
        }
    }
}
