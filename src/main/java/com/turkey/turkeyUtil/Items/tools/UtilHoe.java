package com.turkey.turkeyUtil.items.tools;

import net.minecraft.item.ItemHoe;

import com.turkey.turkeyUtil.TurkeyUtil;

public class UtilHoe extends ItemHoe
{
	public UtilHoe(String unlocalizedName, ToolMaterial material)
	{
		super(material);
		
		this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(TurkeyUtil.MODID + ":" + unlocalizedName.toLowerCase());
        super.setCreativeTab(TurkeyUtil.baseModTab);
	}
}