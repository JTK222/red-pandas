package com.mcmoddev.redpandas.client;

import com.mcmoddev.redpandas.common.entities.RedPandaEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

public class RedPandaModel extends EntityModel<RedPandaEntity> {

	//TODO Animate and make sure the tails parent is set properly for animation.
	private final RendererModel right_ear;
	private final RendererModel left_ear;
	private final RendererModel mouth_upper;
	private final RendererModel mouth_lower;
	private final RendererModel head;
	private final RendererModel torso;
	private final RendererModel left_legs;
	private final RendererModel right_legs;
	private final RendererModel tail_butt;
	private final RendererModel tail_tip;

	public RedPandaModel() {
		textureWidth = 64;
		textureHeight = 64;

		right_ear = new RendererModel(this);
		right_ear.setRotationPoint(-3.5F, 13.5F, -10.0F);
		setRotationAngle(right_ear, 0.0F, 0.0F, 0.5236F);
		right_ear.cubeList.add(new ModelBox(right_ear, 8, 9, -0.75F, -1.5F, -0.5F, 3, 3, 1, 0.0F, false));

		left_ear = new RendererModel(this);
		left_ear.setRotationPoint(3.5F, 13.5F, -10.0F);
		setRotationAngle(left_ear, 0.0F, 0.0F, -0.5236F);
		left_ear.cubeList.add(new ModelBox(left_ear, 0, 9, -2.25F, -1.5F, -0.5F, 3, 3, 1, 0.0F, false));

		mouth_upper = new RendererModel(this);
		mouth_upper.setRotationPoint(-7.0F, 18.0F, -5.0F);
		mouth_upper.cubeList.add(new ModelBox(mouth_upper, 0, 23, 6.0F, -2.0F, -9.5F, 2, 2, 2, 0.0F, false));

		mouth_lower = new RendererModel(this);
		mouth_lower.setRotationPoint(-7.0F, 18.0F, -5.0F);
		setRotationAngle(mouth_lower, 0.1745F, 0.0F, 0.0F);
		mouth_lower.cubeList.add(new ModelBox(mouth_lower, 9, 0, 6.0F, -1.3892F, -8.8785F, 2, 1, 1, 0.0F, false));

		head = new RendererModel(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 28, 28, -3.0F, -11.0F, -13.0F, 6, 6, 6, 0.0F, false));

		torso = new RendererModel(this);
		torso.setRotationPoint(-8.0F, 18.0F, 8.0F);
		setRotationAngle(torso, 0.0873F, 0.0F, 0.0F);
		torso.cubeList.add(new ModelBox(torso, 0, 0, 4.0F, -5.75F, -16.0F, 8, 7, 16, 0.0F, false));

		left_legs = new RendererModel(this);
		left_legs.setRotationPoint(-7.5F, 18.0F, 7.0F);
		left_legs.cubeList.add(new ModelBox(left_legs, 0, 37, 9.0F, 1.0F, -14.0F, 3, 5, 3, 0.0F, false));
		left_legs.cubeList.add(new ModelBox(left_legs, 0, 27, 9.0F, 5.0F, -15.0F, 3, 1, 1, 0.0F, false));
		left_legs.cubeList.add(new ModelBox(left_legs, 0, 0, 9.0F, 0.0F, -1.0F, 3, 6, 3, 0.0F, false));
		left_legs.cubeList.add(new ModelBox(left_legs, 0, 13, 9.0F, 5.0F, -2.0F, 3, 1, 1, 0.0F, false));

		right_legs = new RendererModel(this);
		right_legs.setRotationPoint(-13.5F, 18.0F, 7.0F);
		right_legs.cubeList.add(new ModelBox(right_legs, 12, 37, 9.0F, 1.0F, -14.0F, 3, 5, 3, 0.0F, false));
		right_legs.cubeList.add(new ModelBox(right_legs, 26, 23, 9.0F, 5.0F, -15.0F, 3, 1, 1, 0.0F, false));
		right_legs.cubeList.add(new ModelBox(right_legs, 17, 23, 9.0F, 0.0F, -1.0F, 3, 6, 3, 0.0F, false));
		right_legs.cubeList.add(new ModelBox(right_legs, 8, 13, 9.0F, 5.0F, -2.0F, 3, 1, 1, 0.0F, false));

		tail_butt = new RendererModel(this);
		tail_butt.setRotationPoint(-13.0F, 18.0F, 8.5F);
		setRotationAngle(tail_butt, -0.0873F, 0.0F, 0.0F);
		tail_butt.cubeList.add(new ModelBox(tail_butt, 32, 0, 11.0F, -5.25F, -3.0F, 4, 4, 7, 0.0F, false));

		tail_tip = new RendererModel(this);
		tail_tip.setRotationPoint(0.0F, 14.75F, 16.5F);
		setRotationAngle(tail_tip, -0.2618F, 0.0F, 0.0F);
		tail_tip.cubeList.add(new ModelBox(tail_tip, 0, 23, -1.5F, 0.0F, -5.5F, 3, 3, 11, 0.0F, false));
	}

	@Override
	public void render(RedPandaEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		right_ear.render(f5);
		left_ear.render(f5);
		mouth_upper.render(f5);
		mouth_lower.render(f5);
		head.render(f5);
		torso.render(f5);
		left_legs.render(f5);
		right_legs.render(f5);
		tail_butt.render(f5);
		tail_tip.render(f5);
	}

	private void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}