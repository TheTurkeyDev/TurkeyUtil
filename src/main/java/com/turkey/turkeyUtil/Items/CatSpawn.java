package com.turkey.turkeyUtil.Items;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.TurkeyUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CatSpawn extends Item
{
	public CatSpawn()
	{
		super.setTextureName("turkeyutil:happiness");
		super.setUnlocalizedName("Happiness");
		super.setCreativeTab(TurkeyUtil.modTab);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) 
	{
		list.add("Brings temporary Happiness.... to RyanTheAllmighty atleast");
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if(world.isRemote)
			return stack;
		int x = (int) player.posX-2;
		int z = (int) player.posZ-2;
		for(int xx = 0; xx < 5; xx++)
		{
			for(int zz = 0; zz < 5; zz++)
			{
				spawnCreature(world, (double)x+xx + 0.5D, (double)player.posY + 2, (double)z+zz + 0.5D);
			}
		}
		--stack.stackSize;
        return stack;
    }
	
	public static Entity spawnCreature(World world, double x, double y, double z)
	{
		EntityOcelot entitycat = null;

		for (int j = 0; j < 1; ++j)
		{
			entitycat = new EntityOcelot(world);

			if (entitycat != null && entitycat instanceof EntityLivingBase)
			{
				entitycat.setLocationAndAngles((double)x + 0.5D, (double)y - 1.95D, (double)z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(entitycat);
				entitycat.setHealth(2);
				entitycat.addPotionEffect(new PotionEffect(Potion.wither.id, 1000));

				for (int l = 0; l < 120; ++l)
				{
					world.spawnParticle("snowballpoof", (double)x + world.rand.nextDouble(), (double)(y - 2) + world.rand.nextDouble() * 3.9D, (double)z + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}
			}
		}
		return entitycat;
	}
}
