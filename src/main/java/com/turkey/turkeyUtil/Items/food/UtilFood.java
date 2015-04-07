package com.turkey.turkeyUtil.Items.food;

import cpw.mods.fml.common.registry.GameRegistry;


public class UtilFood
{
	public static TurkeyItemFood houndBiscuit;
	public static TurkeyItemFood waffle;
	public static TurkeyItemFood rawWaffle;
	public static TurkeyItemFood bowlofNoodles;
	public static TurkeyItemFood lime;
	public static TurkeyItemFood noodles;
	public static TurkeyItemFood juice;
	public static TurkeyItemFood gummyWorms;
	public static TurkeyItemFood keyLimePie;
	public static TurkeyItemFood rawTurkey;
	public static TurkeyItemFood cookedTurkey;
	public static TurkeyItemFood dangerDog;
	public static TurkeyItemFood rawBacon;
	public static TurkeyItemFood cookedBacon;
	public static TurkeyItemFood rawHotdog;
	public static TurkeyItemFood cookedHotdog;
	public static TurkeyItemFood doughnutbacon;
	public static TurkeyItemFood rockSoup;
	public static TurkeyItemFood baconRockSoup;
	public static TurkeyItemFood staleCookie;
	public static TurkeyItemFood genPie;
	public static TurkeyItemFood rawchickenNugget;
	public static TurkeyItemFood cookedchickenNugget;
	public static TurkeyItemFood rawDuck;
	public static TurkeyItemFood cookedDuck;
	
	public static void loadFood()
	{
		rawchickenNugget = new RawChickenNugget();
		cookedchickenNugget = new CookedChickenNugget();
		
		waffle = new Waffle();
		rawWaffle = new RawWaffle();
		
		rawTurkey = new RawTurkeyItem();
		cookedTurkey = new CookedTurkeyItem();
		
		rawDuck = new RawDuck();
		cookedDuck = new CookedDuck();
		
		rawBacon = new RawBacon();
		cookedBacon = new CookedBacon();
		
		rawHotdog = new RawHotdog();
		cookedHotdog = new CookedHotdog();
		
		rockSoup = new RockSoup();
		baconRockSoup = new BaconRockSoup();
		
		noodles = new Noodles();
		bowlofNoodles = new BowlofNoodles();
		
		lime = new Lime();
		juice = new Juice();
		keyLimePie = new KeyLimePie();
		
		houndBiscuit = new HoundBiscuits();
		dangerDog = new DangerDog();
		
		gummyWorms = new GummyWorms();
		doughnutbacon = new DoughnutBacon();
		staleCookie = new StaleCookie();
		genPie = new Genpie();
		
		GameRegistry.registerItem(lime, "Lime");
		GameRegistry.registerItem(noodles, "Noodles");
		GameRegistry.registerItem(juice, "Juice");
		GameRegistry.registerItem(gummyWorms, "Gummy_Worms");
		GameRegistry.registerItem(keyLimePie, "Key_Lime_Pie");
		GameRegistry.registerItem(houndBiscuit, "Hound_Biscuit");
		GameRegistry.registerItem(waffle, "Waffle");
		GameRegistry.registerItem(rawWaffle, "Raw_Waffle");
		GameRegistry.registerItem(bowlofNoodles, "Bowl_of_Noodles");
		GameRegistry.registerItem(rawTurkey, "Raw_Turkey");
		GameRegistry.registerItem(cookedTurkey, "Cooked_Turkey");
		GameRegistry.registerItem(dangerDog, "Danger_Dog");
		GameRegistry.registerItem(rawHotdog, "Raw_Hotdog");
		GameRegistry.registerItem(cookedHotdog, "Cooked_Hotdog");
		GameRegistry.registerItem(doughnutbacon, "Doughnut_Bacon");
		GameRegistry.registerItem(rockSoup, "Rock_Soup");
		GameRegistry.registerItem(baconRockSoup, "Bacon_Rock_Soup");
		GameRegistry.registerItem(staleCookie, "Stale_Cookie");
		GameRegistry.registerItem(genPie, "Genpie");
		GameRegistry.registerItem(rawchickenNugget, "Raw_Chicken_Nugget");
		GameRegistry.registerItem(cookedchickenNugget, "Cooked_Chicken_Nugget");
		GameRegistry.registerItem(rawBacon, "Raw_Bacon");
		GameRegistry.registerItem(cookedBacon, "Cooked_Bacon");
		GameRegistry.registerItem(rawDuck, "Raw_Duck");
		GameRegistry.registerItem(cookedDuck, "Cooked_Duck");
	}
}
