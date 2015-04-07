package com.turkey.turkeyUtil.Blocks;

import com.turkey.turkeyUtil.TurkeyUtil;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CompressedCoalBlockTriple extends Block
{	
	public CompressedCoalBlockTriple()
	{
		super(Material.ground);
		setHardness(6);
		setStepSound(Block.soundTypeStone);
		setBlockName("Triple_Compressed_Coal_Block");
		setCreativeTab(TurkeyUtil.modTab);
	}
}
