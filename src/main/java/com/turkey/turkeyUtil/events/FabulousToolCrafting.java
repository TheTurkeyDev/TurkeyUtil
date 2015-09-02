package com.turkey.turkeyUtil.events;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.Items.ColoredCore;
import com.turkey.turkeyUtil.Items.tools.UtilAxe;
import com.turkey.turkeyUtil.Items.tools.UtilHoe;
import com.turkey.turkeyUtil.Items.tools.UtilPickaxe;
import com.turkey.turkeyUtil.Items.tools.UtilSpade;
import com.turkey.turkeyUtil.Items.tools.UtilSword;
import com.turkey.turkeyUtil.armor.SuperFabulousItemArmor;
import com.turkey.turkeyUtil.util.UtilCrafting;

public class FabulousToolCrafting implements IRecipe
{

	public boolean matches(InventoryCrafting inv, World world)
	{
		ItemStack core = null;
		ItemStack result = null;
		int coreSlot = -1;

		for(int i = inv.getSizeInventory() - 1; i >= 0; i--)
		{
			ItemStack item = inv.getStackInSlot(i);
			if(item != null && item.getItem() instanceof ColoredCore)
			{
				if(core != null)
					return false;
				core = item.copy();
				coreSlot = i;
			}
		}

		if(coreSlot == -1 || core == null)
			return false;

		if((result = this.getUtilItemFromCrafting(inv)) != null)
			if(result.getItem() instanceof UtilAxe || result.getItem() instanceof UtilHoe || result.getItem() instanceof UtilPickaxe || result.getItem() instanceof UtilSpade || result.getItem() instanceof UtilSword || result.getItem() instanceof SuperFabulousItemArmor)
				return true;
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv)
	{
		ItemStack core = null;
		ItemStack result = null;
		int coreSlot = -1;

		for(int i = inv.getSizeInventory() - 1; i >= 0; i--)
		{
			ItemStack item = inv.getStackInSlot(i);
			if(item != null && item.getItem() instanceof ColoredCore)
			{
				core = item.copy();
				coreSlot = i;
			}
		}

		if(coreSlot == -1 || core == null)
			return null;

		if(this.getUtilItemFromCrafting(inv) != null)
		{
			result = this.getUtilItemFromCrafting(inv).copy();
			if(result.getItem() instanceof UtilAxe || result.getItem() instanceof UtilHoe || result.getItem() instanceof UtilPickaxe || result.getItem() instanceof UtilSpade || result.getItem() instanceof UtilSword || result.getItem() instanceof SuperFabulousItemArmor)
				result.addEnchantment(this.getEnchantFromCore(core), 1);
		}
		return result;
	}

	@Override
	public int getRecipeSize()
	{
		return 10;
	}

	@Override
	public ItemStack getRecipeOutput()
	{
		return null;
	}

	public Enchantment getEnchantFromCore(ItemStack stack)
	{
		int meta = stack.getItemDamage();

		switch(meta)
		{
			case 0:
				return Enchantment.silkTouch;
			case 1:
				return Enchantment.fireAspect;
			case 2:
				return Enchantment.sharpness;
			case 3:
				return Enchantment.featherFalling;
			case 4:
			{
				if(stack.getItem() instanceof UtilSword)
					return Enchantment.looting;
				else
					return Enchantment.fortune;
			}
			case 5:
				return Enchantment.sharpness;
			case 6:
				return Enchantment.sharpness;
			case 7:
				return Enchantment.efficiency;
			case 8:
				return Enchantment.unbreaking;
			case 9:
				return Enchantment.sharpness;
			case 10:
				return Enchantment.sharpness;
			case 11:
				return Enchantment.respiration;
			case 12:
				return Enchantment.thorns;
			case 13:
				return Enchantment.protection;
			case 14:
				return Enchantment.sharpness;
			case 15:
				return Enchantment.infinity;
			default:
				return Enchantment.sharpness;
		}
	}

	public ItemStack getUtilItemFromCrafting(InventoryCrafting inv)
	{
		for(IRecipe recipe : UtilCrafting.enchantableRecipes)
		{
			if(!(recipe instanceof ShapedRecipes))
				return null;

			boolean same = true;

			ShapedRecipes shaped = (ShapedRecipes) recipe;

			for(int k = 0; k < 3; ++k)
			{
				for(int l = 0; l < 3; ++l)
				{
					if(inv.getStackInRowAndColumn(l, k) == null && shaped.recipeItems[l + k * 3] == null)
						continue;

					if(inv.getStackInRowAndColumn(l, k) != null && shaped.recipeItems[l + k * 3] == null)
					{
						if(!(inv.getStackInRowAndColumn(l, k).getItem() instanceof ColoredCore))
							same = false;
					}
					else if(inv.getStackInRowAndColumn(l, k) == null && shaped.recipeItems[l + k * 3] != null)
						same = false;
					else if(!inv.getStackInRowAndColumn(l, k).isItemEqual(shaped.recipeItems[l + k * 3]))
						same = false;
				}
			}

			if(same)
				return shaped.getRecipeOutput();
		}
		return null;
	}
}