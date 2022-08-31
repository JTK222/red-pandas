package dev.tophatcat.redpandas.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import dev.tophatcat.redpandas.RedPandas;
import dev.tophatcat.redpandas.init.RedPanda;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class RedPandaRenderer extends MobRenderer<RedPanda, RedPandaModel> {

    private static final ResourceLocation resourceLocation
        = new ResourceLocation(RedPandas.MOD_ID, "textures/entity/red_panda.png");

    public RedPandaRenderer(EntityRendererManager context) {
        super(context, new RedPandaModel(), 0.4F);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull final RedPanda entity) {
        return resourceLocation;
    }

    @Override
    protected void scale(@Nonnull RedPanda entity, @Nonnull MatrixStack matrixStack, float partialTickTime) {
        if (model.young) {
            matrixStack.scale(0.65F, 0.65F, 0.65F);
        } else {
            matrixStack.scale(1.0F, 1.0F, 1.0F);
        }
    }
}
