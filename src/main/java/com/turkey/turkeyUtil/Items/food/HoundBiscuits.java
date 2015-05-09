package com.turkey.turkeyUtil.Items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class HoundBiscuits extends TurkeyItemFood
{	
	public HoundBiscuits()
	{
		super(4, .25f, false, "Hound_Biscuit", "Hound_Biscuit", 64);
		super.addLore("Don't Worry, it's made for HumanEntities");
		this.setCreativeTab(TurkeyUtil.walkingwoundedModTab);
	}
}
