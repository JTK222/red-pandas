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
package dev.tophatcat.redpandas.client.rendering;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.tophatcat.redpandas.RedPandas;
import dev.tophatcat.redpandas.client.models.RedPandaModel;
import dev.tophatcat.redpandas.common.entities.RedPandaEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class RenderRedPanda extends MobRenderer<RedPandaEntity, EntityModel<RedPandaEntity>> {

    /**
     * The path to the texture of the entity.
     */
    private static final ResourceLocation RESOURCE_LOCATION
        = new ResourceLocation(RedPandas.MOD_ID, "textures/entity/red_panda.png");

    public RenderRedPanda(EntityRendererProvider.Context rendererManager) {
        super(rendererManager, new RedPandaModel<>(
            rendererManager.bakeLayer(RedPandaModel.RED_PANDA_LOCATION)), 0.4F);
    }

    /**
     * Scale the entity based on its age.
     *
     * @param entity          The entity we should scale.
     * @param matrixStack     .
     * @param partialTickTime .
     */
    @Override
    protected void scale(@Nonnull RedPandaEntity entity, @Nonnull PoseStack matrixStack, float partialTickTime) {
        if (this.model.young) {
            matrixStack.scale(0.65F, 0.65F, 0.65F);
        } else {
            matrixStack.scale(1.0F, 1.0F, 1.0F);
        }
    }

    /**
     * @param entity The entity we want the texture of.
     * @return The path of the texture we are looking for.
     */
    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull RedPandaEntity entity) {
        return RESOURCE_LOCATION;
    }

    @Override
    protected boolean shouldShowName(RedPandaEntity entity) {
        return super.shouldShowName(entity);
    }
}
