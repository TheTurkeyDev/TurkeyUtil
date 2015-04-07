package com.turkey.turkeyUtil.Blocks;

import net.minecraft.block.Block;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

import com.turkey.turkeyUtil.Blocks.Agriculture.LimePlant;
import com.turkey.turkeyUtil.Blocks.TileEntities.ArmorCombinerTileEntity;

public class UtilBlocks
{	
	public static Block charcolBlock;
	public static Block flintBlock;
	public static Block fabulousBlock;
	public static Block mysticalOreBlock;
	public static Block deadpineLog;
	
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
	
	public static void loadBlocks()
	{
		charcolBlock = new CharcoalBlock().setBlockTextureName("turkeyutil:CharcoalBlock");
		flintBlock = new FlintBlock().setBlockTextureName("turkeyutil:FlintBlock");
		fabulousBlock = new FabulousBlock().setBlockTextureName("turkeyutil:fabulous_block");
		mysticalOreBlock = new MysticalOreBlock().setBlockTextureName("turkeyutil:MysticalBlock");
		deadpineLog = new DeadPineLogs();
		
		doublecompressedCoal = new CompressedCoalBlockDouble().setBlockTextureName("turkeyutil:doubleCompressesdCoal");
		triplecompressedCoal = new CompressedCoalBlockTriple().setBlockTextureName("turkeyutil:tripleCompressesdCoal");
		quadruplecompressedCoal = new CompressedCoalBlockQuadruple().setBlockTextureName("turkeyutil:quadCompressesdCoal");
		quintuplecompressedCoal = new CompressedCoalBlockQuintuple().setBlockTextureName("turkeyutil:quintCompressesdCoal");
		hextuplecompressedCoal = new CompressedCoalBlockHextuple().setBlockTextureName("turkeyutil:hexCompressesdCoal");
		septuplecompressedCoal = new CompressedCoalBlockSeptuple().setBlockTextureName("turkeyutil:septCompressesdCoal");
		octuplecompressedCoal = new CompressedCoalBlockOctuple().setBlockTextureName("turkeyutil:octCompressesdCoal");
		
		compressedObsidian = new CompressedObsidianBlock().setBlockTextureName("turkeyutil:CompressesdObsidian");
		doublecompressedObsidian = new CompressedObsidianBlockDouble().setBlockTextureName("turkeyutil:doubleCompressesdObsidian");
		triplecompressedObsidian = new CompressedObsidianBlockTriple().setBlockTextureName("turkeyutil:tripleCompressesdObsidian");
		quadruplecompressedObsidian = new CompressedObsidianBlockQuadruple().setBlockTextureName("turkeyutil:quadCompressesdObsidian");
		quintuplecompressedObsidian = new CompressedObsidianBlockQuintuple().setBlockTextureName("turkeyutil:quintCompressesdObsidian");
		hextuplecompressedObsidian = new CompressedObsidianBlockHextuple().setBlockTextureName("turkeyutil:hexCompressesdObsidian");
		septuplecompressedObsidian = new CompressedObsidianBlockSeptuple().setBlockTextureName("turkeyutil:septCompressesdObsidian");
		octuplecompressedObsidian = new CompressedObsidianBlockOctuple().setBlockTextureName("turkeyutil:octCompressesdObsidian");
		
		limePlant = new LimePlant();
		
		armorCombiner = new ArmorCombiner();
		
		GameRegistry.registerBlock(charcolBlock, "Charcoal_Block");
		GameRegistry.registerBlock(flintBlock, "Flint_Block");
		GameRegistry.registerBlock(fabulousBlock, "Fabulous_Diamond_Block");
		GameRegistry.registerBlock(mysticalOreBlock, "Mystical_Ore_Block");
		GameRegistry.registerBlock(deadpineLog, "Deadpine_Log");
		
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
		
		OreDictionary.registerOre("oreMystical", mysticalOreBlock);
		OreDictionary.registerOre("treeWood", deadpineLog);
	}
}
