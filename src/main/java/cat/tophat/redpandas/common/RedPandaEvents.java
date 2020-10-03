package cat.tophat.redpandas.common;

import java.util.Set;
import java.util.function.Predicate;

import com.google.common.collect.Sets;

import cat.tophat.redpandas.RedPandas;
import cat.tophat.redpandas.common.entities.RedPandaEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MobSpawnInfo.Builder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = RedPandas.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RedPandaEvents {

    private static Predicate<ResourceLocation> allowBiome = null;

    @SubscribeEvent
    public static void onLoad(ModConfig.Loading event) {
        if(event.getConfig().getSpec() != PandasConfig.SERVER_SPECIFICATION) {
            return;
        }
        if(PandasConfig.SERVER.biomeWhitelist.get() != null && !PandasConfig.SERVER.biomeWhitelist.get().isEmpty()) {
            Set<String> whitelist = Sets.newHashSet(PandasConfig.SERVER.biomeWhitelist.get());
            allowBiome = b -> whitelist.contains(b.toString());
        } else if(PandasConfig.SERVER.biomeBlacklist.get() != null && !PandasConfig.SERVER.biomeBlacklist.get().isEmpty()) {
            Set<String> blacklist = Sets.newHashSet(PandasConfig.SERVER.biomeBlacklist.get());
            allowBiome = b -> !blacklist.contains(b.toString());
        }
    }

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> GlobalEntityTypeAttributes.put(RedPandas.RED_PANDA_ENTITY, RedPandaEntity.attributes().create()));
    }

    public static void biomeLoad(BiomeLoadingEvent event) {
        if(PandasConfig.SERVER.redPandaSpawnNaturally.get() && PandasConfig.SERVER.redPandaSpawnWeight.get() > 0 && allowBiome.test(event.getName())) {
            MobSpawnInfo.Spawners entry = new MobSpawnInfo.Spawners(RedPandas.RED_PANDA_ENTITY, PandasConfig.SERVER.redPandaSpawnWeight.get(), PandasConfig.SERVER.redPandaSpawnMinGroup.get(), PandasConfig.SERVER.redPandaSpawnMaxGroup.get());
            Builder builder = event.getSpawns().withSpawner(EntityClassification.CREATURE, entry);
            if(PandasConfig.SERVER.redPandaUseSpawnCost.get()) {
                builder.withSpawnCost(RedPandas.RED_PANDA_ENTITY, PandasConfig.SERVER.redPandaSpawnCostPer.get(), PandasConfig.SERVER.redPandaSpawnCostMax.get());
            }
        }
    }
}
