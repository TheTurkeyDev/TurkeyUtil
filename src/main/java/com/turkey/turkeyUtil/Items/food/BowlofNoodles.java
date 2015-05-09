package com.turkey.turkeyUtil.Items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class BowlofNoodles extends TurkeyItemFood
{	
	public BowlofNoodles()
	{
		super(8, .1875f, false, "Bowl_of_Noodles", "noodle_bowl", 64);
		super.addLore("What else would you expect for NoodleCraft");
		this.setCreativeTab(TurkeyUtil.noodlecraftModTab);
	}
}
