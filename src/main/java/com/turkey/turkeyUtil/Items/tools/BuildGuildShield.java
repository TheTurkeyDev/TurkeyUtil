package com.turkey.turkeyUtil.items.tools;

import net.minecraft.item.Item;

import com.turkey.turkeyUtil.TurkeyUtil;

public class BuildGuildShield extends Item
{
	public BuildGuildShield()
    {
        this.maxStackSize = 1;
        this.setMaxDamage(300);
        this.setUnlocalizedName("Build_Guild_Shield");
        this.setTextureName("turkeyutil:buildGuildSheild");
        this.setCreativeTab(TurkeyUtil.buildguildmodTab);
    }
}
