package com.turkey.turkeyUtil.items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class Genpie extends TurkeyItemFood
{
	public Genpie()
	{
		super(8, .375f, false, "Genpie", "genpie", 16);
		super.addLore("For our wounderful Genipherpher");
		super.addLore("Genipherpher, Member of NoodleCraft");
		this.setCreativeTab(TurkeyUtil.noodlecraftModTab);
	}
}
