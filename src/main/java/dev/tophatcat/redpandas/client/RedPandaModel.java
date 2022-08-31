package dev.tophatcat.redpandas.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.tophatcat.redpandas.RedPandas;
import dev.tophatcat.redpandas.init.RedPanda;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import javax.annotation.Nonnull;

public class RedPandaModel<T extends RedPanda> extends EntityModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(RedPandas.MOD_ID, "red_panda"), "main");
    private final ModelPart headGroup;
    private final ModelPart torso;
    private final ModelPart tail;
    private final ModelPart leftFrontLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart rightBackLeg;
    private final ModelPart leftBackLeg;

    public RedPandaModel(ModelPart root) {
        this.headGroup = root.getChild("headGroup");
        this.torso = root.getChild("torso");
        this.tail = root.getChild("tail");
        this.leftFrontLeg = root.getChild("leftFrontLeg");
        this.rightFrontLeg = root.getChild("rightFrontLeg");
        this.rightBackLeg = root.getChild("rightBackLeg");
        this.leftBackLeg = root.getChild("leftBackLeg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition headGroup = partdefinition.addOrReplaceChild("headGroup", CubeListBuilder.create().texOffs(28, 28).addBox(-3.0F, -2.5F, -6.25F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
            .texOffs(1, 24).addBox(-1.0F, 0.5F, -7.25F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.5F, -7.75F));

        PartDefinition ears = headGroup.addOrReplaceChild("ears", CubeListBuilder.create().texOffs(0, 9).addBox(1.5F, -5.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
            .texOffs(8, 9).addBox(-3.5F, -5.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 1.0F, -2.75F));

        PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition torso_r1 = torso.addOrReplaceChild("torso_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -3.5F, -8.0F, 8.0F, 7.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.3591F, 0.0011F, 0.0873F, 0.0F, 0.0F));

        PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(32, 0).addBox(-2.0F, -2.2385F, -0.0114F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.5F, 7.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition tailTip = tail.addOrReplaceChild("tailTip", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5F, -0.5F, 6.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition tailTip_r1 = tailTip.addOrReplaceChild("tailTip_r1", CubeListBuilder.create().texOffs(0, 23).addBox(-1.5F, -1.5F, -5.5F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.6278F, 5.5301F, -0.1309F, 0.0F, 0.0F));

        PartDefinition leftFrontLeg = partdefinition.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
            .texOffs(0, 13).addBox(-1.5F, 4.0F, -2.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 19.0F, -5.5F));

        PartDefinition rightFrontLeg = partdefinition.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
            .texOffs(0, 13).addBox(-1.5F, 4.0F, -2.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 19.0F, -5.5F));

        PartDefinition rightBackLeg = partdefinition.addOrReplaceChild("rightBackLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
            .texOffs(0, 13).addBox(-1.5F, 5.0F, -2.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 18.0F, 7.5F));

        PartDefinition leftBackLeg = partdefinition.addOrReplaceChild("leftBackLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
            .texOffs(0, 13).addBox(-1.5F, 5.0F, -2.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 18.0F, 7.5F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(@Nonnull RedPanda entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        headGroup.xRot = headPitch * 0.0070F;
        headGroup.yRot = netHeadYaw * 0.0070F;
        leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.9F * limbSwingAmount;
        rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F
            + (float) Math.PI) * 1.4F * limbSwingAmount;
        rightBackLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.9F * limbSwingAmount;
        leftBackLeg.xRot = Mth.cos(limbSwing * 0.6662F
            + (float) Math.PI) * 1.4F * limbSwingAmount;
        tail.yRot = Mth.cos(ageInTicks * 0.1F) * 0.15F;
        tail.getChild("tailTip").yRot = Mth.cos(ageInTicks * 0.1F) * 0.15F;
    }

    @Override
    public void renderToBuffer(@Nonnull PoseStack poseStack, @Nonnull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        headGroup.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightBackLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftBackLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
