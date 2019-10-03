package com.mcmoddev.redpandas.client;

import com.mcmoddev.redpandas.common.entities.RedPandaEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

public class RedPandaModel extends EntityModel<RedPandaEntity> {

	private final RendererModel right_ear;
	private final RendererModel left_ear;
	private final RendererModel mouth_upper;
	private final RendererModel mouth_lower;
	private final RendererModel head;
	private final RendererModel torso;
	private final RendererModel leftFrontLeg01;
	private final RendererModel leftFrontLeg02;
	private final RendererModel leftBackLeg01;
	private final RendererModel leftBackLeg02;
	private final RendererModel rightFrontLeg01;
	private final RendererModel rightFrontLeg02;
	private final RendererModel rightBackLeg01;
	private final RendererModel rightBackLeg02;
	private final RendererModel tail_butt;
	private final RendererModel tail_tip;

	public RedPandaModel() {
		textureWidth = 64;
		textureHeight = 64;

		right_ear = new RendererModel(this);
		right_ear.setRotationPoint(-3.5F, -1.5F, -9.0F);
		setRotationAngle(right_ear, 0.0F, 0.0F, 0.5236F);
		right_ear.cubeList.add(new ModelBox(right_ear, 8, 9, -0.75F, -1.5F, -0.5F, 3, 3, 1, 0.0F, false));

		left_ear = new RendererModel(this);
		left_ear.setRotationPoint(3.5F, -1.5F, -9.0F);
		setRotationAngle(left_ear, 0.0F, 0.0F, -0.5236F);
		left_ear.cubeList.add(new ModelBox(left_ear, 0, 9, -2.25F, -1.5F, -0.5F, 3, 3, 1, 0.0F, false));

		mouth_upper = new RendererModel(this);
		mouth_upper.setRotationPoint(-7.0F, -6.0F, -4.0F);
		mouth_upper.cubeList.add(new ModelBox(mouth_upper, 0, 23, 6.0F, -2.0F, -9.5F, 2, 2, 2, 0.0F, false));

		mouth_lower = new RendererModel(this);
		mouth_lower.setRotationPoint(-7.0F, -6F, -5.0F);
		setRotationAngle(mouth_lower, 0.1745F, 0.0F, 0.0F);
		mouth_lower.cubeList.add(new ModelBox(mouth_lower, 9, 0, 6.0F, -1.3892F, -8.8785F, 2, 1, 1, 0.0F, false));

		head = new RendererModel(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 28, 28, -3.0F, -11.0F, -13.0F, 6, 6, 6, 0.0F, false));
		
		head.addChild(mouth_lower);
		head.addChild(mouth_upper);
		head.addChild(left_ear);
		head.addChild(right_ear);

		torso = new RendererModel(this);
		torso.setRotationPoint(-8.0F, 18.0F, 8.0F);
		setRotationAngle(torso, 0.0873F, 0.0F, 0.0F);
		torso.cubeList.add(new ModelBox(torso, 0, 0, 4.0F, -5.75F, -16.0F, 8, 7, 16, 0.0F, false));

		leftFrontLeg01 = new RendererModel(this);
		leftFrontLeg01.setRotationPoint(-7.5F, 18.0F, -7.0F);
		
		leftFrontLeg02 = new RendererModel(this);
        leftFrontLeg02.setRotationPoint(0,0,0);
        
        leftBackLeg01 = new RendererModel(this);
        leftBackLeg01.setRotationPoint(-7.5F, 18.0F, 6.0F);
        
        leftBackLeg02 = new RendererModel(this);
        leftBackLeg02.setRotationPoint(0,0,0);
        
		leftFrontLeg01.cubeList.add(new ModelBox(leftFrontLeg01, 0, 37, 9.0F, 1.0F, 0.0F, 3, 5, 3, 0.0F, false));
		leftFrontLeg02.cubeList.add(new ModelBox(leftFrontLeg02, 0, 27, 9F, 5.0F, -1.0F, 3, 1, 1, 0.0F, false));
		leftBackLeg01.cubeList.add(new ModelBox(leftBackLeg01, 0, 0, 9.0F, 0.0F, 0F, 3, 6, 3, 0.0F, false));
		leftBackLeg02.cubeList.add(new ModelBox(leftBackLeg02, 0, 13, 9F, 5.0F, -1.0F, 3, 1, 1, 0.0F, false));

		rightFrontLeg01 = new RendererModel(this);
        rightFrontLeg01.setRotationPoint(-13.5F, 18.0F, -7.0F);
        
        rightFrontLeg02 = new RendererModel(this);
        rightFrontLeg02.setRotationPoint(0,0,0);
        
        rightBackLeg01 = new RendererModel(this);
        rightBackLeg01.setRotationPoint(-13.5F, 18.0F, 6.0F);
        
        rightBackLeg02 = new RendererModel(this);
        rightBackLeg02.setRotationPoint(0,0,0);

		rightFrontLeg01.cubeList.add(new ModelBox(rightFrontLeg01, 12, 37, 9.0F, 1.0F, 0F, 3, 5, 3, 0.0F, false));
		rightFrontLeg02.cubeList.add(new ModelBox(rightFrontLeg02, 26, 23, 9F, 5.0F, -1.0F, 3, 1, 1, 0.0F, false));
		rightBackLeg01.cubeList.add(new ModelBox(rightBackLeg01, 17, 23, 9.0F, 0.0F, 0F, 3, 6, 3, 0.0F, false));
		rightBackLeg02.cubeList.add(new ModelBox(rightBackLeg02, 8, 13, 9F, 5.0F, -1.0F, 3, 1, 1, 0.0F, false));
		
		rightBackLeg01.addChild(rightBackLeg02);
		rightFrontLeg01.addChild(rightFrontLeg02);
		leftBackLeg01.addChild(leftBackLeg02);
		leftFrontLeg01.addChild(leftFrontLeg02);

		tail_butt = new RendererModel(this);
		tail_butt.setRotationPoint(-13.0F, 18.0F, 8.5F);
		setRotationAngle(tail_butt, -0.0873F, 0.0F, 0.0F);
		tail_butt.cubeList.add(new ModelBox(tail_butt, 32, 0, 11.0F, -5.25F, -3.0F, 4, 4, 7, 0.0F, false));

		tail_tip = new RendererModel(this);
		tail_tip.setRotationPoint(13.0F, -4F, 8F);
		setRotationAngle(tail_tip, -0.1745F, 0.0F, 0.0F);
		tail_tip.cubeList.add(new ModelBox(tail_tip, 0, 23, -1.5F, 0.0F, -5.5F, 3, 3, 11, 0.0F, false));
		
		tail_butt.addChild(tail_tip);
	}

	@Override
	public void render(RedPandaEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
	    right_ear.setRotationPoint(-3.5F, -10.5F, -9.0F);
	    left_ear.setRotationPoint(3.5F, -10.5F, -9.0F);
	    mouth_upper.setRotationPoint(-7.0F, -6.0F, -5.0F);
		head.render(f5);
		torso.render(f5);
		leftBackLeg01.render(f5);
		leftFrontLeg01.render(f5);
		rightFrontLeg01.render(f5);
        rightBackLeg01.render(f5);
		tail_butt.render(f5);
	}
	
	

	@Override
    public void setRotationAngles(RedPandaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
	    this.head.rotateAngleX = headPitch * 0.0047F;
        this.head.rotateAngleY = netHeadYaw * 0.0047F;
        this.leftFrontLeg01.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
        this.rightFrontLeg01.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
        this.rightBackLeg01.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
        this.leftBackLeg01.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
        
        //this.tail_butt.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
        
	}

    private static void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}