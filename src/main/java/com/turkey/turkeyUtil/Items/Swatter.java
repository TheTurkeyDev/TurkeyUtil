package com.turkey.turkeyUtil.items;

import java.util.List;

import com.turkey.turkeyUtil.TurkeyUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class Swatter extends Item
{
	public Swatter()
	{
		super.setTextureName("turkeyutil:swatter");
		super.setUnlocalizedName("Naraxam's_Bug_Swatter");
		super.setCreativeTab(TurkeyUtil.baseModTab);
		super.setMaxDamage(150);
		super.setMaxStackSize(1);
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
    
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) 
	{
		list.add("Deals +10 damge to mobs smaller than .75 of a block in size");
		list.add("Deals +1 damge to mobs larger than .75 of a block in size");
	}
}
