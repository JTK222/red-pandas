package io.github.proxyneko.redpandas;

import io.github.proxyneko.redpandas.common.PandasConfig;
import io.github.proxyneko.redpandas.common.entities.RedPandaEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

@Mod(RedPandas.MODID)
@EventBusSubscriber(bus = Bus.MOD)
public class RedPandas {

    public static final String MODID = "redpandas";
    private static final Logger LOGGER = LogManager.getLogger("Red Pandas");

    public RedPandas() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::fingerprintViolation);
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        modLoadingContext.registerConfig(ModConfig.Type.SERVER, PandasConfig.SERVER_SPECIFICATION);
    }

    private void fingerprintViolation(FMLFingerprintViolationEvent event) {
        LOGGER.warn("Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been " +
                "tampered with. This version will NOT be supported! Please download the mod from CurseForge for a " +
                "supported and signed version of the mod.");
    }

    public static final EntityType<RedPandaEntity> RED_PANDA_ENTITY = (EntityType<RedPandaEntity>)
            EntityType.Builder.create(RedPandaEntity::new, EntityClassification.CREATURE)
                    .size(0.90F, 0.60F)
                    .setTrackingRange(80)
                    .setUpdateInterval(1)
                    .setShouldReceiveVelocityUpdates(true)
                    .build(RedPandas.MODID + ":red_panda")
                    .setRegistryName(new ResourceLocation(RedPandas.MODID, "red_panda"));

    @SubscribeEvent
    public static void registerEntity(RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().register(RED_PANDA_ENTITY);

        EntitySpawnPlacementRegistry.register(RED_PANDA_ENTITY,
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, CreatureEntity::canSpawnOn);
    }

    @SubscribeEvent
    public static void onItemRegistry(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new SpawnEggItem(RED_PANDA_ENTITY, Color.RED.getRGB(), Color.BLACK.getRGB(),
                new Item.Properties().group(ItemGroup.MISC)).setRegistryName(MODID + ":red_panda_spawn_egg"));
    }
}
