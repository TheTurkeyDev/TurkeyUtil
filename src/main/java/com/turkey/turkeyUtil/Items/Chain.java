package com.turkey.turkeyUtil.Items;

import com.turkey.turkeyUtil.TurkeyUtil;

import net.minecraft.item.Item;

public class Chain extends Item
{
	public Chain()
	{
		super.setTextureName("turkeyutil:chain");
		super.setUnlocalizedName("Chain");
		super.setCreativeTab(TurkeyUtil.baseModTab);
	}
}
