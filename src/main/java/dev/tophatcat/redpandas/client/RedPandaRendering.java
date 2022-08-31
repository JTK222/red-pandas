package dev.tophatcat.redpandas.client;

import dev.tophatcat.redpandas.init.RedPandaRegistry;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class RedPandaRendering {

    public static void registerEntityRendering(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(RedPandaRegistry.RED_PANDA.get(), RedPandaRenderer::new);
    }

    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(RedPandaModel.LAYER_LOCATION, RedPandaModel::createBodyLayer);
    }
}
