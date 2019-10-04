package com.mcmoddev.redpandas.client;

import com.mcmoddev.redpandas.RedPandas;
import com.mcmoddev.redpandas.common.entities.RedPandaEntity;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(value = Side.CLIENT, modid = RedPandas.MODID)
public class Rendering {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(RedPandaEntity.class, RenderRedPanda::new);
    }
}
