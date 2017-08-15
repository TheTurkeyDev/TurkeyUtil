package com.turkey.turkeyUtil.mobs;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTurkey extends RenderLiving<EntityTurkey>
{
	private static final ResourceLocation RES = new ResourceLocation("turkeyutil:textures/entity/Turkey.png");

	public RenderTurkey(RenderManager renderManagerIn)
	{
		super(renderManagerIn, new ModelTurkey(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityTurkey entity)
	{
		return RES;
	}

}
