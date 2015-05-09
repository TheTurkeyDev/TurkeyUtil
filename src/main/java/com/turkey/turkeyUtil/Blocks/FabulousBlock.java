package com.turkey.turkeyUtil.Blocks;

import java.util.Random;

import com.turkey.turkeyUtil.TurkeyUtil;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class FabulousBlock extends Block
{	
	public FabulousBlock() 
	{
		super(Material.ground);
		setHardness(5);
		setStepSound(Block.soundTypeStone);
		setBlockName("Fabulous_Diamond_Block");
		setCreativeTab(TurkeyUtil.baseModTab);
	}
	
    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) 
    {
        return Item.getItemFromBlock(UtilBlocks.fabulousBlock);
    }
}
