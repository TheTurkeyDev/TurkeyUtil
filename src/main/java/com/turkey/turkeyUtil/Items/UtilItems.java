package com.turkey.turkeyUtil.Items;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.turkey.turkeyUtil.Blocks.UtilBlocks;
import com.turkey.turkeyUtil.Items.agriculture.LimeSeeds;
import com.turkey.turkeyUtil.Items.tools.DiamondHammer;
import com.turkey.turkeyUtil.Items.tools.GoldHammer;
import com.turkey.turkeyUtil.Items.tools.IronHammer;
import com.turkey.turkeyUtil.Items.tools.StoneHammer;
import com.turkey.turkeyUtil.Items.tools.WoodHammer;

import cpw.mods.fml.common.registry.GameRegistry;


public class UtilItems
{	

	public static Item woodHammer;
	public static Item stoneHammer;
	public static Item ironHammer;
	public static Item goldHammer;
	public static Item diamondHammer;

	public static Item chain;
	public static Item chainPatch;

	public static Item swatter;

	public static Item infinityBucket_Empty;
	public static Item infinityBucket_Water;
	public static Item infinityBucket_Lava;

	public static Item condensedCore;
	public static Item turkeyTape;

	public static Item fabulousDiamond;

	public static Item coffee;
	public static Item ingyIngot;
	public static Item potato;
	public static Item piePan;
	public static Item flour;
	public static Item limeSeeds;
	public static Item w4llachsAnnounce;
	public static Item catSpawn;
	public static Item duckyArmy;
	public static Item wyldWhiskey;
	
	public static Item betterBook;

	public static void loadItems()
	{
		woodHammer = new WoodHammer();
		stoneHammer = new StoneHammer();
		ironHammer = new IronHammer();
		goldHammer = new GoldHammer();
		diamondHammer = new DiamondHammer();

		chain = new Chain();
		chainPatch = new ChainPatch();

		swatter = new Swatter();
		w4llachsAnnounce = new W4llachsAnnouncement();
		catSpawn = new CatSpawn();
		duckyArmy = new DuckyArmy();
		wyldWhiskey = new WyldWhiskey();

		infinityBucket_Empty = new InfinityBucket(Blocks.air).setTextureName("turkeyutil:infinity_bucket_Empty").setUnlocalizedName("Infinity_Air_Bucket");
		infinityBucket_Water = new InfinityBucket(Blocks.flowing_water).setTextureName("turkeyutil:infinity_bucket_Water").setUnlocalizedName("Infinity_Water_Bucket");
		infinityBucket_Lava = new InfinityBucket(Blocks.flowing_lava).setTextureName("turkeyutil:infinity_bucket_Lava").setUnlocalizedName("Infinity_Lava_Bucket");

		condensedCore = new CondensedCore();
		turkeyTape = new TurkeyTape();

		fabulousDiamond = new FabulousDiamond();

		coffee = new Coffee();
		ingyIngot = new IngyIngot();
		potato = new Potato();

		piePan = new PiePan();
		flour = new Flour();

		limeSeeds = new LimeSeeds(UtilBlocks.limePlant);
		
		betterBook = new BetterBook();
		

		GameRegistry.registerItem(woodHammer, "Wooden_Hammer");
		GameRegistry.registerItem(stoneHammer, "Stone_Hammer");
		GameRegistry.registerItem(ironHammer, "Iron_Hammer");
		GameRegistry.registerItem(goldHammer, "Gold_Hammer");
		GameRegistry.registerItem(diamondHammer, "Diamond_Hammer");
		GameRegistry.registerItem(fabulousDiamond, "Fabulous_Diamond");
		//GameRegistry.registerItem(coffee, "Darkosto's Coffee");
		GameRegistry.registerItem(coffee, "Darkosto's Coffee");
		GameRegistry.registerItem(ingyIngot, "Ingy_The_Ingot");
		GameRegistry.registerItem(potato, "Draskia's_Potato");
		GameRegistry.registerItem(piePan, "Pie_Pan");
		GameRegistry.registerItem(flour, "Flour");
		GameRegistry.registerItem(limeSeeds, "Lime_Seeds");
		GameRegistry.registerItem(infinityBucket_Empty, "Infinity_Air_Bucket");
		GameRegistry.registerItem(infinityBucket_Water, "Infinity_Water_Bucket");
		GameRegistry.registerItem(infinityBucket_Lava, "Infinity_Lava_Bucket");
		GameRegistry.registerItem(condensedCore, "Condensed_Core");
		GameRegistry.registerItem(chain, "Chain");
		GameRegistry.registerItem(chainPatch, "Chain_Patch");
		GameRegistry.registerItem(swatter, "Naraxam's_Bug_Swatter");
		GameRegistry.registerItem(turkeyTape, "TurkeyTape");
		GameRegistry.registerItem(w4llachsAnnounce, "wallachsAnnounce");
		GameRegistry.registerItem(betterBook, "Better_Book");
		GameRegistry.registerItem(catSpawn, "Happiness");
		GameRegistry.registerItem(duckyArmy, "Call_Of_The_Ducky_Army");
		GameRegistry.registerItem(wyldWhiskey, "Wylds_Drink_of_Choice");
		
		OreDictionary.registerOre("listAllwater", infinityBucket_Water);
		OreDictionary.registerOre("listAlllava", infinityBucket_Lava);

		FluidContainerRegistry.registerFluidContainer(FluidRegistry.WATER, new ItemStack(infinityBucket_Water), new ItemStack(infinityBucket_Water));
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.LAVA, new ItemStack(infinityBucket_Lava), new ItemStack(infinityBucket_Lava));
	}
}