package dev.tophatcat.redpandas.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import dev.tophatcat.redpandas.init.RedPanda;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nonnull;

public class RedPandaModel extends EntityModel<RedPanda> {

    private final ModelRenderer head;
    private final ModelRenderer torso;
    private final ModelRenderer leftFrontLeg;
    private final ModelRenderer rightFrontLeg;
    private final ModelRenderer rightBackLeg;
    private final ModelRenderer leftBackLeg;
    private final ModelRenderer tail;
    private final ModelRenderer tailTip;

    public RedPandaModel() {
        texWidth = 64;
        texHeight = 64;

        head = new ModelRenderer(this);
        head.setPos(0.0F, 16.4F, -11.2F);
        head.texOffs(28, 28)
            .addBox(-3.0F, -3.4F, -2.8F, 6.0F,
                6.0F, 6.0F, 0.0F, false);

        ModelRenderer jaw = new ModelRenderer(this);
        jaw.setPos(0.0F, 2.2F, -3.3F);
        head.addChild(jaw);
        setRotationAngle(jaw, 0.1745F, 0.0F, 0.0F);
        jaw.texOffs(9, 0)
            .addBox(-1.0F, -0.5F, -0.5F, 2.0F,
                1.0F, 1.0F, 0.0F, false);

        ModelRenderer leftEar = new ModelRenderer(this);
        leftEar.setPos(2.5F, -1.9F, 1.2F);
        head.addChild(leftEar);
        setRotationAngle(leftEar, 0.0F, 0.0F, -0.5236F);
        leftEar.texOffs(0, 9)
            .addBox(-0.884F, -1.866F, -0.5F, 3.0F,
                3.0F, 1.0F, 0.0F, false);

        ModelRenderer rightEar = new ModelRenderer(this);
        rightEar.setPos(-2.5F, -1.9F, 1.2F);
        head.addChild(rightEar);
        setRotationAngle(rightEar, 0.0F, 0.0F, 0.5236F);
        rightEar.texOffs(8, 9)
            .addBox(-2.116F, -1.866F, -0.5F, 3.0F,
                3.0F, 1.0F, 0.0F, false);

        ModelRenderer nose = new ModelRenderer(this);
        nose.setPos(0.0F, 0.6F, -3.8F);
        head.addChild(nose);
        nose.texOffs(0, 23)
            .addBox(-1.0F, -1.0F, -1.0F, 2.0F,
                2.0F, 2.0F, 0.0F, false);

        torso = new ModelRenderer(this);
        torso.setPos(0.0F, 16.5F, -7.5F);
        setRotationAngle(torso, 0.0873F, 0.0F, 0.0F);
        torso.texOffs(0, 0)
            .addBox(-4.0F, -2.8028F, -0.5304F, 8.0F,
                7.0F, 16.0F, 0.0F, false);

        leftFrontLeg = new ModelRenderer(this);
        leftFrontLeg.setPos(3.0F, 19.5F, -5.5F);
        leftFrontLeg.texOffs(12, 37)
            .addBox(-1.5F, -0.5F, -1.5F, 3.0F,
                5.0F, 3.0F, 0.0F, false);

        ModelRenderer leftFrontLegToes = new ModelRenderer(this);
        leftFrontLegToes.setPos(0.0F, 0.0F, 0.0F);
        leftFrontLeg.addChild(leftFrontLegToes);
        leftFrontLegToes.texOffs(8, 13)
            .addBox(-1.5F, 3.5F, -2.5F, 3.0F,
                1.0F, 1.0F, 0.0F, false);

        rightFrontLeg = new ModelRenderer(this);
        rightFrontLeg.setPos(-3.0F, 19.5F, -5.5F);
        rightFrontLeg.texOffs(0, 37)
            .addBox(-1.5F, -0.5F, -1.5F, 3.0F,
                5.0F, 3.0F, 0.0F, false);

        ModelRenderer rightFrontLegToes = new ModelRenderer(this);
        rightFrontLegToes.setPos(0.0F, 0.0F, 0.0F);
        rightFrontLeg.addChild(rightFrontLegToes);
        rightFrontLegToes.texOffs(0, 13)
            .addBox(-1.5F, 3.5F, -2.5F, 3.0F,
                1.0F, 1.0F, 0.0F, false);

        rightBackLeg = new ModelRenderer(this);
        rightBackLeg.setPos(3.0F, 18.25F, 7.5F);
        rightBackLeg.texOffs(17, 23)
            .addBox(-1.5F, -0.25F, -1.5F, 3.0F,
                6.0F, 3.0F, 0.0F, false);

        ModelRenderer rightBackLegToes = new ModelRenderer(this);
        rightBackLegToes.setPos(0.0F, 0.0F, 0.0F);
        rightBackLeg.addChild(rightBackLegToes);
        rightBackLegToes.texOffs(26, 23)
            .addBox(-1.5F, 4.75F, -2.5F, 3.0F,
                1.0F, 1.0F, 0.0F, false);

        leftBackLeg = new ModelRenderer(this);
        leftBackLeg.setPos(-3.0F, 18.25F, 7.5F);
        leftBackLeg.texOffs(0, 0)
            .addBox(-1.5F, -0.25F, -1.5F, 3.0F,
                6.0F, 3.0F, 0.0F, false);

        ModelRenderer leftBackLegToes = new ModelRenderer(this);
        leftBackLegToes.setPos(0.0F, 0.0F, 0.0F);
        leftBackLeg.addChild(leftBackLegToes);
        leftBackLegToes.texOffs(0, 27)
            .addBox(-1.5F, 4.75F, -2.5F, 3.0F,
                1.0F, 1.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setPos(0.0F, 15.0F, 7.5F);
        setRotationAngle(tail, -0.0873F, 0.0F, 0.0F);
        tail.texOffs(32, 0)
            .addBox(-2.0F, -2.0F, -0.5F, 4.0F,
                4.0F, 7.0F, 0.0F, false);

        tailTip = new ModelRenderer(this);
        tailTip.setPos(-0.5F, -1.4924F, 5.8257F);
        tail.addChild(tailTip);
        setRotationAngle(tailTip, -0.1745F, 0.0F, 0.0F);
        tailTip.texOffs(0, 23)
            .addBox(-1.0F, -0.0038F, -0.1527F, 3.0F,
                3.0F, 11.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(@Nonnull RedPanda entity, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        head.xRot = headPitch * 0.0070F;
        head.yRot = netHeadYaw * 0.0070F;
        leftFrontLeg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 0.9F * limbSwingAmount;
        rightFrontLeg.xRot = MathHelper.cos(limbSwing * 0.6662F
            + (float) Math.PI) * 1.4F * limbSwingAmount;
        rightBackLeg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 0.9F * limbSwingAmount;
        leftBackLeg.xRot = MathHelper.cos(limbSwing * 0.6662F
            + (float) Math.PI) * 1.4F * limbSwingAmount;
        tail.yRot = MathHelper.cos(ageInTicks * 0.1F) * 0.15F;
        tailTip.yRot = MathHelper.cos(ageInTicks * 0.1F) * 0.15F;
    }

    @Override
    public void renderToBuffer(@Nonnull MatrixStack matrixStack, @Nonnull IVertexBuilder buffer,
                               int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        torso.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        leftFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        rightFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        rightBackLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        leftBackLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        tail.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
