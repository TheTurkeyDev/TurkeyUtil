package com.turkey.turkeyUtil.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.turkey.turkeyUtil.TurkeyUtil;

public class VoidWorldPortal extends Block
{
	
	public VoidWorldPortal()
	{
		super(Material.ground);
		super.setHardness(5);
		super.setStepSound(Block.soundTypeStone);
		super.setBlockName("Void_Portal");
		super.setBlockTextureName(TurkeyUtil.MODID + ":void_portal");
		super.setCreativeTab(TurkeyUtil.baseModTab);
	}
}
