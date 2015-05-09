package com.turkey.turkeyUtil.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.turkey.turkeyUtil.TurkeyUtil;

public class CompressedCoalBlockHextuple extends Block
{	
	public CompressedCoalBlockHextuple()
	{
		super(Material.ground);
		setHardness(6);
		setStepSound(Block.soundTypeStone);
		setBlockName("Hextuple_Compressed_Coal_Block");
		setCreativeTab(TurkeyUtil.baseModTab);
	}
}
