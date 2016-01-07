package com.turkey.turkeyUtil.items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class DoughnutBacon extends TurkeyItemFood
{	
	public DoughnutBacon()
	{
		super(6, .167f, false, "Doughnut_Bacon", "doughnut_bacon", 64);
		super.addLore("Because BaconDonuts are too mainstream.");
		super.addLore("Bacon_Donut, Member of The Build Guild");
		this.setCreativeTab(TurkeyUtil.buildguildmodTab);
	}
}
