package com.turkey.turkeyUtil.blocks;

import com.turkey.turkeyUtil.TurkeyUtil;

import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;

public class MonocolorLightBlock extends BlockColored
{
	public MonocolorLightBlock()
	{
		super(Material.ROCK);
		super.setCreativeTab(TurkeyUtil.baseModTab);
		super.setHardness(0.5F);
		super.setLightLevel(1.0f);
	}
}