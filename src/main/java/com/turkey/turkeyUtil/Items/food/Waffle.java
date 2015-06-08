package com.turkey.turkeyUtil.Items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class Waffle extends TurkeyItemFood
{	
	public Waffle()
	{
		super(8, .25f, false, "Waffle", "waffle", 64);
		super.addLore("\"Waffles\" - Mc_guitarist1795 2015");
		super.addLore("MC_GUITARIST1795, Member of NoodleCraft");
		this.setCreativeTab(TurkeyUtil.noodlecraftModTab);
	}
}
