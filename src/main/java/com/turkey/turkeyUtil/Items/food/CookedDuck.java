package com.turkey.turkeyUtil.items.food;

import com.turkey.turkeyUtil.TurkeyUtil;

public class CookedDuck extends TurkeyItemFood
{

	public CookedDuck()
	{
		super(8, .25f, false, "Cooked_Duck", "Turkey_Cooked", 64);
		super.addLore("Totally not the same texture as turkey");
		this.setCreativeTab(TurkeyUtil.baseModTab);
	}

}
