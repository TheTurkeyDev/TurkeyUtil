package com.turkey.turkeyUtil;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.turkey.turkeyUtil.Blocks.UtilBlocks;

import cpw.mods.fml.common.IFuelHandler;

public class TurkeyUtilFuelHandler implements IFuelHandler
{
	
	@Override
	public int getBurnTime(ItemStack fuel)
	{
		if(Item.getItemFromBlock(UtilBlocks.charcolBlock) == fuel.getItem())
		{
			return 16000;
		}
		if(Item.getItemFromBlock(UtilBlocks.doublecompressedCoal) == fuel.getItem())
		{
			return 144000;
		}
		if(Item.getItemFromBlock(UtilBlocks.triplecompressedCoal) == fuel.getItem())
		{
			return 1296000;
		}
		if(Item.getItemFromBlock(UtilBlocks.quadruplecompressedCoal) == fuel.getItem())
		{
			return 11664000;
		}
		if(Item.getItemFromBlock(UtilBlocks.quintuplecompressedCoal) == fuel.getItem())
		{
			return 104976000;
		}
		if(Item.getItemFromBlock(UtilBlocks.hextuplecompressedCoal) == fuel.getItem())
		{
			return 944784000;
		}
		if(Item.getItemFromBlock(UtilBlocks.septuplecompressedCoal) == fuel.getItem())
		{
			return Integer.MAX_VALUE;
		}
		if(Item.getItemFromBlock(UtilBlocks.octuplecompressedCoal) == fuel.getItem())
		{
			return Integer.MAX_VALUE;
		}
		
		return 0;
	}	
	
}
