package com.turkey.turkeyUtil.items;

import com.turkey.turkeyUtil.TurkeyUtil;

public class GlennsSoul extends BaseItemUtil
{
	public GlennsSoul()
	{
		super("Glenns_Soul");
		super.setCreativeTab(TurkeyUtil.buildguildmodTab);
		super.addLore("Used to craft essence containers");
		super.addLore("Obtained by killing mobs with Aknot's soul reaper");
		super.addLore("Sevadus, Member of the Build Guild");
	}
}
