package com.turkey.turkeyUtil;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigLoader 
{
	private static Configuration config;
	private static final String setCat = "Basic Settings";
	public static final String craftCat = "Craftable Settings";
	public static void loadConfigSettings(File file)
	{
		config = new Configuration(file);
		config.load();
		
		TurkeyUtilSettings.UpdateCheck = config.get(setCat, "Check for new Builds", true).getBoolean();
		TurkeyUtilSettings.DevBuildCheck = config.get(setCat, "Check for Dev Builds", true).getBoolean();
		TurkeyUtilSettings.blockedWorlds = config.getStringList("BlockedWorlds", setCat, new String[0], "Worlds that the Mystical ore shold not generate in");
		
		config.addCustomCategoryComment(craftCat, "Allows you to enable and disable items crafting recipies");
				
		config.save();
	}
	
	public static boolean isEnabled(String itemName)
	{
		boolean craftable = config.get(craftCat, itemName, true).getBoolean();
		config.save();
		return craftable;
	}
}