package com.turkey.turkeyUtil.Items;

import com.turkey.turkeyUtil.TurkeyUtil;

import net.minecraft.item.Item;

public class TurkeyFeather extends Item
{
	public TurkeyFeather()
	{
		super.setTextureName("turkeyutil:turkey_feather");
		super.setUnlocalizedName("Turkey_Feather");
		super.setCreativeTab(TurkeyUtil.baseModTab);
	}
}
