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
	
	public static AdvancedHopper[] advancedHoppers;
	
	public static void loadBlocks()
	{
		charcolBlock = new CharcoalBlock().setBlockTextureName("turkeyutil:CharcoalBlock");
		flintBlock = new FlintBlock().setBlockTextureName("turkeyutil:FlintBlock");
		fabulousBlock = new FabulousBlock().setBlockTextureName("turkeyutil:fabulous_block");
		mysticalOreBlock = new MysticalOreBlock().setBlockTextureName("turkeyutil:MysticalBlock");
		deadpineLog = new DeadPineLogs();
		monoBlock = new MonocolorBlock();
		monoLightBlock = new MonocolorLightBlock();
		
		doublecompressedCoal = new CompressedCoalBlock("Double").setBlockTextureName("turkeyutil:doubleCompressesdCoal");
		triplecompressedCoal = new CompressedCoalBlock("Triple").setBlockTextureName("turkeyutil:tripleCompressesdCoal");
		quadruplecompressedCoal = new CompressedCoalBlock("Quadruple").setBlockTextureName("turkeyutil:quadCompressesdCoal");
		quintuplecompressedCoal = new CompressedCoalBlock("Quintuple").setBlockTextureName("turkeyutil:quintCompressesdCoal");
		hextuplecompressedCoal = new CompressedCoalBlock("Hextuple").setBlockTextureName("turkeyutil:hexCompressesdCoal");
		septuplecompressedCoal = new CompressedCoalBlock("Septuple").setBlockTextureName("turkeyutil:septCompressesdCoal");
		octuplecompressedCoal = new CompressedCoalBlock("Octuple").setBlockTextureName("turkeyutil:octCompressesdCoal");
		
		compressedObsidian = new CompressedObsidianBlock("Single", 75).setBlockTextureName("turkeyutil:CompressesdObsidian");
		doublecompressedObsidian = new CompressedObsidianBlock("Double", 75).setBlockTextureName("turkeyutil:doubleCompressesdObsidian");
		triplecompressedObsidian = new CompressedObsidianBlock("Triple", 75).setBlockTextureName("turkeyutil:tripleCompressesdObsidian");
		quadruplecompressedObsidian = new CompressedObsidianBlock("Quadruple", 75).setBlockTextureName("turkeyutil:quadCompressesdObsidian");
		quintuplecompressedObsidian = new CompressedObsidianBlock("Quintuple", 76).setBlockTextureName("turkeyutil:quintCompressesdObsidian");
		hextuplecompressedObsidian = new CompressedObsidianBlock("Hextuple", 76).setBlockTextureName("turkeyutil:hexCompressesdObsidian");
		septuplecompressedObsidian = new CompressedObsidianBlock("Septuple", 76).setBlockTextureName("turkeyutil:septCompressesdObsidian");
		octuplecompressedObsidian = new CompressedObsidianBlock("Octuple", 76).setBlockTextureName("turkeyutil:octCompressesdObsidian");
		
		limePlant = new LimePlant();
		
		armorCombiner = new ArmorCombiner();
		lightCollector = new LightCollector();
		
		GameRegistry.registerBlock(charcolBlock, "Charcoal_Block");
		GameRegistry.registerBlock(flintBlock, "Flint_Block");
		GameRegistry.registerBlock(fabulousBlock, "Fabulous_Diamond_Block");
		GameRegistry.registerBlock(mysticalOreBlock, "Mystical_Ore_Block");
		GameRegistry.registerBlock(deadpineLog, "Deadpine_Log");
		GameRegistry.registerBlock(monoBlock, ItemMonocolorBlock.class, "monocolored_Block");
		GameRegistry.registerBlock(monoLightBlock, ItemMonocolorLightBlock.class, "monocolored_Light_Block");
		
		GameRegistry.registerBlock(doublecompressedCoal, "Double_Compressed_Coal_Block");
		GameRegistry.registerBlock(triplecompressedCoal,  "Triple_Compressed_Coal_Block");
		GameRegistry.registerBlock(quadruplecompressedCoal, "Quadruple_Compressed_Coal_Block");
		GameRegistry.registerBlock(quintuplecompressedCoal, "Quintuple_Compressed_Coal_Block");
		GameRegistry.registerBlock(hextuplecompressedCoal, "Hextuple_Compressed_Coal_Block");
		GameRegistry.registerBlock(septuplecompressedCoal, "Septuple_Compressed_Coal_Block");
		GameRegistry.registerBlock(octuplecompressedCoal, "Octuple_Compressed_Coal_Block");
		
		GameRegistry.registerBlock(compressedObsidian, "Compressed_Obsidian_Block");
		GameRegistry.registerBlock(doublecompressedObsidian, "Double_Compressed_Obsidian_Block");
		GameRegistry.registerBlock(triplecompressedObsidian, "Triple_Compressed_Obsidian_Block");
		GameRegistry.registerBlock(quadruplecompressedObsidian, "Quadruple_Compressed_Obsidian_Block");
		GameRegistry.registerBlock(quintuplecompressedObsidian, "Quintuple_Compressed_Obsidian_Block");
		GameRegistry.registerBlock(hextuplecompressedObsidian, "Hextuple_Compressed_Obsidian_Block");
		GameRegistry.registerBlock(septuplecompressedObsidian, "Septuple_Compressed_Obsidian_Block");
		GameRegistry.registerBlock(octuplecompressedObsidian, "Octuple_Compressed_Obsidian_Block");
		
		GameRegistry.registerBlock(limePlant, "Lime_Plant");
		
		GameRegistry.registerBlock(armorCombiner, "Armor_Combiner");
		GameRegistry.registerTileEntity(ArmorCombinerTileEntity.class, armorCombiner.getUnlocalizedName());
		
		GameRegistry.registerBlock(lightCollector, "Light_Collector");
		GameRegistry.registerTileEntity(LightCollectorTileEntity.class, lightCollector.getUnlocalizedName());
		
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
