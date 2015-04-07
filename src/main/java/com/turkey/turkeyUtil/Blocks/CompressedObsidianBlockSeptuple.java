package com.turkey.turkeyUtil.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.turkey.turkeyUtil.TurkeyUtil;

public class CompressedObsidianBlockSeptuple extends Block
{	
	public CompressedObsidianBlockSeptuple()
	{
		super(Material.ground);
		setHardness(75);
		setStepSound(Block.soundTypeStone);
		setBlockName("Septuple_Compressed_Obsidian_Block");
		setCreativeTab(TurkeyUtil.modTab);
	}
}
