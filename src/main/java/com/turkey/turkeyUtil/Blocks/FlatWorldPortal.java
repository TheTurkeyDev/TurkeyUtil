package com.turkey.turkeyUtil.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.turkey.turkeyUtil.TurkeyUtil;

public class FlatWorldPortal extends Block
{
	
	public FlatWorldPortal()
	{
		super(Material.ground);
		super.setHardness(5);
		super.setStepSound(Block.soundTypeStone);
		super.setBlockName("Flat_Portal");
		super.setBlockTextureName(TurkeyUtil.MODID + ":flat_portal");
		super.setCreativeTab(TurkeyUtil.baseModTab);
	}
}
