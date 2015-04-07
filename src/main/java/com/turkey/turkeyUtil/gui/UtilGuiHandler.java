package com.turkey.turkeyUtil.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.Blocks.Container.ArmorCombinerContainer;
import com.turkey.turkeyUtil.Blocks.TileEntities.ArmorCombinerTileEntity;

import cpw.mods.fml.common.network.IGuiHandler;

public class UtilGuiHandler implements IGuiHandler
{
	public final static int ARMOR_COMBINER_ID = 0;
	public final static int BETTER_BOOK_ID = 1;
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = world.getTileEntity(x, y, z);

		if (tileEntity != null)
		{
			switch (ID)
			{
			case ARMOR_COMBINER_ID:
				if (tileEntity instanceof ArmorCombinerTileEntity)
				{
					return new ArmorCombinerGui(player.inventory, (ArmorCombinerTileEntity) tileEntity, world);
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

		if (tileEntity != null)
		{
			switch (ID)
			{
			case ARMOR_COMBINER_ID:
				if (tileEntity instanceof ArmorCombinerTileEntity)
				{
					return new ArmorCombinerContainer(player.inventory, (ArmorCombinerTileEntity) tileEntity, world);
				}
				break;
			default:
				return null;
			}
		}
		return null;
	}
}
