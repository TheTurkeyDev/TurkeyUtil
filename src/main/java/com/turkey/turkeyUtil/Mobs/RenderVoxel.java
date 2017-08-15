package com.turkey.turkeyUtil.mobs;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderVoxel extends RenderLiving<EntityVoxel>
{
	private static final ResourceLocation wolfTextures = new ResourceLocation("turkeyutil:textures/entity/voxel.png");
	private static final ResourceLocation tamedWolfTextures = new ResourceLocation("turkeyutil:textures/entity/voxel.png");

	public RenderVoxel(RenderManager renderManagerIn)
	{
		super(renderManagerIn, new ModelVoxel(), 0.5f);
	}

	/**
	 * Defines what float the third param in setRotationAngles of ModelBase is
	 */
	protected float handleRotationFloat(EntityVoxel p_77044_1_, float p_77044_2_)
	{
		return p_77044_1_.getTailRotation();
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityVoxel p_110775_1_)
	{
		return p_110775_1_.isTamed() ? tamedWolfTextures : wolfTextures;
	}
}