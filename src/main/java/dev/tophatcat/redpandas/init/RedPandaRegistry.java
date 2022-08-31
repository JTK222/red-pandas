package dev.tophatcat.redpandas.init;

import dev.tophatcat.redpandas.RedPandas;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RedPandaRegistry {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(
        ForgeRegistries.ENTITIES, RedPandas.MOD_ID);

    public static final RegistryObject<EntityType<RedPanda>> RED_PANDA = ENTITIES.register(
        "red_panda", () -> EntityType.Builder.of(RedPanda::new,
                EntityClassification.CREATURE)
            .sized(0.90F, 0.60F)
            .setTrackingRange(80)
            .setUpdateInterval(1)
            .setShouldReceiveVelocityUpdates(true)
            .build(new ResourceLocation(RedPandas.MOD_ID, "red_panda").toString())
    );

    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(RED_PANDA.get(), RedPanda.redPandaAttributes().build());
    }

    public static void registerEntityPlacement(FMLCommonSetupEvent event) {
        EntitySpawnPlacementRegistry.register(RedPandaRegistry.RED_PANDA.get(),
            EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, CreatureEntity::checkMobSpawnRules);
    }
}
