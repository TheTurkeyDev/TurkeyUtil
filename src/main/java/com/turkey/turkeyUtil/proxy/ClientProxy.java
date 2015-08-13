package com.turkey.turkeyUtil.proxy;

import com.turkey.turkeyUtil.mobs.EntityDamageSkeleton;
import com.turkey.turkeyUtil.mobs.EntityDuck;
import com.turkey.turkeyUtil.mobs.EntityPoisonSkeleton;
import com.turkey.turkeyUtil.mobs.EntityRhea;
import com.turkey.turkeyUtil.mobs.EntityTurkey;
import com.turkey.turkeyUtil.mobs.EntityVoxel;
import com.turkey.turkeyUtil.mobs.ModelDuck;
import com.turkey.turkeyUtil.mobs.ModelRhea;
import com.turkey.turkeyUtil.mobs.ModelTurkey;
import com.turkey.turkeyUtil.mobs.ModelVoxel;
import com.turkey.turkeyUtil.mobs.RenderDamageSkeleton;
import com.turkey.turkeyUtil.mobs.RenderDuck;
import com.turkey.turkeyUtil.mobs.RenderPoisonSkeleton;
import com.turkey.turkeyUtil.mobs.RenderRhea;
import com.turkey.turkeyUtil.mobs.RenderTurkey;
import com.turkey.turkeyUtil.mobs.RenderVoxel;

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
	
	public void registerEvents()
	{
		
	}
}
