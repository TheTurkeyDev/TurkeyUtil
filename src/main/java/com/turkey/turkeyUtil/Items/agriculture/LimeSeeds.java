package com.turkey.turkeyUtil.Items.agriculture;

import java.util.List;

import com.turkey.turkeyUtil.TurkeyUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class LimeSeeds extends TurkeySeeds
{
	public LimeSeeds(Block parBlockPlant)
	{
		super(parBlockPlant, Blocks.farmland);
        setUnlocalizedName("Lime_Seeds");
        setTextureName("turkeyUtil:seeds_lime");
        setCreativeTab(TurkeyUtil.modTab);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) 
	{
		list.add("This is totaly how they grow");
	}
}