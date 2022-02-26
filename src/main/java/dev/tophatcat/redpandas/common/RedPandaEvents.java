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
package dev.tophatcat.redpandas.common;

import dev.tophatcat.redpandas.RedPandas;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fmlserverevents.FMLServerAboutToStartEvent;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = RedPandas.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RedPandaEvents {

    public static Set<String> allowList, disallowList;
    public static int weight;

    @SubscribeEvent
    public static void onLoad(ModConfigEvent.Loading event) {
        allowList = new HashSet<>(PandaConfig.SERVER.biomeAllowList.get());
        disallowList = new HashSet<>(PandaConfig.SERVER.biomeDisallowList.get());
        weight = PandaConfig.SERVER.redPandaSpawnWeight.get() == -1 ? 45 : PandaConfig.SERVER.redPandaSpawnWeight.get();
    }

    @SubscribeEvent
    public static void onReload(ModConfigEvent.Reloading event) {
        allowList = new HashSet<>(PandaConfig.SERVER.biomeAllowList.get());
        disallowList = new HashSet<>(PandaConfig.SERVER.biomeDisallowList.get());
        weight = PandaConfig.SERVER.redPandaSpawnWeight.get() == -1 ? 45 : PandaConfig.SERVER.redPandaSpawnWeight.get();
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void biomeLoad(BiomeLoadingEvent event) {
        event.getSpawns().addSpawn(MobCategory.CREATURE,
            new MobSpawnSettings.SpawnerData(EntityRegistry.RED_PANDA.get(), weight, 1, 5));
    }

    @SubscribeEvent
    public static void serverAboutToStart(FMLServerAboutToStartEvent event) {
        event.getServer().registryAccess().registry(Registry.BIOME_REGISTRY).ifPresent(registry -> {
            registry.keySet().forEach(loc -> {
                registry.getOptional(loc).ifPresent(biome -> {
                    biome.getMobSettings().getMobs(MobCategory.CREATURE).unwrap().forEach(spawner -> {
                        if (spawner instanceof MobSpawner) {
                            if (allowList != null && !allowList.isEmpty()) {
                                if (!allowList.contains(loc.toString())) {
                                    ((MobSpawner) spawner).invalidate();
                                } else {
                                    ((MobSpawner) spawner).validate();
                                }
                            } else if (disallowList != null && !disallowList.isEmpty()) {
                                if (disallowList.contains(loc.toString())) {
                                    ((MobSpawner) spawner).invalidate();
                                } else {
                                    ((MobSpawner) spawner).validate();
                                }
                            }
                        }
                    });
                });
            });
        });
    }
}
