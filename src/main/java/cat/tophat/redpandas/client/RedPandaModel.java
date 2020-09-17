package cat.tophat.redpandas.client;

import cat.tophat.redpandas.common.entities.RedPandaEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nonnull;

public class RedPandaModel extends EntityModel<RedPandaEntity> {

    private final RendererModel head;
    private final RendererModel torso;
    private final RendererModel leftFrontLeg;
    private final RendererModel rightFrontLeg;
    private final RendererModel rightBackLeg;
    private final RendererModel leftBackLeg;
    private final RendererModel tail;

    public RedPandaModel() {
        textureWidth = 64;
        textureHeight = 64;

        head = new RendererModel(this);
        head.setRotationPoint(0.0F, 16.4F, -9.2F);
        head.setTextureOffset(28, 28).addBox(-3.0F, -3.4F, -4.8F, 6, 6,
                6, 0.0F, false);

        RendererModel jaw = new RendererModel(this);
        jaw.setRotationPoint(0.0F, 2.2F, -5.3F);
        head.addChild(jaw);
        setRotationAngle(jaw, 0.1745F, 0.0F, 0.0F);
        jaw.setTextureOffset(9, 0).addBox(-1.0F, -0.5F, -0.5F, 2, 1,
                1, 0.0F, false);

        RendererModel leftEar = new RendererModel(this);
        leftEar.setRotationPoint(2.5F, -1.9F, -0.8F);
        head.addChild(leftEar);
        setRotationAngle(leftEar, 0.0F, 0.0F, -0.5236F);
        leftEar.setTextureOffset(0, 9).addBox(-0.884F, -1.866F, -0.5F, 3, 3,
                1, 0.0F, false);

        RendererModel rightEar = new RendererModel(this);
        rightEar.setRotationPoint(-2.5F, -1.9F, -0.8F);
        head.addChild(rightEar);
        setRotationAngle(rightEar, 0.0F, 0.0F, 0.5236F);
        rightEar.setTextureOffset(8, 9).addBox(-2.116F, -1.866F, -0.5F, 3, 3,
                1, 0.0F, false);

        RendererModel nose = new RendererModel(this);
        nose.setRotationPoint(0.0F, 0.6F, -5.8F);
        head.addChild(nose);
        nose.setTextureOffset(0, 23).addBox(-1.0F, -1.0F, -1.0F, 2, 2,
                2, 0.0F, false);

        torso = new RendererModel(this);
        torso.setRotationPoint(0.0F, 16.5F, -7.5F);
        setRotationAngle(torso, 0.0873F, 0.0F, 0.0F);
        torso.setTextureOffset(0, 0).addBox(-4.0F, -2.8028F, -0.5304F, 8, 7,
                16, 0.0F, false);

        leftFrontLeg = new RendererModel(this);
        leftFrontLeg.setRotationPoint(3.0F, 19.5F, -5.5F);
        leftFrontLeg.setTextureOffset(12, 37).addBox(-1.5F, -0.5F, -1.5F, 3, 5,
                3, 0.0F, false);

        RendererModel leftFrontLegToes = new RendererModel(this);
        leftFrontLegToes.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftFrontLeg.addChild(leftFrontLegToes);
        leftFrontLegToes.setTextureOffset(8, 13).addBox(-1.5F, 3.5F, -2.5F, 3, 1,
                1, 0.0F, false);

        rightFrontLeg = new RendererModel(this);
        rightFrontLeg.setRotationPoint(-3.0F, 19.5F, -5.5F);
        rightFrontLeg.setTextureOffset(0, 37).addBox(-1.5F, -0.5F, -1.5F, 3, 5,
                3, 0.0F, false);

        RendererModel rightFrontLegToes = new RendererModel(this);
        rightFrontLegToes.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightFrontLeg.addChild(rightFrontLegToes);
        rightFrontLegToes.setTextureOffset(0, 13).addBox(-1.5F, 3.5F, -2.5F, 3, 1,
                1, 0.0F, false);

        rightBackLeg = new RendererModel(this);
        rightBackLeg.setRotationPoint(3.0F, 18.25F, 7.5F);
        rightBackLeg.setTextureOffset(17, 23).addBox(-1.5F, -0.25F, -1.5F, 3, 6,
                3, 0.0F, false);

        RendererModel rightBackLegToes = new RendererModel(this);
        rightBackLegToes.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightBackLeg.addChild(rightBackLegToes);
        rightBackLegToes.setTextureOffset(26, 23).addBox(-1.5F, 4.75F, -2.5F, 3, 1,
                1, 0.0F, false);

        leftBackLeg = new RendererModel(this);
        leftBackLeg.setRotationPoint(-3.0F, 18.25F, 7.5F);
        leftBackLeg.setTextureOffset(0, 0).addBox(-1.5F, -0.25F, -1.5F, 3, 6,
                3, 0.0F, false);

        RendererModel leftBackLegToes = new RendererModel(this);
        leftBackLegToes.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftBackLeg.addChild(leftBackLegToes);
        leftBackLegToes.setTextureOffset(0, 27).addBox(-1.5F, 4.75F, -2.5F, 3, 1,
                1, 0.0F, false);

        tail = new RendererModel(this);
        tail.setRotationPoint(0.0F, 15.0F, 7.5F);
        setRotationAngle(tail, -0.0873F, 0.0F, 0.0F);
        tail.setTextureOffset(32, 0).addBox(-2.0F, -2.0F, -0.5F, 4, 4,
                7, 0.0F, false);

        RendererModel tailTip = new RendererModel(this);
        tailTip.setRotationPoint(-0.5F, -1.4924F, 5.8257F);
        tail.addChild(tailTip);
        setRotationAngle(tailTip, -0.1745F, 0.0F, 0.0F);
        tailTip.setTextureOffset(0, 23).addBox(-1.0F, -0.0038F, -0.1527F, 3, 3,
                11, 0.0F, false);
    }

    @Override
    public void render(RedPandaEntity entity, float packedLightIn, float packedOverlayIn, float red, float green,
                       float blue, float alpha) {
        head.render(alpha);
        torso.render(alpha);
        leftBackLeg.render(alpha);
        leftFrontLeg.render(alpha);
        rightFrontLeg.render(alpha);
        rightBackLeg.render(alpha);
        tail.render(alpha);
    }

    @Override
    public void setRotationAngles(@Nonnull RedPandaEntity entity, float limbSwing, float limbSwingAmount,
                                  float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.head.rotateAngleX = headPitch * 0.0070F;
        this.head.rotateAngleY = netHeadYaw * 0.0070F;
        this.leftFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.9F * limbSwingAmount;
        this.rightFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F
                + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.rightBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.9F * limbSwingAmount;
        this.leftBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F
                + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.tail.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount;

    }

    private static void setRotationAngle(RendererModel rendererModel, float x, float y, float z) {
        rendererModel.rotateAngleX = x;
        rendererModel.rotateAngleY = y;
        rendererModel.rotateAngleZ = z;
    }
}
