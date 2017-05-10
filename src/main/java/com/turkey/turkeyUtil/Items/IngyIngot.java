package com.turkey.turkeyUtil.items;

import com.theprogrammingturkey.gobblecore.items.BaseItem;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IngyIngot extends BaseItem
{
	public IngyIngot()
	{
		super("Ingy_The_Ingot");
		super.addLore("Spawns an Iron Golem when used.");
		super.addLore("SiylissTV, Member of the Walking Wounded");
	}

	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(world.isRemote)
		{
			return EnumActionResult.FAIL;
		}
		else
		{
			pos.offset(facing);

			Entity entity = spawnCreature(world, (double) pos.getX() + 0.5D, (double) pos.getY() + 2, (double) pos.getZ() + 0.5D);

			if(entity != null)
			{
				((EntityLiving) entity).setCustomNameTag("Siyliss");

				if(!player.capabilities.isCreativeMode)
				{
					--stack.stackSize;
				}
			}

			return EnumActionResult.SUCCESS;
		}
	}

	public static Entity spawnCreature(World world, double x, double y, double z)
	{
		EntityIronGolem entityirongolem = null;

		for(int j = 0; j < 1; ++j)
		{
			entityirongolem = new EntityIronGolem(world);

			if(entityirongolem != null && entityirongolem instanceof EntityLivingBase)
			{
				entityirongolem.setPlayerCreated(true);
				entityirongolem.setLocationAndAngles((double) x + 0.5D, (double) y - 1.95D, (double) z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(entityirongolem);

				for(int l = 0; l < 120; ++l)
				{
					world.spawnParticle(EnumParticleTypes.SNOWBALL, (double) x + world.rand.nextDouble(), (double) (y - 2) + world.rand.nextDouble() * 3.9D, (double) z + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}
			}
		}
		return entityirongolem;
	}
}