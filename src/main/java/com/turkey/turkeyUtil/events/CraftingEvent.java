package com.turkey.turkeyUtil.events;

import com.turkey.turkeyUtil.util.UtilAchievements;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class CraftingEvent
{
	@SubscribeEvent
	public void onCraft(ItemCraftedEvent e)
	{
		if(e.crafting.getItem().equals(Item.getItemFromBlock(Blocks.STONE_STAIRS)))
			e.player.addStat(UtilAchievements.stiars, 1);
	}
}
