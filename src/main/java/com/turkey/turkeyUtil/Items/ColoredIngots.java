package com.turkey.turkeyUtil.Items;

import java.awt.Color;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ColoredIngots extends BaseItemUtil
{
	public static int[] baseColors = new int[] {Color.white.getRGB(), new Color(230, 92, 0).getRGB(), new Color(209, 71, 255).getRGB(), new Color(51, 173, 255).getRGB(), new Color(232, 232, 0).getRGB(), new Color(25, 212, 25).getRGB(), new Color(255, 102, 255).getRGB(), new Color(71, 71, 71).getRGB(), new Color(175, 175, 175).getRGB(), new Color(25, 117, 163).getRGB(), new Color(102, 0, 204).getRGB(), new Color(0, 0, 255).getRGB(), new Color(102, 51, 0).getRGB(), new Color(25, 117, 25).getRGB(), new Color(209, 25, 25).getRGB(), Color.black.getRGB() };

	public ColoredIngots()
	{
		super("Colored_Ingot");
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
		return baseColors[(stack.getItemDamage() % 16)];
	}
}