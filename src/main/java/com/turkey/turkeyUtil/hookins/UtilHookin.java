package com.turkey.turkeyUtil.hookins;

public abstract class UtilHookin
{
	public static boolean isEnabled = false;

	public UtilHookin()
	{
		load();
		isEnabled = true;
	}
	

	public static boolean isEnabled()
	{
		return isEnabled;
	}
	
	public abstract void load();
}
