package com.turkey.turkeyUtil.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.turkey.turkeyUtil.TurkeyUtil;

public class CharcoalBlock extends Block
{
	public CharcoalBlock() 
	{
		super(Material.ground);
		setHardness(5);
		setStepSound(Block.soundTypeStone);
		setBlockName("Charcoal_Block");
		setCreativeTab(TurkeyUtil.baseModTab);
	}
}
