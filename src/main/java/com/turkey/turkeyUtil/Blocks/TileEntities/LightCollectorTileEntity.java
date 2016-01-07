package com.turkey.turkeyUtil.blocks.TileEntities;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.tileentity.TileEntity;

import com.turkey.turkeyUtil.items.UtilItems;
import com.turkey.turkeyUtil.registries.LightRegistry;
import com.turkey.turkeyUtil.registries.LightRegistry.FilterColor;

public class LightCollectorTileEntity extends TileEntity implements ISidedInventory
{
	private ItemStack[] inventory = new ItemStack[1];

	private String customName = "";

	private int progress = 0;

	private int delay = 0;

	public void updateEntity()
	{
		if(this.worldObj.isRemote)
			return;
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
				progress = 0;
			}
			else if(inventory[0].getItem().equals(Items.iron_ingot))
			{
				if(LightRegistry.instance.getFilterColorFromBlock(above, meta).equals(FilterColor.clear))
				{
					if(this.worldObj.isDaytime())
					{
						progress = this.tickInfusing(inventory[0]);
						if(progress >= 100)
							inventory[0] = new ItemStack(UtilItems.lightIngot);
					}
					else
					{
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
					progress = this.tickInfusing(inventory[0]);
					if(progress >= 100)
						inventory[0] = new ItemStack(UtilItems.coloredIngots, 1, color.getMeta());
				}
				else
					progress = 0;
			}
			else if(inventory[0].getItem().equals(UtilItems.coloredIngots))
			{
				if(LightRegistry.instance.getFilterColorFromBlock(above, meta).equals(FilterColor.clear))
				{
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

		NBTTagCompound display = (NBTTagCompound) nbt.getTag("display");

		if(display == null)
		{
			display = new NBTTagCompound();
			nbt.setTag("display", display);
		}

		NBTTagList list = display.getTagList("Lore", 8);
		if(list == null)
			list = new NBTTagList();

		if(list.tagCount() > 0)
			for(int j = list.tagCount() - 1; j >= 0; j--)
				if(list.getStringTagAt(j).contains("Light Infusing Progress"))
					list.removeTag(j);

		list.appendTag(new NBTTagString("Light Infusing Progress: " + percentComplete + "%"));
		display.setTag("Lore", list);

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
		String s = "Idle";
		if(canSeeTheSky())
		{
			Block above = this.worldObj.getBlock(this.xCoord, this.yCoord + 1, this.zCoord);
			int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord + 1, this.zCoord);
			if(inventory[0] == null)
				s = "Idle";
			else if(inventory[0].getItem().equals(Items.iron_ingot))
			{
				float time = Minecraft.getMinecraft().theWorld.getCelestialAngle(1.0F);
				if(LightRegistry.instance.getFilterColorFromBlock(above, meta).equals(FilterColor.clear))
				{
					if(time >= 0.784 || time <= 0.215)
						s = "Infusing with Light";
					else
						s = "Infusing with Darkness";
				}
			}
			else if(inventory[0].getItem().equals(UtilItems.lightIngot))
			{
				FilterColor color = LightRegistry.instance.getFilterColorFromBlock(above, meta);
				if(!color.equals(FilterColor.clear))
					s = "Infusing with " + color.getName() + " Light";
				else
					s = "Idle";
			}
			else if(inventory[0].getItem().equals(UtilItems.coloredIngots))
			{
				if(LightRegistry.instance.getFilterColorFromBlock(above, meta).equals(FilterColor.clear))
					s = "Infusing with Light";
			}
		}
		return s;
	}

	public int getCollectorProgress()
	{
		return this.progress;
	}

	public void setCollectorProgress(int prog)
	{
		this.progress = prog;
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
		return stack.getItem().equals(UtilItems.coloredIngots) || stack.getItem().equals(UtilItems.lightIngot) || stack.getItem().equals(UtilItems.darknessIngot) || stack.getItem().equals(Items.iron_ingot);
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
		return this.isIdle();
	}

	public boolean isIdle()
	{
		if(canSeeTheSky())
		{
			Block above = this.worldObj.getBlock(this.xCoord, this.yCoord + 1, this.zCoord);
			int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord + 1, this.zCoord);
			if(inventory[0] == null)
				return true;
			else if(inventory[0].getItem().equals(Items.iron_ingot))
			{
				if(LightRegistry.instance.getFilterColorFromBlock(above, meta).equals(FilterColor.clear))
					return false;
				return true;
			}
			else if(inventory[0].getItem().equals(UtilItems.lightIngot))
			{
				FilterColor color = LightRegistry.instance.getFilterColorFromBlock(above, meta);
				if(!color.equals(FilterColor.clear))
					return false;
				else
					return true;
			}
			else if(inventory[0].getItem().equals(UtilItems.coloredIngots))
			{
				if(LightRegistry.instance.getFilterColorFromBlock(above, meta).equals(FilterColor.clear))
					return false;
				return true;
			}
		}
		return true;
	}
}