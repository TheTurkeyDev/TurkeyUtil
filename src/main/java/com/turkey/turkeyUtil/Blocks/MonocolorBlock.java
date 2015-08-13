package com.turkey.turkeyUtil.blocks;

import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemDye;
import net.minecraft.util.IIcon;

import com.turkey.turkeyUtil.TurkeyUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MonocolorBlock extends BlockColored
{
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
    
	public MonocolorBlock()
	{
		super(Material.rock);
		super.setCreativeTab(TurkeyUtil.baseModTab);
		super.setHardness(0.5F);
		super.setBlockName("monocolored_Block");
		super.setBlockTextureName("monocolored_block");
	}
	
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return this.icons[p_149691_2_ % this.icons.length];
    }

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
		this.icons = new IIcon[16];

		for (int i = 0; i < this.icons.length; ++i)
		{
			this.icons[i] = p_149651_1_.registerIcon(TurkeyUtil.MODID + ":" + this.getTextureName() + "_" + ItemDye.field_150921_b[func_150031_c(i)]);
		}
	}
}