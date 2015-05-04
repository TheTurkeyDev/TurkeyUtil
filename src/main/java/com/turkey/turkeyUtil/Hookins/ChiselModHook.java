package com.turkey.turkeyUtil.Hookins;

import org.apache.logging.log4j.Level;

import net.minecraft.item.ItemStack;

import com.cricketcraft.chisel.init.ChiselBlocks;
import com.turkey.turkeyUtil.TurkeyUtil;
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
		try{
			GameRegistry.addRecipe(new ItemStack(UtilFood.lime, 1),"AAA","AAA","AAA",'A', new ItemStack(ChiselBlocks.limestone, 1));
		} catch (NoClassDefFoundError e)
		{
			TurkeyUtil.logger.log(Level.WARN, "Unable to load Chisel 2 mod hook!!!! You may have the wrong chisel mod or something has just gone wrong!");
		}
	}

	public static boolean isEnabled()
	{
		return isEnabled;
	}
}
