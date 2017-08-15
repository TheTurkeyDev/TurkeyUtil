package com.turkey.turkeyUtil;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import com.theprogrammingturkey.gobblecore.IModCore;
import com.theprogrammingturkey.gobblecore.blocks.BlockManager;
import com.theprogrammingturkey.gobblecore.entity.EntityManager;
import com.theprogrammingturkey.gobblecore.events.EventManager;
import com.theprogrammingturkey.gobblecore.items.ItemManager;
import com.theprogrammingturkey.gobblecore.modhooks.ModHookManager;
import com.theprogrammingturkey.gobblecore.network.NetworkManager;
import com.turkey.turkeyUtil.armor.UtilArmor;
import com.turkey.turkeyUtil.blocks.UtilBlocks;
import com.turkey.turkeyUtil.events.CraftingEvent;
import com.turkey.turkeyUtil.events.FabulousToolCrafting;
import com.turkey.turkeyUtil.events.HammerEvent;
import com.turkey.turkeyUtil.events.InteractEvent;
import com.turkey.turkeyUtil.gui.UtilGuiHandler;
import com.turkey.turkeyUtil.hookins.ChanceCubesHook;
import com.turkey.turkeyUtil.hookins.ChiselModHook;
import com.turkey.turkeyUtil.hookins.HungerOverhaulHook;
import com.turkey.turkeyUtil.items.UtilItems;
import com.turkey.turkeyUtil.items.food.UtilFood;
import com.turkey.turkeyUtil.items.tools.UtilTools;
import com.turkey.turkeyUtil.mobs.UtilMobs;
import com.turkey.turkeyUtil.network.UtilPackets;
import com.turkey.turkeyUtil.proxy.CommonProxy;
import com.turkey.turkeyUtil.registries.LightRegistry;
import com.turkey.turkeyUtil.util.ConfigLoader;
import com.turkey.turkeyUtil.util.TurkeyUtilFuelHandler;
import com.turkey.turkeyUtil.util.UtilAchievements;
import com.turkey.turkeyUtil.util.UtilCrafting;
import com.turkey.turkeyUtil.util.WorldGen;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.RecipeSorter;

@Mod(modid = TurkeyUtil.MODID, name = TurkeyUtil.NAME, version = TurkeyUtil.VERSION, dependencies = "after:gobblecore")
public class TurkeyUtil implements IModCore
{
	public static final String MODID = "turkeyutil";
	public static final String NAME = "TurkeyUtil";
	public static final String VERSION = "TUR_VER_KEY";

	@SidedProxy(clientSide = "com.turkey.turkeyUtil.proxy.ClientProxy", serverSide = "com.turkey.turkeyUtil.proxy.CommonProxy")
	public static CommonProxy proxy;

	@Instance(value = MODID)
	public static TurkeyUtil instance;

	public static Logger logger;

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

	public TurkeyUtil()
	{
		ItemManager.registerItemHandler(new UtilItems(), this);
		ItemManager.registerItemHandler(new UtilFood(), this);

		BlockManager.registerBlockHandler(new UtilBlocks(), this);

		EntityManager.registerEntityHandler(new UtilMobs(), this);
		
		NetworkManager.registerNetworkHandler(new UtilPackets(), this);
	}

	@EventHandler
	public void load(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		ConfigLoader.loadConfigSettings(event.getSuggestedConfigurationFile());

		UtilArmor.loadArmor();
		UtilTools.loadTools();

		UtilAchievements.loadAchievements();
		LightRegistry.instance.loadDefaultFilters();

		GameRegistry.registerFuelHandler(new TurkeyUtilFuelHandler());

		NetworkRegistry.INSTANCE.registerGuiHandler(this, new UtilGuiHandler());
		proxy.registerGuis();
		proxy.registerRenderings();
		proxy.registerEvents();

		ModHookManager.loadModHook(new HungerOverhaulHook());

		RecipeSorter.register(TurkeyUtil.MODID + ":fabulous_tool_crafting", FabulousToolCrafting.class, RecipeSorter.Category.SHAPED, "after:minecraft:shaped");
		GameRegistry.addRecipe(new FabulousToolCrafting());

		EventManager.registerListener(new InteractEvent());
		EventManager.registerListener(new HammerEvent());
		EventManager.registerListener(new CraftingEvent());
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		GameRegistry.registerWorldGenerator(new WorldGen(), 0);
		OreDictionary.registerOre("listAllwater", UtilItems.infinityBucket_Water);
		OreDictionary.registerOre("listAlllava", UtilItems.infinityBucket_Lava);

		UtilCrafting.loadCraftingRecipies();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		ModHookManager.loadModHook(new ChiselModHook());
		if(ModHookManager.loadModHook(new ChanceCubesHook()))
			logger.log(Level.INFO, "Chance Cubes Detected.... applying (possibly deadly) hooks");
		else
			logger.log(Level.INFO, "Chance Cubes not Detected....... What kind of pack are you making without Chance Cubes?");
	}

	@Override
	public String getModID()
	{
		return MODID;
	}

	@Override
	public String getName()
	{
		return NAME;
	}

	@Override
	public String getVersion()
	{
		return VERSION;
	}
}