package com.turkey.turkeyUtil.hookins;

import net.minecraft.item.ItemStack;

import com.turkey.turkeyUtil.items.food.UtilFood;

import cpw.mods.fml.common.event.FMLInterModComms;

public class HungerOverhaulHook extends UtilHookin
{
	public void load()
	{
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.baconRockSoup));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.bowlofNoodles));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.cookedBacon));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.cookedchickenNugget));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.cookedHotdog));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.cookedTurkey));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.dangerDog));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.doughnutbacon));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.genPie));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.gummyWorms));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.houndBiscuit));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.juice));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.keyLimePie));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.lime));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.noodles));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.rawBacon));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.rawchickenNugget));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.rawHotdog));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.rawTurkey));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.rawWaffle));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.rockSoup));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.staleCookie));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.waffle));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.cookedDuck));
		FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", new ItemStack(UtilFood.rawDuck));
	}

	public static boolean isEnabled()
	{
		return isEnabled;
	}
}
