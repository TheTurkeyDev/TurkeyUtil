package com.turkey.turkeyUtil.mobs;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDamageSkeleton extends RenderBiped<EntityDamageSkeleton>
{
	private static final ResourceLocation skeletonTextures = new ResourceLocation("textures/entity/skeleton/skeleton.png");

	public RenderDamageSkeleton(RenderManager renderManagerIn)
	{
		super(renderManagerIn, new ModelDamageSkeleton(), 0.5F);
	}

	protected void func_82422_c()
	{
		GL11.glTranslatef(0.09375F, 0.1875F, 0.0F);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityDamageSkeleton p_110775_1_)
	{
		return skeletonTextures;
	}
}