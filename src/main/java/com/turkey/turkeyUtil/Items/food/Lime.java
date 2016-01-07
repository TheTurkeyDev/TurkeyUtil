package com.turkey.turkeyUtil.items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class Lime extends TurkeyItemFood
{
	
	public Lime()
	{
		super(1, 0.2f, false, "Lime", "Lime", 64);
		super.addLore("What? Is that not how it works?");
		this.setCreativeTab(TurkeyUtil.baseModTab);
	}
}
