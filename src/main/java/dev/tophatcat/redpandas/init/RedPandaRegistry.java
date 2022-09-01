package dev.tophatcat.redpandas.init;

import dev.tophatcat.redpandas.RedPandas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RedPandaRegistry {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(
        ForgeRegistries.ENTITY_TYPES, RedPandas.MOD_ID);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
        ForgeRegistries.ITEMS, RedPandas.MOD_ID);

    public static final RegistryObject<EntityType<RedPanda>> RED_PANDA = ENTITIES.register(
        "red_panda", () -> EntityType.Builder.of(RedPanda::new,
                MobCategory.CREATURE)
            .sized(0.90F, 0.60F)
            .setTrackingRange(80)
            .setUpdateInterval(1)
            .setShouldReceiveVelocityUpdates(true)
            .build(new ResourceLocation(RedPandas.MOD_ID, "red_panda").toString())
    );

    private static final RegistryObject<SpawnEggItem> RED_PANDA_SPAWN_EGG = ITEMS.register(
        "red_panda_spawn_egg", () -> new ForgeSpawnEggItem(RED_PANDA,
            0xFF4500, 0x000000, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
    );

    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(RED_PANDA.get(), RedPanda.redPandaAttributes().build());
    }

    public static void registerEntityPlacement(FMLCommonSetupEvent event) {
        SpawnPlacements.register(RedPandaRegistry.RED_PANDA.get(),
            SpawnPlacements.Type.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
    }
}
