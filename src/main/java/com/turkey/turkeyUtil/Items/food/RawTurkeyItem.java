package com.turkey.turkeyUtil.items.food;

import com.turkey.turkeyUtil.TurkeyUtil;

public class RawTurkeyItem extends TurkeyItemFood
{
	public RawTurkeyItem()
	{
		super(1, 1f, false, "Raw_Turkey", "Turkey_Raw", 64);
		this.setCreativeTab(TurkeyUtil.baseModTab);
	}
}