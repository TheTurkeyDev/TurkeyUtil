package com.turkey.turkeyUtil.Blocks.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.Blocks.TileEntities.ArmorCombinerTileEntity;

public class ArmorCombinerContainer extends Container
{

	private IInventory outputSlot = new InventoryCraftResult();
	private IInventory inputSlots = new InventoryBasic("Combiner", true, 2)
	{
		/**
		 * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think
		 * it hasn't changed and skip it.
		 */
		public void markDirty()
		{
			super.markDirty();
			ArmorCombinerContainer.this.onCraftMatrixChanged(this);
		}
	};


	private World theWorld;

	public ArmorCombinerContainer(InventoryPlayer player, ArmorCombinerTileEntity tileEntity, World world)
	{
		this.theWorld = world;

		for (int i = 0; i < 9; i++)
		{
			this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
		}

		for (int y = 0; y < 3; y++)
		{
			for (int x = 0; x < 9; x++)
			{
				this.addSlotToContainer(new Slot(player, 9 + (9 * y + x), 8 + x * 18, 84 + y * 18));
			}
		}

		this.addSlotToContainer(new Slot(inputSlots, 0, 27, 33) {
			public boolean isItemValid(ItemStack stack)
			{
				if (stack.getItem() instanceof ItemArmor)
					return true;
				return false;
			}
		});
		this.addSlotToContainer(new Slot(inputSlots, 1, 76, 33) {
			public boolean isItemValid(ItemStack stack)
			{
				if (stack.getItem() instanceof ItemArmor)
					return true;
				return false;
			}
		});
		this.addSlotToContainer(new Slot(outputSlot, 2, 134, 33) {
			public boolean isItemValid(ItemStack stack)
			{
				return false;
			}
		});
	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_)
	{
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot)
	{
		ItemStack stack = null;
		Slot slotObject = (Slot) inventorySlots.get(slot);
		//System.out.println(slot);

		// null checks and checks if the item can be stacked (maxStackSize > 1)
		if (slotObject != null && slotObject.getHasStack())
		{
			ItemStack stackInSlot = slotObject.getStack();
			stack = stackInSlot.copy();

			// merges the item into player inventory since its in the tileEntity
			if (slot > 35)
			{
				if (!this.mergeItemStack(stackInSlot, 0, 36, true))
				{
					return null;
				}
			}
			// places it into the tileEntity is possible since its in the player
			// inventory
			else if(stack.getItem() instanceof ItemArmor)
			{
				if (!this.mergeItemStack(stackInSlot, 36, 38, false))
				{
					return null;
				}
			}

			if (stackInSlot.stackSize == 0)
			{
				slotObject.putStack(null);
			} else
			{
				slotObject.onSlotChanged();
			}

			if (stackInSlot.stackSize == stack.stackSize)
			{
				return null;
			}
			slotObject.onPickupFromSlot(player, stackInSlot);
		}
		return stack;
	}

	public void onCraftMatrixChanged(IInventory p_75130_1_)
	{
		super.onCraftMatrixChanged(p_75130_1_);

		if (p_75130_1_ == this.inputSlots)
		{
			this.updateRepairOutput();
		}
	}

	private void updateRepairOutput()
	{
		
	}
	

	/**
	 * Called when the container is closed.
	 */
	public void onContainerClosed(EntityPlayer p_75134_1_)
	{
		super.onContainerClosed(p_75134_1_);

		if (!this.theWorld.isRemote)
		{
			for (int i = 0; i < this.inputSlots.getSizeInventory(); ++i)
			{
				ItemStack itemstack = this.inputSlots.getStackInSlotOnClosing(i);

				if (itemstack != null)
				{
					p_75134_1_.dropPlayerItemWithRandomChoice(itemstack, false);
				}
			}
		}
	}
}