package com.turkey.turkeyUtil.util;

import net.minecraft.init.Blocks;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import com.turkey.turkeyUtil.blocks.UtilBlocks;

public class UtilAchievements
{
	public static AchievementPage page;
	public static Achievement coalCompression;
	public static Achievement octupleCoal;
	public static Achievement mysticalOre;
	public static Achievement stiars;
	
	public static void loadAchievements()
	{
		coalCompression = new Achievement("turkeyutil.coalCompression", "turkeyutil.coalCompression", -2, -2, UtilBlocks.doublecompressedCoal, null).registerStat();
		octupleCoal = new Achievement("turkeyutil.OctupleCoal", "turkeyutil.OctupleCoal", -2, 0, UtilBlocks.octuplecompressedCoal, coalCompression).registerStat();
		mysticalOre = new Achievement("turkeyutil.mysticalOre", "turkeyutil.mysticalOre", 0, -2, UtilBlocks.mysticalOreBlock, null).registerStat();
		stiars = new Achievement("turkeyutil.stairs", "turkeyutil.stairs", 0, 0, Blocks.stone_stairs, null).registerStat();
		page = new AchievementPage("TurkeyUtil Achievements", coalCompression, octupleCoal, mysticalOre, stiars);
		AchievementPage.registerAchievementPage(page);
	}
}
