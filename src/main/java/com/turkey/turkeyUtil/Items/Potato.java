package com.turkey.turkeyUtil.Items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.turkey.turkeyUtil.TurkeyUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Potato extends Item
{	
	public Potato()
	{
		super.setTextureName("turkeyutil:Potato");
		super.setUnlocalizedName("Draskia's_Potato");
		super.setCreativeTab(TurkeyUtil.modTab);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) 
	{
		list.add("Turns a Zombie Villager into a regular Villager");
	}
}
