package com.turkey.turkeyUtil.hookins.nei;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;

import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.Items.UtilItems;
import com.turkey.turkeyUtil.gui.LightCollectorGui;

public class LightCollectorRecipieHandler extends TemplateRecipeHandler
{

	@Override
	public String getRecipeName()
	{
		return "Light Collector";
	}

	@Override
	public String getGuiTexture()
	{
		return TurkeyUtil.MODID + ":textures/gui/compression_table.png";
	}

	@Override
	public Class<? extends GuiContainer> getGuiClass()
	{
		return LightCollectorGui.class;
	}

	@Override
	public String getOverlayIdentifier()
	{
		return "Light Collector";
	}

	@Override
	public void loadCraftingRecipes(ItemStack result)
	{
		if(result == null)
			return;

		if(!result.getItem().equals(Items.iron_ingot) && !result.getItem().equals(UtilItems.lightIngot) && !result.getItem().equals(UtilItems.coloredIngots))
			return;

		List<PositionedStack> input = new ArrayList<PositionedStack>();
		
		//input.add(new PositionedStack(new ItemStack(LightRegistry.instance.getBlocksForColor(FilterColor.getColorFromMeta(result.getItemDamage())), 1), 25, 6));

		input.add(new PositionedStack(new ItemStack(result.getItem(), 1), 25, 6));

		CompressionRecipe res = new CompressionRecipe(input, result);
		arecipes.add(res);
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient)
	{		
		if(ingredient == null)
			return;

		if(!ingredient.getItem().equals(Items.iron_ingot) && !ingredient.getItem().equals(UtilItems.lightIngot) && !ingredient.getItem().equals(UtilItems.coloredIngots))
			return;

		List<PositionedStack> input;

		if(ingredient.getItemDamage() + 1 < 8)
		{
			input = new ArrayList<PositionedStack>();
			for(int l = 0; l < 3; ++l)
			{
				for(int i1 = 0; i1 < 3; ++i1)
				{
					input.add(new PositionedStack(ingredient, 25 + i1 * 18, 6 + l * 18));
				}
			}
			CompressionRecipe res = new CompressionRecipe(input, new ItemStack(ingredient.getItem(), 1, ingredient.getItemDamage() + 1));
			arecipes.add(res);
		}
	}

	public class CompressionRecipe extends TemplateRecipeHandler.CachedRecipe
	{

		private List<PositionedStack> input;
		private PositionedStack output;
		private int energy;

		public int getEnergy()
		{
			return energy;
		}

		@Override
		public PositionedStack getResult()
		{
			return output;
		}

		@Override
		public List<PositionedStack> getIngredients()
		{
			return input;
		}

		public CompressionRecipe(List<PositionedStack> ingredients, ItemStack result)
		{
			this.input = ingredients;

			if(result != null)
				this.output = new PositionedStack(result, 119, 24);
		}

	}

}
