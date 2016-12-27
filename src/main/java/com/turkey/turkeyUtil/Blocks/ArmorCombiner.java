package com.turkey.turkeyUtil.blocks;

import com.theprogrammingturkey.gobblecore.blocks.BaseBlockContainer;
import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.blocks.TileEntities.ArmorCombinerTileEntity;
import com.turkey.turkeyUtil.gui.UtilGuiHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

public class ArmorCombiner extends BaseBlockContainer
{
	public ArmorCombiner()
	{
		super("armor_combiner");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_)
	{
		return new ArmorCombinerTileEntity();
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if(world.isRemote || player.isSneaking())
		{
			return false;
		}
		else
		{
			FMLNetworkHandler.openGui(player, TurkeyUtil.instance, UtilGuiHandler.ARMOR_COMBINER_ID, world, x, y, z);
			return true;
		}
	}

}