package com.turkey.turkeyUtil.blocks.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.turkey.turkeyUtil.blocks.TileEntities.LightCollectorTileEntity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LightCollectorContainer extends Container
{
	private LightCollectorTileEntity te;
	private int lastDelay;
	private int lastCollectorProgress;

	public LightCollectorContainer(InventoryPlayer player, LightCollectorTileEntity te)
	{
		this.te = te;
		te.openInventory();
		byte b0 = 84;
		int i;

		for(i = 0; i < te.getSizeInventory(); i++)
		{
			this.addSlotToContainer(new Slot(te, i, 80 + (i * 18), 33 + (18 * i))
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
	
	public void addCraftingToCrafters(ICrafting crafting)
    {
        super.addCraftingToCrafters(crafting);
        crafting.sendProgressBarUpdate(this, 0, this.te.getDelay());
        crafting.sendProgressBarUpdate(this, 1, this.te.getCollectorProgress());
    }
	
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastDelay != this.te.getDelay())
            {
                icrafting.sendProgressBarUpdate(this, 0, this.te.getDelay());
            }

            if (this.lastCollectorProgress != this.te.getCollectorProgress())
            {
                icrafting.sendProgressBarUpdate(this, 1, this.te.getCollectorProgress());
            }
        }

        this.lastDelay = this.te.getDelay();
        this.lastCollectorProgress = this.te.getCollectorProgress();
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value)
    {
        if (id == 0)
        {
            this.te.setDelay(value);
        }

        if (id == 1)
        {
            this.te.setCollectorProgress(value);
        }
    }

	public boolean canInteractWith(EntityPlayer p_75145_1_)
	{
		return this.te.isUseableByPlayer(p_75145_1_);
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

			if(slotNum < this.te.getSizeInventory())
			{
				if(!this.mergeItemStack(itemstack1, this.te.getSizeInventory(), this.inventorySlots.size(), true))
				{
					return null;
				}
			}
			else if(!this.mergeItemStack(itemstack1, 0, this.te.getSizeInventory(), false))
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
		this.te.closeInventory();
	}
}
