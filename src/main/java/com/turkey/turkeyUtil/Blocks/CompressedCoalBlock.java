package com.turkey.turkeyUtil.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.turkey.turkeyUtil.TurkeyUtil;

public class CompressedCoalBlock extends Block
{
	public CompressedCoalBlock(String level)
	{
		super(Material.ground);
		setHardness(6);
		setStepSound(Block.soundTypeStone);
		setBlockName(level + "_Compressed_Coal_Block");
		setCreativeTab(TurkeyUtil.baseModTab);
	}	
}