package com.turkey.turkeyUtil.items;

import com.theprogrammingturkey.gobblecore.items.BaseItem;
import com.theprogrammingturkey.gobblecore.items.IItemHandler;
import com.theprogrammingturkey.gobblecore.items.ItemLoader;
import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.blocks.UtilBlocks;
import com.turkey.turkeyUtil.items.agriculture.LimeSeeds;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class UtilItems implements IItemHandler
{
	public static BaseItem chain;
	public static BaseItem chainPatch;

	public static BaseItem swatter;

	public static BaseItem passiveEssenceContainer;
	public static BaseItem hostileEssenceContainer;

	public static Item infinityBucket_Empty;
	public static Item infinityBucket_Water;
	public static Item infinityBucket_Lava;

	public static BaseItem condensedCore;
	public static BaseItem turkeyTape;

	public static BaseItem fabulousDiamond;
	public static BaseItem coloredIngots;
	public static BaseItem coloredCores;
	public static BaseItem lightIngot;
	public static BaseItem darknessIngot;

	public static BaseItem coffee;
	public static BaseItem ingyIngot;
	public static BaseItem potato;
	public static BaseItem piePan;
	public static BaseItem flour;
	public static Item limeSeeds;
	public static BaseItem w4llachsAnnounce;
	public static BaseItem catSpawn;
	public static BaseItem duckyArmy;
	public static BaseItem wyldWhiskey;
	public static BaseItem glennsSoul;
	public static BaseItem turkeyFeather;
	public static BaseItem kiraeysTurkeyFeather;

	public static BaseItem betterBook;

	@Override
	public void registerItems(ItemLoader loader)
	{
		loader.setCreativeTab(TurkeyUtil.baseModTab);

		loader.registerItem(chain = new BaseItem("Chain"));
		loader.registerItem(chainPatch = new BaseItem("Chain_Patch"));

		loader.registerItem(passiveEssenceContainer = new SoulEssanceContainer("Passive"));
		loader.registerItem(hostileEssenceContainer = new SoulEssanceContainer("Hostile"));

		loader.registerItem(infinityBucket_Empty = new InfinityBucket(Blocks.AIR).setUnlocalizedName("Infinity_Air_Bucket"), "Infinity_Air_Bucket");
		loader.registerItem(infinityBucket_Water = new InfinityBucket(Blocks.FLOWING_WATER).setUnlocalizedName("Infinity_Water_Bucket"), "Infinity_Water_Bucket");
		loader.registerItem(infinityBucket_Lava = new InfinityBucket(Blocks.FLOWING_LAVA).setUnlocalizedName("Infinity_Lava_Bucket"), "Infinity_Lava_Bucket");

		loader.registerItem(condensedCore = new BaseItem("Condensed_Core"));
		loader.registerItem(turkeyTape = new BaseItem("TurkeyTape"));
		loader.registerItem(turkeyFeather = new BaseItem("Turkey_Feather"));

		loader.registerItem(fabulousDiamond = new BaseItem("Fabulous_Diamond"));
		fabulousDiamond.addLore("Obtained as a random percent drop from Mystical Ladyosto Ore");
		loader.registerItem(coloredIngots = new ColoredIngots(), "Colored_Ingot");
		loader.registerItem(lightIngot = new BaseItem("Light_Ingot"));
		loader.registerItem(darknessIngot = new BaseItem("Darkness_Ingot"));
		loader.registerItem(coloredCores = new ColoredCore());

		loader.registerItem(swatter = new Swatter());

		
		loader.registerItem(kiraeysTurkeyFeather = new KiraeysTurkeyFeather());

		loader.registerItem(piePan = new BaseItem("Pie_Pan"));
		piePan.setContainerItem(piePan);
		
		loader.registerItem(flour = new BaseItem("Flour"));

		loader.registerItem(limeSeeds = new LimeSeeds(UtilBlocks.limePlant), "Lime_Seeds");

		loader.registerItem(betterBook = new BetterBook());

		loader.setCreativeTab(TurkeyUtil.noodlecraftModTab);
		loader.registerItem(w4llachsAnnounce = new W4llachsAnnouncement());
		loader.registerItem(duckyArmy = new DuckyArmy());
		loader.registerItem(potato = new BaseItem("Draskia's_Potato"));
		potato.addLore("Turns a Zombie Villager into a regular Villager");
		potato.addLore("Draskia, Member of the Walking Wounded and NoodleCraft");

		loader.setCreativeTab(TurkeyUtil.walkingwoundedModTab);
		loader.registerItem(catSpawn = new CatSpawn());
		loader.registerItem(coffee = new Coffee());
		loader.registerItem(ingyIngot = new IngyIngot());

		loader.setCreativeTab(TurkeyUtil.buildguildmodTab);
		loader.registerItem(wyldWhiskey = new WyldWhiskey());
		loader.registerItem(glennsSoul = new BaseItem("Glenns_Soul"));
		glennsSoul.addLore("Used to craft essence containers");
		glennsSoul.addLore("Obtained by killing mobs with Aknot's soul reaper");
		glennsSoul.addLore("Sevadus, Member of the Build Guild");

		FluidContainerRegistry.registerFluidContainer(FluidRegistry.WATER, new ItemStack(infinityBucket_Water), new ItemStack(infinityBucket_Water, 1, 1));
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.LAVA, new ItemStack(infinityBucket_Lava), new ItemStack(infinityBucket_Lava, 1, 1));
	}

	@Override
	public void registerModels(ItemLoader loader)
	{
		
	}
}