package com.turkey.turkeyUtil.items;

import com.theprogrammingturkey.gobblecore.items.BaseItem;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class W4llachsAnnouncement extends BaseItem
{
	public W4llachsAnnouncement()
	{
		super("wallachsAnnounce");
		super.addLore("W4llach, Member of NoodleCraft");
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
		player.addChatMessage(new ITextComponent(player.getDisplayName() + " PLES"));
		return stack;
    }
}
