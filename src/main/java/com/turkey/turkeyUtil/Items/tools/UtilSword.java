package com.turkey.turkeyUtil.items.tools;

import com.turkey.turkeyUtil.TurkeyUtil;

import net.minecraft.item.ItemSword;

public class UtilSword extends ItemSword
{
	public UtilSword(String unlocalizedName, ToolMaterial material)
	{
		super(material);
		
		this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(TurkeyUtil.MODID + ":" + unlocalizedName.toLowerCase());
        super.setCreativeTab(TurkeyUtil.baseModTab);
	}
}