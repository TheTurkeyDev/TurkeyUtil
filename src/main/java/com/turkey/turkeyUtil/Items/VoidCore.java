package com.turkey.turkeyUtil.items;

import com.turkey.turkeyUtil.TurkeyUtil;

import net.minecraft.item.Item;

public class VoidCore extends Item
{
	public VoidCore()
	{
		this.setUnlocalizedName("Void_Core");
		this.setTextureName(TurkeyUtil.MODID + ":void_core");
		this.setCreativeTab(TurkeyUtil.baseModTab);
	}
}
