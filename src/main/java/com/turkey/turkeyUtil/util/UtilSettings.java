package com.turkey.turkeyUtil.util;

public class UtilSettings
{
	public static boolean UpdateCheck = true;

	public static boolean cobbleArmorSlow = true;

	public static int voidBiomeID = 42;
	public static int voidDimensionID = -4;
	public static boolean disableVoidworld = false;
	
	public static String[] blockedWorlds = new String[] {};

	public static boolean isBlockedWorld(String world)
	{
		for(String blockedWorld : blockedWorlds)
			if(blockedWorld.equalsIgnoreCase(world))
				return true;
		return false;
	}
}
