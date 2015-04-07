package com.turkey.turkeyUtil.Mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderTurkey extends RenderLiving
{

	ResourceLocation res = new ResourceLocation("turkeyutil:textures/entity/Turkey.png");
	
	public RenderTurkey(ModelBase model, float f) {
		super(model, f);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return res;
	}

}
