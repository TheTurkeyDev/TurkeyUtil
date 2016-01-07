package com.turkey.turkeyUtil.items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class RawBacon extends TurkeyItemFood
{	
	public RawBacon()
	{
		super(1, 0.5f, false, "Raw_Bacon", "bacon_raw", 64);
		this.setCreativeTab(TurkeyUtil.baseModTab);
	}
}
