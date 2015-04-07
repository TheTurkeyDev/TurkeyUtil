package com.turkey.turkeyUtil.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.TurkeyUtil;

public class W4llachsAnnouncement extends Item
{
	public W4llachsAnnouncement()
	{
		super.setTextureName("turkeyutil:w4llachs_Announcement");
		super.setUnlocalizedName("wallachsAnnounce");
		super.setCreativeTab(TurkeyUtil.modTab);
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
		player.addChatMessage(new ChatComponentText(player.getDisplayName() + " PLES"));
		return stack;
    }
}
