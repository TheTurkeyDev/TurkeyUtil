package com.turkey.turkeyUtil.util;

import java.util.Random;

import com.turkey.turkeyUtil.blocks.UtilBlocks;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		if(UtilSettings.isBlockedWorld(world.getWorldInfo().getWorldName()))
			return;
		generateOre(world, random, chunkX * 16, chunkZ * 16);
	}

	private void generateOre(World world, Random rand, int chunkX, int chunkZ)
	{
		for(int k = 0; k < 5; k++)
		{
			int firstBlockXCoord = chunkX + rand.nextInt(16);
			int firstBlockYCoord = rand.nextInt(20);
			int firstBlockZCoord = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(UtilBlocks.mysticalOreBlock.getDefaultState(), 3)).generate(world, rand, new BlockPos(firstBlockXCoord, firstBlockYCoord, firstBlockZCoord));
		}
	}
}