/*
 * Red Pandas - https://tophatcat.dev/red-pandas
 * Copyright (C) 2016-2022 <KiriCattus>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.redpandas;

import dev.tophatcat.redpandas.client.PandaRendering;
import dev.tophatcat.redpandas.common.PandaConfig;
import dev.tophatcat.redpandas.common.PandaEvents;
import dev.tophatcat.redpandas.common.PandaRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

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
        //TODO Fix missing model animations.
        //TODO Fix missing spawn egg.
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        FMLJavaModLoadingContext fmlContext = FMLJavaModLoadingContext.get();

        IEventBus modBus = fmlContext.getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        PandaRegistry.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        if (FMLEnvironment.dist == Dist.CLIENT) {
            PandaRendering.setupRendering(modBus, forgeBus);
        }

        modLoadingContext.registerConfig(ModConfig.Type.COMMON, PandaConfig.SERVER_SPECIFICATION);
        modBus.addListener(PandaConfig::onLoad);
        modBus.addListener(PandaConfig::onReload);
        modBus.addListener(PandaRegistry::commonSetupEvent);
        modBus.addListener(PandaRegistry::attributeCreation);
        forgeBus.addListener(PandaEvents::serverAboutToStart);
        forgeBus.addListener(PandaEvents::biomeLoad);
    }

    @SuppressWarnings("deprecation")
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
            new SpawnEggItem(PandaRegistry.RED_PANDA.get(), Color.RED.getRGB(), Color.BLACK.getRGB(),
                new Item.Properties().tab(CreativeModeTab.TAB_MISC))
                .setRegistryName(MOD_ID + ":red_panda_spawn_egg"));
    }
}
