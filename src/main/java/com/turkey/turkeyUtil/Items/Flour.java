package com.turkey.turkeyUtil.Items;

import com.turkey.turkeyUtil.TurkeyUtil;

import net.minecraft.item.Item;

public class Flour extends Item
{
	public Flour()
	{
		super.setTextureName("turkeyutil:flour");
		super.setUnlocalizedName("Flour");
		super.setCreativeTab(TurkeyUtil.modTab);
	}
}
