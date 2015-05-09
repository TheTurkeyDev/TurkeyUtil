package com.turkey.turkeyUtil.Blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.Blocks.TileEntities.ArmorCombinerTileEntity;
import com.turkey.turkeyUtil.gui.UtilGuiHandler;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class ArmorCombiner extends BlockContainer
{

	public ArmorCombiner()
	{
		super(Material.ground);
		super.setHardness(3.5f);
		super.setHarvestLevel("pickaxe", 0);
		super.setResistance(10);
		super.setBlockName("Armor_Combiner");
		super.setCreativeTab(TurkeyUtil.baseModTab);
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