package com.turkey.turkeyUtil.Items.food;

import net.minecraft.item.ItemStack;

public class StaleCookie extends TurkeyItemFood
{
	public StaleCookie()
	{
		super(2, .25f, false, "Stale_Cookie", "cookie_stale", 64);
	}
	
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 96;
    }
}
