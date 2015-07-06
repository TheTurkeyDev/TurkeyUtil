package com.turkey.turkeyUtil.Items.tools;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Multimap;
import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.Items.UtilItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoulReaper extends Item
{
	private Random rand = new Random();

	public SoulReaper()
	{
		this.setUnlocalizedName("Soul_Reaper");
		this.setTextureName("turkeyutil:soul_Reaper");
		super.setMaxDamage(500);
		super.setCreativeTab(TurkeyUtil.baseModTab);
		super.showDurabilityBar(new ItemStack(this));
		super.setMaxStackSize(1);
	}

	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public Multimap getItemAttributeModifiers()
	{
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", 1, 0));
		return multimap;
	}

	public boolean hitEntity(ItemStack stack, EntityLivingBase hit, EntityLivingBase damager)
	{
		if(hit.getHealth() <= 0)
		{
			int r = rand.nextInt(100);
			if(r == 0)
			{
				hit.worldObj.spawnEntityInWorld(new EntityItem(hit.worldObj, hit.posX, hit.posY, hit.posZ, new ItemStack(UtilItems.glennsSoul)));
			}
		}
		return true;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) 
	{
		list.add("Upon killing a mob, there is a 1% chance that a Glenn's soul will drop");
		list.add("AknotsDeath");
	}
}
