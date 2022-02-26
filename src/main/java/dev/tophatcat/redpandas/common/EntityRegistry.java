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
import dev.tophatcat.redpandas.common.entities.RedPandaEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


@Mod.EventBusSubscriber(modid = RedPandas.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRegistry {

    public static final DeferredRegister<EntityType<?>> ENTITIES
        = DeferredRegister.create(ForgeRegistries.ENTITIES, RedPandas.MOD_ID);

    /**
     * Set up the Red Panda entity.
     */
    public static final RegistryObject<EntityType<RedPandaEntity>> RED_PANDA
        = ENTITIES.register("red_panda",
        () -> EntityType.Builder.of(RedPandaEntity::new, MobCategory.CREATURE)
            .sized(0.90F, 0.60F)
            .setTrackingRange(80)
            .setUpdateInterval(1)
            .setShouldReceiveVelocityUpdates(true)
            .build(RedPandas.MOD_ID + ":red_panda"));

    /**
     * Setup spawn placement.
     */
    @SubscribeEvent
    public static void common(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(RED_PANDA.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        });
    }

    /**
     * Register the mobs and spawn placements.
     */
    @SubscribeEvent
    public static void attributeCreation(EntityAttributeCreationEvent event) {
        event.put(RED_PANDA.get(), RedPandaEntity.prepareAttributes().build());
    }
}
