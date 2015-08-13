package com.turkey.turkeyUtil.blocks.TileEntities;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.turkey.turkeyUtil.Items.UtilItems;
import com.turkey.turkeyUtil.registries.LightRegistry;
import com.turkey.turkeyUtil.registries.LightRegistry.FilterColor;

public class LightCollectorTileEntity extends TileEntity implements IInventory
{
	private ItemStack[] inventory = new ItemStack[1];

	private String customName;

	private String status = "Idle";
	private int progress = 0;

	private int delay = 0;

	public void updateEntity()
	{
		delay++;

		if(delay < 20)
			return;
		delay = 0;

		if(canSeeTheSky())
		{
			Block above = this.worldObj.getBlock(this.xCoord, this.yCoord + 1, this.zCoord);
			int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord + 1, this.zCoord);
			if(inventory[0] == null)
			{
				status = "Idle";
				progress = 0;
			}
			else if(inventory[0].getItem().equals(Items.iron_ingot))
			{
				if(LightRegistry.instance.getFilterColorFromBlock(above, meta).equals(FilterColor.clear))
				{
					if(this.worldObj.isDaytime())
					{
						status = "Infusing with Light";
						progress = this.tickInfusing(inventory[0]);
						if(progress >= 100)
							inventory[0] = new ItemStack(UtilItems.lightIngot);
					}
					else
					{
						status = "Infusing with Darkness";
						progress = this.tickInfusing(inventory[0]);
						if(progress >= 100)
							inventory[0] = new ItemStack(UtilItems.darknessIngot);
					}
				}
			}
			else if(inventory[0].getItem().equals(UtilItems.lightIngot))
			{
				FilterColor color = LightRegistry.instance.getFilterColorFromBlock(above, meta);
				if(!color.equals(FilterColor.clear))
				{
					status = "Infusing with " + color.getName() + " Light";
					progress = this.tickInfusing(inventory[0]);
					if(progress >= 100)
						inventory[0] = new ItemStack(UtilItems.coloredIngots, 1, color.getMeta());
				}
				else
				{
					status = "Idle";
					progress = 0;
				}
			}
			else if(inventory[0].getItem().equals(UtilItems.coloredIngots))
			{
				if(LightRegistry.instance.getFilterColorFromBlock(above, meta).equals(FilterColor.clear))
				{
					status = "Infusing with Light";
					progress = this.tickInfusing(inventory[0]);
					if(progress >= 100)
						inventory[0] = new ItemStack(UtilItems.lightIngot);
				}
			}
		}
	}

	private boolean canSeeTheSky()
	{
		if(!LightRegistry.instance.isFilterBlock(this.worldObj.getBlock(this.xCoord, this.yCoord + 1, this.zCoord), this.worldObj.getBlockMetadata(this.xCoord, this.yCoord + 1, this.zCoord)))
			return false;
		for(int y = this.yCoord + 2; y <= this.worldObj.getHeight(); y++)
			if(!this.worldObj.getBlock(this.xCoord, y, this.zCoord).equals(Blocks.air))
				return false;
		return true;
	}

	private int tickInfusing(ItemStack stack)
	{
		NBTTagCompound nbt = stack.getTagCompound();
		if(nbt == null)
			nbt = new NBTTagCompound();

		int percentComplete = 0;

		if(nbt.hasKey("InfusionPercent"))
			percentComplete = nbt.getInteger("InfusionPercent");

		percentComplete++;

		nbt.setInteger("InfusionPercent", percentComplete);
		stack.setTagCompound(nbt);

		return percentComplete;
	}

	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		NBTTagList nbttaglist = nbt.getTagList("Items", 10);

		if(nbt.hasKey("CustomName", 8))
		{
			this.customName = nbt.getString("CustomName");
		}

		this.status = nbt.getString("Status");
		this.progress = nbt.getInteger("Progress");
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


		nbt.setString("Status", this.status);
		nbt.setInteger("Progress", this.progress);
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

	public String getCollectorStatus()
	{
		return this.status;
	}

	public int getCollectorProgress()
	{
		return this.progress;
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
		return stack.getItem().equals(UtilItems.coloredIngots) || stack.getItem().equals(UtilItems.lightIngot) || stack.getItem().equals(UtilItems.darknessIngot) || stack.getItem().equals(Items.iron_ingot);
	}
}
