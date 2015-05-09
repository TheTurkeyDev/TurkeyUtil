package com.turkey.turkeyUtil.Items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class CookedChickenNugget extends TurkeyItemFood
{
	public CookedChickenNugget()
	{
		super(3, .33f, false, "Cooked_Chicken_Nugget", "nugget_cooked", 64);
		this.setCreativeTab(TurkeyUtil.baseModTab);
	}
}
