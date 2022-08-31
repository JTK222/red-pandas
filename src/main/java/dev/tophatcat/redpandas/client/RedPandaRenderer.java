package dev.tophatcat.redpandas.client;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.tophatcat.redpandas.RedPandas;
import dev.tophatcat.redpandas.init.RedPanda;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class RedPandaRenderer extends MobRenderer<RedPanda, RedPandaModel<RedPanda>> {

    private static final ResourceLocation RESOURCE_LOCATION
        = new ResourceLocation(RedPandas.MOD_ID, "textures/entity/red_panda.png");

    public RedPandaRenderer(EntityRendererProvider.Context context) {
        super(context, new RedPandaModel<>(
            context.bakeLayer(RedPandaModel.LAYER_LOCATION)), 0.4F);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull final RedPanda entity) {
        return RESOURCE_LOCATION;
    }

    @Override
    protected void scale(@Nonnull RedPanda entity, @Nonnull PoseStack matrixStack, float partialTickTime) {
        if (model.young) {
            matrixStack.scale(0.65F, 0.65F, 0.65F);
        } else {
            matrixStack.scale(1.0F, 1.0F, 1.0F);
        }
    }
}
