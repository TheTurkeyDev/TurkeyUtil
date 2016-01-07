package com.turkey.turkeyUtil.items.tools;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.google.common.collect.Multimap;
import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.items.UtilItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoulEssanceReaper extends Item
{
	public SoulEssanceReaper()
	{
		this.setUnlocalizedName("Soul_Essence_Reaper");
		this.setTextureName("turkeyutil:soul_Essence_Reaper");
		super.setMaxDamage(500);
		super.setCreativeTab(TurkeyUtil.baseModTab);
		super.showDurabilityBar(new ItemStack(this));
		super.setMaxStackSize(1);
	}

	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public Multimap getItemAttributeModifiers()
	{
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", 6, 0));
		return multimap;
	}

	public boolean hitEntity(ItemStack stack, EntityLivingBase hit, EntityLivingBase damager)
	{	
		if(damager instanceof EntityPlayer)
		{
			int increase = 1;
			if(hit.getHealth() <= 0)
				increase = 3;
			EntityPlayer player = (EntityPlayer) damager;
			ItemStack[] mainInventory = player.inventory.mainInventory;
			int slot = -1;
			for(int i = 0; i < mainInventory.length; ++i)
			{
				if(mainInventory[i] != null && (mainInventory[i].getItem() == UtilItems.hostileEssenceContainer || mainInventory[i].getItem() == UtilItems.passiveEssenceContainer))
				{
					slot = i;
					break;
				}
			}
			if(slot != -1)
			{
				ItemStack container = player.inventory.getStackInSlot(slot);
				if(container.getTagCompound() == null || !container.getTagCompound().hasKey("Completed"))
				{
					NBTTagCompound nbt = container.getTagCompound();
					if(nbt == null)
						nbt = new NBTTagCompound();
					container.setItemDamage(100);
					nbt.setBoolean("Completed", false);
					container.setTagCompound(nbt);
				}
				if(container.getItemDamage() != 0)
				{
					if(container.getItemDamage() - increase <= 0)
					{
						container.setItemDamage(0);
						container.getTagCompound().setBoolean("Completed", true);
					}
					else
						container.setItemDamage(container.getItemDamage() - increase);
				}
			}
		}
		stack.damageItem(1, damager);
		return true;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) 
	{
		list.add("Grants 1 essence for damaging a mob and 3 essence for killing a mob.");
		list.add("Essence is stored in essence containers");
		list.add("AknotsDeath");
	}
}
