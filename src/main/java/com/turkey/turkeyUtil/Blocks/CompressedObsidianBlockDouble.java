package com.turkey.turkeyUtil.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.turkey.turkeyUtil.TurkeyUtil;

public class CompressedObsidianBlockDouble extends Block
{
	public CompressedObsidianBlockDouble()
	{
		super(Material.ground);
		setHardness(75);
		setStepSound(Block.soundTypeStone);
		setBlockName("Double_Compressed_Obsidian_Block");
		setCreativeTab(TurkeyUtil.modTab);
	}
	
}