package com.turkey.turkeyUtil.Items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;

import com.turkey.turkeyUtil.TurkeyUtil;

import cpw.mods.fml.common.eventhandler.Event;

public class InfinityBucket extends ItemBucket
{	
	private Block isFull;

	public InfinityBucket(Block p_i45331_1_)
	{
		super(p_i45331_1_);
		isFull = p_i45331_1_;
		this.setCreativeTab(TurkeyUtil.baseModTab);
		super.setContainerItem(this);
	}

	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
	{
		boolean flag = this.isFull == Blocks.air;
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(p_77659_2_, p_77659_3_, flag);

		if (movingobjectposition == null)
		{
			return p_77659_1_;
		}
		else
		{
			FillBucketEvent event = new FillBucketEvent(p_77659_3_, p_77659_1_, p_77659_2_, movingobjectposition);
			if (MinecraftForge.EVENT_BUS.post(event))
				return p_77659_1_;

			if (event.getResult() == Event.Result.ALLOW)
				return p_77659_1_;
			
			if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
			{
				int i = movingobjectposition.blockX;
				int j = movingobjectposition.blockY;
				int k = movingobjectposition.blockZ;

				if (!p_77659_2_.canMineBlock(p_77659_3_, i, j, k))
				{
					return p_77659_1_;
				}

				if (flag)
				{
					if (!p_77659_3_.canPlayerEdit(i, j, k, movingobjectposition.sideHit, p_77659_1_))
					{
						return p_77659_1_;
					}

					Material material = p_77659_2_.getBlock(i, j, k).getMaterial();
					int l = p_77659_2_.getBlockMetadata(i, j, k);

					if (material == Material.water && l == 0)
					{
						p_77659_2_.setBlockToAir(i, j, k);
						return this.func_150910_a(p_77659_1_, p_77659_3_, UtilItems.infinityBucket_Empty);
					}

					if (material == Material.lava && l == 0)
					{
						p_77659_2_.setBlockToAir(i, j, k);
						return this.func_150910_a(p_77659_1_, p_77659_3_, UtilItems.infinityBucket_Empty);
					}
				}
				else
				{
					if (this.isFull == Blocks.air)
					{
						return new ItemStack(UtilItems.infinityBucket_Empty);
					}

					if (movingobjectposition.sideHit == 0)
					{
						--j;
					}

					if (movingobjectposition.sideHit == 1)
					{
						++j;
					}

					if (movingobjectposition.sideHit == 2)
					{
						--k;
					}

					if (movingobjectposition.sideHit == 3)
					{
						++k;
					}

					if (movingobjectposition.sideHit == 4)
					{
						--i;
					}

					if (movingobjectposition.sideHit == 5)
					{
						++i;
					}

					if (!p_77659_3_.canPlayerEdit(i, j, k, movingobjectposition.sideHit, p_77659_1_))
					{
						return p_77659_1_;
					}

					if (this.tryPlaceContainedLiquid(p_77659_2_, i, j, k) && !p_77659_3_.capabilities.isCreativeMode)
					{
						if(isFull == Blocks.flowing_lava)
						{
							return new ItemStack(UtilItems.infinityBucket_Lava);
						}
						else if(isFull == Blocks.flowing_water)
						{
							return new ItemStack(UtilItems.infinityBucket_Water);
						}
					}
				}
			}

			return p_77659_1_;
		}
	}

	private ItemStack func_150910_a(ItemStack p_150910_1_, EntityPlayer p_150910_2_, Item p_150910_3_)
	{
		if (p_150910_2_.capabilities.isCreativeMode)
		{
			return p_150910_1_;
		}
		else if (--p_150910_1_.stackSize <= 0)
		{
			return new ItemStack(p_150910_3_);
		}
		else
		{
			if (!p_150910_2_.inventory.addItemStackToInventory(new ItemStack(p_150910_3_)))
			{
				p_150910_2_.dropPlayerItemWithRandomChoice(new ItemStack(p_150910_3_, 1, 0), false);
			}

			return p_150910_1_;
		}
	}

	public boolean tryPlaceContainedLiquid(World world, ItemStack stack, int x, int y, int z)
	{
		if (stack.getItemDamage() == 0)
		{
			return false;
		}
		else
		{
			Material material = world.getBlock(x, y, z).getMaterial();
			boolean flag = !material.isSolid();

			if (!world.isAirBlock(x, y, z) && !flag)
			{
				return false;
			}
			else
			{
				if (world.provider.isHellWorld && stack.getItemDamage() == 1)
				{
					world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

					for (int l = 0; l < 8; ++l)
					{
						world.spawnParticle("largesmoke", (double)x + Math.random(), (double)y + Math.random(), (double)z + Math.random(), 0.0D, 0.0D, 0.0D);
					}
				}
				else if(stack.getItemDamage() == 1)
				{
					if (!world.isRemote && flag && !material.isLiquid())
					{
						world.func_147480_a(x, y, z, true);
					}
					world.setBlock(x, y, z, Blocks.water, 0, 3);
				}
				else if(stack.getItemDamage() == 2)
				{
					if (!world.isRemote && flag && !material.isLiquid())
					{
						world.func_147480_a(x, y, z, true);
					}
					world.setBlock(x, y, z, Blocks.lava, 0, 3);
				}
				return true;
			}
		}
	}
}
