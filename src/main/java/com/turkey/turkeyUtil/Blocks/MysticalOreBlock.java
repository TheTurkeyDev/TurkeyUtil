package com.turkey.turkeyUtil.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.Items.UtilItems;
import com.turkey.turkeyUtil.util.UtilAchievements;

public class MysticalOreBlock extends Block
{
	public MysticalOreBlock()
	{
		super(Material.ground);
		setHardness(.3f);
		setStepSound(Block.soundTypeStone);
		setBlockName("Mystical_Ore_Block");
		setCreativeTab(TurkeyUtil.baseModTab);
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		int fortuneAdd = fortune * 10;
		System.out.println(fortuneAdd);
		Random r = new Random();
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		if(r.nextInt(100) < (60 + fortuneAdd))
			drops.add(new ItemStack(Items.coal, r.nextInt(10) + 1 + fortune));
		if(r.nextInt(100) < (15 + fortuneAdd))
			drops.add(new ItemStack(UtilItems.fabulousDiamond, r.nextInt(3) + 1 + fortune));
		if(r.nextInt(100) < (20 + fortuneAdd))
			drops.add(new ItemStack(Items.quartz, r.nextInt(3) + 1 + fortune));
		if(r.nextInt(100) < (35 + fortuneAdd))
			drops.add(new ItemStack(Items.dye, r.nextInt(7) + 1 + fortune, 4));
		if(r.nextInt(100) < (35 + fortuneAdd))
			drops.add(new ItemStack(Items.brick, r.nextInt(7) + 1 + fortune));
		if(r.nextInt(100) < (35 + fortuneAdd))
			drops.add(new ItemStack(Items.redstone, r.nextInt(7) + 1 + fortune));
		if(r.nextInt(100) < (30 + fortuneAdd))
			drops.add(new ItemStack(Items.iron_ingot, r.nextInt(7) + 1 + fortune));
		if(r.nextInt(100) < (25 + fortuneAdd))
			drops.add(new ItemStack(Items.gold_ingot, r.nextInt(3) + 1 + fortune));
		if(r.nextInt(100) < (15 + fortuneAdd))
			drops.add(new ItemStack(Items.emerald, r.nextInt(3) + 1 + fortune));
		if(r.nextInt(100) < (15 + fortuneAdd))
			drops.add(new ItemStack(Items.diamond, r.nextInt(3) + 1 + fortune));

		return drops;
	}

	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player)
	{
		player.addStat(UtilAchievements.mysticalOre, 1);
	}
}
