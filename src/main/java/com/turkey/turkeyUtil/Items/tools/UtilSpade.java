package com.turkey.turkeyUtil.items.tools;

import net.minecraft.item.ItemSpade;

import com.turkey.turkeyUtil.TurkeyUtil;

public class UtilSpade extends ItemSpade
{
	public UtilSpade(String unlocalizedName, ToolMaterial material)
	{
		super(material);
		
		this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(TurkeyUtil.MODID + ":" + unlocalizedName.toLowerCase());
        super.setCreativeTab(TurkeyUtil.baseModTab);
	}
}
