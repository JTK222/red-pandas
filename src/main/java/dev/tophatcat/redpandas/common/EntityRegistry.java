package dev.tophatcat.redpandas.common;

import dev.tophatcat.redpandas.RedPandas;
import dev.tophatcat.redpandas.common.entities.RedPandaEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


@Mod.EventBusSubscriber(modid = RedPandas.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRegistry {

    public static final DeferredRegister<EntityType<?>> ENTITIES
        = DeferredRegister.create(ForgeRegistries.ENTITIES, RedPandas.MOD_ID);

    /**
     * Set up the Red Panda entity.
     */
    public static final RegistryObject<EntityType<RedPandaEntity>> RED_PANDA
        = ENTITIES.register("red_panda",
        () -> EntityType.Builder.of(RedPandaEntity::new, MobCategory.CREATURE)
            .sized(0.90F, 0.60F)
            .setTrackingRange(80)
            .setUpdateInterval(1)
            .setShouldReceiveVelocityUpdates(true)
            .build(RedPandas.MOD_ID + ":red_panda"));

    /**
     * Setup spawn placement.
     */
    @SubscribeEvent
    public static void common(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(RED_PANDA.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        });
    }

    /**
     * Register the mobs and spawn placements.
     */
    @SubscribeEvent
    public static void attributeCreation(EntityAttributeCreationEvent event) {
        event.put(RED_PANDA.get(), RedPandaEntity.prepareAttributes().build());
    }
}
