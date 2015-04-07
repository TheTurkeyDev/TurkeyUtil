package com.turkey.turkeyUtil.proxy;

import com.turkey.turkeyUtil.Mobs.EntityDamageSkeleton;
import com.turkey.turkeyUtil.Mobs.EntityDuck;
import com.turkey.turkeyUtil.Mobs.EntityPoisonSkeleton;
import com.turkey.turkeyUtil.Mobs.EntityRhea;
import com.turkey.turkeyUtil.Mobs.EntityTurkey;
import com.turkey.turkeyUtil.Mobs.EntityVoxel;
import com.turkey.turkeyUtil.Mobs.ModelDuck;
import com.turkey.turkeyUtil.Mobs.ModelRhea;
import com.turkey.turkeyUtil.Mobs.ModelTurkey;
import com.turkey.turkeyUtil.Mobs.ModelVoxel;
import com.turkey.turkeyUtil.Mobs.RenderDamageSkeleton;
import com.turkey.turkeyUtil.Mobs.RenderDuck;
import com.turkey.turkeyUtil.Mobs.RenderPoisonSkeleton;
import com.turkey.turkeyUtil.Mobs.RenderRhea;
import com.turkey.turkeyUtil.Mobs.RenderTurkey;
import com.turkey.turkeyUtil.Mobs.RenderVoxel;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{

	@Override
	public boolean isClient()
	{
		return true;
	}

	public void registerGuis()
	{

	}

	public void registerRenderings()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityTurkey.class, new RenderTurkey(new ModelTurkey(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityDuck.class, new RenderDuck(new ModelDuck(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityRhea.class, new RenderRhea(new ModelRhea(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityVoxel.class, new RenderVoxel(new ModelVoxel(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityPoisonSkeleton.class, new RenderPoisonSkeleton());
		RenderingRegistry.registerEntityRenderingHandler(EntityDamageSkeleton.class, new RenderDamageSkeleton());
	}
}
