package cat.tophat.redpandas.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nonnull;

public class RedPandaModel extends ModelBase {

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
        head.setTextureOffset(28, 28).addBox(-3.0F, -3.4F,
                -4.8F, 6, 6, 6, false);

        ModelRenderer jaw = new ModelRenderer(this);
        jaw.setRotationPoint(0.0F, 2.2F, -5.3F);
        head.addChild(jaw);
        setRotationAngle(jaw, 0.1745F, 0.0F, 0.0F);
        jaw.setTextureOffset(9, 0).addBox(-1.0F, -0.5F,
                -0.5F, 2, 1, 1, false);

        ModelRenderer leftEar = new ModelRenderer(this);
        leftEar.setRotationPoint(2.5F, -1.9F, -0.8F);
        head.addChild(leftEar);
        setRotationAngle(leftEar, 0.0F, 0.0F, -0.5236F);
        leftEar.setTextureOffset(0, 9).addBox(-0.884F, -1.866F,
                -0.5F, 3, 3, 1, false);

        ModelRenderer rightEar = new ModelRenderer(this);
        rightEar.setRotationPoint(-2.5F, -1.9F, -0.8F);
        head.addChild(rightEar);
        setRotationAngle(rightEar, 0.0F, 0.0F, 0.5236F);
        rightEar.setTextureOffset(8, 9).addBox(-2.116F, -1.866F,
                -0.5F, 3, 3, 1, false);

        ModelRenderer nose = new ModelRenderer(this);
        nose.setRotationPoint(0.0F, 0.6F, -5.8F);
        head.addChild(nose);
        nose.setTextureOffset(0, 23).addBox(-1.0F, -1.0F, -1.0F,
                2, 2, 2, false);

        torso = new ModelRenderer(this);
        torso.setRotationPoint(0.0F, 16.5F, -7.5F);
        setRotationAngle(torso, 0.0873F, 0.0F, 0.0F);
        torso.setTextureOffset(0, 0).addBox(-4.0F, -2.8028F,
                -0.5304F, 8, 7, 16, false);

        leftFrontLeg = new ModelRenderer(this);
        leftFrontLeg.setRotationPoint(3.0F, 19.5F, -5.5F);
        leftFrontLeg.setTextureOffset(12, 37).addBox(-1.5F, -0.5F,
                -1.5F, 3, 5, 3, false);

        ModelRenderer leftFrontLegToes = new ModelRenderer(this);
        leftFrontLegToes.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftFrontLeg.addChild(leftFrontLegToes);
        leftFrontLegToes.setTextureOffset(8, 13).addBox(-1.5F, 3.5F,
                -2.5F, 3, 1, 1, false);

        rightFrontLeg = new ModelRenderer(this);
        rightFrontLeg.setRotationPoint(-3.0F, 19.5F, -5.5F);
        rightFrontLeg.setTextureOffset(0, 37).addBox(-1.5F, -0.5F,
                -1.5F, 3, 5, 3, false);

        ModelRenderer rightFrontLegToes = new ModelRenderer(this);
        rightFrontLegToes.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightFrontLeg.addChild(rightFrontLegToes);
        rightFrontLegToes.setTextureOffset(0, 13).addBox(-1.5F, 3.5F,
                -2.5F, 3, 1, 1, false);

        rightBackLeg = new ModelRenderer(this);
        rightBackLeg.setRotationPoint(3.0F, 18.25F, 7.5F);
        rightBackLeg.setTextureOffset(17, 23).addBox(-1.5F, -0.25F,
                -1.5F, 3, 6, 3, false);

        ModelRenderer rightBackLegToes = new ModelRenderer(this);
        rightBackLegToes.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightBackLeg.addChild(rightBackLegToes);
        rightBackLegToes.setTextureOffset(26, 23).addBox(-1.5F, 4.75F,
                -2.5F, 3, 1, 1, false);

        leftBackLeg = new ModelRenderer(this);
        leftBackLeg.setRotationPoint(-3.0F, 18.25F, 7.5F);
        leftBackLeg.setTextureOffset(0, 0).addBox(-1.5F, -0.25F,
                -1.5F, 3, 6, 3, false);

        ModelRenderer leftBackLegToes = new ModelRenderer(this);
        leftBackLegToes.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftBackLeg.addChild(leftBackLegToes);
        leftBackLegToes.setTextureOffset(0, 27).addBox(-1.5F, 4.75F,
                -2.5F, 3, 1, 1, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 15.0F, 7.5F);
        setRotationAngle(tail, -0.0873F, 0.0F, 0.0F);
        tail.setTextureOffset(32, 0).addBox(-2.0F, -2.0F, -0.5F,
                4, 4, 7, false);

        ModelRenderer tailTip = new ModelRenderer(this);
        tailTip.setRotationPoint(-0.5F, -1.4924F, 5.8257F);
        tail.addChild(tailTip);
        setRotationAngle(tailTip, -0.1745F, 0.0F, 0.0F);
        tailTip.setTextureOffset(0, 23).addBox(-1.0F, -0.0038F,
                -0.1527F, 3, 3, 11, false);
    }

    @Override
    public void render(@Nonnull Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                       float netHeadYaw, float headPitch, float alpha) {
        head.render(alpha);
        torso.render(alpha);
        leftBackLeg.render(alpha);
        leftFrontLeg.render(alpha);
        rightFrontLeg.render(alpha);
        rightBackLeg.render(alpha);
        tail.render(alpha);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                                  float headPitch, float scaleFactor, Entity entity) {
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

    private static void setRotationAngle(ModelRenderer rendererModel, float x, float y, float z) {
        rendererModel.rotateAngleX = x;
        rendererModel.rotateAngleY = y;
        rendererModel.rotateAngleZ = z;
    }
}
