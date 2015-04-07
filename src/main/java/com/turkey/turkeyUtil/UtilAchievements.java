package com.turkey.turkeyUtil;

import com.turkey.turkeyUtil.Blocks.UtilBlocks;

import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

public class UtilAchievements
{
	public static AchievementPage page;
	public static Achievement coalCompression;
	public static Achievement octupleCoal;
	public static Achievement mysticalOre;
	
	public static void loadAchievements()
	{
		coalCompression = new Achievement("turkeyutil.coalCompression", "turkeyutil.coalCompression", -2, -2, UtilBlocks.doublecompressedCoal, AchievementList.buildPickaxe).registerStat();
		octupleCoal = new Achievement("turkeyutil.OctupleCoal", "turkeyutil.OctupleCoal", -2, 0, UtilBlocks.octuplecompressedCoal, coalCompression).registerStat();
		mysticalOre = new Achievement("turkeyutil.mysticalOre", "turkeyutil.mysticalOre", 0, -2, UtilBlocks.mysticalOreBlock, AchievementList.buildPickaxe).registerStat();
		page = new AchievementPage("TurkeyUtil Achievements", coalCompression, octupleCoal, mysticalOre);
		AchievementPage.registerAchievementPage(page);
	}
}
