package com.turkey.turkeyUtil.blocks;

import java.util.List;

import com.theprogrammingturkey.gobblecore.blocks.BaseBlock;
import com.theprogrammingturkey.gobblecore.blocks.BaseBlockContainer;
import com.theprogrammingturkey.gobblecore.blocks.BlockLoader;
import com.theprogrammingturkey.gobblecore.blocks.IBlockHandler;
import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.blocks.Agriculture.LimePlant;
import com.turkey.turkeyUtil.blocks.TileEntities.AdvancedHopperTileEntity;
import com.turkey.turkeyUtil.blocks.TileEntities.ArmorCombinerTileEntity;
import com.turkey.turkeyUtil.blocks.TileEntities.LightCollectorTileEntity;
import com.turkey.turkeyUtil.blocks.TileEntities.LightHealingTileEntity;
import com.turkey.turkeyUtil.util.HopperType;

import net.minecraft.block.Block;
import net.minecraftforge.oredict.OreDictionary;

public class UtilBlocks implements IBlockHandler
{
	public static BaseBlock charcolBlock;
	public static BaseBlock flintBlock;
	public static BaseBlock fabulousBlock;
	public static BaseBlock mysticalOreBlock;
	public static Block deadpineLog;
	public static Block monoBlock;
	public static Block monoLightBlock;

	public static BaseBlock doublecompressedCoal;
	public static BaseBlock triplecompressedCoal;
	public static BaseBlock quadruplecompressedCoal;
	public static BaseBlock quintuplecompressedCoal;
	public static BaseBlock hextuplecompressedCoal;
	public static BaseBlock septuplecompressedCoal;
	public static BaseBlock octuplecompressedCoal;

	public static BaseBlock compressedObsidian;
	public static BaseBlock doublecompressedObsidian;
	public static BaseBlock triplecompressedObsidian;
	public static BaseBlock quadruplecompressedObsidian;
	public static BaseBlock quintuplecompressedObsidian;
	public static BaseBlock hextuplecompressedObsidian;
	public static BaseBlock septuplecompressedObsidian;
	public static BaseBlock octuplecompressedObsidian;

	public static Block limePlant;

	public static BaseBlockContainer armorCombiner;
	public static BaseBlockContainer lightCollector;
	public static BaseBlockContainer lightHealer;

	public static AdvancedHopper[] advancedHoppers;

	@Override
	public void registerBlocks(BlockLoader loader)
	{	
		loader.setCreativeTab(TurkeyUtil.baseModTab);
		loader.registerBlock(charcolBlock = new BaseBlock("charcoal_block", 5f));
		loader.registerBlock(flintBlock = new BaseBlock("flint_block", 5f));
		loader.registerBlock(fabulousBlock = new BaseBlock("fabulous_diamond_block", 5f));
		fabulousBlock.setUseableBeaconBase(true);
		loader.registerBlock(mysticalOreBlock = new MysticalOreBlock());
		loader.registerBlock(deadpineLog = new DeadPineLog(), "deadpine_log");
		loader.registerBlock(monoBlock = new MonocolorBlock(), "monocolored_block");
		loader.registerBlock(monoLightBlock = new MonocolorLightBlock(), "monocolored_block");

		loader.registerBlock(doublecompressedCoal = new BaseBlock("double_compressed_coal_block", 6f));
		loader.registerBlock(triplecompressedCoal = new BaseBlock("triple_compressed_coal_block", 6f));
		loader.registerBlock(quadruplecompressedCoal = new BaseBlock("quadruple_compressed_coal_block", 6f));
		loader.registerBlock(quintuplecompressedCoal = new BaseBlock("quintuple_compressed_coal_block", 6f));
		loader.registerBlock(hextuplecompressedCoal = new BaseBlock("hextuple_compressed_coal_block", 6f));
		loader.registerBlock(septuplecompressedCoal = new BaseBlock("septuple_compressed_coal_block", 6f));
		loader.registerBlock(octuplecompressedCoal = new BaseBlock("octuple_compressed_coal_block", 6f));
		
		loader.registerBlock(compressedObsidian = new BaseBlock("compressed_obsidian_block", 75f));
		loader.registerBlock(doublecompressedObsidian = new BaseBlock("double_compressed_obsidian_block", 75f));
		loader.registerBlock(triplecompressedObsidian = new BaseBlock("triple_compressed_obsidian_block", 75f));
		loader.registerBlock(quadruplecompressedObsidian = new BaseBlock("quadruple_compressed_obsidian_block", 75f));
		loader.registerBlock(quintuplecompressedObsidian = new BaseBlock("quintuple_compressed_obsidian_block", 76f));
		quintuplecompressedObsidian.setWitherProof(true);
		loader.registerBlock(hextuplecompressedObsidian = new BaseBlock("hextuple_compressed_obsidian_block", 76f));
		hextuplecompressedObsidian.setWitherProof(true);
		loader.registerBlock(hextuplecompressedObsidian = new BaseBlock("septuple_compressed_obsidian_block", 76f));
		hextuplecompressedObsidian.setWitherProof(true);
		loader.registerBlock(octuplecompressedObsidian = new BaseBlock("octuple_compressed_obsidian_block", 76f));
		octuplecompressedObsidian.setWitherProof(true);

		loader.registerBlock(limePlant = new LimePlant(), "lime_plant");

		
		loader.registerBlock(armorCombiner = new ArmorCombiner(), ArmorCombinerTileEntity.class);
		loader.registerBlock(lightCollector = new LightCollector(), LightCollectorTileEntity.class);
		loader.registerBlock(lightHealer = new LightHealer(), LightHealingTileEntity.class);

		OreDictionary.registerOre("oreMystical", mysticalOreBlock);
		OreDictionary.registerOre("treeWood", deadpineLog);

		List<HopperType> hopperTypes = HopperType.getHopperTypes();
		advancedHoppers = new AdvancedHopper[hopperTypes.size()];
		for(int i = 0; i < hopperTypes.size(); i++)
		{
			advancedHoppers[i] = new AdvancedHopper(hopperTypes.get(i).getName(), hopperTypes.get(i).getBlock());
			loader.registerBlock(advancedHoppers[i], AdvancedHopperTileEntity.class, hopperTypes.get(i).getName());
		}
	}

	@Override
	public void registerModels(BlockLoader loader)
	{
		
	}
}
