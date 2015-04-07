package com.turkey.turkeyUtil.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.turkey.turkeyUtil.TurkeyUtil;

public class CompressedObsidianBlockHextuple extends Block
{	
	public CompressedObsidianBlockHextuple()
	{
		super(Material.ground);
		setHardness(75);
		setStepSound(Block.soundTypeStone);
		setBlockName("Hextuple_Compressed_Obsidian_Block");
		setCreativeTab(TurkeyUtil.modTab);
	}
}
