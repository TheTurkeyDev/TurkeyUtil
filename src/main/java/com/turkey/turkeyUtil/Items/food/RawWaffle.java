package com.turkey.turkeyUtil.items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class RawWaffle extends TurkeyItemFood
{	
	public RawWaffle()
	{
		super(1, 0.5f, false, "Raw_Waffle", "waffle_raw", 64);
		super.addLore("Ewwwwwww");
		this.setCreativeTab(TurkeyUtil.baseModTab);
	}
}
