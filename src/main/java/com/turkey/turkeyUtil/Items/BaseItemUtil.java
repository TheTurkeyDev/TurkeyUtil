package com.turkey.turkeyUtil.Items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Lists;
import com.turkey.turkeyUtil.TurkeyUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BaseItemUtil extends Item
{
	private List<String> lore = Lists.newArrayList();
	
	public BaseItemUtil(String name)
	{
		this.setUnlocalizedName(name);
		this.setTextureName(TurkeyUtil.MODID + ":" + name.toLowerCase());
		this.setCreativeTab(TurkeyUtil.baseModTab);
	}
	
	public void addLore(String info)
	{
		lore.add(info);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) 
	{
		list.addAll(lore);
	}
}
