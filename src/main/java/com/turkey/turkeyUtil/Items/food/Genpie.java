package com.turkey.turkeyUtil.Items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class Genpie extends TurkeyItemFood
{
	public Genpie()
	{
		super(8, .375f, false, "Genpie", "genpie", 16);
		super.addLore("For our wounderful Genipherpher");
		this.setCreativeTab(TurkeyUtil.noodlecraftModTab);
	}
}
