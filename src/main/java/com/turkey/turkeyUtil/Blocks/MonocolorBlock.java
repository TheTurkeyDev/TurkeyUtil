package com.turkey.turkeyUtil.blocks;

import com.turkey.turkeyUtil.TurkeyUtil;

import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;

public class MonocolorBlock extends BlockColored
{
    
	public MonocolorBlock()
	{
		super(Material.ROCK);
		super.setCreativeTab(TurkeyUtil.baseModTab);
		super.setHardness(0.5F);
	}
}