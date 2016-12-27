package com.turkey.turkeyUtil.items;

import java.util.List;

import com.theprogrammingturkey.gobblecore.items.BaseItem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ColoredCore extends BaseItem
{
	public ColoredCore()
	{
		super("Colored_Core");
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack stack)
	{
		int i = stack.getItemDamage();
		return super.getUnlocalizedName(stack) + "." + EnumDyeColor.byDyeDamage((ItemDye.DYE_COLORS.length - 1) - (i % 16)).getUnlocalizedName();
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> list)
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