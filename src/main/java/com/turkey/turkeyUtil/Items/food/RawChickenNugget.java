package com.turkey.turkeyUtil.Items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class RawChickenNugget extends TurkeyItemFood
{
	public RawChickenNugget()
	{
		super(1, .5f, false, "Raw_Chicken_Nugget", "nugget_raw", 64);
		this.setCreativeTab(TurkeyUtil.baseModTab);
	}
}
