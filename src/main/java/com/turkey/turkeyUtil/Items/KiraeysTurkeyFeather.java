package com.turkey.turkeyUtil.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.TurkeyUtil;

public class KiraeysTurkeyFeather extends Item
{
	public KiraeysTurkeyFeather()
	{
		super.setTextureName("turkeyutil:kiraeys_turkey_feather");
		super.setUnlocalizedName("Kiraeys_Turkey_Feather");
		super.setCreativeTab(TurkeyUtil.baseModTab);
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		stack.stackSize--;
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 100, 5));
		player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 100, 2));
		return stack;
	}
}
