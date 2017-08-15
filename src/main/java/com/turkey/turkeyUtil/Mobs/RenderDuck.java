package com.turkey.turkeyUtil.mobs;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDuck extends RenderLiving<EntityDuck>
{
	private static final ResourceLocation duckTextures = new ResourceLocation("turkeyutil:textures/entity/Duck.png");

	public RenderDuck(RenderManager renderManagerIn)
	{
		super(renderManagerIn, new ModelDuck(), 0.5f);
	}

	protected ResourceLocation getEntityTexture(EntityDuck p_110775_1_)
	{
		return duckTextures;
	}

	protected float handleRotationFloat(EntityDuck p_77044_1_, float p_77044_2_)
	{
		float f1 = p_77044_1_.field_70888_h + (p_77044_1_.field_70886_e - p_77044_1_.field_70888_h) * p_77044_2_;
		float f2 = p_77044_1_.field_70884_g + (p_77044_1_.destPos - p_77044_1_.field_70884_g) * p_77044_2_;
		return (MathHelper.sin(f1) + 1.0F) * f2;
	}
}