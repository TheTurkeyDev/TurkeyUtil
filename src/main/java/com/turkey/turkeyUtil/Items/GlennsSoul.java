package com.turkey.turkeyUtil.Items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.turkey.turkeyUtil.TurkeyUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GlennsSoul extends Item
{
	public GlennsSoul()
	{
		super.setTextureName("turkeyutil:glennsSoul");
		super.setUnlocalizedName("Glenns_Soul");
		super.setCreativeTab(TurkeyUtil.buildguildmodTab);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) 
	{
		list.add("Used to craft essence containers");
		list.add("Obtained by killing mobs with Aknot's soul reaper");
		list.add("Sevadus, Member of the Build Guild");
	}
}
