package com.turkey.turkeyUtil.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ColoredCore extends BaseItemUtil
{
	public ColoredCore()
	{
		super("Colored_Core");
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack stack)
	{
		int i = stack.getItemDamage();
		return super.getUnlocalizedName(stack) + "." + ItemDye.field_150921_b[(ItemDye.field_150921_b.length - 1) - (i % 16)];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for(int i = 0; i < 16; i++)
			list.add(new ItemStack(item, 1, i));
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int pacss)
	{
		return ColoredIngots.baseColors[(stack.getItemDamage() % 16)];
	}
}