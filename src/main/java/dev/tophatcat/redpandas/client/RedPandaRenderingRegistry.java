package dev.tophatcat.redpandas.client;

import dev.tophatcat.redpandas.RedPandas;
import dev.tophatcat.redpandas.client.rendering.RenderRedPanda;
import dev.tophatcat.redpandas.common.EntityRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD, modid = RedPandas.MOD_ID)
public class RedPandaRenderingRegistry {

    @SubscribeEvent
    public static void registerEntityModels(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityRegistry.RED_PANDA.get(), RenderRedPanda::new);
    }
}
