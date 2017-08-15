package com.turkey.turkeyUtil.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelTurkey extends ModelBase
{
	private ModelRenderer main_Body;
	private ModelRenderer right_Wing;
	private ModelRenderer left_Wing;
	private ModelRenderer neck;
	private ModelRenderer head;
	private ModelRenderer back_Wing;
	private ModelRenderer lower_Top_Body;
	private ModelRenderer beak;
	private ModelRenderer tail;
	private ModelRenderer right_Leg;
	private ModelRenderer left_Leg;
	private ModelRenderer right_Foot;
	private ModelRenderer left_Foot;

	public ModelTurkey()
	{
		textureWidth = 128;
		textureHeight = 64;

		main_Body = new ModelRenderer(this, 0, 0);
		main_Body.addBox(0F, 0F, 0F, 20, 9, 13);
		main_Body.setRotationPoint(-8F, 11F, -6F);
		main_Body.setTextureSize(128, 64);
		main_Body.mirror = true;
		setRotation(main_Body, 0F, 0F, 0F);
		right_Wing = new ModelRenderer(this, 66, 0);
		right_Wing.addBox(0F, 0F, 0F, 10, 6, 1);
		right_Wing.setRotationPoint(-6F, 12F, -7F);
		right_Wing.setTextureSize(128, 64);
		right_Wing.mirror = true;
		setRotation(right_Wing, 0F, 0F, 0F);
		left_Wing = new ModelRenderer(this, 66, 7);
		left_Wing.addBox(0F, 0F, 0F, 10, 6, 1);
		left_Wing.setRotationPoint(-7F, 12F, 6.866667F);
		left_Wing.setTextureSize(128, 64);
		left_Wing.mirror = true;
		setRotation(left_Wing, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 45);
		neck.addBox(0F, 0F, 0F, 2, 4, 3);
		neck.setRotationPoint(-7F, 8F, -1F);
		neck.setTextureSize(128, 64);
		neck.mirror = true;
		setRotation(neck, 0F, 0F, 0.2602503F);
		head = new ModelRenderer(this, 10, 45);
		head.addBox(-4F, 0F, -2F, 4, 2, 3);
		head.setRotationPoint(-6F, 7F, 1F);
		head.setTextureOffset(4, 1);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		back_Wing = new ModelRenderer(this, 0, 22);
		back_Wing.addBox(0F, 0F, 0F, 15, 1, 11);
		back_Wing.setRotationPoint(-4F, 10F, -5F);
		back_Wing.setTextureSize(128, 64);
		back_Wing.mirror = true;
		setRotation(back_Wing, 0F, 0F, 0F);
		lower_Top_Body = new ModelRenderer(this, 0, 34);
		lower_Top_Body.addBox(0F, 0F, 0F, 14, 2, 9);
		lower_Top_Body.setRotationPoint(-4F, 8F, -4F);
		lower_Top_Body.setTextureSize(128, 64);
		lower_Top_Body.mirror = true;
		setRotation(lower_Top_Body, 0F, 0F, 0F);
		beak = new ModelRenderer(this, 0, 52);
		beak.addBox(-5F, 1F, -1F, 1, 2, 1);
		beak.setRotationPoint(-6F, 7F, 1F);
		beak.setTextureSize(128, 64);
		beak.mirror = true;
		setRotation(beak, 0F, 0F, 0F);
		tail = new ModelRenderer(this, 88, 30);
		tail.addBox(0F, 0F, 0F, 0, 14, 20);
		tail.setRotationPoint(15F, 3F, -9F);
		tail.setTextureSize(128, 64);
		tail.mirror = true;
		setRotation(tail, 0F, 0F, 0.4833219F);
		right_Leg = new ModelRenderer(this, 0, 55);
		right_Leg.addBox(0F, 0F, 0F, 0, 4, 1);
		right_Leg.setRotationPoint(4F, 20F, -3F);
		right_Leg.setTextureSize(128, 64);
		right_Leg.mirror = true;
		setRotation(right_Leg, 0F, 0F, 0F);
		left_Leg = new ModelRenderer(this, 2, 55);
		left_Leg.addBox(0F, 0F, 0F, 0, 4, 1);
		left_Leg.setRotationPoint(4F, 20F, 3F);
		left_Leg.setTextureSize(128, 64);
		left_Leg.mirror = true;
		setRotation(left_Leg, 0F, 0F, 0F);
		right_Foot = new ModelRenderer(this, 0, 60);
		right_Foot.addBox(0F, 0F, 0F, 1, 0, 1);
		right_Foot.setRotationPoint(3F, 24F, -3F);
		right_Foot.setTextureSize(128, 64);
		right_Foot.mirror = true;
		setRotation(right_Foot, 0F, 0F, 0F);
		left_Foot = new ModelRenderer(this, 0, 61);
		left_Foot.addBox(0F, 0F, 0F, 1, 0, 1);
		left_Foot.setRotationPoint(3F, 24F, 3F);
		left_Foot.setTextureSize(128, 64);
		left_Foot.mirror = true;
		setRotation(left_Foot, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		main_Body.render(f5);
		right_Wing.render(f5);
		left_Wing.render(f5);
		neck.render(f5);
		head.render(f5);
		back_Wing.render(f5);
		lower_Top_Body.render(f5);
		beak.render(f5);
		tail.render(f5);
		right_Leg.render(f5);
		left_Leg.render(f5);
		right_Foot.render(f5);
		left_Foot.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
		this.head.rotateAngleZ = f4 / (180F / (float) Math.PI);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.beak.rotateAngleZ = this.head.rotateAngleZ;
		this.beak.rotateAngleY = this.head.rotateAngleY;
		this.right_Leg.rotateAngleZ = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		this.right_Foot.rotateAngleZ = this.right_Leg.rotateAngleZ;
		this.left_Leg.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
		this.left_Foot.rotateAngleZ = this.left_Foot.rotateAngleZ;
		this.right_Wing.rotateAngleX = f3;
		this.left_Wing.rotateAngleX = -f3;
	}

}
