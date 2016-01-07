package com.turkey.turkeyUtil.items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class CookedTurkeyItem extends TurkeyItemFood
{
	public CookedTurkeyItem()
	{
		super(8, .375f, false, "Cooked_Turkey", "Turkey_Cooked", 64);
		this.setCreativeTab(TurkeyUtil.baseModTab);
	}
}
