package com.turkey.turkeyUtil;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigLoader 
{
	private static Configuration config;
	private static final String entCat = "Entities";
	private static final String setCat = "Basic Settings";
	public static final String craftCat = "Craftable Settings";
	
	public static void loadConfigSettings(File file)
	{
		config = new Configuration(file);
		config.load();
		
		TurkeyUtilSettings.UpdateCheck = config.get(setCat, "Check for new Builds", true).getBoolean();
		TurkeyUtilSettings.DevBuildCheck = config.get(setCat, "Check for Dev Builds", true).getBoolean();
		
		TurkeyUtilSettings.TurkeyEntityID = config.get(entCat, "Turkey Entity ID", "7000").getInt();
		TurkeyUtilSettings.DuckEntityID = config.get(entCat, "Duck Entity ID", "7001").getInt();
		TurkeyUtilSettings.RheaEntityID = config.get(entCat, "Rhea Entity ID", "7002").getInt();
		TurkeyUtilSettings.VoxelEntityID = config.get(entCat, "Voxel Entity ID", "7003").getInt();
		TurkeyUtilSettings.PoisonSkeltonEntityID = config.get(entCat, "Poison Skelton Entity ID", "7010").getInt();
		
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