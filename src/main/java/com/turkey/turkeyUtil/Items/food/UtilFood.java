package com.turkey.turkeyUtil.items.food;

import com.theprogrammingturkey.gobblecore.items.BaseItemFood;
import com.theprogrammingturkey.gobblecore.items.IItemHandler;
import com.theprogrammingturkey.gobblecore.items.ItemLoader;
import com.turkey.turkeyUtil.TurkeyUtil;

public class UtilFood implements IItemHandler
{
	public static BaseItemFood houndBiscuit;
	public static BaseItemFood waffle;
	public static BaseItemFood rawWaffle;
	public static BaseItemFood bowlofNoodles;
	public static BaseItemFood lime;
	public static BaseItemFood noodles;
	public static BaseItemFood juice;
	public static BaseItemFood gummyWorms;
	public static BaseItemFood keyLimePie;
	public static BaseItemFood rawTurkey;
	public static BaseItemFood cookedTurkey;
	public static BaseItemFood dangerDog;
	public static BaseItemFood rawBacon;
	public static BaseItemFood cookedBacon;
	public static BaseItemFood rawHotdog;
	public static BaseItemFood cookedHotdog;
	public static BaseItemFood doughnutbacon;
	public static BaseItemFood rockSoup;
	public static BaseItemFood baconRockSoup;
	public static BaseItemFood staleCookie;
	public static BaseItemFood genPie;
	public static BaseItemFood rawchickenNugget;
	public static BaseItemFood cookedchickenNugget;
	public static BaseItemFood rawDuck;
	public static BaseItemFood cookedDuck;

	@Override
	public void registerItems(ItemLoader loader)
	{

		loader.setCreativeTab(TurkeyUtil.baseModTab);
		loader.registerItem(lime = new BaseItemFood("lime", 1, 0.2f, false), lime.getItemName());
		lime.addLore("What? Is that not how it works?");
		loader.registerItem(gummyWorms = new BaseItemFood("gummy_worms", 5, .2f, false), gummyWorms.getItemName());
		loader.registerItem(keyLimePie = new BaseItemFood("key_lime_pie", 8, .25f, false, 16), keyLimePie.getItemName());
		loader.registerItem(rawWaffle = new BaseItemFood("raw_waffle", 1, 0.5f, false), rawWaffle.getItemName());
		rawWaffle.addLore("Ewwwwwww");
		loader.registerItem(rawTurkey = new BaseItemFood("raw_turkey", 1, 1f, false), rawTurkey.getItemName());
		loader.registerItem(cookedTurkey = new BaseItemFood("cooked_turkey", 8, .375f, false), cookedTurkey.getItemName());
		loader.registerItem(rawHotdog = new BaseItemFood("raw_hotdog", 1, 0.5f, false), rawHotdog.getItemName());
		loader.registerItem(cookedHotdog = new BaseItemFood("cooked_hotdog", 5, .2f, false), cookedHotdog.getItemName());
		loader.registerItem(rockSoup = new RockSoup(), rockSoup.getItemName());
		loader.registerItem(baconRockSoup = new BaconRockSoup(), baconRockSoup.getItemName());
		loader.registerItem(staleCookie = new StaleCookie(), staleCookie.getItemName());
		loader.registerItem(rawchickenNugget = new BaseItemFood("raw_nugget", 1, .5f, false), rawchickenNugget.getItemName());
		loader.registerItem(cookedchickenNugget = new BaseItemFood("cooked_nugget", 3, .33f, false), cookedchickenNugget.getItemName());
		loader.registerItem(rawBacon = new BaseItemFood("raw_bacon", 1, 0.5f, false), rawBacon.getItemName());
		loader.registerItem(cookedBacon = new BaseItemFood("cooked_bacon", 4, .375f, false), cookedBacon.getItemName());
		loader.registerItem(rawDuck = new BaseItemFood("raw_duck", 8, .25f, false), rawDuck.getItemName());
		rawDuck.addLore("Totally not the same texture as turkey");
		loader.registerItem(cookedDuck = new BaseItemFood("cooked_duck", 8, .25f, false), cookedDuck.getItemName());
		cookedDuck.addLore("Totally not the same texture as turkey");

		loader.setCreativeTab(TurkeyUtil.walkingwoundedModTab);
		loader.registerItem(houndBiscuit = new BaseItemFood("Hound_Biscuit", 4, .25f, false), houndBiscuit.getItemName());
		houndBiscuit.addLore("Don't Worry, it's made for HumanEntities");
		loader.registerItem(dangerDog = new BaseItemFood("danger_dog", 8, .25f, false, 16), dangerDog.getItemName());
		dangerDog.addLore("It's wrapped in bacon! What more could you want!");
		dangerDog.addLore("AnneMunition, Member of The Walking Wounded");

		loader.setCreativeTab(TurkeyUtil.noodlecraftModTab);
		loader.registerItem(noodles = new BaseItemFood("noodles", 3, .33f, false), noodles.getItemName());
		loader.registerItem(juice = new Juice(), juice.getItemName());
		loader.registerItem(waffle = new BaseItemFood("waffle", 8, .25f, false), waffle.getItemName());
		waffle.addLore("\"Waffles\" - Mc_guitarist1795 2015");
		waffle.addLore("MC_GUITARIST1795, Member of NoodleCraft");
		loader.registerItem(bowlofNoodles = new BaseItemFood("noodle_bowl", 8, .1875f, false), bowlofNoodles.getItemName());
		bowlofNoodles.addLore("What else would you expect for NoodleCraft");
		loader.registerItem(genPie = new BaseItemFood("genpie", 8, .375f, false, 16), genPie.getItemName());
		genPie.addLore("For our wounderful Genipherpher");
		genPie.addLore("Genipherpher, Member of NoodleCraft");

		loader.setCreativeTab(TurkeyUtil.buildguildmodTab);
		loader.registerItem(doughnutbacon = new BaseItemFood("doughnut_bacon", 6, .167f, false), doughnutbacon.getItemName());
		doughnutbacon.addLore("Because BaconDonuts are too mainstream.");
		doughnutbacon.addLore("Bacon_Donut, Member of The Build Guild");
	}

	@Override
	public void registerModels(ItemLoader arg0)
	{

	}
}
