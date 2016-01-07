package com.turkey.turkeyUtil.items.agriculture;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class TurkeySeeds extends ItemSeeds
{	
	private final Block theBlockPlant;
	
	public TurkeySeeds(Block parBlockPlant, Block SoilBlock)
	{
		super(parBlockPlant, SoilBlock);
		theBlockPlant = parBlockPlant;
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
	{
		return EnumPlantType.Crop;
	}
	
	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z)
	{
		return theBlockPlant;
	}
	
	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
	{
		return 0;
	}
}
