package com.turkey.turkeyUtil.events;

import com.turkey.turkeyUtil.armor.UtilArmor;
import com.turkey.turkeyUtil.items.UtilItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class InteractEvent
{
	@SubscribeEvent
	public void onInteract(EntityInteract e)
	{
		try
		{
			if(e.getEntityPlayer().inventory.getCurrentItem().getItem().toString().equalsIgnoreCase(UtilItems.potato.toString()) && e.getTarget() instanceof EntityZombie)
			{
				if(e.getEntityPlayer().worldObj.isRemote)
				{
					return;
				}
				else
				{
					EntityZombie zomb = (EntityZombie) e.getTarget();
					if(zomb.isVillager())
					{
						EntityVillager entityvillager = new EntityVillager(zomb.worldObj);
						entityvillager.copyLocationAndAnglesFrom(zomb);
						entityvillager.onInitialSpawn(zomb.worldObj.getDifficultyForLocation(new BlockPos(entityvillager)), (IEntityLivingData) null);
						entityvillager.setLookingForHome();

						if(zomb.isChild())
						{
							entityvillager.setGrowingAge(-24000);
						}

						zomb.worldObj.removeEntity(zomb);
						entityvillager.setNoAI(zomb.isAIDisabled());
						if(zomb.getVillagerTypeForge() != null)
							entityvillager.setProfession(zomb.getVillagerTypeForge());
						else
							entityvillager.setProfession(0);

						if(zomb.hasCustomName())
						{
							entityvillager.setCustomNameTag(zomb.getCustomNameTag());
							entityvillager.setAlwaysRenderNameTag(zomb.getAlwaysRenderNameTag());
						}

						zomb.worldObj.spawnEntityInWorld(entityvillager);
						entityvillager.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 200, 0));
						zomb.worldObj.playEvent((EntityPlayer) null, 1027, new BlockPos((int) zomb.posX, (int) zomb.posY, (int) zomb.posZ), 0);
					}
				}
			}
		} catch(NullPointerException ex)
		{
		}
	}

	@SubscribeEvent
	public void onInteract(LivingHurtEvent e)
	{
		if(e.getEntity() instanceof EntityPlayer)
		{
			Entity dmgent = e.getSource().getEntity();
			Entity player = e.getEntity();

			if(((EntityPlayer) player).inventory.armorInventory[2] == null || !((EntityPlayer) player).inventory.armorInventory[2].getItem().equals(UtilArmor.turtleShell))
				return;

			float yaw = player.rotationYaw;
			if(yaw >= -30 && yaw <= 30)
			{
				if(player.posZ > dmgent.prevPosZ)
					e.setCanceled(true);
			}
			if(yaw > 30 && yaw <= 60)
			{
				if(player.posZ > dmgent.prevPosZ && player.posX < dmgent.prevPosX)
					e.setCanceled(true);
			}
			if(yaw > 60 && yaw <= 120)
			{
				if(player.posX < dmgent.prevPosX)
					e.setCanceled(true);
			}
			if(yaw > 120 && yaw <= 150)
			{
				if(player.posZ < dmgent.prevPosZ && player.posX < dmgent.prevPosX)
					e.setCanceled(true);
			}
			if(yaw > 150 && yaw <= -150)
			{
				if(player.posZ < dmgent.prevPosZ)
					e.setCanceled(true);
			}
			if(yaw > -150 && yaw <= -120)
			{
				if(player.posZ < dmgent.prevPosZ && player.posX > dmgent.prevPosX)
					e.setCanceled(true);
			}
			if(yaw > -120 && yaw <= -60)
			{

				if(player.posX > dmgent.prevPosX)
					e.setCanceled(true);
			}
			if(yaw > -60 && yaw <= -30)
			{
				if(player.posZ > dmgent.prevPosZ && player.posX > dmgent.prevPosX)
					e.setCanceled(true);
			}
		}
	}
}
