package com.turkey.turkeyUtil.armor;

import com.turkey.turkeyUtil.TurkeyUtil;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class UtilArmor
{
	public static ArmorMaterial superFabulousArmor;
	public static ArmorMaterial cobblestoneArmor;
	public static ArmorMaterial combinedArmor;
	public static ArmorMaterial miscArmor;
	public static ArmorMaterial turtleshell;
	
	public static Item superFabulousHelm;
	public static Item superFabulousChest;
	public static Item superFabulousPants;
	public static Item superFabulousBoots;
	
	public static Item cobbleHelm;
	public static Item cobbleChest;
	public static Item cobblePants;
	public static Item cobbleBoots;
	
	public static Item gasMask;
	public static Item woundedBand;
	public static Item pandaMask;
	public static Item turtleShell;
	public static Item j3dWig;
	
	public static void loadArmor()
	{
		superFabulousArmor = EnumHelper.addArmorMaterial("Super Fabulous", 30, new int[] {6, 10, 9, 6}, 16);
		cobblestoneArmor = EnumHelper.addArmorMaterial("Cobble Armor", 5, new int[] {1, 2, 2, 1}, 16);
		combinedArmor = EnumHelper.addArmorMaterial("Combined Armor", 0, new int[] {0, 0, 0, 0}, 1);
		miscArmor = EnumHelper.addArmorMaterial("Misc Armor Material", 0, new int[] {0, 0, 0, 0}, 1);
		turtleshell = EnumHelper.addArmorMaterial("Turtle Shell Armor Material", 35, new int[] {0, 4, 0, 0}, 1);
		
		superFabulousHelm = (new SuperFabulousItemArmor("Super_Fabulous_Helmet", superFabulousArmor, "Super_Fabulous_helmet", 0)).setTextureName("turkeyutil:Super_Fabulous_helmet");
		superFabulousChest = (new SuperFabulousItemArmor("Super_Fabulous_ChestPlate", superFabulousArmor, "Super_Fabulous_chestplate", 1)).setTextureName("turkeyutil:Super_Fabulous_chestplate");
		superFabulousPants = (new SuperFabulousItemArmor("Super_Fabulous_Leggings", superFabulousArmor, "Super_Fabulous_leggings", 2)).setTextureName("turkeyutil:Super_Fabulous_leggings");
		superFabulousBoots = (new SuperFabulousItemArmor("Super_Fabulous_Boots", superFabulousArmor, "Super_Fabulous_boots", 3)).setTextureName("turkeyutil:Super_Fabulous_boots");
		
		cobbleHelm = (new CobbleItemArmor("Cobblestone_Helmet", cobblestoneArmor, "Cobblestone_helmet", 0)).setTextureName("turkeyutil:Cobblestone_helmet");
		cobbleChest = (new CobbleItemArmor("Cobblestone_ChestPlate", cobblestoneArmor, "Cobblestone_chestplate", 1)).setTextureName("turkeyutil:Cobblestone_chestplate");
		cobblePants = (new CobbleItemArmor("Cobblestone_Leggings", cobblestoneArmor, "Cobblestone_leggings", 2)).setTextureName("turkeyutil:Cobblestone_leggings");
		cobbleBoots = (new CobbleItemArmor("Cobblestone_Boots", cobblestoneArmor, "Cobblestone_boots", 3)).setTextureName("turkeyutil:Cobblestone_boots");
		
		gasMask = (new MiscItemArmor("Gas_Mask", miscArmor, 0)).setTextureName("turkeyutil:Gas_Mask");
		woundedBand = (new MiscItemArmor("Walking_Wounded_Headband", miscArmor,0)).setTextureName("turkeyutil:Wounded_Headband").setCreativeTab(TurkeyUtil.walkingwoundedModTab);
		pandaMask = (new MiscItemArmor("pandaaburr's_Panda_Mask", miscArmor,0)).setTextureName("turkeyutil:Panda_Mask").setCreativeTab(TurkeyUtil.noodlecraftModTab);
		turtleShell = (new TurtleShellItemArmor("Thilia's_Turtle_Shell", miscArmor,1)).setTextureName("turkeyutil:turtle_Shell").setCreativeTab(TurkeyUtil.noodlecraftModTab);
		j3dWig = (new MiscItemArmor("J3D_Wig", miscArmor, 0)).setTextureName("turkeyutil:J3D_Wig").setCreativeTab(TurkeyUtil.noodlecraftModTab);
		
		GameRegistry.registerItem(superFabulousHelm, "Super_Fabulous_Helmet");
		GameRegistry.registerItem(superFabulousChest, "Super_Fabulous_ChestPlate");
		GameRegistry.registerItem(superFabulousPants, "Super_Fabulous_Leggings");
		GameRegistry.registerItem(superFabulousBoots, "Super_Fabulous_Boots");
		
		GameRegistry.registerItem(cobbleHelm, "Cobblestone_Helmet");
		GameRegistry.registerItem(cobbleChest, "Cobblestone_ChestPlate");
		GameRegistry.registerItem(cobblePants, "Cobblestone_Leggings");
		GameRegistry.registerItem(cobbleBoots, "Cobblestone_Boots");
		
		GameRegistry.registerItem(gasMask, "Gas_Mask");
		GameRegistry.registerItem(woundedBand, "Walking_Wounded_Headband");
		GameRegistry.registerItem(pandaMask, "pandaaburr's_Panda_Mask");
		GameRegistry.registerItem(turtleShell, "Thilia's_Turtle_Shell");
		GameRegistry.registerItem(j3dWig, "J3D_Wig");
	}
}
