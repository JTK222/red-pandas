package dev.tophatcat.redpandas;

import dev.tophatcat.redpandas.client.RedPandaRendering;
import dev.tophatcat.redpandas.init.RedPandaRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(RedPandas.MOD_ID)
public class RedPandas {

    public static final String MOD_ID = "redpandas";

    public RedPandas() {
        IEventBus mod = FMLJavaModLoadingContext.get().getModEventBus();
        RedPandaRegistry.ENTITIES.register(mod);
        RedPandaRegistry.ITEMS.register(mod);
        mod.addListener(RedPandaRegistry::registerAttributes);
        mod.addListener(RedPandaRegistry::registerEntityPlacement);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            mod.addListener(RedPandaRendering::registerEntityRendering);
            mod.addListener(RedPandaRendering::registerLayers);
        }
        System.out.println(ForgeRegistries.BIOMES.getEntries());
    }
}
