package com.turkey.turkeyUtil.Items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.turkey.turkeyUtil.TurkeyUtil;

public class Hammer extends Item
{	
	
	public Hammer()
	{
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
}
