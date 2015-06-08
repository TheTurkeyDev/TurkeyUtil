package com.turkey.turkeyUtil.Items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.TurkeyUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class W4llachsAnnouncement extends Item
{
	public W4llachsAnnouncement()
	{
		super.setTextureName("turkeyutil:w4llachs_Announcement");
		super.setUnlocalizedName("wallachsAnnounce");
		super.setCreativeTab(TurkeyUtil.noodlecraftModTab);
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
		player.addChatMessage(new ChatComponentText(player.getDisplayName() + " PLES"));
		return stack;
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) 
	{
		list.add("W4llach, Member of NoodleCraft");
	}
}
