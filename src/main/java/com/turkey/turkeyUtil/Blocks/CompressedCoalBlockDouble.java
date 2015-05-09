package com.turkey.turkeyUtil.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.turkey.turkeyUtil.TurkeyUtil;

public class CompressedCoalBlockDouble extends Block
{
	public CompressedCoalBlockDouble()
	{
		super(Material.ground);
		setHardness(6);
		setStepSound(Block.soundTypeStone);
		setBlockName("Double_Compressed_Coal_Block");
		setCreativeTab(TurkeyUtil.baseModTab);
	}	
}