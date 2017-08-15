package com.turkey.turkeyUtil.mobs;

import com.theprogrammingturkey.gobblecore.entity.EntityLoader;
import com.theprogrammingturkey.gobblecore.entity.IEntityHandler;

public class UtilMobs implements IEntityHandler
{

	@Override
	public void registerEntities(EntityLoader loader)
	{
		loader.registerEntityWithEgg("turkey", EntityTurkey.class, 120, 1, true, 0x522900, 0xE68A00);
		loader.registerEntityWithEgg("duck", EntityDuck.class, 120, 1, true, 0xA65300, 0x005300);
		loader.registerEntityWithEgg("rhea", EntityRhea.class, 120, 1, true, 0x291400, 0x694016);
		loader.registerEntityWithEgg("voxel", EntityVoxel.class, 120, 1, true, 0x999999, 0xEBEBEB);
		loader.registerEntityWithEgg("poison_skeleton", EntityPoisonSkeleton.class, 120, 1, true, 0xCCCCCC, 0x009933);
		loader.registerEntityWithEgg("damage_skeleton", EntityDamageSkeleton.class, 120, 1, true, 0xCCCCCC, 0x800000);
	}

	@Override
	public void registerRenderings(EntityLoader loader)
	{
		loader.registerEntityRendering(EntityTurkey.class, RenderTurkey.class);
		loader.registerEntityRendering(EntityDuck.class, RenderDuck.class);
		loader.registerEntityRendering(EntityRhea.class, RenderRhea.class);
		loader.registerEntityRendering(EntityVoxel.class, RenderVoxel.class);
		loader.registerEntityRendering(EntityPoisonSkeleton.class, RenderPoisonSkeleton.class);
		loader.registerEntityRendering(EntityDamageSkeleton.class, RenderDamageSkeleton.class);
	}
}
