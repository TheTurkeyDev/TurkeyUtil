package com.turkey.turkeyUtil.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.turkey.turkeyUtil.TurkeyUtil;

public class CompressedCoalBlockSeptuple extends Block
{	
	public CompressedCoalBlockSeptuple()
	{
		super(Material.ground);
		setHardness(6);
		setStepSound(Block.soundTypeStone);
		setBlockName("Septuple_Compressed_Coal_Block");
		setCreativeTab(TurkeyUtil.modTab);
	}
}
