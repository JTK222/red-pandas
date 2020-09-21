package cat.tophat.redpandas.client;

import cat.tophat.redpandas.RedPandas;
import cat.tophat.redpandas.common.entities.RedPandaEntity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

@SideOnly(Side.CLIENT)
public class RenderRedPanda extends RenderLiving<RedPandaEntity> {

    private static final ResourceLocation resourceLocation
            = new ResourceLocation(RedPandas.MODID, "textures/entity/red_panda.png");

    public RenderRedPanda(RenderManager rendererManager) {
        super(rendererManager, new RedPandaModel(), 0.4F);
    }

    @Override
    protected void preRenderCallback(@Nonnull RedPandaEntity entity, float partialTickTime) {
        if (this.mainModel.isChild) {
            GlStateManager.scale(0.65F, 0.65F, 0.65F);
        } else {
            GlStateManager.scale(1.0F, 1.0F, 1.0F);
        }
    }

    @Override
    protected boolean canRenderName(RedPandaEntity entity) {
        return entity.hasCustomName();
    }

    @Nonnull
    @Override
    public ResourceLocation getEntityTexture(@Nonnull RedPandaEntity entity) {
        return resourceLocation;
    }
}
