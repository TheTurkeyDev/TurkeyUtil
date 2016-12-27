package com.turkey.turkeyUtil.util;

import java.util.List;

import com.google.common.collect.Lists;
import com.theprogrammingturkey.gobblecore.managers.CraftingManager;
import com.turkey.turkeyUtil.armor.UtilArmor;
import com.turkey.turkeyUtil.blocks.AdvancedHopper;
import com.turkey.turkeyUtil.blocks.UtilBlocks;
import com.turkey.turkeyUtil.items.UtilItems;
import com.turkey.turkeyUtil.items.food.UtilFood;
import com.turkey.turkeyUtil.items.tools.UtilTools;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class UtilCrafting
{

	public static List<IRecipe> enchantableRecipes = Lists.newArrayList();

	public static void loadCraftingRecipies()
	{
		if(ConfigLoader.isEnabled(UtilBlocks.charcolBlock.getLocalizedName()))
			CraftingManager.register3x3CompressionRecipe(new ItemStack(Items.COAL, 1, 1), new ItemStack(UtilBlocks.charcolBlock, 1), true);

		if(ConfigLoader.isEnabled(UtilBlocks.fabulousBlock.getLocalizedName()))
			CraftingManager.register3x3CompressionRecipe(new ItemStack(UtilItems.fabulousDiamond, 1), new ItemStack(UtilBlocks.fabulousBlock, 1), true);

		if(ConfigLoader.isEnabled(UtilBlocks.charcolBlock.getLocalizedName()))
			CraftingManager.register3x3CompressionRecipe(new ItemStack(Items.FLINT, 1), new ItemStack(UtilBlocks.flintBlock, 1), true);

		if(ConfigLoader.isEnabled("Compressed Coal"))
		{
			CraftingManager.register3x3CompressionRecipe(new ItemStack(Blocks.COAL_BLOCK, 1), new ItemStack(UtilBlocks.doublecompressedCoal, 1), true);
			CraftingManager.register3x3CompressionRecipe(new ItemStack(UtilBlocks.doublecompressedCoal, 1), new ItemStack(UtilBlocks.triplecompressedCoal, 1), true);
			CraftingManager.register3x3CompressionRecipe(new ItemStack(UtilBlocks.triplecompressedCoal, 1), new ItemStack(UtilBlocks.quadruplecompressedCoal, 1), true);
			CraftingManager.register3x3CompressionRecipe(new ItemStack(UtilBlocks.quadruplecompressedCoal, 1), new ItemStack(UtilBlocks.quintuplecompressedCoal, 1), true);
			CraftingManager.register3x3CompressionRecipe(new ItemStack(UtilBlocks.quintuplecompressedCoal, 1), new ItemStack(UtilBlocks.hextuplecompressedCoal, 1), true);
			CraftingManager.register3x3CompressionRecipe(new ItemStack(UtilBlocks.hextuplecompressedCoal, 1), new ItemStack(UtilBlocks.septuplecompressedCoal, 1), true);
			CraftingManager.register3x3CompressionRecipe(new ItemStack(UtilBlocks.septuplecompressedCoal, 1), new ItemStack(UtilBlocks.octuplecompressedCoal, 1), true);
			CraftingManager.register3x3CompressionRecipe(new ItemStack(UtilBlocks.octuplecompressedCoal, 1), new ItemStack(UtilItems.condensedCore, 1), true);
		}

		if(ConfigLoader.isEnabled("Compressed Obsidian"))
		{
			CraftingManager.register3x3CompressionRecipe(new ItemStack(Blocks.OBSIDIAN, 1), new ItemStack(UtilBlocks.compressedObsidian, 1), true);
			CraftingManager.register3x3CompressionRecipe(new ItemStack(UtilBlocks.compressedObsidian, 1), new ItemStack(UtilBlocks.doublecompressedObsidian, 1), true);
			CraftingManager.register3x3CompressionRecipe(new ItemStack(UtilBlocks.doublecompressedObsidian, 1), new ItemStack(UtilBlocks.triplecompressedObsidian, 1), true);
			CraftingManager.register3x3CompressionRecipe(new ItemStack(UtilBlocks.triplecompressedObsidian, 1), new ItemStack(UtilBlocks.quadruplecompressedObsidian, 1), true);
			CraftingManager.register3x3CompressionRecipe(new ItemStack(UtilBlocks.quadruplecompressedObsidian, 1), new ItemStack(UtilBlocks.quintuplecompressedObsidian, 1), true);
			CraftingManager.register3x3CompressionRecipe(new ItemStack(UtilBlocks.quintuplecompressedObsidian, 1), new ItemStack(UtilBlocks.hextuplecompressedObsidian, 1), true);
			CraftingManager.register3x3CompressionRecipe(new ItemStack(UtilBlocks.hextuplecompressedObsidian, 1), new ItemStack(UtilBlocks.septuplecompressedObsidian, 1), true);
			CraftingManager.register3x3CompressionRecipe(new ItemStack(UtilBlocks.septuplecompressedObsidian, 1), new ItemStack(UtilBlocks.octuplecompressedObsidian, 1), true);
		}

		if(ConfigLoader.isEnabled("Monocolored Blocks"))
		{
			for(int i = 0; i < 16; i++)
				CraftingManager.register2x2CompressionRecipe(new ItemStack(UtilItems.coloredIngots, 1, i), new ItemStack(UtilBlocks.monoBlock, 1, i), true);
		}

		if(ConfigLoader.isEnabled("Colored Cores"))
		{
			for(int i = 0; i < 16; i++)
				CraftingManager.register3x3CompressionRecipe(new ItemStack(UtilItems.coloredIngots, 1, i), new ItemStack(UtilItems.coloredCores, 1, i), false);
		}

		if(ConfigLoader.isEnabled("Monocolored Light Blocks"))
		{
			for(int i = 0; i < 16; i++)
				GameRegistry.addShapelessRecipe(new ItemStack(UtilBlocks.monoLightBlock, 1, i), new ItemStack(UtilBlocks.monoBlock, 1, i), new ItemStack(Blocks.GLOWSTONE, 1));
		}

		if(ConfigLoader.isEnabled(UtilBlocks.lightCollector.getLocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilBlocks.lightCollector), "IGI", "IDI", "III", 'I', new ItemStack(Items.IRON_INGOT), 'G', new ItemStack(Blocks.GLASS), 'D', new ItemStack(Items.DIAMOND));
		if(ConfigLoader.isEnabled(UtilBlocks.lightHealer.getLocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilBlocks.lightHealer), "FGF", "CLC", "III", 'I', new ItemStack(Items.IRON_INGOT), 'G', new ItemStack(Blocks.GLASS), 'F', new ItemStack(UtilItems.fabulousDiamond), 'C', new ItemStack(UtilItems.coloredCores, 1, 13), 'L', new ItemStack(UtilBlocks.lightCollector));

		if(ConfigLoader.isEnabled("Advanced Hoppers"))
			for(AdvancedHopper hopper : UtilBlocks.advancedHoppers)
				GameRegistry.addShapedRecipe(new ItemStack(hopper), "I I", "IHI", " I ", 'I', new ItemStack(HopperType.getHopperTypeFromName(hopper.getUnlocalizedName().replace("tile.", "").replace("_Advanced_Hopper", "").trim()).getItem()), 'H', new ItemStack(Blocks.HOPPER));

		if(ConfigLoader.isEnabled(UtilTools.woodHammer.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilTools.woodHammer, 1), "WS", "WS", " S", 'W', new ItemStack(Blocks.PLANKS), 'S', new ItemStack(Items.STICK));
		if(ConfigLoader.isEnabled(UtilTools.stoneHammer.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilTools.stoneHammer, 1), "TS", "TS", " S", 'T', new ItemStack(Blocks.COBBLESTONE), 'S', new ItemStack(Items.STICK));
		if(ConfigLoader.isEnabled(UtilTools.ironHammer.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilTools.ironHammer, 1), "IS", "IS", " S", 'I', new ItemStack(Items.IRON_INGOT), 'S', new ItemStack(Items.STICK));
		if(ConfigLoader.isEnabled(UtilTools.goldHammer.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilTools.goldHammer, 1), "GS", "GS", " S", 'G', new ItemStack(Items.GOLD_INGOT), 'S', new ItemStack(Items.STICK));
		if(ConfigLoader.isEnabled(UtilTools.diamondHammer.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilTools.diamondHammer, 1), "DS", "DS", " S", 'D', new ItemStack(Items.DIAMOND), 'S', new ItemStack(Items.STICK));

		if(ConfigLoader.isEnabled(UtilItems.swatter.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.swatter, 1), "S", "S", "T", 'S', new ItemStack(Items.STRING), 'T', new ItemStack(Items.STICK));

		if(ConfigLoader.isEnabled(UtilTools.soulReaper.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilTools.soulReaper, 1), "III", " S ", "S  ", 'S', new ItemStack(Items.STICK), 'I', new ItemStack(Items.IRON_INGOT));
		if(ConfigLoader.isEnabled(UtilTools.soulEssenceReaper.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilTools.soulEssenceReaper, 1), "III", "GS ", "S  ", 'S', new ItemStack(Items.STICK), 'I', new ItemStack(Items.IRON_INGOT), 'G', new ItemStack(UtilItems.glennsSoul));
		if(ConfigLoader.isEnabled(UtilItems.passiveEssenceContainer.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.passiveEssenceContainer, 1), "GBG", "SIS", "GSG", 'S', new ItemStack(UtilItems.glennsSoul), 'G', new ItemStack(Blocks.GLASS), 'I', new ItemStack(Items.IRON_INGOT), 'B', new ItemStack(Blocks.DIAMOND_BLOCK));
		if(ConfigLoader.isEnabled(UtilItems.hostileEssenceContainer.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.hostileEssenceContainer, 1), "GBG", "SIS", "GSG", 'S', new ItemStack(UtilItems.glennsSoul), 'G', new ItemStack(Blocks.GLASS), 'I', new ItemStack(Items.IRON_INGOT), 'B', new ItemStack(Blocks.IRON_BLOCK));

		if(ConfigLoader.isEnabled(UtilItems.infinityBucket_Empty.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.infinityBucket_Empty, 1), "IBI", "IBI", "IBI", 'I', new ItemStack(Items.IRON_INGOT), 'B', new ItemStack(Items.BUCKET));
		if(ConfigLoader.isEnabled(UtilItems.infinityBucket_Water.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.infinityBucket_Water, 1), "IBI", "IBI", "ICI", 'I', new ItemStack(Items.IRON_INGOT), 'B', new ItemStack(Items.WATER_BUCKET), 'C', new ItemStack(Items.BUCKET, 1));
		if(ConfigLoader.isEnabled(UtilItems.infinityBucket_Lava.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.infinityBucket_Lava, 1), "IBI", "IBI", "ICI", 'I', new ItemStack(Items.IRON_INGOT), 'B', new ItemStack(Items.LAVA_BUCKET), 'C', new ItemStack(UtilItems.condensedCore, 1));

		if(ConfigLoader.isEnabled(UtilItems.betterBook.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.betterBook), "LPL", 'L', new ItemStack(Items.LEATHER), 'P', new ItemStack(Items.PAPER));

		if(ConfigLoader.isEnabled(UtilItems.chain.getUnlocalizedName()))
		{
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.chain, 16), new ItemStack(UtilTools.woodHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.IRON_INGOT, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.chain, 16), new ItemStack(UtilTools.stoneHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.IRON_INGOT, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.chain, 16), new ItemStack(UtilTools.ironHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.IRON_INGOT, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.chain, 16), new ItemStack(UtilTools.goldHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.IRON_INGOT, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.chain, 16), new ItemStack(UtilTools.diamondHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.IRON_INGOT, 1));
		}

		if(ConfigLoader.isEnabled(UtilItems.chainPatch.getUnlocalizedName()))
			CraftingManager.register3x3CompressionRecipe(new ItemStack(UtilItems.chain), new ItemStack(UtilItems.chainPatch), false);

		if(ConfigLoader.isEnabled("Super Fabulous Armor"))
		{
			CraftingManager.registerHelemetRecipe(new ItemStack(UtilItems.fabulousDiamond), new ItemStack(UtilArmor.superFabulousHelm));
			CraftingManager.registerChestplateRecipe(new ItemStack(UtilItems.fabulousDiamond), new ItemStack(UtilArmor.superFabulousChest));
			CraftingManager.registerLeggingsRecipe(new ItemStack(UtilItems.fabulousDiamond), new ItemStack(UtilArmor.superFabulousPants));
			CraftingManager.registerBootsRecipe(new ItemStack(UtilItems.fabulousDiamond), new ItemStack(UtilArmor.superFabulousBoots));
		}

		if(ConfigLoader.isEnabled("CobbleStone Armor"))
		{
			CraftingManager.registerHelemetRecipe(new ItemStack(UtilArmor.cobbleHelm), new ItemStack(Blocks.COBBLESTONE));
			CraftingManager.registerChestplateRecipe(new ItemStack(UtilArmor.cobbleChest), new ItemStack(Blocks.COBBLESTONE));
			CraftingManager.registerLeggingsRecipe(new ItemStack(UtilArmor.cobblePants), new ItemStack(Blocks.COBBLESTONE));
			CraftingManager.registerBootsRecipe(new ItemStack(UtilArmor.cobbleBoots), new ItemStack(Blocks.COBBLESTONE));
		}

		if(ConfigLoader.isEnabled("Super Fabulous Sword"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.fabulousSword), " F ", " F ", " S ", 'S', new ItemStack(Items.STICK), 'F', new ItemStack(UtilItems.fabulousDiamond)));

		if(ConfigLoader.isEnabled("Super Fabulous Pickaxe"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.fabulousPickaxe), "FFF", " S ", " S ", 'S', new ItemStack(Items.STICK), 'F', new ItemStack(UtilItems.fabulousDiamond)));

		if(ConfigLoader.isEnabled("Super Fabulous Axe"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.fabulousAxe), "FF ", "FS ", " S ", 'S', new ItemStack(Items.STICK), 'F', new ItemStack(UtilItems.fabulousDiamond)));

		if(ConfigLoader.isEnabled("Super Fabulous Shovel"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.fabulousSpade), " F ", " S ", " S ", 'S', new ItemStack(Items.STICK), 'F', new ItemStack(UtilItems.fabulousDiamond)));

		if(ConfigLoader.isEnabled("Super Fabulous Hoe"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.fabulousHoe), "FF ", " S ", " S ", 'S', new ItemStack(Items.STICK), 'F', new ItemStack(UtilItems.fabulousDiamond)));

		if(ConfigLoader.isEnabled("Flint Sword"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.flintSword), " F ", " F ", " S ", 'S', new ItemStack(Items.STICK), 'F', new ItemStack(Items.FLINT)));

		if(ConfigLoader.isEnabled("Flint Pickaxe"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.flintPickaxe), "FFF", " S ", " S ", 'S', new ItemStack(Items.STICK), 'F', new ItemStack(Items.FLINT)));

		if(ConfigLoader.isEnabled("Flint Axe"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.flintAxe), "FF ", "FS ", " S ", 'S', new ItemStack(Items.STICK), 'F', new ItemStack(Items.FLINT)));

		if(ConfigLoader.isEnabled("Flint Shovel"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.flintSpade), " F ", " S ", " S ", 'S', new ItemStack(Items.STICK), 'F', new ItemStack(Items.FLINT)));

		if(ConfigLoader.isEnabled("Flint Hoe"))
			enchantableRecipes.add(GameRegistry.addShapedRecipe(new ItemStack(UtilTools.flintHoe), "FF ", " S ", " S ", 'S', new ItemStack(Items.STICK), 'F', new ItemStack(Items.FLINT)));

		if(ConfigLoader.isEnabled(UtilItems.turkeyTape.getUnlocalizedName()))
		{
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.turkeyTape), "PPP", "SSS", 'P', new ItemStack(Items.PAPER), 'S', new ItemStack(Items.STRING));
			GameRegistry.addShapedRecipe(new ItemStack(Items.IRON_HELMET), "FCT", " F ", 'F', new ItemStack(Items.IRON_INGOT), 'C', new ItemStack(UtilArmor.cobbleHelm), 'T', new ItemStack(UtilItems.turkeyTape));
			GameRegistry.addShapedRecipe(new ItemStack(Items.IRON_CHESTPLATE), "FCT", " F ", 'F', new ItemStack(Items.IRON_INGOT), 'C', new ItemStack(UtilArmor.cobbleChest), 'T', new ItemStack(UtilItems.turkeyTape));
			GameRegistry.addShapedRecipe(new ItemStack(Items.IRON_LEGGINGS), "FCT", " F ", 'F', new ItemStack(Items.IRON_INGOT), 'C', new ItemStack(UtilArmor.cobblePants), 'T', new ItemStack(UtilItems.turkeyTape));
			GameRegistry.addShapedRecipe(new ItemStack(Items.IRON_BOOTS), "FCT", " F ", 'F', new ItemStack(Items.IRON_INGOT), 'C', new ItemStack(UtilArmor.cobbleBoots), 'T', new ItemStack(UtilItems.turkeyTape));

			GameRegistry.addShapedRecipe(new ItemStack(Items.DIAMOND_HELMET), "FCT", " F ", 'F', new ItemStack(Items.DIAMOND), 'C', new ItemStack(Items.IRON_HELMET), 'T', new ItemStack(UtilItems.turkeyTape));
			GameRegistry.addShapedRecipe(new ItemStack(Items.DIAMOND_CHESTPLATE), "FCT", " F ", 'F', new ItemStack(Items.DIAMOND), 'C', new ItemStack(Items.IRON_CHESTPLATE), 'T', new ItemStack(UtilItems.turkeyTape));
			GameRegistry.addShapedRecipe(new ItemStack(Items.DIAMOND_LEGGINGS), "FCT", " F ", 'F', new ItemStack(Items.DIAMOND), 'C', new ItemStack(Items.IRON_LEGGINGS), 'T', new ItemStack(UtilItems.turkeyTape));
			GameRegistry.addShapedRecipe(new ItemStack(Items.DIAMOND_BOOTS), "FCT", " F ", 'F', new ItemStack(Items.DIAMOND), 'C', new ItemStack(Items.IRON_BOOTS), 'T', new ItemStack(UtilItems.turkeyTape));

			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.superFabulousHelm), "FCT", " F ", 'F', new ItemStack(UtilItems.fabulousDiamond), 'C', new ItemStack(Items.DIAMOND_HELMET), 'T', new ItemStack(UtilItems.turkeyTape));
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.superFabulousChest), "FCT", " F ", 'F', new ItemStack(UtilItems.fabulousDiamond), 'C', new ItemStack(Items.DIAMOND_CHESTPLATE), 'T', new ItemStack(UtilItems.turkeyTape));
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.superFabulousPants), "FCT", " F ", 'F', new ItemStack(UtilItems.fabulousDiamond), 'C', new ItemStack(Items.DIAMOND_LEGGINGS), 'T', new ItemStack(UtilItems.turkeyTape));
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.superFabulousBoots), "FCT", " F ", 'F', new ItemStack(UtilItems.fabulousDiamond), 'C', new ItemStack(Items.DIAMOND_BOOTS), 'T', new ItemStack(UtilItems.turkeyTape));
		}

		if(ConfigLoader.isEnabled("Chain armor"))
		{
			CraftingManager.registerHelemetRecipe(new ItemStack(UtilItems.chainPatch), new ItemStack(Items.CHAINMAIL_HELMET));
			CraftingManager.registerChestplateRecipe(new ItemStack(UtilItems.chainPatch), new ItemStack(Items.CHAINMAIL_CHESTPLATE));
			CraftingManager.registerLeggingsRecipe(new ItemStack(UtilItems.chainPatch), new ItemStack(Items.CHAINMAIL_LEGGINGS));
			CraftingManager.registerBootsRecipe(new ItemStack(UtilItems.chainPatch), new ItemStack(Items.CHAINMAIL_BOOTS));
		}

		if(ConfigLoader.isEnabled(UtilItems.coffee.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.coffee, 1), new ItemStack(Items.POTIONITEM, 1), new ItemStack(Items.DYE, 1, 3), new ItemStack(Items.SUGAR, 1));
		if(ConfigLoader.isEnabled(UtilFood.dangerDog.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.dangerDog, 1), new ItemStack(Items.BREAD, 1), new ItemStack(UtilFood.cookedHotdog, 1), new ItemStack(UtilFood.cookedBacon, 1));
		if(ConfigLoader.isEnabled(UtilArmor.gasMask.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilArmor.gasMask, 1), new ItemStack(Blocks.GLASS_PANE, 1), new ItemStack(Items.STRING, 1));
		if(ConfigLoader.isEnabled(UtilFood.houndBiscuit.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilFood.houndBiscuit, 1), "CFC", "SPS", "CFC", 'C', new ItemStack(Items.COOKIE, 1), 'F', new ItemStack(UtilItems.flour, 1), 'S', new ItemStack(Items.SUGAR, 1), 'P', new ItemStack(UtilItems.piePan, 1));
		if(ConfigLoader.isEnabled(UtilArmor.woundedBand.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.woundedBand), " S ", "SRS", " S ", 'S', new ItemStack(Items.STRING), 'R', new ItemStack(Items.ROTTEN_FLESH));
		if(ConfigLoader.isEnabled(UtilItems.ingyIngot.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.ingyIngot), " J ", "III", " I ", 'I', new ItemStack(Blocks.IRON_BLOCK), 'J', new ItemStack(Blocks.LIT_PUMPKIN));
		if(ConfigLoader.isEnabled(UtilItems.potato.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.potato), "GEG", "GPG", "GGG", 'G', new ItemStack(Items.GOLD_INGOT), 'E', new ItemStack(Items.EMERALD), 'P', new ItemStack(Items.POTATO));
		if(ConfigLoader.isEnabled(UtilArmor.turtleShell.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.turtleShell), "WWW", "WCW", "WWW", 'W', new ItemStack(Blocks.WOOL), 'C', new ItemStack(Items.DIAMOND_CHESTPLATE));
		if(ConfigLoader.isEnabled(UtilArmor.pandaMask.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilArmor.pandaMask), "BWB", "WBW", "BBB", 'W', new ItemStack(Blocks.WOOL), 'B', new ItemStack(Blocks.WOOL, 1, 15));
		if(ConfigLoader.isEnabled(UtilItems.w4llachsAnnounce.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.w4llachsAnnounce, 1), new ItemStack(UtilArmor.pandaMask, 1), new ItemStack(Items.SIGN, 1));
		if(ConfigLoader.isEnabled(UtilItems.catSpawn.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.catSpawn, 1), "FFF", "FRF", "FFF", 'F', new ItemStack(Items.FISH, 1), 'R', new ItemStack(Blocks.RED_FLOWER, 1));
		if(ConfigLoader.isEnabled(UtilItems.duckyArmy.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.duckyArmy, 1), "FDF", "DCD", "FDF", 'F', new ItemStack(Items.FEATHER, 1), 'D', new ItemStack(UtilFood.rawDuck, 1), 'C', new ItemStack(UtilBlocks.quadruplecompressedCoal, 1));
		if(ConfigLoader.isEnabled(UtilItems.wyldWhiskey.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.wyldWhiskey, 1), "SDR", " B ", 'S', new ItemStack(UtilFood.juice, 1), 'D', new ItemStack(UtilItems.coffee, 1), 'R', new ItemStack(UtilFood.baconRockSoup, 1), 'B', new ItemStack(Items.GLASS_BOTTLE, 1));
		if(ConfigLoader.isEnabled(UtilItems.kiraeysTurkeyFeather.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.kiraeysTurkeyFeather, 1), "ROY", "GFB", "IVP", 'R', new ItemStack(Items.DYE, 1, 1), 'O', new ItemStack(Items.DYE, 1, 14), 'Y', new ItemStack(Items.DYE, 1, 11), 'G', new ItemStack(Items.DYE, 1, 2), 'F', new ItemStack(UtilItems.turkeyFeather), 'B', new ItemStack(Items.DYE, 1, 4), 'I', new ItemStack(Items.DYE, 1, 5), 'V', new ItemStack(Items.DYE, 1, 13), 'P', new ItemStack(Items.DYE, 1, 9));

		if(ConfigLoader.isEnabled(UtilItems.flour.getUnlocalizedName()))
		{
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.flour, 1), new ItemStack(UtilTools.woodHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.WHEAT, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.flour, 1), new ItemStack(UtilTools.stoneHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.WHEAT, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.flour, 1), new ItemStack(UtilTools.goldHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.WHEAT, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.flour, 1), new ItemStack(UtilTools.ironHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.WHEAT, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.flour, 1), new ItemStack(UtilTools.diamondHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.WHEAT, 1));
		}

		if(ConfigLoader.isEnabled(UtilFood.juice.getUnlocalizedName()))
		{
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.juice, 1), new ItemStack(UtilTools.woodHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(UtilFood.lime, 1), new ItemStack(Items.GLASS_BOTTLE, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.juice, 1), new ItemStack(UtilTools.stoneHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(UtilFood.lime, 1), new ItemStack(Items.GLASS_BOTTLE, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.juice, 1), new ItemStack(UtilTools.goldHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(UtilFood.lime, 1), new ItemStack(Items.GLASS_BOTTLE, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.juice, 1), new ItemStack(UtilTools.ironHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(UtilFood.lime, 1), new ItemStack(Items.GLASS_BOTTLE, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.juice, 1), new ItemStack(UtilTools.diamondHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(UtilFood.lime, 1), new ItemStack(Items.GLASS_BOTTLE, 1));
		}

		if(ConfigLoader.isEnabled(UtilFood.rawBacon.getUnlocalizedName()))
		{
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawBacon, 1), new ItemStack(UtilTools.woodHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.PORKCHOP, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawBacon, 1), new ItemStack(UtilTools.stoneHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.PORKCHOP, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawBacon, 1), new ItemStack(UtilTools.ironHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.PORKCHOP, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawBacon, 1), new ItemStack(UtilTools.goldHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.PORKCHOP, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawBacon, 1), new ItemStack(UtilTools.diamondHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.PORKCHOP, 1));
		}

		if(ConfigLoader.isEnabled(UtilFood.rawHotdog.getUnlocalizedName()))
		{
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawHotdog, 1), new ItemStack(UtilTools.woodHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.BEEF, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawHotdog, 1), new ItemStack(UtilTools.stoneHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.BEEF, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawHotdog, 1), new ItemStack(UtilTools.ironHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.BEEF, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawHotdog, 1), new ItemStack(UtilTools.goldHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.BEEF, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawHotdog, 1), new ItemStack(UtilTools.diamondHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.BEEF, 1));
		}

		if(ConfigLoader.isEnabled(UtilFood.rawchickenNugget.getUnlocalizedName()))
		{
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawchickenNugget, 1), new ItemStack(UtilTools.woodHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.CHICKEN, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawchickenNugget, 1), new ItemStack(UtilTools.stoneHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.CHICKEN, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawchickenNugget, 1), new ItemStack(UtilTools.ironHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.CHICKEN, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawchickenNugget, 1), new ItemStack(UtilTools.goldHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.CHICKEN, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawchickenNugget, 1), new ItemStack(UtilTools.diamondHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.CHICKEN, 1));
		}

		if(ConfigLoader.isEnabled(UtilFood.noodles.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilFood.noodles), "FFF", 'F', new ItemStack(UtilItems.flour));

		if(ConfigLoader.isEnabled(UtilItems.piePan.getUnlocalizedName()))
			GameRegistry.addShapedRecipe(new ItemStack(UtilItems.piePan), " I ", "III", " I ", 'I', new ItemStack(Items.IRON_INGOT));
		if(ConfigLoader.isEnabled(UtilFood.gummyWorms.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.gummyWorms, 1), new ItemStack(UtilFood.juice, 1), new ItemStack(Items.SUGAR, 1));
		if(ConfigLoader.isEnabled(UtilFood.keyLimePie.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.keyLimePie, 1), new ItemStack(UtilFood.lime, 1), new ItemStack(Items.SUGAR, 1), new ItemStack(UtilItems.piePan, 1), new ItemStack(UtilItems.flour, 1));
		if(ConfigLoader.isEnabled(UtilFood.rawWaffle.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rawWaffle, 1), new ItemStack(UtilItems.piePan, 1), new ItemStack(UtilItems.flour, 1), new ItemStack(Items.MILK_BUCKET, 1));
		if(ConfigLoader.isEnabled(UtilFood.bowlofNoodles.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.bowlofNoodles, 1), new ItemStack(Items.BOWL, 1), new ItemStack(UtilFood.noodles, 1), new ItemStack(Items.WATER_BUCKET, 1));
		if(ConfigLoader.isEnabled(UtilItems.limeSeeds.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilItems.limeSeeds, 1), new ItemStack(UtilFood.lime, 1));
		if(ConfigLoader.isEnabled(UtilFood.rockSoup.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.rockSoup, 1), new ItemStack(Items.BOWL, 1), new ItemStack(Blocks.COBBLESTONE, 1));
		if(ConfigLoader.isEnabled(UtilFood.baconRockSoup.getUnlocalizedName()))
		{
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.baconRockSoup, 1), new ItemStack(Items.BOWL, 1), new ItemStack(Blocks.COBBLESTONE, 1), new ItemStack(UtilFood.cookedBacon, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.baconRockSoup, 1), new ItemStack(UtilFood.rockSoup, 1), new ItemStack(UtilFood.cookedBacon, 1));
		}
		if(ConfigLoader.isEnabled(UtilFood.doughnutbacon.getUnlocalizedName()))
			GameRegistry.addRecipe(new ItemStack(UtilFood.doughnutbacon, 1), "AAA", "ABA", "AAA", 'A', new ItemStack(Items.WHEAT, 1), 'B', new ItemStack(UtilFood.cookedBacon, 1));
		if(ConfigLoader.isEnabled(UtilFood.genPie.getUnlocalizedName()))
			GameRegistry.addShapelessRecipe(new ItemStack(UtilFood.genPie, 1), new ItemStack(UtilItems.piePan, 1), new ItemStack(UtilItems.flour, 1), new ItemStack(Items.APPLE));

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
			GameRegistry.addSmelting(Items.ROTTEN_FLESH, new ItemStack(Items.LEATHER), 10);
		if(ConfigLoader.isEnabled("smelt_sand_stone"))
			GameRegistry.addSmelting(Blocks.SANDSTONE, new ItemStack(Blocks.GLASS, 4), 10);
	}
}