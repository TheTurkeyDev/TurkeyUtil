package com.turkey.turkeyUtil.Items.food;

import com.turkey.turkeyUtil.TurkeyUtil;

import net.minecraft.item.ItemStack;

public class StaleCookie extends TurkeyItemFood
{
	public StaleCookie()
	{
		super(2, .25f, false, "Stale_Cookie", "cookie_stale", 64);
		this.setCreativeTab(TurkeyUtil.baseModTab);
	}
	
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 96;
    }
}
