package com.turkey.turkeyUtil.Items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class CookedHotdog extends TurkeyItemFood
{
	public CookedHotdog()
	{
		super(5, .2f, false, "Cooked_Hotdog", "hotdog_cooked", 64);
		this.setCreativeTab(TurkeyUtil.baseModTab);
	}
}
