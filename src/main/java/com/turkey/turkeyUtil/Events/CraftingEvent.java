package com.turkey.turkeyUtil.Events;

import com.turkey.turkeyUtil.UtilAchievements;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class CraftingEvent 
{

	@SubscribeEvent
	public void onCraft(ItemCraftedEvent e)
	{
		if(e.crafting.getItem().equals(Item.getItemFromBlock(Blocks.stone_stairs)))
		{
			e.player.addStat(UtilAchievements.stiars, 1);
		}
	}
}
