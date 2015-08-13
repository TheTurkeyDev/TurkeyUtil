package com.turkey.turkeyUtil.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

import com.turkey.turkeyUtil.Items.UtilItems;
import com.turkey.turkeyUtil.armor.UtilArmor;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class InteractEvent
{	
	@SubscribeEvent
	public void onInteract(EntityInteractEvent e)
	{
		try{
			if(e.entityPlayer.inventory.getCurrentItem().getItem().toString().equalsIgnoreCase(UtilItems.potato.toString()) && e.target instanceof EntityZombie)
			{
				if (e.entityPlayer.worldObj.isRemote)
				{
					return;
				}
				else
				{
					EntityZombie zomb = (EntityZombie) e.target;
					if(zomb.isVillager())
					{
						EntityVillager entityvillager = new EntityVillager(zomb.worldObj);
						entityvillager.copyLocationAndAnglesFrom(zomb);
						entityvillager.onSpawnWithEgg((IEntityLivingData)null);
						entityvillager.setLookingForHome();
						
						if (zomb.isChild())
						{
							entityvillager.setGrowingAge(-24000);
						}
						
						zomb.worldObj.removeEntity(zomb);
						zomb.worldObj.spawnEntityInWorld(entityvillager);
						entityvillager.addPotionEffect(new PotionEffect(Potion.confusion.id, 200, 0));
						zomb.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1017, (int)zomb.posX, (int)zomb.posY, (int)zomb.posZ, 0);
						
						e.entityPlayer.inventory.consumeInventoryItem(e.entityPlayer.inventory.getCurrentItem().getItem());
					}
				}
			}
		}catch(NullPointerException ex){};
	}
	
	@SubscribeEvent
	public void onInteract(LivingHurtEvent e)
	{
		if(e.entity instanceof EntityPlayer)
		{
			Entity dmgent = e.source.getEntity();
			Entity player = e.entity;
			
			if(((EntityPlayer)player).inventory.armorInventory[2] == null || !((EntityPlayer)player).inventory.armorInventory[2].getItem().equals(UtilArmor.turtleShell))
				return;
			
			float yaw = player.rotationYaw;
			if(yaw >= -30 && yaw <= 30)
			{
				if(player.posZ > dmgent.prevPosZ)
					e.setCanceled(true);
			}
			if(yaw > 30 && yaw <= 60)
			{
				if(player.posZ > dmgent.prevPosZ && player.posX < dmgent.prevPosX )
					e.setCanceled(true);
			}
			if(yaw > 60 && yaw <= 120)
			{
				if(player.posX < dmgent.prevPosX )
					e.setCanceled(true);
			}
			if(yaw > 120 && yaw <= 150)
			{
				if(player.posZ < dmgent.prevPosZ && player.posX < dmgent.prevPosX )
					e.setCanceled(true);
			}
			if(yaw > 150 && yaw <= -150)
			{
				if(player.posZ < dmgent.prevPosZ)
					e.setCanceled(true);
			}
			if(yaw > -150 && yaw <= -120)
			{
				if(player.posZ < dmgent.prevPosZ && player.posX > dmgent.prevPosX )
					e.setCanceled(true);
			}
			if(yaw > -120 && yaw <= -60)
			{
				
				if(player.posX > dmgent.prevPosX )
					e.setCanceled(true);
			}
			if(yaw > -60 && yaw <= -30)
			{
				if(player.posZ > dmgent.prevPosZ && player.posX > dmgent.prevPosX )
					e.setCanceled(true);
			}
		}
	}
}
