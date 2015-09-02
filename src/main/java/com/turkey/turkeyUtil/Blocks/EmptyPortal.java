package com.turkey.turkeyUtil.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.turkey.turkeyUtil.TurkeyUtil;

public class EmptyPortal extends Block
{
	
	public EmptyPortal()
	{
		super(Material.ground);
		super.setHardness(5);
		super.setStepSound(Block.soundTypeStone);
		super.setBlockName("Empty_Portal");
		super.setBlockTextureName(TurkeyUtil.MODID + ":empty_portal");
		super.setCreativeTab(TurkeyUtil.baseModTab);
	}
}
