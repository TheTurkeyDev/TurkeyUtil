package com.turkey.turkeyUtil.items;

import java.util.ArrayList;
import java.util.List;

import com.theprogrammingturkey.gobblecore.items.BaseItem;
import com.theprogrammingturkey.gobblecore.util.Scheduler;
import com.theprogrammingturkey.gobblecore.util.Task;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class CatSpawn extends BaseItem
{
	public CatSpawn()
	{
		super("Happiness");
		super.addLore("Brings temporary Happiness.... to RyanTheAllmighty atleast");
		super.addLore("RyanTheAllmighty, Member of the Walking Wounded");
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if(world.isRemote)
			return stack;
		int x = (int) player.posX - 2;
		int z = (int) player.posZ - 2;
		final List<Entity> entities = new ArrayList<Entity>();
		for(int xx = 0; xx < 5; xx++)
		{
			for(int zz = 0; zz < 5; zz++)
			{
				entities.add(spawnCreature(world, (double) x + xx + 0.5D, (double) player.posY + 2, (double) z + zz + 0.5D));
			}
		}
		--stack.stackSize;

		Scheduler.scheduleTask(new Task("Happiness_Reward", 60)
		{

			@Override
			public void callback()
			{
				for(Entity ent : entities)
				{
					ent.setDead();
				}
			}
		});

		return stack;
	}

	public static Entity spawnCreature(World world, double x, double y, double z)
	{
		EntityOcelot entitycat = null;

		for(int j = 0; j < 1; ++j)
		{
			entitycat = new EntityOcelot(world);

			if(entitycat != null && entitycat instanceof EntityLivingBase)
			{
				entitycat.setLocationAndAngles((double) x + 0.5D, (double) y - 1.95D, (double) z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(entitycat);

				for(int l = 0; l < 120; ++l)
				{
					world.spawnParticle(EnumParticleTypes.SNOWBALL, (double) x + world.rand.nextDouble(), (double) (y - 2) + world.rand.nextDouble() * 3.9D, (double) z + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}
			}
		}
		return entitycat;
	}
}
