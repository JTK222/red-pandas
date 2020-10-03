package cat.tophat.redpandas.common;

import cat.tophat.redpandas.RedPandas;
import cat.tophat.redpandas.common.entities.RedPandaEntity;
import com.google.common.collect.Sets;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.util.NonNullLazy;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.function.Predicate;

@Mod.EventBusSubscriber(modid = RedPandas.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RedPandaEvents {

    private static final NonNullLazy<MobSpawnInfo.Spawners> entry = NonNullLazy.of(() -> new MobSpawnInfo.Spawners(RedPandas.RED_PANDA_ENTITY, 4, 1, 5));
    private static final Field WEIGHT = ObfuscationReflectionHelper.findField(WeightedRandom.Item.class, "field_76292_a"); //itemWeight

    static {
        FieldUtils.removeFinalModifier(WEIGHT);
    }

    private static Predicate<ResourceLocation> allowBiome = null;
    private static int currentWeight = 0;

    @SubscribeEvent
    public static void onLoad(ModConfig.Loading event) {
        if (event.getConfig().getSpec() != PandasConfig.SERVER_SPECIFICATION) {
            return;
        }

        if (PandasConfig.SERVER.RedPandaSpawnNaturally.get()) {
            currentWeight = PandasConfig.SERVER.RedPandaSpawnWeight.get();

            if (currentWeight > 0) {
                if (PandasConfig.SERVER.BiomeWhitelist.get() != null
                        && !PandasConfig.SERVER.BiomeWhitelist.get().isEmpty()) {
                    Set<String> whitelist = Sets.newHashSet(PandasConfig.SERVER.BiomeWhitelist.get());
                    allowBiome = b -> whitelist.contains(b.toString());
                } else {
                    if (PandasConfig.SERVER.BiomeBlacklist.get() != null
                            && !PandasConfig.SERVER.BiomeBlacklist.get().isEmpty()) {
                        Set<String> blacklist = Sets.newHashSet(PandasConfig.SERVER.BiomeBlacklist.get());
                        allowBiome = b -> !blacklist.contains(b.toString());
                    }
                }
            }
        } else {
            currentWeight = 0;
        }
        try {
            WEIGHT.setInt(entry.get(), currentWeight);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> GlobalEntityTypeAttributes.put(RedPandas.RED_PANDA_ENTITY, RedPandaEntity.attributes().create()));
    }

    public static void biomeLoad(BiomeLoadingEvent event) {
        if (currentWeight > 0 && allowBiome.test(event.getName())) {
            event.getSpawns()
                    .withSpawner(EntityClassification.CREATURE, entry.get())
                    .withSpawnCost(RedPandas.RED_PANDA_ENTITY, 1, 0.2);
        }
    }
}
