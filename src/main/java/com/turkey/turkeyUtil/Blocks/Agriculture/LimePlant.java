package com.turkey.turkeyUtil.blocks.Agriculture;

import java.util.Random;

import com.turkey.turkeyUtil.items.UtilItems;
import com.turkey.turkeyUtil.items.food.UtilFood;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class LimePlant extends BlockCrops
{
	
    protected Item getSeed()
    {
        return UtilItems.limeSeeds;
    }

    protected Item getCrop()
    {
        return UtilFood.lime;
    }
    
	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override 
	public int quantityDropped(IBlockState state, int fortune, Random random)
	{
		return 2;
	}
}