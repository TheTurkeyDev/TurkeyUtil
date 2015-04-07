package com.turkey.turkeyUtil.Hookins;

import net.minecraft.item.ItemStack;

import com.cricketcraft.chisel.init.ChiselBlocks;
import com.turkey.turkeyUtil.Items.food.UtilFood;

import cpw.mods.fml.common.registry.GameRegistry;

public class ChiselModHook
{
	
	public static boolean isEnabled = false;
	
	public ChiselModHook()
	{
		load();
		isEnabled = true;
	}
	
	public void load()
	{
		GameRegistry.addRecipe(new ItemStack(UtilFood.lime, 1),"AAA","AAA","AAA",'A', new ItemStack(ChiselBlocks.limestone, 1));
	}
	
	public static boolean isEnabled()
	{
		return isEnabled;
	}
}
