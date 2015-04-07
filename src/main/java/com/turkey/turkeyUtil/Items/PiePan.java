package com.turkey.turkeyUtil.Items;

import com.turkey.turkeyUtil.TurkeyUtil;

import net.minecraft.item.Item;

public class PiePan extends Item
{
	public PiePan()
	{
		super.setTextureName("turkeyutil:pie_pan");
		super.setUnlocalizedName("Pie_Pan");
		super.setCreativeTab(TurkeyUtil.modTab);
		super.setContainerItem(this);
	}
}
