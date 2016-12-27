package com.turkey.turkeyUtil.items.food;

import com.theprogrammingturkey.gobblecore.items.BaseFoodItem;
import com.theprogrammingturkey.gobblecore.items.IItemHandler;
import com.theprogrammingturkey.gobblecore.items.ItemLoader;
import com.turkey.turkeyUtil.TurkeyUtil;

public class UtilFood implements IItemHandler
{
	public static BaseFoodItem houndBiscuit;
	public static BaseFoodItem waffle;
	public static BaseFoodItem rawWaffle;
	public static BaseFoodItem bowlofNoodles;
	public static BaseFoodItem lime;
	public static BaseFoodItem noodles;
	public static BaseFoodItem juice;
	public static BaseFoodItem gummyWorms;
	public static BaseFoodItem keyLimePie;
	public static BaseFoodItem rawTurkey;
	public static BaseFoodItem cookedTurkey;
	public static BaseFoodItem dangerDog;
	public static BaseFoodItem rawBacon;
	public static BaseFoodItem cookedBacon;
	public static BaseFoodItem rawHotdog;
	public static BaseFoodItem cookedHotdog;
	public static BaseFoodItem doughnutbacon;
	public static BaseFoodItem rockSoup;
	public static BaseFoodItem baconRockSoup;
	public static BaseFoodItem staleCookie;
	public static BaseFoodItem genPie;
	public static BaseFoodItem rawchickenNugget;
	public static BaseFoodItem cookedchickenNugget;
	public static BaseFoodItem rawDuck;
	public static BaseFoodItem cookedDuck;

	@Override
	public void registerItems(ItemLoader loader)
	{

		loader.setCreativeTab(TurkeyUtil.baseModTab);
		loader.registerItem(lime = new BaseFoodItem(1, 0.2f, "lime"));
		lime.addLore("What? Is that not how it works?");
		loader.registerItem(gummyWorms = new BaseFoodItem(5, .2f, "gummy_worms"));
		loader.registerItem(keyLimePie = new BaseFoodItem(8, .25f, "key_lime_pie", 16));
		loader.registerItem(rawWaffle = new BaseFoodItem(1, 0.5f, "raw_waffle"));
		rawWaffle.addLore("Ewwwwwww");
		loader.registerItem(rawTurkey = new BaseFoodItem(1, 1f, "raw_turkey"));
		loader.registerItem(cookedTurkey = new BaseFoodItem(8, .375f, "cooked_turkey"));
		loader.registerItem(rawHotdog = new BaseFoodItem(1, 0.5f, "raw_hotdog"));
		loader.registerItem(cookedHotdog = new BaseFoodItem(5, .2f, "cooked_hotdog"));
		loader.registerItem(rockSoup = new RockSoup());
		loader.registerItem(baconRockSoup = new BaconRockSoup());
		loader.registerItem(staleCookie = new StaleCookie());
		loader.registerItem(rawchickenNugget = new BaseFoodItem(1, .5f, "raw_nugget"));
		loader.registerItem(cookedchickenNugget = new BaseFoodItem(3, .33f, "cooked_nugget"));
		loader.registerItem(rawBacon = new BaseFoodItem(1, 0.5f, "raw_bacon"));
		loader.registerItem(cookedBacon = new BaseFoodItem(4, .375f, "cooked_bacon"));
		loader.registerItem(rawDuck = new BaseFoodItem(8, .25f, "raw_duck"));
		rawDuck.addLore("Totally not the same texture as turkey");
		loader.registerItem(cookedDuck = new BaseFoodItem(8, .25f, "cooked_duck"));
		cookedDuck.addLore("Totally not the same texture as turkey");

		loader.setCreativeTab(TurkeyUtil.walkingwoundedModTab);
		loader.registerItem(houndBiscuit = new BaseFoodItem(4, .25f, "Hound_Biscuit"));
		houndBiscuit.addLore("Don't Worry, it's made for HumanEntities");
		loader.registerItem(dangerDog = new BaseFoodItem(8, .25f, "danger_dog", 16));
		dangerDog.addLore("It's wrapped in bacon! What more could you want!");
		dangerDog.addLore("AnneMunition, Member of The Walking Wounded");

		loader.setCreativeTab(TurkeyUtil.noodlecraftModTab);
		loader.registerItem(noodles = new BaseFoodItem(3, .33f, "noodles"));
		loader.registerItem(juice = new Juice());
		loader.registerItem(waffle = new BaseFoodItem(8, .25f, "waffle"));
		waffle.addLore("\"Waffles\" - Mc_guitarist1795 2015");
		waffle.addLore("MC_GUITARIST1795, Member of NoodleCraft");
		loader.registerItem(bowlofNoodles = new BaseFoodItem(8, .1875f, "noodle_bowl"));
		bowlofNoodles.addLore("What else would you expect for NoodleCraft");
		loader.registerItem(genPie = new BaseFoodItem(8, .375f, "genpie", 16));
		genPie.addLore("For our wounderful Genipherpher");
		genPie.addLore("Genipherpher, Member of NoodleCraft");

		loader.setCreativeTab(TurkeyUtil.buildguildmodTab);
		loader.registerItem(doughnutbacon = new BaseFoodItem(6, .167f, "doughnut_bacon"));
		doughnutbacon.addLore("Because BaconDonuts are too mainstream.");
		doughnutbacon.addLore("Bacon_Donut, Member of The Build Guild");
	}

	@Override
	public void registerModels(ItemLoader arg0)
	{

	}
}
