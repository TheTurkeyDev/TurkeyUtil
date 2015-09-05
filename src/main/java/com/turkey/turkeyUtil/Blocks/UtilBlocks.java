package com.turkey.turkeyUtil.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraftforge.oredict.OreDictionary;

import com.turkey.turkeyUtil.Items.ItemMonocolorBlock;
import com.turkey.turkeyUtil.Items.ItemMonocolorLightBlock;
import com.turkey.turkeyUtil.blocks.Agriculture.LimePlant;
import com.turkey.turkeyUtil.blocks.TileEntities.AdvancedHopperTileEntity;
import com.turkey.turkeyUtil.blocks.TileEntities.ArmorCombinerTileEntity;
import com.turkey.turkeyUtil.blocks.TileEntities.LightCollectorTileEntity;
import com.turkey.turkeyUtil.blocks.TileEntities.LightHealingTileEntity;
import com.turkey.turkeyUtil.util.HopperType;

import cpw.mods.fml.common.registry.GameRegistry;

public class UtilBlocks
{
	public static Block charcolBlock;
	public static Block flintBlock;
	public static Block fabulousBlock;
	public static Block mysticalOreBlock;
	public static Block deadpineLog;
	public static Block monoBlock;
	public static Block monoLightBlock;

	public static Block doublecompressedCoal;
	public static Block triplecompressedCoal;
	public static Block quadruplecompressedCoal;
	public static Block quintuplecompressedCoal;
	public static Block hextuplecompressedCoal;
	public static Block septuplecompressedCoal;
	public static Block octuplecompressedCoal;

	public static Block compressedObsidian;
	public static Block doublecompressedObsidian;
	public static Block triplecompressedObsidian;
	public static Block quadruplecompressedObsidian;
	public static Block quintuplecompressedObsidian;
	public static Block hextuplecompressedObsidian;
	public static Block septuplecompressedObsidian;
	public static Block octuplecompressedObsidian;

	public static Block limePlant;

	public static Block armorCombiner;
	public static Block lightCollector;
	public static Block lightHealer;

	public static AdvancedHopper[] advancedHoppers;

	public static void loadBlocks()
	{
		GameRegistry.registerBlock(charcolBlock = new CharcoalBlock().setBlockTextureName("turkeyutil:CharcoalBlock"), "Charcoal_Block");
		GameRegistry.registerBlock(flintBlock = new FlintBlock().setBlockTextureName("turkeyutil:FlintBlock"), "Flint_Block");
		GameRegistry.registerBlock(fabulousBlock = new FabulousBlock().setBlockTextureName("turkeyutil:fabulous_block"), "Fabulous_Diamond_Block");
		GameRegistry.registerBlock(mysticalOreBlock = new MysticalOreBlock().setBlockTextureName("turkeyutil:MysticalBlock"), "Mystical_Ore_Block");
		GameRegistry.registerBlock(deadpineLog = new DeadPineLogs(), "Deadpine_Log");
		GameRegistry.registerBlock(monoBlock = new MonocolorBlock(), ItemMonocolorBlock.class, "monocolored_Block");
		GameRegistry.registerBlock(monoLightBlock = new MonocolorLightBlock(), ItemMonocolorLightBlock.class, "monocolored_Light_Block");

		GameRegistry.registerBlock(doublecompressedCoal = new CompressedCoalBlock("Double").setBlockTextureName("turkeyutil:doubleCompressesdCoal"), "Double_Compressed_Coal_Block");
		GameRegistry.registerBlock(triplecompressedCoal = new CompressedCoalBlock("Triple").setBlockTextureName("turkeyutil:tripleCompressesdCoal"), "Triple_Compressed_Coal_Block");
		GameRegistry.registerBlock(quadruplecompressedCoal = new CompressedCoalBlock("Quadruple").setBlockTextureName("turkeyutil:quadCompressesdCoal"), "Quadruple_Compressed_Coal_Block");
		GameRegistry.registerBlock(quintuplecompressedCoal = new CompressedCoalBlock("Quintuple").setBlockTextureName("turkeyutil:quintCompressesdCoal"), "Quintuple_Compressed_Coal_Block");
		GameRegistry.registerBlock(hextuplecompressedCoal = new CompressedCoalBlock("Hextuple").setBlockTextureName("turkeyutil:hexCompressesdCoal"), "Hextuple_Compressed_Coal_Block");
		GameRegistry.registerBlock(septuplecompressedCoal = new CompressedCoalBlock("Septuple").setBlockTextureName("turkeyutil:septCompressesdCoal"), "Septuple_Compressed_Coal_Block");
		GameRegistry.registerBlock(octuplecompressedCoal = new CompressedCoalBlock("Octuple").setBlockTextureName("turkeyutil:octCompressesdCoal"), "Octuple_Compressed_Coal_Block");

		GameRegistry.registerBlock(compressedObsidian = new CompressedObsidianBlock("Single", 75).setBlockTextureName("turkeyutil:CompressesdObsidian"), "Compressed_Obsidian_Block");
		GameRegistry.registerBlock(doublecompressedObsidian = new CompressedObsidianBlock("Double", 75).setBlockTextureName("turkeyutil:doubleCompressesdObsidian"), "Double_Compressed_Obsidian_Block");
		GameRegistry.registerBlock(triplecompressedObsidian = new CompressedObsidianBlock("Triple", 75).setBlockTextureName("turkeyutil:tripleCompressesdObsidian"), "Triple_Compressed_Obsidian_Block");
		GameRegistry.registerBlock(quadruplecompressedObsidian = new CompressedObsidianBlock("Quadruple", 75).setBlockTextureName("turkeyutil:quadCompressesdObsidian"), "Quadruple_Compressed_Obsidian_Block");
		GameRegistry.registerBlock(quintuplecompressedObsidian = new CompressedObsidianBlock("Quintuple", 76).setBlockTextureName("turkeyutil:quintCompressesdObsidian"), "Quintuple_Compressed_Obsidian_Block");
		GameRegistry.registerBlock(hextuplecompressedObsidian = new CompressedObsidianBlock("Hextuple", 76).setBlockTextureName("turkeyutil:hexCompressesdObsidian"), "Hextuple_Compressed_Obsidian_Block");
		GameRegistry.registerBlock(septuplecompressedObsidian = new CompressedObsidianBlock("Septuple", 76).setBlockTextureName("turkeyutil:septCompressesdObsidian"), "Septuple_Compressed_Obsidian_Block");
		GameRegistry.registerBlock(octuplecompressedObsidian = new CompressedObsidianBlock("Octuple", 76).setBlockTextureName("turkeyutil:octCompressesdObsidian"), "Octuple_Compressed_Obsidian_Block");

		GameRegistry.registerBlock(limePlant = new LimePlant(), "Lime_Plant");

		GameRegistry.registerBlock(armorCombiner = new ArmorCombiner(), "Armor_Combiner");
		GameRegistry.registerTileEntity(ArmorCombinerTileEntity.class, armorCombiner.getUnlocalizedName());

		GameRegistry.registerBlock(lightCollector = new LightCollector(), "Light_Collector");
		GameRegistry.registerTileEntity(LightCollectorTileEntity.class, lightCollector.getUnlocalizedName());
		GameRegistry.registerBlock(lightHealer = new LightHealer(), "Light_Healer");
		GameRegistry.registerTileEntity(LightHealingTileEntity.class, lightHealer.getUnlocalizedName());

		OreDictionary.registerOre("oreMystical", mysticalOreBlock);
		OreDictionary.registerOre("treeWood", deadpineLog);

		List<HopperType> hopperTypes = HopperType.getHopperTypes();
		advancedHoppers = new AdvancedHopper[hopperTypes.size()];
		for(int i = 0; i < hopperTypes.size(); i++)
		{
			advancedHoppers[i] = new AdvancedHopper(hopperTypes.get(i).getName(), hopperTypes.get(i).getBlock());
			GameRegistry.registerBlock(advancedHoppers[i], hopperTypes.get(i).getName());
			GameRegistry.registerTileEntity(AdvancedHopperTileEntity.class, hopperTypes.get(i).getName());
		}
	}
}
