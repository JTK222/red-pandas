package dev.tophatcat.redpandas;

import dev.tophatcat.redpandas.common.EntityRegistry;
import dev.tophatcat.redpandas.common.PandaConfig;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;

import java.awt.Color;

@Mod(RedPandas.MOD_ID)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class RedPandas {

    /**
     * This is the mod's ID used for registering things and identifying the mod.
     */
    public static final String MOD_ID = "redpandas";

    /**
     * Setup the mod.
     */
    public RedPandas() {
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, PandaConfig.SERVER_SPECIFICATION);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
            new SpawnEggItem(EntityRegistry.RED_PANDA.get(), Color.RED.getRGB(), Color.BLACK.getRGB(),
                new Item.Properties().tab(CreativeModeTab.TAB_MISC))
                .setRegistryName(MOD_ID + ":red_panda_spawn_egg"));
    }
}
