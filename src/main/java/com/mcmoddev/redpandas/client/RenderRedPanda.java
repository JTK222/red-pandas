package com.mcmoddev.redpandas.client;

import com.mcmoddev.redpandas.RedPandas;
import com.mcmoddev.redpandas.common.entities.RedPandaEntity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRedPanda extends RenderLiving<RedPandaEntity> {

    private static final ResourceLocation resourceLocation = new ResourceLocation(RedPandas.MODID, "textures/entity/red_panda.png");

    public RenderRedPanda(RenderManager rendererManager) {
        super(rendererManager, new RedPandaModel(), 0.4F);
    }

    @Override
    protected void preRenderCallback(RedPandaEntity entity, float partialTickTime) {
        if (this.mainModel.isChild) {
            GlStateManager.scale(0.65D, 0.65D, 0.65D);
        } else {
            GlStateManager.scale(1.0D, 1.0D, 1.0D);
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
