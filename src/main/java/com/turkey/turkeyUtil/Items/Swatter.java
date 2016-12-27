package com.turkey.turkeyUtil.items;

import com.theprogrammingturkey.gobblecore.items.BaseItem;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class Swatter extends BaseItem
{
	public Swatter()
	{
		super("Naraxam's_Bug_Swatter");
		super.setMaxDamage(150);
		super.setMaxStackSize(1);
		super.addLore("Deals +10 damge to mobs smaller than .75 of a block in size");
		super.addLore("Deals +1 damge to mobs larger than .75 of a block in size");
	}
	
    public boolean hitEntity(ItemStack stack, EntityLivingBase mob, EntityLivingBase playerBase)
    {
    	stack.damageItem(1, playerBase);
    	Entity damaged = mob;
		if((!(damaged instanceof EntityPlayer)) && (playerBase instanceof EntityPlayer))
		{
			EntityPlayer player = (EntityPlayer) playerBase;
			if(player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == UtilItems.swatter)
			{
				if(damaged.width < .75f && damaged.height < .75f )
				{
					damaged.attackEntityFrom(DamageSource.causePlayerDamage(player), 10);
				}
				else
				{
					damaged.attackEntityFrom(DamageSource.causePlayerDamage(player), .5f);
				}
			}
		}
        return true;
    }
}