package com.turkey.turkeyUtil.items;

import com.theprogrammingturkey.gobblecore.items.BaseItem;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Coffee extends BaseItem
{
	public Coffee()
	{
		super("Darkosto's_Coffee");
		this.setMaxStackSize(8);
		super.addLore("The one, the only, Darkosto!");
		super.addLore("FeelsBirthdayMan");
	}

	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		if(!player.capabilities.isCreativeMode)
		{
			--stack.stackSize;
		}

		if(!world.isRemote)
		{
			player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 1800, 2));
		}

		return stack;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	public int getMaxItemUseDuration(ItemStack p_77626_1_)
	{
		return 32;
	}

	/**
	 * returns the action that specifies what animation to play when the items is being used
	 */
	public EnumAction getItemUseAction(ItemStack stack)
	{
		return EnumAction.DRINK;
	}
}
