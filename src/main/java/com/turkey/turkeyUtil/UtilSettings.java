package com.turkey.turkeyUtil;

public class UtilSettings
{
	public static boolean UpdateCheck = true;

	public static boolean cobbleArmorSlow = true;

	public static String[] blockedWorlds = new String[] {};

	public static boolean isBlockedWorld(String world)
	{
		for(String blockedWorld : blockedWorlds)
			if(blockedWorld.equalsIgnoreCase(world))
				return true;
		return false;
	}
}
