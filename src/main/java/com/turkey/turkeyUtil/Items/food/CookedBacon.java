package com.turkey.turkeyUtil.Items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class CookedBacon extends TurkeyItemFood
{	
	public CookedBacon()
	{
		super(4, .375f, false, "Cooked_Bacon", "bacon_cooked", 64);
		this.setCreativeTab(TurkeyUtil.baseModTab);
	}
}
