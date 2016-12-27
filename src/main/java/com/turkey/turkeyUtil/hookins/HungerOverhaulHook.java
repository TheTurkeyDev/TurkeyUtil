package com.turkey.turkeyUtil.hookins;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInterModComms;

import com.theprogrammingturkey.gobblecore.modhooks.BaseModHook;
import com.turkey.turkeyUtil.items.food.UtilFood;

public class HungerOverhaulHook extends BaseModHook
{
	public HungerOverhaulHook()
	{
		super("HungerOverhaul");
	}

	@Override
	public void initHook()
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
}
