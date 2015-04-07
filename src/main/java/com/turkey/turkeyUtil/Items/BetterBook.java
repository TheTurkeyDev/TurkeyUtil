package com.turkey.turkeyUtil.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.gui.BetterBookGui;

import cpw.mods.fml.common.FMLCommonHandler;

public class BetterBook extends Item 
{
	
	public BetterBook() 
	{
		super.setCreativeTab(TurkeyUtil.modTab);
		super.setUnlocalizedName("Better_Book");
		super.setMaxStackSize(1);
		new ItemStack(this, 1).setTagInfo("author", new NBTTagString(""));
		super.setTextureName("turkeyUtil:betterBook");
	}
	
	public String getItemStackDisplayName(ItemStack stack)
	{
		if(stack.getTagCompound() != null && stack.getTagCompound().getString("title") != null && stack.getTagCompound().getString("author") != null)
			return "\"" + stack.getTagCompound().getString("title") + "\"" + " By: " + stack.getTagCompound().getString("authorName");
		return super.getItemStackDisplayName(stack);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (world.isRemote)
		{
			FMLCommonHandler.instance().showGuiScreen(new BetterBookGui(player, stack));
		}
		return stack;
	}
	
	public boolean getShareTag()
	{
		return true;
	}
	
	public static boolean func_150930_a(NBTTagCompound p_150930_0_)
	{
		if (p_150930_0_ == null)
		{
			return false;
		}
		else if (!p_150930_0_.hasKey("pages", 9))
		{
			return false;
		}
		else
		{
			NBTTagList nbttaglist = p_150930_0_.getTagList("pages", 8);
			
			for (int i = 0; i < nbttaglist.tagCount(); ++i)
			{
				String s = nbttaglist.getStringTagAt(i);
				
				if (s == null)
				{
					return false;
				}
				
				if (s.length() > 256)
				{
					return false;
				}
			}
			
			return true;
		}
	}
	
}