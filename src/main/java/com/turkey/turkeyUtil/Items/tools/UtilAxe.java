package com.turkey.turkeyUtil.items.tools;

import net.minecraft.item.ItemAxe;

import com.turkey.turkeyUtil.TurkeyUtil;

public class UtilAxe extends ItemAxe
{
	public UtilAxe(String unlocalizedName, ToolMaterial material)
	{
		super(material);
		
		this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(TurkeyUtil.MODID + ":" + unlocalizedName.toLowerCase());
        super.setCreativeTab(TurkeyUtil.baseModTab);
	}
}