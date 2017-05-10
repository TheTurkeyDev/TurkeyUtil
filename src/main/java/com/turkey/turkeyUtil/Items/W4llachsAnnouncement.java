package com.turkey.turkeyUtil.items;

import com.theprogrammingturkey.gobblecore.items.BaseItem;
import com.theprogrammingturkey.gobblecore.util.MessageUtil;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class W4llachsAnnouncement extends BaseItem
{
	public W4llachsAnnouncement()
	{
		super("wallachsAnnounce");
		super.addLore("W4llach, Member of NoodleCraft");
	}

	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		MessageUtil.sendMessageToPlayer(player, player.getDisplayName() + " PLES");
		return EnumActionResult.SUCCESS;
	}
}
