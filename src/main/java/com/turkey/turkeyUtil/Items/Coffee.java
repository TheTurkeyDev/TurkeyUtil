package com.turkey.turkeyUtil.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.TurkeyUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Coffee extends Item
{
	public Coffee()
	{
		super.setTextureName("turkeyutil:Coffee");
		super.setUnlocalizedName("Darkosto's_Coffee");
		this.setMaxStackSize(8);
		this.setCreativeTab(TurkeyUtil.walkingwoundedModTab);
	}

	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		if (!player.capabilities.isCreativeMode)
		{
			--stack.stackSize;
		}

		if (!world.isRemote)
		{
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 1800, 2));
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
		return EnumAction.drink;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		return stack;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) 
	{
		list.add("The one, the only, Darkosto");
	}
}
