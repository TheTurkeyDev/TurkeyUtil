package com.turkey.turkeyUtil.items.food;

import com.theprogrammingturkey.gobblecore.items.BaseItemFood;

import net.minecraft.item.ItemStack;

public class StaleCookie extends BaseItemFood
{
	public StaleCookie()
	{
		super("cookie_stale", 2, .25f, false);
	}

	public int getMaxItemUseDuration(ItemStack p_77626_1_)
	{
		return 96;
	}
}
