package com.turkey.turkeyUtil.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.blocks.Container.AdvancedHopperContainer;
import com.turkey.turkeyUtil.blocks.Container.ArmorCombinerContainer;
import com.turkey.turkeyUtil.blocks.Container.LightCollectorContainer;
import com.turkey.turkeyUtil.blocks.Container.LightHealingContainer;
import com.turkey.turkeyUtil.blocks.TileEntities.AdvancedHopperTileEntity;
import com.turkey.turkeyUtil.blocks.TileEntities.ArmorCombinerTileEntity;
import com.turkey.turkeyUtil.blocks.TileEntities.LightCollectorTileEntity;
import com.turkey.turkeyUtil.blocks.TileEntities.LightHealingTileEntity;

import cpw.mods.fml.common.network.IGuiHandler;

public class UtilGuiHandler implements IGuiHandler
{
	public final static int ARMOR_COMBINER_ID = 0;
	public final static int BETTER_BOOK_ID = 1;
	public final static int ADVANCED_HOPPER_ID = 2;
	public final static int LIGHT_COLLECTOR_ID = 3;
	public final static int LIGHT_HEALER_ID = 4;

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = world.getTileEntity(x, y, z);

		if(tileEntity != null)
		{
			switch(ID)
			{
				case ARMOR_COMBINER_ID:
					if(tileEntity instanceof ArmorCombinerTileEntity)
					{
						return new ArmorCombinerGui(player.inventory, (ArmorCombinerTileEntity) tileEntity, world);
					}
					break;
				case ADVANCED_HOPPER_ID:
					if(tileEntity instanceof AdvancedHopperTileEntity)
					{
						return new AdvancedHopperGui(player.inventory, (AdvancedHopperTileEntity) tileEntity);
					}
					break;
				case LIGHT_COLLECTOR_ID:
					if(tileEntity instanceof LightCollectorTileEntity)
					{
						return new LightCollectorGui(player.inventory, (LightCollectorTileEntity) tileEntity);
					}
					break;
				case LIGHT_HEALER_ID:
					if(tileEntity instanceof LightHealingTileEntity)
					{
						return new LightHealingGui(player.inventory, (LightHealingTileEntity) tileEntity);
					}
					break;
				default:
					return null;
			}
		}
		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = world.getTileEntity(x, y, z);

		if(tileEntity != null)
		{
			switch(ID)
			{
				case ARMOR_COMBINER_ID:
					if(tileEntity instanceof ArmorCombinerTileEntity)
					{
						return new ArmorCombinerContainer(player.inventory, (ArmorCombinerTileEntity) tileEntity, world);
					}
					break;
				case ADVANCED_HOPPER_ID:
					if(tileEntity instanceof AdvancedHopperTileEntity)
					{
						return new AdvancedHopperContainer(player.inventory, (AdvancedHopperTileEntity) tileEntity);
					}
					break;
				case LIGHT_COLLECTOR_ID:
					if(tileEntity instanceof LightCollectorTileEntity)
					{
						return new LightCollectorContainer(player.inventory, (LightCollectorTileEntity) tileEntity);
					}
					break;
				case LIGHT_HEALER_ID:
					if(tileEntity instanceof LightHealingTileEntity)
					{
						return new LightHealingContainer(player.inventory, (LightHealingTileEntity) tileEntity);
					}
					break;
				default:
					return null;
			}
		}
		return null;
	}
}
