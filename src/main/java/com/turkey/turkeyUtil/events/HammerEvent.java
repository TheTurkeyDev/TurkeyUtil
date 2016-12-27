package com.turkey.turkeyUtil.events;

import com.turkey.turkeyUtil.items.tools.Hammer;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HammerEvent
{
	@SubscribeEvent
	public void onBlockBreak(BreakEvent e)
	{
		World world = e.getWorld();
		if(!world.isRemote)
		{
			Block b = e.getState().getBlock();
			BlockPos pos = e.getPos();

			ItemStack stack = e.getPlayer().inventory.getCurrentItem();

			if(stack != null && stack.getItem() instanceof Hammer)
			{
				if(b == Blocks.COBBLESTONE)
					world.spawnEntityInWorld(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Blocks.GRAVEL)));
				else if(b == Blocks.GRAVEL)
					world.spawnEntityInWorld(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Blocks.SAND)));
			}
		}
	}

	@SubscribeEvent
	public void onBlockHarvest(HarvestDropsEvent e)
	{
		if(!e.getWorld().isRemote && e.getHarvester() != null)
		{
			Block b = e.getState().getBlock();

			if(b == Blocks.COBBLESTONE || b == Blocks.GRAVEL)
			{
				ItemStack stack = e.getHarvester().inventory.getCurrentItem();
				if(stack != null && stack.getItem() instanceof Hammer)
					e.getDrops().clear();
			}
		}
	}
}
