package com.turkey.turkeyUtil.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.turkey.turkeyUtil.TurkeyUtil;

public class CompressedCoalBlockQuintuple extends Block
{	
	public CompressedCoalBlockQuintuple()
	{
		super(Material.ground);
		setHardness(6);
		setStepSound(Block.soundTypeStone);
		setBlockName("Quintuple_Compressed_Coal_Block");
		setCreativeTab(TurkeyUtil.modTab);
	}
}
