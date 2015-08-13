package com.turkey.turkeyUtil.blocks.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class LightCollectorContainer extends Container
{
	private final IInventory inventory;

	public LightCollectorContainer(InventoryPlayer player, IInventory inventory)
	{
		this.inventory = inventory;
		inventory.openInventory();
		byte b0 = 84;
		int i;

		for(i = 0; i < inventory.getSizeInventory(); i++)
		{
			this.addSlotToContainer(new Slot(inventory, i, 80 + (i * 18), 33 + (18 * i))
			{
			    public boolean isItemValid(ItemStack stack)
			    {
			        return inventory.isItemValidForSlot(this.slotNumber, stack);
			    }
			});
		}

		for(i = 0; i < 3; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, i * 18 + b0));
			}
		}

		for(i = 0; i < 9; i++)
		{
			this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 58 + b0));
		}
	}

	public boolean canInteractWith(EntityPlayer p_75145_1_)
	{
		return this.inventory.isUseableByPlayer(p_75145_1_);
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	 */
	public ItemStack transferStackInSlot(EntityPlayer player, int slotNum)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotNum);

		if(slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if(slotNum < this.inventory.getSizeInventory())
			{
				if(!this.mergeItemStack(itemstack1, this.inventory.getSizeInventory(), this.inventorySlots.size(), true))
				{
					return null;
				}
			}
			else if(!this.mergeItemStack(itemstack1, 0, this.inventory.getSizeInventory(), false))
			{
				return null;
			}

			if(itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
			}
			else
			{
				slot.onSlotChanged();
			}
		}

		return itemstack;
	}

	/**
	 * Called when the container is closed.
	 */
	public void onContainerClosed(EntityPlayer player)
	{
		super.onContainerClosed(player);
		this.inventory.closeInventory();
	}
}
