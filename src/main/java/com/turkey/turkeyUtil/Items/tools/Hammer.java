package com.turkey.turkeyUtil.items.tools;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import com.google.common.collect.Sets;
import com.turkey.turkeyUtil.TurkeyUtil;

public class Hammer extends ItemTool
{
	private static final Set<Block> usefulAgainst = Sets.newHashSet(new Block[] { Blocks.cobblestone, Blocks.gravel });

	public Hammer(String name, int durability, ToolMaterial material)
	{
		super(1.0F, material, usefulAgainst);
		this.setUnlocalizedName(name);
		this.setTextureName("turkeyutil:" + name);
		super.setMaxDamage(durability);
		super.setCreativeTab(TurkeyUtil.baseModTab);
		super.setContainerItem(this);
		super.showDurabilityBar(new ItemStack(this));
		super.setMaxStackSize(1);
		super.setNoRepair();
	}

	public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack)
	{
		return false;
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemStack)
	{
		ItemStack stack = itemStack.copy();

		stack.setItemDamage(stack.getItemDamage() + 1);
		stack.stackSize = 1;

		return stack;
	}

	public boolean canHarvestBlock(Block block, ItemStack itemStack)
	{
		return block == Blocks.cobblestone || block == Blocks.gravel;

	}
}
