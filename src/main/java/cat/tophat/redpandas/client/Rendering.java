package cat.tophat.redpandas.client;

import cat.tophat.redpandas.RedPandas;
import cat.tophat.redpandas.common.entities.RedPandaEntity;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = RedPandas.MODID)
public class Rendering {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(RedPandaEntity.class, RenderRedPanda::new);
    }
}
