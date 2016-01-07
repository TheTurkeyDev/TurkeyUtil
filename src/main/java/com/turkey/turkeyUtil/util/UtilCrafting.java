package com.turkey.turkeyUtil.util;

import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;

import com.google.common.collect.Lists;
import com.turkey.turkeyUtil.armor.UtilArmor;
import com.turkey.turkeyUtil.blocks.AdvancedHopper;
import com.turkey.turkeyUtil.blocks.UtilBlocks;
import com.turkey.turkeyUtil.items.UtilItems;
import com.turkey.turkeyUtil.items.food.UtilFood;
import com.turkey.turkeyUtil.items.tools.UtilTools;

import cpw.mods.fml.common.registry.GameRegistry;

public class UtilCrafting
{

	public static List<IRecipe> enchantableRecipes = Lists.newArrayList();

	public static void loadCraftingRecipies()
	{
		if(ConfigLoader.isEnabled(UtilBlocks.charcolBlock.getLocalizedName()))
		{
			GameRegistry.addRecipe(new ItemStack(UtilBlocks.charcolBlock, 1), "AAA", "AAA", "AAA", 'A', new ItemStack(Items.coal, 1, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.coal, 9, 1), new ItemStack(UtilBlocks.charcolBlock, 1));
		}
		if(ConfigLoader.isEnabled(UtilBlocks.fabulousBlock.getLocalizedName()))
			GameRegistry.addRecipe(new ItemStack(UtilBlocks.fabulousBlock, 1), "FFF", "FFF", "FFF", 'F', new ItemStack(UtilItems.fabulousDiamond, 1));
		if(ConfigLoader.isEnabled(UtilBlocks.charcolBlock.getLocalizedName()))
		{
			GameRegistry.addRecipe(new ItemStack(UtilBlocks.flintBlock, 1), "AAA", "AAA", "AAA", 'A', new ItemStack(Items.flint, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.flint, 9), new ItemStack(UtilBlocks.flintBlock, 1));
		}

		if(ConfigLoader.isEnabled("Compressed Coal"))
		{
			GameRegistry.addRecipe(new ItemStack(UtilBlocks.doublecompressedCoal, 1), "AAA", "AAA", "AAA", 'A', new ItemStack(Blocks.coal_block, 1));
			GameRegistry.addRecipe(new ItemStack(UtilBlocks.triplecompressedCoal, 1), "AAA", "AAA", "AAA", 'A', new ItemStack(UtilBlocks.doublecompressedCoal, 1));
			GameRegistry.addRecipe(new ItemStack(UtilBlocks.quadruplecompressedCoal, 1), "AAA", "AAA", "AAA", 'A', new ItemStack(UtilBlocks.triplecompressedCoal, 1));
			GameRegistry.addRecipe(new ItemStack(UtilBlocks.quintuplecompressedCoal, 1), "AAA", "AAA", "AAA", 'A', new ItemStack(UtilBlocks.quadruplecompressedCoal, 1));
			GameRegistry.addRecipe(new ItemStack(UtilBlocks.hextuplecompressedCoal, 1), "AAA", "AAA", "AAA", 'A', new ItemStack(UtilBlocks.quintuplecompressedCoal, 1));
			GameRegistry.addRecipe(new ItemStack(UtilBlocks.septuplecompressedCoal, 1), "AAA", "AAA", "AAA", 'A', new ItemStack(UtilBlocks.hextuplecompressedCoal, 1));
			GameRegistry.addRecipe(new ItemStack(UtilBlocks.octuplecompressedCoal, 1), "AAA", "AAA", "AAA", 'A', new ItemStack(UtilBlocks.septuplecompressedCoal, 1));
			GameRegistry.addRecipe(new ItemStack(UtilItems.condensedCore, 1), "AAA", "AAA", "AAA", 'A', new ItemStack(UtilBlocks.octuplecompressedCoal, 1));

			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.coal_block, 9), new ItemStack(UtilBlocks.doublecompressedCoal, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilBlocks.doublecompressedCoal, 9), new ItemStack(UtilBlocks.triplecompressedCoal, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilBlocks.triplecompressedCoal, 9), new ItemStack(UtilBlocks.quadruplecompressedCoal, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilBlocks.quadruplecompressedCoal, 9), new ItemStack(UtilBlocks.quintuplecompressedCoal, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilBlocks.quintuplecompressedCoal, 9), new ItemStack(UtilBlocks.hextuplecompressedCoal, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilBlocks.hextuplecompressedCoal, 9), new ItemStack(UtilBlocks.septuplecompressedCoal, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilBlocks.septuplecompressedCoal, 9), new ItemStack(UtilBlocks.octuplecompressedCoal, 1));
		}

		if(ConfigLoader.isEnabled("Compressed Obsidian"))
		{
			GameRegistry.addRecipe(new ItemStack(UtilBlocks.compressedObsidian, 1), "AAA", "AAA", "AAA", 'A', new ItemStack(Blocks.obsidian));
			GameRegistry.addRecipe(new ItemStack(UtilBlocks.doublecompressedObsidian, 1), "AAA", "AAA", "AAA", 'A', new ItemStack(UtilBlocks.compressedObsidian, 1));
			GameRegistry.addRecipe(new ItemStack(UtilBlocks.triplecompressedObsidian, 1), "AAA", "AAA", "AAA", 'A', new ItemStack(UtilBlocks.doublecompressedObsidian, 1));
			GameRegistry.addRecipe(new ItemStack(UtilBlocks.quadruplecompressedObsidian, 1), "AAA", "AAA", "AAA", 'A', new ItemStack(UtilBlocks.triplecompressedObsidian, 1));
			GameRegistry.addRecipe(new ItemStack(UtilBlocks.quintuplecompressedObsidian, 1), "AAA", "AAA", "AAA", 'A', new ItemStack(UtilBlocks.quadruplecompressedObsidian, 1));
			GameRegistry.addRecipe(new ItemStack(UtilBlocks.hextuplecompressedObsidian, 1), "AAA", "AAA", "AAA", 'A', new ItemStack(UtilBlocks.quintuplecompressedObsidian, 1));
			GameRegistry.addRecipe(new ItemStack(UtilBlocks.septuplecompressedObsidian, 1), "AAA", "AAA", "AAA", 'A', new ItemStack(UtilBlocks.hextuplecompressedObsidian, 1));
			GameRegistry.addRecipe(new ItemStack(UtilBlocks.octuplecompressedObsidian, 1), "AAA", "AAA", "AAA", 'A', new ItemStack(UtilBlocks.septuplecompressedObsidian, 1));

			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.obsidian, 9), new ItemStack(UtilBlocks.compressedObsidian, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilBlocks.compressedObsidian, 9), new ItemStack(UtilBlocks.doublecompressedObsidian, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilBlocks.doublecompressedObsidian, 9), new ItemStack(UtilBlocks.triplecompressedObsidian, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilBlocks.triplecompressedObsidian, 9), new ItemStack(UtilBlocks.quadruplecompressedObsidian, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilBlocks.quadruplecompressedObsidian, 9), new ItemStack(UtilBlocks.quintuplecompressedObsidian, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilBlocks.quintuplecompressedObsidian, 9), new ItemStack(UtilBlocks.hextuplecompressedObsidian, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilBlocks.hextuplecompressedObsidian, 9), new ItemStack(UtilBlocks.septuplecompressedObsidian, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilBlocks.septuplecompressedObsidian, 9), new ItemStack(UtilBlocks.octuplecompressedObsidian, 1));
		}

		if(ConfigLoader.isEnabled("Monocolored Blocks"))
		{
			for(int i = 0; i < 16; i++)
				GameRegistry.addShapedRecipe(new ItemStack(UtilBlocks.monoBlock, 1, i), "DD", "DD", 'D', new ItemStack(UtilItems.coloredIngots, 1, i));
		}

		if(ConfigLoader.isEnabled("Colored Cores"))
		{
			for(int i = 0; i < 16; i++)
				GameRegistry.addShapedRecipe(new ItemStack(UtilItems.coloredCores, 1, i), "CCC", "CCC", "CCC", 'C', new ItemStack(UtilItems.coloredIngots, 1, i));
		}

		if(ConfigLoader.isEnabled("Monocolored Light Blocks"))
		{
			for(int i = 0; i < 16; i++)
				GameRegistry.addShapelessRecipe(new ItemStack(UtilBlocks.monoLightBlock, 1, i), new ItemStack(UtilBlocks.monoBlock, 1, i), new ItemStack(Blocks.glowstone, 1));
		}

		if(ConfigLoader.isEnabled(UtilBlocks.lightCollector.getLocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilBlocks.lightCollector), "IGI", "IDI", "III", 'I', new ItemStack(Items.iron_ingot), 'G', new ItemStack(Blocks.glass), 'D', new ItemStack(Items.diamond));
		if(ConfigLoader.isEnabled(UtilBlocks.lightHealer.getLocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilBlocks.lightHealer), "FGF", "CLC", "III", 'I', new ItemStack(Items.iron_ingot), 'G', new ItemStack(Blocks.glass), 'F', new ItemStack(UtilItems.fabulousDiamond), 'C', new ItemStack(UtilItems.coloredCores, 1, 13), 'L', new ItemStack(UtilBlocks.lightCollector));

		if(ConfigLoader.isEnabled("Advanced Hoppers"))
			for(AdvancedHopper hopper : UtilBlocks.advancedHoppers)
				GameRegistry.addShapedRecipe(new ItemStack(hopper), "I I", "IHI", " I ", 'I', new ItemStack(HopperType.getHopperTypeFromName(hopper.getUnlocalizedName().replace("tile.", "").replace("_Advanced_Hopper", "").trim()).getItem()), 'H', new ItemStack(Blocks.hopper));

		if(ConfigLoader.isEnabled(UtilTools.woodHammer.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilTools.woodHammer, 1), "WS", "WS", " S", 'W', new ItemStack(Blocks.planks), 'S', new ItemStack(Items.stick));
		if(ConfigLoader.isEnabled(UtilTools.stoneHammer.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilTools.stoneHammer, 1), "TS", "TS", " S", 'T', new ItemStack(Blocks.cobblestone), 'S', new ItemStack(Items.stick));
		if(ConfigLoader.isEnabled(UtilTools.ironHammer.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilTools.ironHammer, 1), "IS", "IS", " S", 'I', new ItemStack(Items.iron_ingot), 'S', new ItemStack(Items.stick));
		if(ConfigLoader.isEnabled(UtilTools.goldHammer.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilTools.goldHammer, 1), "GS", "GS", " S", 'G', new ItemStack(Items.gold_ingot), 'S', new ItemStack(Items.stick));
		if(ConfigLoader.isEnabled(UtilTools.diamondHammer.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilTools.diamondHammer, 1), "DS", "DS", " S", 'D', new ItemStack(Items.diamond), 'S', new ItemStack(Items.stick));

		if(ConfigLoader.isEnabled(UtilItems.swatter.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.swatter, 1), "S", "S", "T", 'S', new ItemStack(Items.string), 'T', new ItemStack(Items.stick));

		if(ConfigLoader.isEnabled(UtilTools.soulReaper.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilTools.soulReaper, 1), "III", " S ", "S  ", 'S', new ItemStack(Items.stick), 'I', new ItemStack(Items.iron_ingot));
		if(ConfigLoader.isEnabled(UtilTools.soulEssenceReaper.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilTools.soulEssenceReaper, 1), "III", "GS ", "S  ", 'S', new ItemStack(Items.stick), 'I', new ItemStack(Items.iron_ingot), 'G', new ItemStack(UtilItems.glennsSoul));
		if(ConfigLoader.isEnabled(UtilItems.passiveEssenceContainer.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.passiveEssenceContainer, 1), "GBG", "SIS", "GSG", 'S', new ItemStack(UtilItems.glennsSoul), 'G', new ItemStack(Blocks.glass), 'I', new ItemStack(Items.iron_ingot), 'B', new ItemStack(Blocks.diamond_block));
		if(ConfigLoader.isEnabled(UtilItems.hostileEssenceContainer.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.hostileEssenceContainer, 1), "GBG", "SIS", "GSG", 'S', new ItemStack(UtilItems.glennsSoul), 'G', new ItemStack(Blocks.glass), 'I', new ItemStack(Items.iron_ingot), 'B', new ItemStack(Blocks.iron_block));

		if(ConfigLoader.isEnabled(UtilItems.infinityBucket_Empty.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.infinityBucket_Empty, 1), "IBI", "IBI", "IBI", 'I', new ItemStack(Items.iron_ingot), 'B', new ItemStack(Items.bucket));
		if(ConfigLoader.isEnabled(UtilItems.infinityBucket_Water.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.infinityBucket_Water, 1), "IBI", "IBI", "ICI", 'I', new ItemStack(Items.iron_ingot), 'B', new ItemStack(Items.water_bucket), 'C', new ItemStack(Items.bucket, 1));
		if(ConfigLoader.isEnabled(UtilItems.infinityBucket_Lava.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.infinityBucket_Lava, 1), "IBI", "IBI", "ICI", 'I', new ItemStack(Items.iron_ingot), 'B', new ItemStack(Items.lava_bucket), 'C', new ItemStack(UtilItems.condensedCore, 1));

		if(ConfigLoader.isEnabled(UtilItems.betterBook.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.betterBook), "LPL", 'L', new ItemStack(Items.leather), 'P', new ItemStack(Items.paper));

		if(ConfigLoader.isEnabled(UtilItems.chain.getUnlocalizedName()))
		{
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.chain, 16), new ItemStack(UtilTools.woodHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.iron_ingot, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.chain, 16), new ItemStack(UtilTools.stoneHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.iron_ingot, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.chain, 16), new ItemStack(UtilTools.ironHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.iron_ingot, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.chain, 16), new ItemStack(UtilTools.goldHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.iron_ingot, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.chain, 16), new ItemStack(UtilTools.diamondHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.iron_ingot, 1));
		}

		if(ConfigLoader.isEnabled(UtilItems.chainPatch.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.chainPatch), "CCC", "CCC", "CCC", 'C', new ItemStack(UtilItems.chain));

		if(ConfigLoader.isEnabled("Super Fabulous Armor"))
		{
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.superFabulousHelm), "FFF", "F F", 'F', new ItemStack(UtilItems.fabulousDiamond));
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.superFabulousChest), "F F", "FFF", "FFF", 'F', new ItemStack(UtilItems.fabulousDiamond));
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.superFabulousPants), "FFF", "F F", "F F", 'F', new ItemStack(UtilItems.fabulousDiamond));
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.superFabulousBoots), "F F", "F F", 'F', new ItemStack(UtilItems.fabulousDiamond));
		}

		if(ConfigLoader.isEnabled("CobbleStone Armor"))
		{
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.cobbleHelm), "FFF", "F F", 'F', new ItemStack(Blocks.cobblestone));
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.cobbleChest), "F F", "FFF", "FFF", 'F', new ItemStack(Blocks.cobblestone));
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.cobblePants), "FFF", "F F", "F F", 'F', new ItemStack(Blocks.cobblestone));
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.cobbleBoots), "F F", "F F", 'F', new ItemStack(Blocks.cobblestone));
		}

		if(ConfigLoader.isEnabled("Super Fabulous Sword"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.fabulousSword), " F ", " F ", " S ", 'S', new ItemStack(Items.stick), 'F', new ItemStack(UtilItems.fabulousDiamond)));

		if(ConfigLoader.isEnabled("Super Fabulous Pickaxe"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.fabulousPickaxe), "FFF", " S ", " S ", 'S', new ItemStack(Items.stick), 'F', new ItemStack(UtilItems.fabulousDiamond)));

		if(ConfigLoader.isEnabled("Super Fabulous Axe"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.fabulousAxe), "FF ", "FS ", " S ", 'S', new ItemStack(Items.stick), 'F', new ItemStack(UtilItems.fabulousDiamond)));

		if(ConfigLoader.isEnabled("Super Fabulous Shovel"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.fabulousSpade), " F ", " S ", " S ", 'S', new ItemStack(Items.stick), 'F', new ItemStack(UtilItems.fabulousDiamond)));

		if(ConfigLoader.isEnabled("Super Fabulous Hoe"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.fabulousHoe), "FF ", " S ", " S ", 'S', new ItemStack(Items.stick), 'F', new ItemStack(UtilItems.fabulousDiamond)));

		if(ConfigLoader.isEnabled("Flint Sword"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.flintSword), " F ", " F ", " S ", 'S', new ItemStack(Items.stick), 'F', new ItemStack(Items.flint)));

		if(ConfigLoader.isEnabled("Flint Pickaxe"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.flintPickaxe), "FFF", " S ", " S ", 'S', new ItemStack(Items.stick), 'F', new ItemStack(Items.flint)));

		if(ConfigLoader.isEnabled("Flint Axe"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.flintAxe), "FF ", "FS ", " S ", 'S', new ItemStack(Items.stick), 'F', new ItemStack(Items.flint)));

		if(ConfigLoader.isEnabled("Flint Shovel"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.flintSpade), " F ", " S ", " S ", 'S', new ItemStack(Items.stick), 'F', new ItemStack(Items.flint)));

		if(ConfigLoader.isEnabled("Flint Hoe"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.flintHoe), "FF ", " S ", " S ", 'S', new ItemStack(Items.stick), 'F', new ItemStack(Items.flint)));

		if(ConfigLoader.isEnabled(UtilItems.turkeyTape.getUnlocalizedName()))
		{
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.turkeyTape), "PPP", "SSS", 'P', new ItemStack(Items.paper), 'S', new ItemStack(Items.string));
			GameRegistry.addShapedRecipe(new ItemStack(Items.iron_helmet), "FCT", " F ", 'F', new ItemStack(Items.iron_ingot), 'C', new ItemStack(UtilArmor.cobbleHelm), 'T', new ItemStack(UtilItems.turkeyTape));
			GameRegistry.addShapedRecipe(new ItemStack(Items.iron_chestplate), "FCT", " F ", 'F', new ItemStack(Items.iron_ingot), 'C', new ItemStack(UtilArmor.cobbleChest), 'T', new ItemStack(UtilItems.turkeyTape));
			GameRegistry.addShapedRecipe(new ItemStack(Items.iron_leggings), "FCT", " F ", 'F', new ItemStack(Items.iron_ingot), 'C', new ItemStack(UtilArmor.cobblePants), 'T', new ItemStack(UtilItems.turkeyTape));
			GameRegistry.addShapedRecipe(new ItemStack(Items.iron_boots), "FCT", " F ", 'F', new ItemStack(Items.iron_ingot), 'C', new ItemStack(UtilArmor.cobbleBoots), 'T', new ItemStack(UtilItems.turkeyTape));

			GameRegistry.addShapedRecipe(new ItemStack(Items.diamond_helmet), "FCT", " F ", 'F', new ItemStack(Items.diamond), 'C', new ItemStack(Items.iron_helmet), 'T', new ItemStack(UtilItems.turkeyTape));
			GameRegistry.addShapedRecipe(new ItemStack(Items.diamond_chestplate), "FCT", " F ", 'F', new ItemStack(Items.diamond), 'C', new ItemStack(Items.iron_chestplate), 'T', new ItemStack(UtilItems.turkeyTape));
			GameRegistry.addShapedRecipe(new ItemStack(Items.diamond_leggings), "FCT", " F ", 'F', new ItemStack(Items.diamond), 'C', new ItemStack(Items.iron_leggings), 'T', new ItemStack(UtilItems.turkeyTape));
			GameRegistry.addShapedRecipe(new ItemStack(Items.diamond_boots), "FCT", " F ", 'F', new ItemStack(Items.diamond), 'C', new ItemStack(Items.iron_boots), 'T', new ItemStack(UtilItems.turkeyTape));

			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.superFabulousHelm), "FCT", " F ", 'F', new ItemStack(UtilItems.fabulousDiamond), 'C', new ItemStack(Items.diamond_helmet), 'T', new ItemStack(UtilItems.turkeyTape));
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.superFabulousChest), "FCT", " F ", 'F', new ItemStack(UtilItems.fabulousDiamond), 'C', new ItemStack(Items.diamond_chestplate), 'T', new ItemStack(UtilItems.turkeyTape));
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.superFabulousPants), "FCT", " F ", 'F', new ItemStack(UtilItems.fabulousDiamond), 'C', new ItemStack(Items.diamond_leggings), 'T', new ItemStack(UtilItems.turkeyTape));
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.superFabulousBoots), "FCT", " F ", 'F', new ItemStack(UtilItems.fabulousDiamond), 'C', new ItemStack(Items.diamond_boots), 'T', new ItemStack(UtilItems.turkeyTape));
		}

		if(ConfigLoader.isEnabled("Chain armor"))
		{
			GameRegistry.addShapedRecipe(new ItemStack(Items.chainmail_helmet), "CCC", "C C", 'C', new ItemStack(UtilItems.chainPatch));
			GameRegistry.addShapedRecipe(new ItemStack(Items.chainmail_chestplate), "C C", "CCC", "CCC", 'C', new ItemStack(UtilItems.chainPatch));
			GameRegistry.addShapedRecipe(new ItemStack(Items.chainmail_leggings), "CCC", "C C", "C C", 'C', new ItemStack(UtilItems.chainPatch));
			GameRegistry.addShapedRecipe(new ItemStack(Items.chainmail_boots), "C C", "C C", 'C', new ItemStack(UtilItems.chainPatch));
		}

		if(ConfigLoader.isEnabled(UtilItems.coffee.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.coffee, 1), new ItemStack(Items.potionitem, 1), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.sugar, 1));
		if(ConfigLoader.isEnabled(UtilFood.dangerDog.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.dangerDog, 1), new ItemStack(Items.bread, 1), new ItemStack(UtilFood.cookedHotdog, 1), new ItemStack(UtilFood.cookedBacon, 1));
		if(ConfigLoader.isEnabled(UtilArmor.gasMask.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilArmor.gasMask, 1), new ItemStack(Blocks.glass_pane, 1), new ItemStack(Items.string, 1));
		if(ConfigLoader.isEnabled(UtilFood.houndBiscuit.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilFood.houndBiscuit, 1), "CFC", "SPS", "CFC", 'C', new ItemStack(Items.cookie, 1), 'F', new ItemStack(UtilItems.flour, 1), 'S', new ItemStack(Items.sugar, 1), 'P', new ItemStack(UtilItems.piePan, 1));
		if(ConfigLoader.isEnabled(UtilArmor.woundedBand.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.woundedBand), " S ", "SRS", " S ", 'S', new ItemStack(Items.string), 'R', new ItemStack(Items.rotten_flesh));
		if(ConfigLoader.isEnabled(UtilItems.ingyIngot.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.ingyIngot), " J ", "III", " I ", 'I', new ItemStack(Blocks.iron_block), 'J', new ItemStack(Blocks.lit_pumpkin));
		if(ConfigLoader.isEnabled(UtilItems.potato.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.potato), "GEG", "GPG", "GGG", 'G', new ItemStack(Items.gold_ingot), 'E', new ItemStack(Items.emerald), 'P', new ItemStack(Items.potato));
		if(ConfigLoader.isEnabled(UtilArmor.turtleShell.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.turtleShell), "WWW", "WCW", "WWW", 'W', new ItemStack(Blocks.wool), 'C', new ItemStack(Items.diamond_chestplate));
		if(ConfigLoader.isEnabled(UtilArmor.pandaMask.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.pandaMask), "BWB", "WBW", "BBB", 'W', new ItemStack(Blocks.wool), 'B', new ItemStack(Blocks.wool, 1, 15));
		if(ConfigLoader.isEnabled(UtilItems.w4llachsAnnounce.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.w4llachsAnnounce, 1), new ItemStack(UtilArmor.pandaMask, 1), new ItemStack(Items.sign, 1));
		if(ConfigLoader.isEnabled(UtilItems.catSpawn.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.catSpawn, 1), "FFF", "FRF", "FFF", 'F', new ItemStack(Items.fish, 1), 'R', new ItemStack(Blocks.red_flower, 1));
		if(ConfigLoader.isEnabled(UtilItems.duckyArmy.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.duckyArmy, 1), "FDF", "DCD", "FDF", 'F', new ItemStack(Items.feather, 1), 'D', new ItemStack(UtilFood.rawDuck, 1), 'C', new ItemStack(UtilBlocks.quadruplecompressedCoal, 1));
		if(ConfigLoader.isEnabled(UtilItems.wyldWhiskey.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.wyldWhiskey, 1), "SDR", " B ", 'S', new ItemStack(UtilFood.juice, 1), 'D', new ItemStack(UtilItems.coffee, 1), 'R', new ItemStack(UtilFood.baconRockSoup, 1), 'B', new ItemStack(Items.glass_bottle, 1));
		if(ConfigLoader.isEnabled(UtilItems.kiraeysTurkeyFeather.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.kiraeysTurkeyFeather, 1), "ROY", "GFB", "IVP", 'R', new ItemStack(Items.dye, 1, 1), 'O', new ItemStack(Items.dye, 1, 14), 'Y', new ItemStack(Items.dye, 1, 11), 'G', new ItemStack(Items.dye, 1, 2), 'F', new ItemStack(UtilItems.turkeyFeather), 'B', new ItemStack(Items.dye, 1, 4), 'I', new ItemStack(Items.dye, 1, 5), 'V', new ItemStack(Items.dye, 1, 13), 'P', new ItemStack(Items.dye, 1, 9));

		if(ConfigLoader.isEnabled(UtilItems.flour.getUnlocalizedName()))
		{
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.flour, 1), new ItemStack(UtilTools.woodHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.wheat, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.flour, 1), new ItemStack(UtilTools.stoneHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.wheat, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.flour, 1), new ItemStack(UtilTools.goldHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.wheat, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.flour, 1), new ItemStack(UtilTools.ironHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.wheat, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.flour, 1), new ItemStack(UtilTools.diamondHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.wheat, 1));
		}

		if(ConfigLoader.isEnabled(UtilFood.juice.getUnlocalizedName()))
		{
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.juice, 1), new ItemStack(UtilTools.woodHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(UtilFood.lime, 1), new ItemStack(Items.glass_bottle, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.juice, 1), new ItemStack(UtilTools.stoneHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(UtilFood.lime, 1), new ItemStack(Items.glass_bottle, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.juice, 1), new ItemStack(UtilTools.goldHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(UtilFood.lime, 1), new ItemStack(Items.glass_bottle, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.juice, 1), new ItemStack(UtilTools.ironHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(UtilFood.lime, 1), new ItemStack(Items.glass_bottle, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.juice, 1), new ItemStack(UtilTools.diamondHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(UtilFood.lime, 1), new ItemStack(Items.glass_bottle, 1));
		}

		if(ConfigLoader.isEnabled(UtilFood.rawBacon.getUnlocalizedName()))
		{
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawBacon, 1), new ItemStack(UtilTools.woodHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.porkchop, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawBacon, 1), new ItemStack(UtilTools.stoneHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.porkchop, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawBacon, 1), new ItemStack(UtilTools.ironHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.porkchop, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawBacon, 1), new ItemStack(UtilTools.goldHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.porkchop, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawBacon, 1), new ItemStack(UtilTools.diamondHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.porkchop, 1));
		}

		if(ConfigLoader.isEnabled(UtilFood.rawHotdog.getUnlocalizedName()))
		{
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawHotdog, 1), new ItemStack(UtilTools.woodHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.beef, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawHotdog, 1), new ItemStack(UtilTools.stoneHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.beef, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawHotdog, 1), new ItemStack(UtilTools.ironHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.beef, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawHotdog, 1), new ItemStack(UtilTools.goldHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.beef, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawHotdog, 1), new ItemStack(UtilTools.diamondHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.beef, 1));
		}

		if(ConfigLoader.isEnabled(UtilFood.rawchickenNugget.getUnlocalizedName()))
		{
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawchickenNugget, 1), new ItemStack(UtilTools.woodHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.chicken, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawchickenNugget, 1), new ItemStack(UtilTools.stoneHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.chicken, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawchickenNugget, 1), new ItemStack(UtilTools.ironHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.chicken, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawchickenNugget, 1), new ItemStack(UtilTools.goldHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.chicken, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawchickenNugget, 1), new ItemStack(UtilTools.diamondHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.chicken, 1));
		}

		if(ConfigLoader.isEnabled(UtilFood.noodles.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilFood.noodles), "FFF", 'F', new ItemStack(UtilItems.flour));

		if(ConfigLoader.isEnabled(UtilItems.piePan.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.piePan), " I ", "III", " I ", 'I', new ItemStack(Items.iron_ingot));
		if(ConfigLoader.isEnabled(UtilFood.gummyWorms.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.gummyWorms, 1), new ItemStack(UtilFood.juice, 1), new ItemStack(Items.sugar, 1));
		if(ConfigLoader.isEnabled(UtilFood.keyLimePie.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.keyLimePie, 1), new ItemStack(UtilFood.lime, 1), new ItemStack(Items.sugar, 1), new ItemStack(UtilItems.piePan, 1), new ItemStack(UtilItems.flour, 1));
		if(ConfigLoader.isEnabled(UtilFood.rawWaffle.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawWaffle, 1), new ItemStack(UtilItems.piePan, 1), new ItemStack(UtilItems.flour, 1), new ItemStack(Items.milk_bucket, 1));
		if(ConfigLoader.isEnabled(UtilFood.bowlofNoodles.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.bowlofNoodles, 1), new ItemStack(Items.bowl, 1), new ItemStack(UtilFood.noodles, 1), new ItemStack(Items.water_bucket, 1));
		if(ConfigLoader.isEnabled(UtilItems.limeSeeds.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.limeSeeds, 1), new ItemStack(UtilFood.lime, 1));
		if(ConfigLoader.isEnabled(UtilFood.rockSoup.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rockSoup, 1), new ItemStack(Items.bowl, 1), new ItemStack(Blocks.cobblestone, 1));
		if(ConfigLoader.isEnabled(UtilFood.baconRockSoup.getUnlocalizedName()))
		{
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.baconRockSoup, 1), new ItemStack(Items.bowl, 1), new ItemStack(Blocks.cobblestone, 1), new ItemStack(UtilFood.cookedBacon, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.baconRockSoup, 1), new ItemStack(UtilFood.rockSoup, 1), new ItemStack(UtilFood.cookedBacon, 1));
		}
		if(ConfigLoader.isEnabled(UtilFood.doughnutbacon.getUnlocalizedName()))
			GameRegistry.addRecipe(new ItemStack(UtilFood.doughnutbacon, 1), "AAA", "ABA", "AAA", 'A', new ItemStack(Items.wheat, 1), 'B', new ItemStack(UtilFood.cookedBacon, 1));
		if(ConfigLoader.isEnabled(UtilFood.genPie.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.genPie, 1), new ItemStack(UtilItems.piePan, 1), new ItemStack(UtilItems.flour, 1), new ItemStack(Items.apple));
		
		
		if(ConfigLoader.isEnabled(UtilFood.waffle.getUnlocalizedName()))
			GameRegistry.addSmelting(UtilFood.rawWaffle, new ItemStack(UtilFood.waffle), 10);
		if(ConfigLoader.isEnabled(UtilFood.cookedTurkey.getUnlocalizedName()))
			GameRegistry.addSmelting(UtilFood.rawTurkey, new ItemStack(UtilFood.cookedTurkey), 10);
		if(ConfigLoader.isEnabled(UtilFood.cookedDuck.getUnlocalizedName()))
			GameRegistry.addSmelting(UtilFood.rawDuck, new ItemStack(UtilFood.cookedDuck), 10);
		if(ConfigLoader.isEnabled(UtilFood.cookedBacon.getUnlocalizedName()))
			GameRegistry.addSmelting(UtilFood.rawBacon, new ItemStack(UtilFood.cookedBacon), 10);
		if(ConfigLoader.isEnabled(UtilFood.cookedHotdog.getUnlocalizedName()))
			GameRegistry.addSmelting(UtilFood.rawHotdog, new ItemStack(UtilFood.cookedHotdog), 10);
		if(ConfigLoader.isEnabled(UtilFood.cookedchickenNugget.getUnlocalizedName()))
			GameRegistry.addSmelting(UtilFood.rawchickenNugget, new ItemStack(UtilFood.cookedchickenNugget), 10);

		if(ConfigLoader.isEnabled("smelt_rotten_flesh"))
			GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.leather), 10);
		if(ConfigLoader.isEnabled("smelt_sand_stone"))
			GameRegistry.addSmelting(Blocks.sandstone, new ItemStack(Blocks.glass, 4), 10);
	}
}