package com.turkey.turkeyUtil;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import com.turkey.turkeyUtil.Armor.UtilArmor;
import com.turkey.turkeyUtil.Blocks.UtilBlocks;
import com.turkey.turkeyUtil.Events.InteractEvent;
import com.turkey.turkeyUtil.Hookins.ChiselModHook;
import com.turkey.turkeyUtil.Hookins.HungerOverhaulHook;
import com.turkey.turkeyUtil.Items.UtilItems;
import com.turkey.turkeyUtil.Items.food.UtilFood;
import com.turkey.turkeyUtil.Mobs.UtilMobs;
import com.turkey.turkeyUtil.gui.UtilGuiHandler;
import com.turkey.turkeyUtil.network.UtilPacket;
import com.turkey.turkeyUtil.proxy.CommonProxy;

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

	public static CreativeTabs modTab = new CreativeTabs(MODID) {
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(UtilBlocks.charcolBlock);
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
		UtilCrafting.loadCraftingRecipies();
		UtilMobs.loadMobs();
		GameRegistry.registerFuelHandler(new TurkeyUtilFuelHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new UtilGuiHandler());
		UtilAchievements.loadAchievements();
		proxy.registerGuis();
		proxy.registerRenderings();
		this.network = NetworkRegistry.INSTANCE.newSimpleChannel("TurkeyUtil");
		this.network.registerMessage(UtilPacket.HandlerServer.class, UtilPacket.class, 0, Side.SERVER);
		this.network.registerMessage(UtilPacket.HandlerClient.class, UtilPacket.class, 1, Side.CLIENT);

		if (Loader.isModLoaded("HungerOverhaul"))
		{
			logger.log(Level.INFO, "HungerOverhaul Detected.... applying hooks");
			new HungerOverhaulHook();
		}
		else logger.log(Level.INFO, "HungerOverhaul not Detected, there for not adding hooks");

		MinecraftForge.EVENT_BUS.register(new InteractEvent());
		FMLCommonHandler.instance().bus().register(new UpdateNotificationHandler());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		if (Loader.isModLoaded("chisel"))
		{
			logger.log(Level.INFO, "Chisel 2 Detected.... applying hooks");
			new ChiselModHook();
		}
		else logger.log(Level.INFO, "Chisel 2 not Detected, there for not adding hooks");
	}
}