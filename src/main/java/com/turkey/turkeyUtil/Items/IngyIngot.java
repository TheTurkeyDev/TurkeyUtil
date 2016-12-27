package com.turkey.turkeyUtil.items;

import com.theprogrammingturkey.gobblecore.items.BaseItem;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.world.World;

public class IngyIngot extends BaseItem
{	
	public IngyIngot()
	{
		super("Ingy_The_Ingot");
		super.addLore("Spawns an Iron Golem when used.");
		super.addLore("SiylissTV, Member of the Walking Wounded");
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
		if (world.isRemote)
		{
			return true;
		}
		else
		{
			p_77648_4_ += Facing.offsetsXForSide[p_77648_7_];
			p_77648_5_ += Facing.offsetsYForSide[p_77648_7_];
			p_77648_6_ += Facing.offsetsZForSide[p_77648_7_];

			Entity entity = spawnCreature(world, (double)p_77648_4_ + 0.5D, (double)p_77648_5_ + 2, (double)p_77648_6_ + 0.5D);

			if (entity != null)
			{
				((EntityLiving)entity).setCustomNameTag("Siyliss");
				
				if (!player.capabilities.isCreativeMode)
				{
					--stack.stackSize;
				}
			}

			return true;
		}
	}

	public static Entity spawnCreature(World world, double x, double y, double z)
	{
		EntityIronGolem entityirongolem = null;

		for (int j = 0; j < 1; ++j)
		{
			entityirongolem = new EntityIronGolem(world);

			if (entityirongolem != null && entityirongolem instanceof EntityLivingBase)
			{
				entityirongolem.setPlayerCreated(true);
				entityirongolem.setLocationAndAngles((double)x + 0.5D, (double)y - 1.95D, (double)z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(entityirongolem);

				for (int l = 0; l < 120; ++l)
				{
					world.spawnParticle("snowballpoof", (double)x + world.rand.nextDouble(), (double)(y - 2) + world.rand.nextDouble() * 3.9D, (double)z + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}
			}
		}
		return entityirongolem;
	}
}