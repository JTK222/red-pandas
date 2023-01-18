/*
 * Red Pandas - https://github.com/tophatcats-mods/red-pandas
 * Copyright (C) 2013-2023 <KiriCattus>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation;
 * Specifically version 2.1 of the License.
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
            mod.addListener(RedPandaRegistry::addToCreativeTabs);
        }
    }
}
