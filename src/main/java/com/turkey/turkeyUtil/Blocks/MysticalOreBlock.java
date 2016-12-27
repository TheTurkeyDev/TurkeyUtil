package com.turkey.turkeyUtil.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.theprogrammingturkey.gobblecore.blocks.BaseBlock;
import com.turkey.turkeyUtil.items.UtilItems;
import com.turkey.turkeyUtil.util.UtilAchievements;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MysticalOreBlock extends BaseBlock
{
	public MysticalOreBlock()
	{
		super("Mystical_Ore_Block", 0.3f);
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
	{
		int fortuneAdd = fortune * 10;
		System.out.println(fortuneAdd);
		Random r = new Random();
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		if(r.nextInt(100) < (60 + fortuneAdd))
			drops.add(new ItemStack(Items.COAL, r.nextInt(10) + 1 + fortune));
		if(r.nextInt(100) < (15 + fortuneAdd))
			drops.add(new ItemStack(UtilItems.fabulousDiamond, r.nextInt(3) + 1 + fortune));
		if(r.nextInt(100) < (20 + fortuneAdd))
			drops.add(new ItemStack(Items.QUARTZ, r.nextInt(3) + 1 + fortune));
		if(r.nextInt(100) < (35 + fortuneAdd))
			drops.add(new ItemStack(Items.DYE, r.nextInt(7) + 1 + fortune, 4));
		if(r.nextInt(100) < (35 + fortuneAdd))
			drops.add(new ItemStack(Items.BRICK, r.nextInt(7) + 1 + fortune));
		if(r.nextInt(100) < (35 + fortuneAdd))
			drops.add(new ItemStack(Items.REDSTONE, r.nextInt(7) + 1 + fortune));
		if(r.nextInt(100) < (30 + fortuneAdd))
			drops.add(new ItemStack(Items.IRON_INGOT, r.nextInt(7) + 1 + fortune));
		if(r.nextInt(100) < (25 + fortuneAdd))
			drops.add(new ItemStack(Items.GOLD_INGOT, r.nextInt(3) + 1 + fortune));
		if(r.nextInt(100) < (15 + fortuneAdd))
			drops.add(new ItemStack(Items.EMERALD, r.nextInt(3) + 1 + fortune));
		if(r.nextInt(100) < (15 + fortuneAdd))
			drops.add(new ItemStack(Items.DIAMOND, r.nextInt(3) + 1 + fortune));

		return drops;
	}

	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player)
	{
		player.addStat(UtilAchievements.mysticalOre, 1);
	}
}
