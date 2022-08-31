package dev.tophatcat.redpandas;

import dev.tophatcat.redpandas.client.RedPandaRendering;
import dev.tophatcat.redpandas.init.RedPandaRegistry;
import dev.tophatcat.redpandas.init.RedPandaSpawnHandler;
import dev.tophatcat.redpandas.init.RedPandaConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(RedPandas.MOD_ID)
public class RedPandas {

    public static final String MOD_ID = "redpandas";

    public RedPandas() {
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        modLoadingContext.registerConfig(ModConfig.Type.SERVER, RedPandaConfig.SERVER_SPEC);
        IEventBus mod = FMLJavaModLoadingContext.get().getModEventBus(),
        forge = MinecraftForge.EVENT_BUS;
        RedPandaRegistry.ENTITIES.register(mod);
        mod.addListener(RedPandaRegistry::registerAttributes);
        mod.addListener(RedPandaRegistry::registerEntityPlacement);
        forge.addListener(RedPandaSpawnHandler::addSpawns);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            mod.addListener(RedPandaRendering::registerModels);
        }
    }
}
