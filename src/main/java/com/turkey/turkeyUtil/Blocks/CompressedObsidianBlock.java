package com.turkey.turkeyUtil.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.turkey.turkeyUtil.TurkeyUtil;

public class CompressedObsidianBlock extends Block
{
	public CompressedObsidianBlock()
	{
		super(Material.ground);
		setHardness(75);
		setStepSound(Block.soundTypeStone);
		setBlockName("Compressed_Obsidian_Block");
		setCreativeTab(TurkeyUtil.baseModTab);
	}
	
}