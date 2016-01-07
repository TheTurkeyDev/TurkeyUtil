package com.turkey.turkeyUtil.items.food;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TurkeyItemFood extends ItemFood
{
	private List<String> lore = new ArrayList<String>();
	
	public TurkeyItemFood(int replenish, float satMult, boolean bool, String name, String texture, int maxStack)
	{
		super(replenish,satMult,bool);
		super.setTextureName("turkeyutil:" + texture);
		super.setUnlocalizedName(name);
		this.setMaxStackSize(maxStack);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) 
	{
		list.addAll(lore);
	}
	
	public void addLore(String s)
	{
		lore.add(s);
	}
}
