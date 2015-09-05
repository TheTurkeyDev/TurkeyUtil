package com.turkey.turkeyUtil;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.RecipeSorter;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import com.turkey.turkeyUtil.Items.UtilItems;
import com.turkey.turkeyUtil.Items.food.UtilFood;
import com.turkey.turkeyUtil.Items.tools.UtilTools;
import com.turkey.turkeyUtil.armor.UtilArmor;
import com.turkey.turkeyUtil.blocks.UtilBlocks;
import com.turkey.turkeyUtil.events.FabulousToolCrafting;
import com.turkey.turkeyUtil.events.InteractEvent;
import com.turkey.turkeyUtil.events.UpdateNotificationHandler;
import com.turkey.turkeyUtil.gui.UtilGuiHandler;
import com.turkey.turkeyUtil.hookins.ChanceCubesHook;
import com.turkey.turkeyUtil.hookins.ChiselModHook;
import com.turkey.turkeyUtil.hookins.HungerOverhaulHook;
import com.turkey.turkeyUtil.mobs.UtilMobs;
import com.turkey.turkeyUtil.network.UtilPacket;
import com.turkey.turkeyUtil.proxy.CommonProxy;
import com.turkey.turkeyUtil.registries.LightRegistry;
import com.turkey.turkeyUtil.util.ConfigLoader;
import com.turkey.turkeyUtil.util.TurkeyUtilFuelHandler;
import com.turkey.turkeyUtil.util.UtilAchievements;
import com.turkey.turkeyUtil.util.UtilCrafting;
import com.turkey.turkeyUtil.util.WorldGen;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = TurkeyUtil.MODID, version = TurkeyUtil.VERSION)
public class TurkeyUtil
{
	public static final String MODID = "TurkeyUtil";
	public static final String VERSION = "TUR_VER_KEY";

	@SidedProxy(clientSide = "com.turkey.turkeyUtil.proxy.ClientProxy", serverSide = "com.turkey.turkeyUtil.proxy.CommonProxy")
	public static CommonProxy proxy;

	@Instance(value = MODID)
	public static TurkeyUtil instance;

	public static Logger logger;

	public SimpleNetworkWrapper network;

	public static CreativeTabs baseModTab = new CreativeTabs(MODID)
	{
		public Item getTabIconItem()
		{
			return UtilItems.turkeyFeather;
		}
	};

	public static CreativeTabs noodlecraftModTab = new CreativeTabs(MODID + "_NoodleCraft")
	{
		public Item getTabIconItem()
		{
			return UtilFood.bowlofNoodles;
		}
	};

	public static CreativeTabs walkingwoundedModTab = new CreativeTabs(MODID + "_WalkingWounded")
	{
		public Item getTabIconItem()
		{
			return UtilArmor.woundedBand;
		}
	};

	public static CreativeTabs buildguildmodTab = new CreativeTabs(MODID + "_BuildGuild")
	{
		public Item getTabIconItem()
		{
			return UtilTools.bgShield;
		}
	};

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		GameRegistry.registerWorldGenerator(new WorldGen(), 0);
	}

	@EventHandler
	public void load(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		ConfigLoader.loadConfigSettings(event.getSuggestedConfigurationFile());
		
		UtilBlocks.loadBlocks();
		UtilItems.loadItems();
		UtilFood.loadFood();
		UtilArmor.loadArmor();
		UtilTools.loadTools();
		UtilCrafting.loadCraftingRecipies();
		UtilMobs.loadMobs();
		UtilAchievements.loadAchievements();
		LightRegistry.instance.loadDefaultFilters();
		
		GameRegistry.registerFuelHandler(new TurkeyUtilFuelHandler());
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new UtilGuiHandler());
		proxy.registerGuis();
		proxy.registerRenderings();
		proxy.registerEvents();
		
		this.network = NetworkRegistry.INSTANCE.newSimpleChannel("TurkeyUtil");
		this.network.registerMessage(UtilPacket.HandlerServer.class, UtilPacket.class, 0, Side.SERVER);
		this.network.registerMessage(UtilPacket.HandlerClient.class, UtilPacket.class, 1, Side.CLIENT);

		if(Loader.isModLoaded("HungerOverhaul"))
		{
			logger.log(Level.INFO, "HungerOverhaul Detected.... applying hooks");
			new HungerOverhaulHook();
		}
		else
			logger.log(Level.INFO, "HungerOverhaul not Detected, there for not adding hooks");
		
		RecipeSorter.register(TurkeyUtil.MODID + ":fabulous_tool_crafting", FabulousToolCrafting.class, RecipeSorter.Category.SHAPED, "after:minecraft:shaped");
		GameRegistry.addRecipe(new FabulousToolCrafting());

		MinecraftForge.EVENT_BUS.register(new InteractEvent());
		FMLCommonHandler.instance().bus().register(new UpdateNotificationHandler());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		if(Loader.isModLoaded("chisel"))
		{
			logger.log(Level.INFO, "Chisel 2 Detected.... applying hooks");
			new ChiselModHook();
		}
		else
			logger.log(Level.INFO, "Chisel 2 not Detected, there for not adding hooks");

		if(Loader.isModLoaded("chancecubes"))
		{
			logger.log(Level.INFO, "Chance Cubes Detected.... applying (possibly deadly) hooks");
			new ChanceCubesHook();
		}
		else
			logger.log(Level.INFO, "Chance Cubes not Detected....... What kind of pack are you making without Chance Cubes?");
	}
}