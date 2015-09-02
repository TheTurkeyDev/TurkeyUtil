package com.turkey.turkeyUtil.hookins.nei;

import codechicken.nei.api.IConfigureNEI;

import com.turkey.turkeyUtil.TurkeyUtil;

public class NEITurkeyUtilConfig implements IConfigureNEI
{
	@Override
	public void loadConfig()
	{
		//API.registerRecipeHandler(new LightCollectorRecipieHandler());
	    //API.registerUsageHandler(new LightCollectorRecipieHandler());
	}

	@Override
	public String getName()
	{
		return "Void Compression";
	}

	@Override
	public String getVersion()
	{
		return TurkeyUtil.MODID;
	}
}