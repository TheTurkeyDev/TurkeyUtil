package com.turkey.turkeyUtil.Items;

import net.minecraft.item.Item;

import com.turkey.turkeyUtil.TurkeyUtil;

public class DarknessIngot extends Item
{
	public DarknessIngot()
	{
		this.setUnlocalizedName("Darkness_Ingot");
		this.setTextureName(TurkeyUtil.MODID + ":darkness_Ingot");
		this.setCreativeTab(TurkeyUtil.baseModTab);
	}
}
