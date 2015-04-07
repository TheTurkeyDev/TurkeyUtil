package com.turkey.turkeyUtil.Blocks.Agriculture;

import java.util.Random;

import net.minecraft.block.BlockCrops;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TurkeyPlant extends BlockCrops
{
	protected int maxGrowthStage = 7;

	@SideOnly(Side.CLIENT)
	protected IIcon[] iIcon;

	public TurkeyPlant()
	{

	}

	@Override
	public void updateTick(World parWorld, int parX, int parY, int parZ, Random parRand)
	{
		super.updateTick(parWorld, parX, parY, parZ, parRand);
		int growStage = parWorld.getBlockMetadata(parX, parY, parZ) + 1;

		if (growStage > 7)
		{
			growStage = 7;
		}

		parWorld.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int parSide, int parGrowthStage)
	{
		return iIcon[parGrowthStage];
	}
}
