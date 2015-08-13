package com.turkey.turkeyUtil.Items;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.turkey.turkeyUtil.Items.agriculture.LimeSeeds;
import com.turkey.turkeyUtil.Items.tools.BuildGuildShield;
import com.turkey.turkeyUtil.Items.tools.Hammer;
import com.turkey.turkeyUtil.Items.tools.SoulEssanceReaper;
import com.turkey.turkeyUtil.Items.tools.SoulReaper;
import com.turkey.turkeyUtil.blocks.UtilBlocks;

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
	
	public static Item soulReaper;
	public static Item soulEssenceReaper;
	public static Item passiveEssenceContainer;
	public static Item hostileEssenceContainer;

	public static Item infinityBucket_Empty;
	public static Item infinityBucket_Water;
	public static Item infinityBucket_Lava;

	public static Item condensedCore;
	public static Item turkeyTape;

	public static Item fabulousDiamond;
	public static Item coloredIngots;
	public static Item lightIngot;
	public static Item darknessIngot;

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
	public static Item bgShield;
	public static Item glennsSoul;
	
	public static Item betterBook;

	public static void loadItems()
	{
		woodHammer = new Hammer("Wooden_Hammer", 16);
		stoneHammer = new Hammer("Stone_Hammer", 32);
		ironHammer = new Hammer("Iron_Hammer", 64);
		goldHammer = new Hammer("Gold_Hammer", 10);
		diamondHammer = new Hammer("Diamond_Hammer", 390);

		chain = new Chain();
		chainPatch = new ChainPatch();

		soulReaper = new SoulReaper();
		soulEssenceReaper = new SoulEssanceReaper();
		passiveEssenceContainer = new SoulEssanceContainer("Passive");
		hostileEssenceContainer = new SoulEssanceContainer("Hostile");
		
		swatter = new Swatter();
		w4llachsAnnounce = new W4llachsAnnouncement();
		catSpawn = new CatSpawn();
		duckyArmy = new DuckyArmy();
		wyldWhiskey = new WyldWhiskey();
		bgShield = new BuildGuildShield();
		glennsSoul = new GlennsSoul();

		infinityBucket_Empty = new InfinityBucket(Blocks.air).setTextureName("turkeyutil:infinity_bucket_Empty").setUnlocalizedName("Infinity_Air_Bucket");
		infinityBucket_Water = new InfinityBucket(Blocks.flowing_water).setTextureName("turkeyutil:infinity_bucket_Water").setUnlocalizedName("Infinity_Water_Bucket");
		infinityBucket_Lava = new InfinityBucket(Blocks.flowing_lava).setTextureName("turkeyutil:infinity_bucket_Lava").setUnlocalizedName("Infinity_Lava_Bucket");

		condensedCore = new CondensedCore();
		turkeyTape = new TurkeyTape();

		fabulousDiamond = new FabulousDiamond();
		coloredIngots = new ColoredIngots();
		lightIngot = new LightIngot();
		darknessIngot = new DarknessIngot();

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
		GameRegistry.registerItem(bgShield, "Build_Guild_Shield");
		GameRegistry.registerItem(glennsSoul, "Glenns_Soul");
		GameRegistry.registerItem(soulReaper, "Soul_Reaper");
		GameRegistry.registerItem(soulEssenceReaper, "Soul_Essence_Reaper");
		GameRegistry.registerItem(passiveEssenceContainer, "Soul_Essence_Container_Hostile");
		GameRegistry.registerItem(hostileEssenceContainer, "Soul_Essence_Container_Passive");
		GameRegistry.registerItem(coloredIngots, "Colored_Ingot");
		GameRegistry.registerItem(lightIngot, "Light_Ingot");
		GameRegistry.registerItem(darknessIngot, "Darkness_Ingot");
		
		OreDictionary.registerOre("listAllwater", infinityBucket_Water);
		OreDictionary.registerOre("listAlllava", infinityBucket_Lava);

		FluidContainerRegistry.registerFluidContainer(FluidRegistry.WATER, new ItemStack(infinityBucket_Water), new ItemStack(infinityBucket_Water));
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.LAVA, new ItemStack(infinityBucket_Lava), new ItemStack(infinityBucket_Lava));
	}
}