package com.turkey.turkeyUtil.blocks.TileEntities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class LightHealingTileEntity extends TileEntity implements ISidedInventory
{
	private ItemStack[] inventory = new ItemStack[1];

	private String customName = "";

	private int delay = 0;

	public void updateEntity()
	{
		if(this.worldObj.isRemote)
			return;
		delay++;

		if(delay < 40)
			return;
		delay = 0;

		if(canSeeTheSky() && this.inventory[0] != null)
		{
			if(this.inventory[0].getMaxDamage() > 0 && this.inventory[0].getItemDamageForDisplay() > 0)
			{
				this.inventory[0].setItemDamage(this.inventory[0].getItemDamage() - 1);
			}
		}
	}

	private boolean canSeeTheSky()
	{
		for(int y = this.yCoord + 1; y <= this.worldObj.getHeight(); y++)
			if(!this.worldObj.getBlock(this.xCoord, y, this.zCoord).equals(Blocks.air))
				return false;
		return true;
	}

	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		NBTTagList nbttaglist = nbt.getTagList("Items", 10);

		if(nbt.hasKey("CustomName", 8))
		{
			this.customName = nbt.getString("CustomName");
		}

		this.delay = nbt.getInteger("Delay");

		for(int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if(b0 >= 0 && b0 < this.inventory.length)
			{
				this.inventory[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	}

	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		NBTTagList nbttaglist = new NBTTagList();

		for(int i = 0; i < this.inventory.length; ++i)
		{
			if(this.inventory[i] != null)
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.inventory[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		nbt.setTag("Items", nbttaglist);

		nbt.setInteger("Delay", this.delay);

		if(this.hasCustomInventoryName())
		{
			nbt.setString("CustomName", this.customName);
		}
	}

	@Override
	public int getSizeInventory()
	{
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot)
	{
		return inventory[slot];
	}

	public ItemStack decrStackSize(int slot, int number)
	{
		if(this.inventory[slot] != null)
		{
			ItemStack itemstack;

			if(this.inventory[slot].stackSize <= number)
			{
				itemstack = this.inventory[slot];
				this.inventory[slot] = null;
				this.markDirty();
				return itemstack;
			}
			else
			{
				itemstack = this.inventory[slot].splitStack(number);

				if(this.inventory[slot].stackSize == 0)
				{
					this.inventory[slot] = null;
				}

				this.markDirty();
				return itemstack;
			}
		}
		else
		{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot)
	{
		return this.inventory[slot];
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack)
	{
		this.inventory[slot] = stack;

	}

	@Override
	public String getInventoryName()
	{
		return customName == "" ? "Light Collector" : customName;
	}

	public int getDelay()
	{
		return this.delay;
	}

	public void setDelay(int delay)
	{
		this.delay = delay;
	}

	@Override
	public boolean hasCustomInventoryName()
	{
		return customName != "";
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return true;
	}

	@Override
	public void openInventory()
	{

	}

	@Override
	public void closeInventory()
	{

	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack)
	{
		return stack.getMaxDamage() > 0 && stack.getItemDamageForDisplay() > 0;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_)
	{
		return new int[] { 0 };
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack stack, int side)
	{
		return this.isItemValidForSlot(slot, stack) && this.inventory[0] == null;
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack stack, int side)
	{
		return stack.getItemDamage() == 0;
	}
}