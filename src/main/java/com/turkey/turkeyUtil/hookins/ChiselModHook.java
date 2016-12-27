package com.turkey.turkeyUtil.hookins;

import com.theprogrammingturkey.gobblecore.modhooks.BaseModHook;
import com.turkey.turkeyUtil.items.food.UtilFood;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ChiselModHook extends BaseModHook
{
	public ChiselModHook()
	{
		super("chisel");
	}

	@Override
	public void initHook()
	{
		GameRegistry.addRecipe(new ItemStack(UtilFood.lime, 1), "AAA", "AAA", "AAA", 'A', new ItemStack(Block.REGISTRY.getObject(new ResourceLocation("chisel", "limestone")), 1));
	}
}