package com.turkey.turkeyUtil.Items.tools;

import net.minecraft.item.ItemPickaxe;

import com.turkey.turkeyUtil.TurkeyUtil;

public class UtilPickaxe extends ItemPickaxe
{
	public UtilPickaxe(String unlocalizedName, ToolMaterial material)
	{
		super(material);
		
		this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(TurkeyUtil.MODID + ":" + unlocalizedName.toLowerCase());
        super.setCreativeTab(TurkeyUtil.baseModTab);
	}
}