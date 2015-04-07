package com.turkey.turkeyUtil.Blocks;

import com.turkey.turkeyUtil.TurkeyUtil;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CompressedObsidianBlockTriple extends Block
{	
	public CompressedObsidianBlockTriple()
	{
		super(Material.ground);
		setHardness(75);
		setStepSound(Block.soundTypeStone);
		setBlockName("Triple_Compressed_Obsidian_Block");
		setCreativeTab(TurkeyUtil.modTab);
	}
}
