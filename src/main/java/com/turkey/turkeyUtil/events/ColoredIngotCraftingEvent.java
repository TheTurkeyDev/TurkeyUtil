package com.turkey.turkeyUtil.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class ColoredIngotCraftingEvent implements IRecipe
{

	@Override
	public boolean matches(InventoryCrafting crafting, World world)
	{
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting crafting)
	{
		return null;
	}

	@Override
	public int getRecipeSize()
	{
		return 10;
	}

	@Override
	public ItemStack getRecipeOutput()
	{
		return null;
	}

	@SubscribeEvent
	public void onCrafting(PlayerEvent.ItemCraftedEvent event)
	{
		IInventory craftMatrix = event.craftMatrix;
		if(!(craftMatrix instanceof InventoryCrafting))
		{
			return;
		}

		if(this.matches((InventoryCrafting) craftMatrix, event.player.worldObj))
		{
			for(int i = craftMatrix.getSizeInventory() - 1; i >= 0; i--)
			{
				ItemStack slot = craftMatrix.getStackInSlot(i);

				if(slot == null)
				{
					continue;
				}
			}
		}
	}

}
