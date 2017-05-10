package com.turkey.turkeyUtil.items;

import com.theprogrammingturkey.gobblecore.items.BaseItem;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class KiraeysTurkeyFeather extends BaseItem
{
	public KiraeysTurkeyFeather()
	{
		super("Kiraeys_Turkey_Feather");
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		stack.stackSize--;
		player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 100, 5));
		player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 100, 2));
		return stack;
	}
}
