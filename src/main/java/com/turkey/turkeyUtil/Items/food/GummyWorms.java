package com.turkey.turkeyUtil.items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class GummyWorms extends TurkeyItemFood
{	
	public GummyWorms()
	{
		super(5, .2f, false, "Gummy_worms", "gummy_worms", 64);
		this.setCreativeTab(TurkeyUtil.baseModTab);
	}
}
