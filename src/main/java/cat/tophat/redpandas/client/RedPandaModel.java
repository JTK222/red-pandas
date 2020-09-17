package cat.tophat.redpandas.client;

import cat.tophat.redpandas.common.entities.RedPandaEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nonnull;

public class RedPandaModel extends EntityModel<RedPandaEntity> {

    private final ModelRenderer head;
    private final ModelRenderer torso;
    private final ModelRenderer leftFrontLeg;
    private final ModelRenderer rightFrontLeg;
    private final ModelRenderer rightBackLeg;
    private final ModelRenderer leftBackLeg;
    private final ModelRenderer tail;

    public RedPandaModel() {
        textureWidth = 64;
        textureHeight = 64;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 16.4F, -9.2F);
        head.setTextureOffset(28, 28).addBox(-3.0F, -3.4F, -4.8F, 6.0F, 6.0F,
                6.0F, 0.0F, false);

        ModelRenderer jaw = new ModelRenderer(this);
        jaw.setRotationPoint(0.0F, 2.2F, -5.3F);
        head.addChild(jaw);
        setRotationAngle(jaw, 0.1745F, 0.0F, 0.0F);
        jaw.setTextureOffset(9, 0).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F,
                1.0F, 0.0F, false);

        ModelRenderer leftEar = new ModelRenderer(this);
        leftEar.setRotationPoint(2.5F, -1.9F, -0.8F);
        head.addChild(leftEar);
        setRotationAngle(leftEar, 0.0F, 0.0F, -0.5236F);
        leftEar.setTextureOffset(0, 9).addBox(-0.884F, -1.866F, -0.5F, 3.0F, 3.0F,
                1.0F, 0.0F, false);

        ModelRenderer rightEar = new ModelRenderer(this);
        rightEar.setRotationPoint(-2.5F, -1.9F, -0.8F);
        head.addChild(rightEar);
        setRotationAngle(rightEar, 0.0F, 0.0F, 0.5236F);
        rightEar.setTextureOffset(8, 9).addBox(-2.116F, -1.866F, -0.5F, 3.0F, 3.0F,
                1.0F, 0.0F, false);

        ModelRenderer nose = new ModelRenderer(this);
        nose.setRotationPoint(0.0F, 0.6F, -5.8F);
        head.addChild(nose);
        nose.setTextureOffset(0, 23).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F,
                2.0F, 0.0F, false);

        torso = new ModelRenderer(this);
        torso.setRotationPoint(0.0F, 16.5F, -7.5F);
        setRotationAngle(torso, 0.0873F, 0.0F, 0.0F);
        torso.setTextureOffset(0, 0).addBox(-4.0F, -2.8028F, -0.5304F, 8.0F, 7.0F,
                16.0F, 0.0F, false);

        leftFrontLeg = new ModelRenderer(this);
        leftFrontLeg.setRotationPoint(3.0F, 19.5F, -5.5F);
        leftFrontLeg.setTextureOffset(12, 37).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 5.0F,
                3.0F, 0.0F, false);

        ModelRenderer leftFrontLegToes = new ModelRenderer(this);
        leftFrontLegToes.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftFrontLeg.addChild(leftFrontLegToes);
        leftFrontLegToes.setTextureOffset(8, 13).addBox(-1.5F, 3.5F, -2.5F, 3.0F, 1.0F,
                1.0F, 0.0F, false);

        rightFrontLeg = new ModelRenderer(this);
        rightFrontLeg.setRotationPoint(-3.0F, 19.5F, -5.5F);
        rightFrontLeg.setTextureOffset(0, 37).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 5.0F,
                3.0F, 0.0F, false);

        ModelRenderer rightFrontLegToes = new ModelRenderer(this);
        rightFrontLegToes.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightFrontLeg.addChild(rightFrontLegToes);
        rightFrontLegToes.setTextureOffset(0, 13).addBox(-1.5F, 3.5F, -2.5F, 3.0F, 1.0F,
                1.0F, 0.0F, false);

        rightBackLeg = new ModelRenderer(this);
        rightBackLeg.setRotationPoint(3.0F, 18.25F, 7.5F);
        rightBackLeg.setTextureOffset(17, 23).addBox(-1.5F, -0.25F, -1.5F, 3.0F, 6.0F,
                3.0F, 0.0F, false);

        ModelRenderer rightBackLegToes = new ModelRenderer(this);
        rightBackLegToes.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightBackLeg.addChild(rightBackLegToes);
        rightBackLegToes.setTextureOffset(26, 23).addBox(-1.5F, 4.75F, -2.5F, 3.0F, 1.0F,
                1.0F, 0.0F, false);

        leftBackLeg = new ModelRenderer(this);
        leftBackLeg.setRotationPoint(-3.0F, 18.25F, 7.5F);
        leftBackLeg.setTextureOffset(0, 0).addBox(-1.5F, -0.25F, -1.5F, 3.0F, 6.0F,
                3.0F, 0.0F, false);

        ModelRenderer leftBackLegToes = new ModelRenderer(this);
        leftBackLegToes.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftBackLeg.addChild(leftBackLegToes);
        leftBackLegToes.setTextureOffset(0, 27).addBox(-1.5F, 4.75F, -2.5F, 3.0F, 1.0F,
                1.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 15.0F, 7.5F);
        setRotationAngle(tail, -0.0873F, 0.0F, 0.0F);
        tail.setTextureOffset(32, 0).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F,
                7.0F, 0.0F, false);

        ModelRenderer tailTip = new ModelRenderer(this);
        tailTip.setRotationPoint(-0.5F, -1.4924F, 5.8257F);
        tail.addChild(tailTip);
        setRotationAngle(tailTip, -0.1745F, 0.0F, 0.0F);
        tailTip.setTextureOffset(0, 23).addBox(-1.0F, -0.0038F, -0.1527F, 3.0F, 3.0F,
                11.0F, 0.0F, false);
    }

    @Override
    public void render(@Nonnull MatrixStack matrixStack, @Nonnull IVertexBuilder buffer, int packedLightIn,
                       int packedOverlayIn, float red, float green, float blue, float alpha) {
        head.render(matrixStack, buffer, packedLightIn, packedOverlayIn);
        torso.render(matrixStack, buffer, packedLightIn, packedOverlayIn);
        leftBackLeg.render(matrixStack, buffer, packedLightIn, packedOverlayIn);
        leftFrontLeg.render(matrixStack, buffer, packedLightIn, packedOverlayIn);
        rightFrontLeg.render(matrixStack, buffer, packedLightIn, packedOverlayIn);
        rightBackLeg.render(matrixStack, buffer, packedLightIn, packedOverlayIn);
        tail.render(matrixStack, buffer, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setRotationAngles(@Nonnull RedPandaEntity entity, float limbSwing, float limbSwingAmount,
                                  float ageInTicks, float netHeadYaw, float headPitch) {
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

    private static void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
