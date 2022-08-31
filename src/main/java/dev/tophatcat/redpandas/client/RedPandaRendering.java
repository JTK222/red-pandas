package dev.tophatcat.redpandas.client;

import dev.tophatcat.redpandas.init.RedPandaRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class RedPandaRendering {

    public static void registerModels(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(RedPandaRegistry.RED_PANDA.get(), RedPandaRenderer::new);
    }
}
