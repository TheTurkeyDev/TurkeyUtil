package com.turkey.turkeyUtil.Items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class KeyLimePie extends TurkeyItemFood
{	
	public KeyLimePie()
	{
		super(8, .25f, false, "Key_Lime_Pie", "key_lime_pie", 16);
		this.setCreativeTab(TurkeyUtil.baseModTab);
	}
}
