package com.turkey.turkeyUtil.hookins;

import net.minecraft.item.ItemStack;

import org.apache.logging.log4j.Level;

import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.items.food.UtilFood;

import cpw.mods.fml.common.registry.GameRegistry;

public class ChiselModHook extends UtilHookin
{

	public void load()
	{
		try{
			GameRegistry.addRecipe(new ItemStack(UtilFood.lime, 1),"AAA","AAA","AAA",'A', new ItemStack(GameRegistry.findBlock("chisel", "limestone"), 1));
		} catch (NoClassDefFoundError e)
		{
			TurkeyUtil.logger.log(Level.WARN, "Unable to load Chisel 2 mod hook!!!! You may have the wrong chisel mod or something has just gone wrong!");
		}
	}
}