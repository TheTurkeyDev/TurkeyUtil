package com.turkey.turkeyUtil.Items;

import com.turkey.turkeyUtil.TurkeyUtil;

import net.minecraft.item.Item;

public class LightIngot extends Item
{
	public LightIngot()
	{
		this.setUnlocalizedName("Light_Ingot");
		this.setTextureName(TurkeyUtil.MODID + ":light_Ingot");
		this.setCreativeTab(TurkeyUtil.baseModTab);
	}

}
