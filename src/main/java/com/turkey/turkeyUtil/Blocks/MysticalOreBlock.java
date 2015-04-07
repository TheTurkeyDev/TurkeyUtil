package com.turkey.turkeyUtil.Blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.UtilAchievements;
import com.turkey.turkeyUtil.Items.UtilItems;

public class MysticalOreBlock extends Block
{	
	public MysticalOreBlock() 
	{
		super(Material.ground);
		setHardness(.3f);
		setStepSound(Block.soundTypeStone);
		setBlockName("Mystical_Ore_Block");
		setCreativeTab(TurkeyUtil.modTab);
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		Random r = new Random();
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		if(r.nextInt(100) < 60)
			drops.add(new ItemStack(Items.coal, r.nextInt(10) + 1));
		if(r.nextInt(100) < 15)
			drops.add(new ItemStack(UtilItems.fabulousDiamond, r.nextInt(3) + 1));
		if(r.nextInt(100) < 20)
			drops.add(new ItemStack(Items.quartz, r.nextInt(3) + 1));
		if(r.nextInt(100) < 35)
			drops.add(new ItemStack(Items.dye, r.nextInt(7) + 1, 4));
		if(r.nextInt(100) < 35)
			drops.add(new ItemStack(Items.brick, r.nextInt(7) + 1));
		if(r.nextInt(100) < 35)
			drops.add(new ItemStack(Items.redstone, r.nextInt(7) + 1));
		if(r.nextInt(100) < 30)
			drops.add(new ItemStack(Items.iron_ingot, r.nextInt(7) + 1));
		if(r.nextInt(100) < 25)
			drops.add(new ItemStack(Items.gold_ingot, r.nextInt(3) + 1));
		if(r.nextInt(100) < 15)
			drops.add(new ItemStack(Items.emerald, r.nextInt(3) + 1));
		if(r.nextInt(100) < 15)
			drops.add(new ItemStack(Items.diamond, r.nextInt(3) + 1));
		
		return drops;
	}
	
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) 
	{
		player.addStat(UtilAchievements.mysticalOre, 1);
	}
}
