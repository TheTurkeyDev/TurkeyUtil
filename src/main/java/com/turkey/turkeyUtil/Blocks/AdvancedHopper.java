package com.turkey.turkeyUtil.blocks;

import java.util.Random;

import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.blocks.TileEntities.AdvancedHopperTileEntity;
import com.turkey.turkeyUtil.gui.UtilGuiHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHopper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

public class AdvancedHopper extends BlockHopper
{
	private final Random rand = new Random();
    
    private Block block;

	public AdvancedHopper(String type, Block b)
	{
		super.setCreativeTab(TurkeyUtil.baseModTab);
		this.block = b;
	}

	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new AdvancedHopperTileEntity();
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
	{
		AdvancedHopperTileEntity te = getAdvHopperAT(world, x, y, z);
		te.setHopperType(stack.getItem().getUnlocalizedName().replace("_Advanced_Hopper", "").replace("tile.", "").trim());
		if (stack.hasDisplayName())
			te.setCustomName(stack.getDisplayName());
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	{
		if (world.isRemote || player.isSneaking())
		{
			return true;
		}
		else
		{
			FMLNetworkHandler.openGui(player, TurkeyUtil.instance, UtilGuiHandler.ADVANCED_HOPPER_ID, world, x, y, z);
			return true;
		}
	}

	public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
	{
		this.func_149919_e(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
	}

	private void func_149919_e(World world, int x, int y, int z)
	{
		int l = world.getBlockMetadata(x, y, z);
		int i1 = getDirectionFromMetadata(l);
		boolean flag = !world.isBlockIndirectlyGettingPowered(x, y, z);
		boolean flag1 = func_149917_c(l);

		if (flag != flag1)
		{
			world.setBlockMetadataWithNotify(x, y, z, i1 | (flag ? 0 : 8), 4);
		}
	}

	public void breakBlock(World world, int x, int y, int z, Block p_149749_5_, int p_149749_6_)
	{
		AdvancedHopperTileEntity te = (AdvancedHopperTileEntity)world.getTileEntity(x, y, z);

		if (te != null)
		{
			for (int i1 = 0; i1 < te.getSizeInventory(); ++i1)
			{
				ItemStack itemstack = te.getStackInSlot(i1);

				if (itemstack != null)
				{
					float f = this.rand.nextFloat() * 0.8F + 0.1F;
					float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
					float f2 = this.rand.nextFloat() * 0.8F + 0.1F;

					while (itemstack.stackSize > 0)
					{
						int j1 = this.rand.nextInt(21) + 10;

						if (j1 > itemstack.stackSize)
						{
							j1 = itemstack.stackSize;
						}

						itemstack.stackSize -= j1;
						EntityItem entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));

						if (itemstack.hasTagCompound())
						{
							entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
						}

						float f3 = 0.05F;
						entityitem.motionX = (double)((float)this.rand.nextGaussian() * f3);
						entityitem.motionY = (double)((float)this.rand.nextGaussian() * f3 + 0.2F);
						entityitem.motionZ = (double)((float)this.rand.nextGaussian() * f3);
						world.spawnEntityInWorld(entityitem);
					}
				}
			}

			world.func_147453_f(x, y, z, p_149749_5_);
			world.removeTileEntity(x, y, z);
		}
	}

	public static AdvancedHopperTileEntity getAdvHopperAT(IBlockAccess acess, int x, int y, int z)
	{
		return (AdvancedHopperTileEntity)acess.getTileEntity(x, y, z);
	}
}