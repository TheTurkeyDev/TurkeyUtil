package com.turkey.turkeyUtil.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.turkey.turkeyUtil.TurkeyUtil;

public class CompressedObsidianBlockOctuple extends Block
{	
	public CompressedObsidianBlockOctuple()
	{
		super(Material.ground);
		setHardness(75);
		setStepSound(Block.soundTypeStone);
		setBlockName("Octuple_Compressed_Obsidian_Block");
		setCreativeTab(TurkeyUtil.baseModTab);
	}
}
