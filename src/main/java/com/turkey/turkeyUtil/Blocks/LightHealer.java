package com.turkey.turkeyUtil.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.blocks.TileEntities.LightHealingTileEntity;
import com.turkey.turkeyUtil.gui.UtilGuiHandler;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class LightHealer extends BlockContainer
{

	public LightHealer()
	{
		super(Material.ground);
		super.setHardness(3.5f);
		super.setBlockName("Light_Healer");
		super.setBlockTextureName(TurkeyUtil.MODID + ":light_healer");
		super.setCreativeTab(TurkeyUtil.baseModTab);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_)
	{
		return new LightHealingTileEntity();
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if(world.isRemote || player.isSneaking())
		{
			return false;
		}
		else
		{
			FMLNetworkHandler.openGui(player, TurkeyUtil.instance, UtilGuiHandler.LIGHT_HEALER_ID, world, x, y, z);
			return true;
		}
	}

}