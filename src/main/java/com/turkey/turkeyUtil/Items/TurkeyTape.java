package com.turkey.turkeyUtil.Items;

import net.minecraft.item.Item;

import com.turkey.turkeyUtil.TurkeyUtil;

public class TurkeyTape extends Item
{
	public TurkeyTape()
	{
		super.setTextureName("turkeyutil:TurkeyTape");
		super.setUnlocalizedName("TurkeyTape");
		super.setCreativeTab(TurkeyUtil.modTab);
	}
}
