package com.mcmoddev.redpandas.client;

import com.mcmoddev.redpandas.RedPandas;
import com.mcmoddev.redpandas.common.entities.RedPandaEntity;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderRedPanda extends LivingRenderer<RedPandaEntity, RedPandaModel> {

    private static final ResourceLocation resourceLocation = new ResourceLocation(RedPandas.MODID, "textures/models/red_panda.png");

    public RenderRedPanda(EntityRendererManager rendererManager) {
        super(rendererManager, new RedPandaModel(), 0);
    }

    @Override
    protected void preRenderCallback(RedPandaEntity entity, float partialTickTime) {
        if (this.entityModel.isChild) {
            GlStateManager.scaled(0.65D, 0.65D, 0.65D);
        } else {
            GlStateManager.scaled(1.0D, 1.0D, 1.0D);
        }
    }

    @Override
    protected boolean canRenderName(RedPandaEntity entity) {
        return entity.hasCustomName();
    }

    @Override
    protected ResourceLocation getEntityTexture(RedPandaEntity entity) {
        return resourceLocation;
    }
}
