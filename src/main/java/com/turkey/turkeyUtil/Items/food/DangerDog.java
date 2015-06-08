package com.turkey.turkeyUtil.Items.food;

import com.turkey.turkeyUtil.TurkeyUtil;


public class DangerDog extends TurkeyItemFood
{
	
	public DangerDog()
	{
		super(8, .25f, false, "Danger_Dog", "Danger_Dog", 16);
		super.addLore("It's wrapped in bacon! What more could you want!");
		super.addLore("AnneMunition, Member of The Walking Wounded");
		this.setCreativeTab(TurkeyUtil.walkingwoundedModTab);
	}
}
