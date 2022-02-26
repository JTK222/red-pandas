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

import net.minecraft.core.Registry;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fmlserverevents.FMLServerAboutToStartEvent;

public class PandaEvents {

    public static void biomeLoad(BiomeLoadingEvent event) {
        event.getSpawns().addSpawn(MobCategory.CREATURE,
            new MobSpawnSettings.SpawnerData(PandaRegistry.RED_PANDA.get(), PandaConfig.weight, 1, 5));
    }

    public static void serverAboutToStart(FMLServerAboutToStartEvent event) {
        event.getServer().registryAccess().registry(Registry.BIOME_REGISTRY).ifPresent(registry -> {
            registry.keySet().forEach(loc -> {
                registry.getOptional(loc).ifPresent(biome -> {
                    biome.getMobSettings().getMobs(MobCategory.CREATURE).unwrap().forEach(spawner -> {
                        if (spawner instanceof MobSpawner) {
                            if (PandaConfig.allowList != null && !PandaConfig.allowList.isEmpty()) {
                                if (!PandaConfig.allowList.contains(loc.toString())) {
                                    ((MobSpawner) spawner).invalidate();
                                } else {
                                    ((MobSpawner) spawner).validate();
                                }
                            } else if (PandaConfig.disallowList != null && !PandaConfig.disallowList.isEmpty()) {
                                if (PandaConfig.disallowList.contains(loc.toString())) {
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
