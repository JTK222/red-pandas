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
package dev.tophatcat.redpandas.client;

import dev.tophatcat.redpandas.client.models.RedPandaModel;
import dev.tophatcat.redpandas.client.rendering.RenderRedPanda;
import dev.tophatcat.redpandas.common.PandaRegistry;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class PandaRendering {

    public static void setupRendering(IEventBus modBus, IEventBus forgeBus) {
        modBus.addListener(PandaRendering::registerEntityModels);
        modBus.addListener(PandaRendering::registerLayerDefinitions);
    }

    public static void registerEntityModels(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(PandaRegistry.RED_PANDA.get(), RenderRedPanda::new);
    }

    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(RedPandaModel.RED_PANDA_LOCATION, RedPandaModel::createBodyLayer);
    }
}
