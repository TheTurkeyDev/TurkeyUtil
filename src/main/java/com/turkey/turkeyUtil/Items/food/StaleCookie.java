package com.turkey.turkeyUtil.items.food;

import com.theprogrammingturkey.gobblecore.items.BaseFoodItem;

import net.minecraft.item.ItemStack;

public class StaleCookie extends BaseFoodItem
{
	public StaleCookie()
	{
		super(2, .25f, "cookie_stale");
	}
	
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 96;
    }
}
