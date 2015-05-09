package com.turkey.turkeyUtil.Items.food;

import com.turkey.turkeyUtil.TurkeyUtil;

public class RawDuck extends TurkeyItemFood
{

	public RawDuck()
	{
		super(8, .25f, false, "Raw_Duck", "Turkey_Raw", 64);
		super.addLore("Totally not the same texture as turkey");
		this.setCreativeTab(TurkeyUtil.baseModTab);
	}

}
