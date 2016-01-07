package com.turkey.turkeyUtil.items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class Noodles extends TurkeyItemFood
{
	public Noodles()
	{
		super(3, .33f, false, "Noodles", "Noodles", 64);
		this.setCreativeTab(TurkeyUtil.noodlecraftModTab);
	}
}
