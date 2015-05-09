package com.turkey.turkeyUtil.Items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class Waffle extends TurkeyItemFood
{	
	public Waffle()
	{
		super(8, .25f, false, "Waffle", "waffle", 64);
		super.addLore("\"Waffles\" - Mc_guitarist1795 2015");
		this.setCreativeTab(TurkeyUtil.noodlecraftModTab);
	}
}
