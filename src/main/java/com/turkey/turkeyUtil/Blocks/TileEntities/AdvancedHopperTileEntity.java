package com.turkey.turkeyUtil.blocks.TileEntities;

import java.util.List;

import com.turkey.turkeyUtil.blocks.AdvancedHopper;
import com.turkey.turkeyUtil.util.HopperType;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.IHopper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class AdvancedHopperTileEntity extends TileEntity implements IHopper
{
	private ItemStack[] inventory = new ItemStack[0];

	private String customName;
	private int transferDelay = -1;
	private HopperType type;

	public AdvancedHopperTileEntity()
	{

	}

	public void setHopperType(String name)
	{
		type = HopperType.getHopperTypeFromName(name);

		if(type != null)
			inventory = new ItemStack[type.getInventorySlots()];
	}

	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		NBTTagList nbttaglist = nbt.getTagList("Items", 10);

		if(nbt.hasKey("CustomName", 8))
		{
			this.customName = nbt.getString("CustomName");
		}

		this.setHopperType(nbt.getString("HopperType"));
		this.transferDelay = nbt.getInteger("TransferCooldown");

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
		nbt.setInteger("TransferCooldown", this.transferDelay);
		nbt.setString("HopperType", this.type.getName());

		if(this.hasCustomInventoryName())
		{
			nbt.setString("CustomName", this.customName);
		}
	}

	public void setCustomName(String name)
	{
		this.customName = name;
	}

	public void markDirty()
	{
		super.markDirty();
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

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_)
	{
		if(this.inventory[p_70298_1_] != null)
		{
			ItemStack itemstack;

			if(this.inventory[p_70298_1_].stackSize <= p_70298_2_)
			{
				itemstack = this.inventory[p_70298_1_];
				this.inventory[p_70298_1_] = null;
				return itemstack;
			}
			else
			{
				itemstack = this.inventory[p_70298_1_].splitStack(p_70298_2_);

				if(this.inventory[p_70298_1_].stackSize == 0)
				{
					this.inventory[p_70298_1_] = null;
				}

				return itemstack;
			}
		}
		else
		{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_)
	{
		if(this.inventory[p_70304_1_] != null)
		{
			ItemStack itemstack = this.inventory[p_70304_1_];
			this.inventory[p_70304_1_] = null;
			return itemstack;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_)
	{
		this.inventory[p_70299_1_] = p_70299_2_;

		if(p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit())
		{
			p_70299_2_.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName()
	{
		return this.hasCustomInventoryName() ? this.customName : this.type == null? "" : this.type.getName() + " Hopper";
	}

	@Override
	public boolean hasCustomInventoryName()
	{
		return this.customName != null && this.customName.length() > 0;
	}

	@Override
	public int getInventoryStackLimit()
	{
		if(type != null)
			return type.getMaxStackSize();
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
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
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
	{
		return true;
	}

	public void updateEntity()
	{
		if(this.worldObj != null && !this.worldObj.isRemote)
		{
			--this.transferDelay;

			if(!this.func_145888_j())
			{
				this.func_145896_c(0);
				this.func_145887_i();
			}
		}
	}

	public boolean func_145887_i()
	{
		if(this.worldObj != null && !this.worldObj.isRemote)
		{
			if(!this.func_145888_j() && AdvancedHopper.func_149917_c(this.getBlockMetadata()))
			{
				boolean flag = false;

				if(!this.func_152104_k())
				{
					flag = this.func_145883_k();
				}

				if(!this.func_152105_l())
				{
					flag = func_145891_a(this) || flag;
				}

				if(flag)
				{
					this.func_145896_c(type.getTransferSpeed());
					this.markDirty();
					return true;
				}
			}

			return false;
		}
		else
		{
			return false;
		}
	}

	private boolean func_152104_k()
	{
		ItemStack[] aitemstack = this.inventory;
		int i = aitemstack.length;

		for(int j = 0; j < i; ++j)
		{
			ItemStack itemstack = aitemstack[j];

			if(itemstack != null)
			{
				return false;
			}
		}

		return true;
	}

	private boolean func_152105_l()
	{
		ItemStack[] aitemstack = this.inventory;
		int i = aitemstack.length;

		for(int j = 0; j < i; ++j)
		{
			ItemStack itemstack = aitemstack[j];

			if(itemstack == null || itemstack.stackSize != itemstack.getMaxStackSize())
			{
				return false;
			}
		}

		return true;
	}

	private boolean func_145883_k()
	{
		IInventory iinventory = this.func_145895_l();

		if(iinventory == null)
		{
			return false;
		}
		else
		{
			int i = Facing.oppositeSide[AdvancedHopper.getDirectionFromMetadata(this.getBlockMetadata())];

			if(this.func_152102_a(iinventory, i))
			{
				return false;
			}
			else
			{
				for(int j = 0; j < this.getSizeInventory(); ++j)
				{
					if(this.getStackInSlot(j) != null)
					{
						ItemStack itemstack = this.getStackInSlot(j).copy();
						ItemStack itemstack1 = func_145889_a(iinventory, this.decrStackSize(j, 1), i);

						if(itemstack1 == null || itemstack1.stackSize == 0)
						{
							iinventory.markDirty();
							return true;
						}

						this.setInventorySlotContents(j, itemstack);
					}
				}

				return false;
			}
		}
	}

	private boolean func_152102_a(IInventory p_152102_1_, int p_152102_2_)
	{
		if(p_152102_1_ instanceof ISidedInventory && p_152102_2_ > -1)
		{
			ISidedInventory isidedinventory = (ISidedInventory) p_152102_1_;
			int[] aint = isidedinventory.getAccessibleSlotsFromSide(p_152102_2_);

			for(int l = 0; l < aint.length; ++l)
			{
				ItemStack itemstack1 = isidedinventory.getStackInSlot(aint[l]);

				if(itemstack1 == null || itemstack1.stackSize != itemstack1.getMaxStackSize())
				{
					return false;
				}
			}
		}
		else
		{
			int j = p_152102_1_.getSizeInventory();

			for(int k = 0; k < j; ++k)
			{
				ItemStack itemstack = p_152102_1_.getStackInSlot(k);

				if(itemstack == null || itemstack.stackSize != itemstack.getMaxStackSize())
				{
					return false;
				}
			}
		}

		return true;
	}

	private static boolean func_152103_b(IInventory p_152103_0_, int p_152103_1_)
	{
		if(p_152103_0_ instanceof ISidedInventory && p_152103_1_ > -1)
		{
			ISidedInventory isidedinventory = (ISidedInventory) p_152103_0_;
			int[] aint = isidedinventory.getAccessibleSlotsFromSide(p_152103_1_);

			for(int l = 0; l < aint.length; ++l)
			{
				if(isidedinventory.getStackInSlot(aint[l]) != null)
				{
					return false;
				}
			}
		}
		else
		{
			int j = p_152103_0_.getSizeInventory();

			for(int k = 0; k < j; ++k)
			{
				if(p_152103_0_.getStackInSlot(k) != null)
				{
					return false;
				}
			}
		}

		return true;
	}

	public static boolean func_145891_a(IHopper p_145891_0_)
	{
		IInventory iinventory = func_145884_b(p_145891_0_);

		if(iinventory != null)
		{
			byte b0 = 0;

			if(func_152103_b(iinventory, b0))
			{
				return false;
			}

			if(iinventory instanceof ISidedInventory && b0 > -1)
			{
				ISidedInventory isidedinventory = (ISidedInventory) iinventory;
				int[] aint = isidedinventory.getAccessibleSlotsFromSide(b0);

				for(int k = 0; k < aint.length; ++k)
				{
					if(func_145892_a(p_145891_0_, iinventory, aint[k], b0))
					{
						return true;
					}
				}
			}
			else
			{
				int i = iinventory.getSizeInventory();

				for(int j = 0; j < i; ++j)
				{
					if(func_145892_a(p_145891_0_, iinventory, j, b0))
					{
						return true;
					}
				}
			}
		}
		else
		{
			EntityItem entityitem = func_145897_a(p_145891_0_.getWorldObj(), p_145891_0_.getXPos(), p_145891_0_.getYPos() + 1.0D, p_145891_0_.getZPos());

			if(entityitem != null)
			{
				return func_145898_a(p_145891_0_, entityitem);
			}
		}

		return false;
	}

	private static boolean func_145892_a(IHopper p_145892_0_, IInventory p_145892_1_, int p_145892_2_, int p_145892_3_)
	{
		ItemStack itemstack = p_145892_1_.getStackInSlot(p_145892_2_);

		if(itemstack != null && func_145890_b(p_145892_1_, itemstack, p_145892_2_, p_145892_3_))
		{
			ItemStack itemstack1 = itemstack.copy();
			ItemStack itemstack2 = func_145889_a(p_145892_0_, p_145892_1_.decrStackSize(p_145892_2_, 1), -1);

			if(itemstack2 == null || itemstack2.stackSize == 0)
			{
				p_145892_1_.markDirty();
				return true;
			}

			p_145892_1_.setInventorySlotContents(p_145892_2_, itemstack1);
		}

		return false;
	}

	public static boolean func_145898_a(IInventory p_145898_0_, EntityItem p_145898_1_)
	{
		boolean flag = false;

		if(p_145898_1_ == null)
		{
			return false;
		}
		else
		{
			ItemStack itemstack = p_145898_1_.getEntityItem().copy();
			ItemStack itemstack1 = func_145889_a(p_145898_0_, itemstack, -1);

			if(itemstack1 != null && itemstack1.stackSize != 0)
			{
				p_145898_1_.setEntityItemStack(itemstack1);
			}
			else
			{
				flag = true;
				p_145898_1_.setDead();
			}

			return flag;
		}
	}

	public static ItemStack func_145889_a(IInventory p_145889_0_, ItemStack p_145889_1_, int p_145889_2_)
	{
		if(p_145889_0_ instanceof ISidedInventory && p_145889_2_ > -1)
		{
			ISidedInventory isidedinventory = (ISidedInventory) p_145889_0_;
			int[] aint = isidedinventory.getAccessibleSlotsFromSide(p_145889_2_);

			for(int l = 0; l < aint.length && p_145889_1_ != null && p_145889_1_.stackSize > 0; ++l)
			{
				p_145889_1_ = func_145899_c(p_145889_0_, p_145889_1_, aint[l], p_145889_2_);
			}
		}
		else
		{
			int j = p_145889_0_.getSizeInventory();

			for(int k = 0; k < j && p_145889_1_ != null && p_145889_1_.stackSize > 0; ++k)
			{
				p_145889_1_ = func_145899_c(p_145889_0_, p_145889_1_, k, p_145889_2_);
			}
		}

		if(p_145889_1_ != null && p_145889_1_.stackSize == 0)
		{
			p_145889_1_ = null;
		}

		return p_145889_1_;
	}

	private static boolean func_145885_a(IInventory p_145885_0_, ItemStack p_145885_1_, int p_145885_2_, int p_145885_3_)
	{
		return !p_145885_0_.isItemValidForSlot(p_145885_2_, p_145885_1_) ? false : !(p_145885_0_ instanceof ISidedInventory) || ((ISidedInventory) p_145885_0_).canInsertItem(p_145885_2_, p_145885_1_, p_145885_3_);
	}

	private static boolean func_145890_b(IInventory p_145890_0_, ItemStack p_145890_1_, int p_145890_2_, int p_145890_3_)
	{
		return !(p_145890_0_ instanceof ISidedInventory) || ((ISidedInventory) p_145890_0_).canExtractItem(p_145890_2_, p_145890_1_, p_145890_3_);
	}

	private static ItemStack func_145899_c(IInventory p_145899_0_, ItemStack p_145899_1_, int p_145899_2_, int p_145899_3_)
	{
		ItemStack itemstack1 = p_145899_0_.getStackInSlot(p_145899_2_);

		if(func_145885_a(p_145899_0_, p_145899_1_, p_145899_2_, p_145899_3_))
		{
			boolean flag = false;

			if(itemstack1 == null)
			{
				// Forge: BUGFIX: Again, make things respect max stack sizes.
				int max = Math.min(p_145899_1_.getMaxStackSize(), p_145899_0_.getInventoryStackLimit());
				if(max >= p_145899_1_.stackSize)
				{
					p_145899_0_.setInventorySlotContents(p_145899_2_, p_145899_1_);
					p_145899_1_ = null;
				}
				else
				{
					p_145899_0_.setInventorySlotContents(p_145899_2_, p_145899_1_.splitStack(max));
				}
				flag = true;
			}
			else if(func_145894_a(itemstack1, p_145899_1_))
			{
				// Forge: BUGFIX: Again, make things respect max stack sizes.
				int max = Math.min(p_145899_1_.getMaxStackSize(), p_145899_0_.getInventoryStackLimit());
				if(max > itemstack1.stackSize)
				{
					int l = Math.min(p_145899_1_.stackSize, max - itemstack1.stackSize);
					p_145899_1_.stackSize -= l;
					itemstack1.stackSize += l;
					flag = l > 0;
				}
			}

			if(flag)
			{
				if(p_145899_0_ instanceof AdvancedHopperTileEntity)
				{
					((AdvancedHopperTileEntity) p_145899_0_).func_145896_c(((AdvancedHopperTileEntity) p_145899_0_).type.getTransferSpeed());
					p_145899_0_.markDirty();
				}

				p_145899_0_.markDirty();
			}
		}

		return p_145899_1_;
	}

	private IInventory func_145895_l()
	{
		int i = AdvancedHopper.getDirectionFromMetadata(this.getBlockMetadata());
		return func_145893_b(this.getWorldObj(), (double) (this.xCoord + Facing.offsetsXForSide[i]), (double) (this.yCoord + Facing.offsetsYForSide[i]), (double) (this.zCoord + Facing.offsetsZForSide[i]));
	}

	public static IInventory func_145884_b(IHopper p_145884_0_)
	{
		return func_145893_b(p_145884_0_.getWorldObj(), p_145884_0_.getXPos(), p_145884_0_.getYPos() + 1.0D, p_145884_0_.getZPos());
	}

	@SuppressWarnings("unchecked")
	public static EntityItem func_145897_a(World p_145897_0_, double p_145897_1_, double p_145897_3_, double p_145897_5_)
	{
		List<EntityItem> list = p_145897_0_.selectEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox(p_145897_1_, p_145897_3_, p_145897_5_, p_145897_1_ + 1.0D, p_145897_3_ + 1.0D, p_145897_5_ + 1.0D), IEntitySelector.selectAnything);
		return list.size() > 0 ? list.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	public static IInventory func_145893_b(World p_145893_0_, double p_145893_1_, double p_145893_3_, double p_145893_5_)
	{
		IInventory iinventory = null;
		int i = MathHelper.floor_double(p_145893_1_);
		int j = MathHelper.floor_double(p_145893_3_);
		int k = MathHelper.floor_double(p_145893_5_);
		TileEntity tileentity = p_145893_0_.getTileEntity(i, j, k);

		if(tileentity != null && tileentity instanceof IInventory)
		{
			iinventory = (IInventory) tileentity;

			if(iinventory instanceof TileEntityChest)
			{
				Block block = p_145893_0_.getBlock(i, j, k);

				if(block instanceof BlockChest)
				{
					iinventory = ((BlockChest) block).func_149951_m(p_145893_0_, i, j, k);
				}
			}
		}

		if(iinventory == null)
		{
			List<IInventory> list = p_145893_0_.getEntitiesWithinAABBExcludingEntity((Entity) null, AxisAlignedBB.getBoundingBox(p_145893_1_, p_145893_3_, p_145893_5_, p_145893_1_ + 1.0D, p_145893_3_ + 1.0D, p_145893_5_ + 1.0D), IEntitySelector.selectInventories);

			if(list != null && list.size() > 0)
			{
				iinventory = list.get(p_145893_0_.rand.nextInt(list.size()));
			}
		}

		return iinventory;
	}

	private static boolean func_145894_a(ItemStack p_145894_0_, ItemStack p_145894_1_)
	{
		return p_145894_0_.getItem() != p_145894_1_.getItem() ? false : (p_145894_0_.getItemDamage() != p_145894_1_.getItemDamage() ? false : (p_145894_0_.stackSize > p_145894_0_.getMaxStackSize() ? false : ItemStack.areItemStackTagsEqual(p_145894_0_, p_145894_1_)));
	}

	/**
	 * Gets the world X position for this hopper entity.
	 */
	@Override
	public double getXPos()
	{
		return (double) this.xCoord;
	}

	/**
	 * Gets the world Y position for this hopper entity.
	 */
	@Override
	public double getYPos()
	{
		return (double) this.yCoord;
	}

	/**
	 * Gets the world Z position for this hopper entity.
	 */
	@Override
	public double getZPos()
	{
		return (double) this.zCoord;
	}

	public void func_145896_c(int p_145896_1_)
	{
		this.transferDelay = p_145896_1_;
	}

	public boolean func_145888_j()
	{
		return this.transferDelay > 0;
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound syncData = new NBTTagCompound();
		syncData.setString("HopperType", this.type.getName());
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, syncData);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		NBTTagCompound nbt = pkt.func_148857_g();
		if(this.type == null)
			this.setHopperType(nbt.getString("HopperType"));
	}
}