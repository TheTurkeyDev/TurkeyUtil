package com.turkey.turkeyUtil.Items;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.turkey.turkeyUtil.Items.agriculture.LimeSeeds;
import com.turkey.turkeyUtil.blocks.UtilBlocks;

import cpw.mods.fml.common.registry.GameRegistry;


public class UtilItems
{

	public static Item chain;
	public static Item chainPatch;

	public static Item swatter;
	
	public static Item passiveEssenceContainer;
	public static Item hostileEssenceContainer;

	public static Item infinityBucket_Empty;
	public static Item infinityBucket_Water;
	public static Item infinityBucket_Lava;

	public static Item condensedCore;
	public static Item turkeyTape;

	public static Item fabulousDiamond;
	public static Item coloredIngots;
	public static Item coloredCores;
	public static Item lightIngot;
	public static Item darknessIngot;
	public static Item abyssCore;

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
	public static Item glennsSoul;
	public static Item turkeyFeather;
	public static Item kiraeysTurkeyFeather;
	
	public static Item betterBook;

	public static void loadItems()
	{

		GameRegistry.registerItem(chain = new BaseItemUtil("Chain"), "Chain");
		GameRegistry.registerItem(chainPatch = new BaseItemUtil("Chain_Patch"), "Chain_Patch");

		GameRegistry.registerItem(passiveEssenceContainer = new SoulEssanceContainer("Passive"), "Soul_Essence_Container_Hostile");
		GameRegistry.registerItem(hostileEssenceContainer = new SoulEssanceContainer("Hostile"), "Soul_Essence_Container_Passive");

		GameRegistry.registerItem(infinityBucket_Empty = new InfinityBucket(Blocks.air).setTextureName("turkeyutil:infinity_bucket_Empty").setUnlocalizedName("Infinity_Air_Bucket"), "Infinity_Air_Bucket");
		GameRegistry.registerItem(infinityBucket_Water = new InfinityBucket(Blocks.flowing_water).setTextureName("turkeyutil:infinity_bucket_Water").setUnlocalizedName("Infinity_Water_Bucket"), "Infinity_Water_Bucket");
		GameRegistry.registerItem(infinityBucket_Lava = new InfinityBucket(Blocks.flowing_lava).setTextureName("turkeyutil:infinity_bucket_Lava").setUnlocalizedName("Infinity_Lava_Bucket"), "Infinity_Lava_Bucket");

		GameRegistry.registerItem(condensedCore = new BaseItemUtil("Condensed_Core"), "Condensed_Core");
		GameRegistry.registerItem(turkeyTape = new BaseItemUtil("TurkeyTape"), "TurkeyTape");
		GameRegistry.registerItem(turkeyFeather = new BaseItemUtil("Turkey_Feather"), "Turkey_Feather");
		
		GameRegistry.registerItem(fabulousDiamond = new FabulousDiamond(), "Fabulous_Diamond");
		GameRegistry.registerItem(coloredIngots = new ColoredIngots(), "Colored_Ingot");
		GameRegistry.registerItem(lightIngot = new BaseItemUtil("Light_Ingot"), "Light_Ingot");
		GameRegistry.registerItem(darknessIngot = new BaseItemUtil("Darkness_Ingot"), "Darkness_Ingot");
		GameRegistry.registerItem(coloredCores = new ColoredCore(), "Colored_Core");
		GameRegistry.registerItem(abyssCore = new BaseItemUtil("Abyss_Core"), "Abyss_Core");

		GameRegistry.registerItem(swatter = new Swatter(), "Naraxam's_Bug_Swatter");
		GameRegistry.registerItem(w4llachsAnnounce = new W4llachsAnnouncement(), "wallachsAnnounce");
		GameRegistry.registerItem(catSpawn = new CatSpawn(), "Happiness");
		GameRegistry.registerItem(duckyArmy = new DuckyArmy(), "Call_Of_The_Ducky_Army");
		GameRegistry.registerItem(wyldWhiskey = new WyldWhiskey(), "Wylds_Drink_of_Choice");
		GameRegistry.registerItem(glennsSoul = new GlennsSoul(), "Glenns_Soul");
		GameRegistry.registerItem(coffee = new Coffee(), "Darkosto's Coffee");
		GameRegistry.registerItem(ingyIngot = new IngyIngot(), "Ingy_The_Ingot");
		GameRegistry.registerItem(potato = new Potato(), "Draskia's_Potato");
		GameRegistry.registerItem(kiraeysTurkeyFeather = new KiraeysTurkeyFeather(), "Kiraeys_Turkey_Feather");

		GameRegistry.registerItem(piePan = new BaseItemUtil("Pie_Pan").setContainerItem(piePan), "Pie_Pan");
		GameRegistry.registerItem(flour = new BaseItemUtil("Flour"), "Flour");
		
		GameRegistry.registerItem(limeSeeds = new LimeSeeds(UtilBlocks.limePlant), "Lime_Seeds");
		
		GameRegistry.registerItem(betterBook = new BetterBook(), "Better_Book");
		
		OreDictionary.registerOre("listAllwater", infinityBucket_Water);
		OreDictionary.registerOre("listAlllava", infinityBucket_Lava);

		FluidContainerRegistry.registerFluidContainer(FluidRegistry.WATER, new ItemStack(infinityBucket_Water), new ItemStack(infinityBucket_Water));
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.LAVA, new ItemStack(infinityBucket_Lava), new ItemStack(infinityBucket_Lava));
	}
}