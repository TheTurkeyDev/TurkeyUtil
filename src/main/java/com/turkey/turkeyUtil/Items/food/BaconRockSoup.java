package com.turkey.turkeyUtil.items.food;

import com.theprogrammingturkey.gobblecore.items.BaseItemFood;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BaconRockSoup extends BaseItemFood
{
	public BaconRockSoup()
	{
		super("bacon_rock_soup", 8, .1875f, false);
		super.addLore("\"Everything is better With bacon\" - MyasisDragon");
	}

	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		player.attackEntityFrom(DamageSource.starve, 1.5f);

		player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600, 0));
		return super.onEaten(stack, world, player);
	}
}
