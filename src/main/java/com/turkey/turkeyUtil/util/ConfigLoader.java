package com.turkey.turkeyUtil.util;

import java.io.File;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.common.config.Configuration;

public class ConfigLoader 
{
	private static Configuration config;
	private static final String setCat = "Basic Settings";
	private static final String gameCat = "In-Game Settings";
	public static final String craftCat = "Craftable Settings";
	public static void loadConfigSettings(File file)
	{
		config = new Configuration(file);
		config.load();
		
		loadHopperTypes();
		
		UtilSettings.UpdateCheck = config.get(setCat, "Check for new Builds", true).getBoolean();
		UtilSettings.blockedWorlds = config.getStringList("BlockedWorlds", setCat, new String[0], "Worlds that the Mystical ore shold not generate in");
		UtilSettings.cobbleArmorSlow = config.get(gameCat, "Cobble Armor Slows", true).getBoolean();
		config.addCustomCategoryComment(craftCat, "Allows you to enable and disable items crafting recipies");
				
		config.save();
	}
	
	private static void loadHopperTypes()
	{
		HopperType.createNewHopperType("Iron", 10, 8, 64, Blocks.iron_block, Items.iron_ingot);
		HopperType.createNewHopperType("Gold", 5, 4, 64, Blocks.gold_block, Items.gold_ingot);
		HopperType.createNewHopperType("Diamond", 10, 4, 64, Blocks.diamond_block, Items.diamond);
	}

	public static boolean isEnabled(String itemName)
	{
		boolean craftable = config.get(craftCat, itemName, true).getBoolean();
		config.save();
		return craftable;
	}
}