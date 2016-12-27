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
		HopperType.createNewHopperType("Iron", 10, 8, 64, Blocks.IRON_BLOCK, Items.IRON_INGOT);
		HopperType.createNewHopperType("Gold", 5, 4, 64, Blocks.GOLD_BLOCK, Items.GOLD_INGOT);
		HopperType.createNewHopperType("Diamond", 10, 4, 64, Blocks.DIAMOND_BLOCK, Items.DIAMOND);
	}

	public static boolean isEnabled(String itemName)
	{
		boolean craftable = config.get(craftCat, itemName, true).getBoolean();
		config.save();
		return craftable;
	}
}