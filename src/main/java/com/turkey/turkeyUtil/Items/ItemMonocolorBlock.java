package com.turkey.turkeyUtil.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMonocolorBlock extends ItemBlock
{
	private Block block;

	public ItemMonocolorBlock(Block b)
	{
		super(b);
		this.block = b;
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack p_82790_1_, int p_82790_2_)
	{
		return block.getRenderColor(p_82790_1_.getItemDamage());
	}

	/**
	 * Returns the metadata of the block which this Item (ItemBlock) can place
	 */
	public int getMetadata(int meta)
	{
		return meta;
	}

	/**
	 * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have different names based on their damage or NBT.
	 */
	public String getUnlocalizedName(ItemStack p_77667_1_)
	{
		int i = p_77667_1_.getItemDamage();
		return super.getUnlocalizedName(p_77667_1_) + "." + ItemDye.field_150921_b[(ItemDye.field_150921_b.length - 1) - (i % 16)];
	}

	/**
	 * Gets an icon index based on an item's damage value
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta)
	{
		return block.getIcon(0, meta);
	}

}
