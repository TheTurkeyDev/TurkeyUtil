package com.turkey.turkeyUtil.Items.tools;

import net.minecraft.item.Item;

import com.turkey.turkeyUtil.TurkeyUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BuildGuildSheild extends Item
{
	protected BuildGuildSheild()
    {
        this.maxStackSize = 1;
        this.setMaxDamage(300);
        this.setCreativeTab(TurkeyUtil.modTab);
    }
	
	@SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
}
