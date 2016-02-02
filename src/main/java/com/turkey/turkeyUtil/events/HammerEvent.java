package com.turkey.turkeyUtil.events;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

import com.turkey.turkeyUtil.items.tools.Hammer;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class HammerEvent
{
	@SubscribeEvent
	public void onBlockBreak(BreakEvent e)
	{
		if(!e.world.isRemote)
		{
			Block b = e.block;

			if(e.getPlayer().inventory.getCurrentItem().getItem() instanceof Hammer)
			{
				if(b == Blocks.cobblestone )
					e.world.spawnEntityInWorld(new EntityItem(e.world, e.x, e.y, e.z, new ItemStack(Blocks.gravel)));
				else if(b == Blocks.gravel)
					e.world.spawnEntityInWorld(new EntityItem(e.world, e.x, e.y, e.z, new ItemStack(Blocks.sand)));
			}
		}
	}

	@SubscribeEvent
	public void onBlockHarvest(HarvestDropsEvent e)
	{
		if(!e.world.isRemote && e.harvester != null)
		{
			Block b = e.block;

			if(b == Blocks.cobblestone || b == Blocks.gravel)
			{
				if(e.harvester.inventory.getCurrentItem().getItem() instanceof Hammer)
				{
					e.drops.clear();
				}
			}
		}
	}
}
