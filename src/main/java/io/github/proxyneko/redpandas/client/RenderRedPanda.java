package io.github.proxyneko.redpandas.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import io.github.proxyneko.redpandas.RedPandas;
import io.github.proxyneko.redpandas.common.entities.RedPandaEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderRedPanda extends LivingRenderer<RedPandaEntity, RedPandaModel> {

    private static final ResourceLocation resourceLocation = new ResourceLocation(RedPandas.MODID, "textures/entity/red_panda.png");

    public RenderRedPanda(EntityRendererManager rendererManager) {
        super(rendererManager, new RedPandaModel(), 0.4F);
    }

    @Override
    protected void preRenderCallback(RedPandaEntity entity, MatrixStack matrixStack, float partialTickTime) {
        if (this.entityModel.isChild) {
            matrixStack.scale(0.65F, 0.65F, 0.65F);
        } else {
            matrixStack.scale(1.0F, 1.0F, 1.0F);
        }
    }

    @Override
    protected boolean canRenderName(RedPandaEntity entity) {
        return entity.hasCustomName();
    }

    @Override
    public ResourceLocation getEntityTexture(RedPandaEntity entity) {
        return resourceLocation;
    }
}
