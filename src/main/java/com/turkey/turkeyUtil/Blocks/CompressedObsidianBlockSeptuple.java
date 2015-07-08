package com.turkey.turkeyUtil.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.TurkeyUtil;

public class CompressedObsidianBlockSeptuple extends Block
{	
	public CompressedObsidianBlockSeptuple()
	{
		super(Material.ground);
		setHardness(75);
		setStepSound(Block.soundTypeStone);
		setBlockName("Septuple_Compressed_Obsidian_Block");
		setCreativeTab(TurkeyUtil.baseModTab);
	}
	
	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) 
	{
		return !(entity instanceof EntityWither) && super.canEntityDestroy(world, x, y, z, entity);
	}

	@Override
	public void onBlockExploded(World world, int x, int y, int z, Explosion explosion) 
	{

	}

	@Override
	public boolean canDropFromExplosion(Explosion explosion) 
	{
		return false;
	}
}
