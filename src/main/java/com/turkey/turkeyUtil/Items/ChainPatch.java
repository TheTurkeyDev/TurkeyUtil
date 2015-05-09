package com.turkey.turkeyUtil.Items;

import com.turkey.turkeyUtil.TurkeyUtil;

import net.minecraft.item.Item;

public class ChainPatch extends Item
{
	public ChainPatch()
	{
		super.setTextureName("turkeyutil:chain_patch");
		super.setUnlocalizedName("Chain_Patch");
		super.setCreativeTab(TurkeyUtil.baseModTab);
	}
}
