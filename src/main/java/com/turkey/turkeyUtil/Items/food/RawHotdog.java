package com.turkey.turkeyUtil.items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class RawHotdog extends TurkeyItemFood
{
	public RawHotdog()
	{
		super(1, 0.5f, false, "Raw_Hotdog", "hotdog_raw", 64);
		this.setCreativeTab(TurkeyUtil.baseModTab);
	}

}
