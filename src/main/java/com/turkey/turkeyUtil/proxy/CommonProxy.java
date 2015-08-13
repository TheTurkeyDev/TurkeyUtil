package com.turkey.turkeyUtil.proxy;

import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.events.ColoredIngotCraftingEvent;

import net.minecraftforge.oredict.RecipeSorter;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;


public class CommonProxy
{

	public boolean isClient()
	{
		return false;
	}

	public void registerGuis()
	{

	}

	public void registerRenderings()
	{

	}
	
	public void registerEvents()
	{
		ColoredIngotCraftingEvent event = new ColoredIngotCraftingEvent();
		RecipeSorter.register(TurkeyUtil.MODID + ":colored_ingot_crafting", ColoredIngotCraftingEvent.class, RecipeSorter.Category.SHAPED, "after:minecraft:shaped");
		GameRegistry.addRecipe(event);
		FMLCommonHandler.instance().bus().register(event);
	}
}
