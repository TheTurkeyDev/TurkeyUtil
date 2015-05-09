package com.turkey.turkeyUtil.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.turkey.turkeyUtil.TurkeyUtil;

public class CompressedCoalBlockOctuple extends Block
{	
	public CompressedCoalBlockOctuple()
	{
		super(Material.ground);
		setHardness(6);
		setStepSound(Block.soundTypeStone);
		setBlockName("Octuple_Compressed_Coal_Block");
		setCreativeTab(TurkeyUtil.baseModTab);
	}
}
