package com.turkey.turkeyUtil.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.TurkeyUtil;

public class CompressedObsidianBlock extends Block
{
	public CompressedObsidianBlock(String level, int hardness)
	{
		super(Material.ground);
		setHardness(hardness);
		setStepSound(Block.soundTypeStone);
		setBlockName(level + "_Compressed_Obsidian_Block");
		setCreativeTab(TurkeyUtil.baseModTab);
	}
	
	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) 
	{
		if(this.blockHardness < 76)
			super.canEntityDestroy(world, x, y, z, entity);
		return !(entity instanceof EntityWither) && super.canEntityDestroy(world, x, y, z, entity);
	}

	@Override
	public void onBlockExploded(World world, int x, int y, int z, Explosion explosion) 
	{
		if(this.blockHardness < 76)
			super.onBlockExploded(world, x, y, z, explosion);
	}

	@Override
	public boolean canDropFromExplosion(Explosion explosion) 
	{
		return this.blockHardness < 76;
	}
	
}