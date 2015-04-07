package com.turkey.turkeyUtil.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import com.turkey.turkeyUtil.TurkeyUtil;

public class FlintBlock extends Block
{
	public FlintBlock() 
	{
		super(Material.ground);
		setHardness(5);
		setStepSound(Block.soundTypeStone);
		setBlockName("Flint_Block");
		setCreativeTab(TurkeyUtil.modTab);
	}
	
    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) 
    {
        return Item.getItemFromBlock(UtilBlocks.flintBlock);
    }
}
