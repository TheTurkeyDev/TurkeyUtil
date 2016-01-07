package com.turkey.turkeyUtil.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class KiraeysTurkeyFeather extends BaseItemUtil
{
	public KiraeysTurkeyFeather()
	{
		super("Kiraeys_Turkey_Feather");
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		stack.stackSize--;
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 100, 5));
		player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 100, 2));
		return stack;
	}
}
