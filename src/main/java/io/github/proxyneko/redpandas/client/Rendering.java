package io.github.proxyneko.redpandas.client;

import io.github.proxyneko.redpandas.RedPandas;
import io.github.proxyneko.redpandas.common.entities.RedPandaEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(value = Dist.CLIENT, bus = Bus.MOD, modid = RedPandas.MODID)
public class Rendering {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(RedPandas.RED_PANDA_ENTITY, RenderRedPanda::new);
    }
}
