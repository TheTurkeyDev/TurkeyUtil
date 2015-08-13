package com.turkey.turkeyUtil.blocks;

import java.util.List;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.turkey.turkeyUtil.TurkeyUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DeadPineLogs extends BlockLog
{

	public DeadPineLogs()
	{
		super.setBlockName("Deadpine_Log");
		super.setCreativeTab(TurkeyUtil.noodlecraftModTab);
		super.setBlockTextureName("turkeyUtil:deadpineLog");
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
		this.field_150167_a = new IIcon[1];
        this.field_150166_b = new IIcon[1];
		this.field_150167_a[0] = p_149651_1_.registerIcon("turkeyUtil:deadpineLog");
		this.field_150166_b[0] = p_149651_1_.registerIcon("turkeyUtil:deadpineLog_top");
	}
	
	@SideOnly(Side.CLIENT)
	protected IIcon getSideIcon(int p_150163_1_)
	{
		return this.field_150167_a[0];
	}

	@SideOnly(Side.CLIENT)
	protected IIcon getTopIcon(int p_150161_1_)
	{
		return this.field_150166_b[0];
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) 
	{
		list.add("Deadpine, Member of the Walking Wounded and NoodleCraft");
	}
}