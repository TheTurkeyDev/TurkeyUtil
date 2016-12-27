package com.turkey.turkeyUtil.blocks;

import java.util.List;

import com.turkey.turkeyUtil.TurkeyUtil;

import net.minecraft.block.BlockLog;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DeadPineLog extends BlockLog
{
	public DeadPineLog()
	{
		super.setCreativeTab(TurkeyUtil.noodlecraftModTab);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean bool)
	{
		list.add("Deadpine, Member of the Walking Wounded and NoodleCraft");
	}
}