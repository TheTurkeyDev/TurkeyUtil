package com.turkey.turkeyUtil.items.food;

import com.theprogrammingturkey.gobblecore.items.BaseItemFood;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class RockSoup extends BaseItemFood
{
	public RockSoup()
	{
		super("rock_soup", 4, .25f, false);
		super.addLore("MMMMM Tasty");
	}

	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		player.attackEntityFrom(DamageSource.starve, 2.0f);

		player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600, 0));
		return super.onEaten(stack, world, player);
	}
}