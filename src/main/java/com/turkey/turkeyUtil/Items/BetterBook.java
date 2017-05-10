package com.turkey.turkeyUtil.items;

import com.theprogrammingturkey.gobblecore.items.BaseItem;
import com.turkey.turkeyUtil.gui.BetterBookGui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class BetterBook extends BaseItem
{

	public BetterBook()
	{
		super("Better_Book");
		super.setMaxStackSize(1);
		new ItemStack(this, 1).setTagInfo("author", new NBTTagString(""));
	}

	public String getItemStackDisplayName(ItemStack stack)
	{
		if(stack.getTagCompound() != null && stack.getTagCompound().getString("title") != null && stack.getTagCompound().getString("author") != null)
			return "\"" + stack.getTagCompound().getString("title") + "\"" + " By: " + stack.getTagCompound().getString("authorName");
		return super.getItemStackDisplayName(stack);
	}

	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(world.isRemote)
		{
			FMLCommonHandler.instance().showGuiScreen(new BetterBookGui(player, stack));
		}
		return EnumActionResult.PASS;
	}

	public boolean getShareTag()
	{
		return true;
	}

	public static boolean func_150930_a(NBTTagCompound p_150930_0_)
	{
		if(p_150930_0_ == null)
		{
			return false;
		}
		else if(!p_150930_0_.hasKey("pages", 9))
		{
			return false;
		}
		else
		{
			NBTTagList nbttaglist = p_150930_0_.getTagList("pages", 8);

			for(int i = 0; i < nbttaglist.tagCount(); ++i)
			{
				String s = nbttaglist.getStringTagAt(i);

				if(s == null)
				{
					return false;
				}

				if(s.length() > 256)
				{
					return false;
				}
			}

			return true;
		}
	}

}