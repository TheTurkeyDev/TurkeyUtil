package com.turkey.turkeyUtil.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.Items.food.UtilFood;

public class EntityDuck extends EntityTameable
{
	public float field_70886_e;
	public float destPos;
	public float field_70884_g;
	public float field_70888_h;
	public float field_70889_i = 1.0F;
	public boolean field_152118_bv;

	public EntityDuck(World p_i1682_1_)
	{
		super(p_i1682_1_);
		this.setSize(0.3F, 0.7F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.7D));
		this.tasks.addTask(3, new EntityAITempt(this, 1.0D, Items.bread, false));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(5, new EntityAIWander(this, 1.3D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.tasks.addTask(8, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
	}

	 protected void applyEntityAttributes()
	 {
		 super.applyEntityAttributes();
		 this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4.0D);
		 this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35D);
	 }

	 public void onLivingUpdate()
	 {
		 super.onLivingUpdate();
		 this.field_70888_h = this.field_70886_e;
		 this.field_70884_g = this.destPos;
		 this.destPos = (float)((double)this.destPos + (double)(this.onGround ? -1 : 4) * 0.3D);

		 if (this.destPos < 0.0F)
		 {
			 this.destPos = 0.0F;
		 }

		 if (this.destPos > 1.0F)
		 {
			 this.destPos = 1.0F;
		 }

		 if (!this.onGround && this.field_70889_i < 1.0F)
		 {
			 this.field_70889_i = 1.0F;
		 }

		 this.field_70889_i = (float)((double)this.field_70889_i * 0.9D);

		 if (!this.onGround && this.motionY < 0.0D)
		 {
			 this.motionY *= 0.6D;
		 }

		 this.field_70886_e += this.field_70889_i * 2.0F;
		 
		 this.fallDistance = 0;
	 }

	 /**
	  * Returns the sound this mob makes while it's alive.
	  */
	 protected String getLivingSound()
	 {
		 return "turkeyutil:Duck_Double_Quack";
	 }

	 /**
	  * Returns the sound this mob makes when it is hurt.
	  */
	 protected String getHurtSound()
	 {
		 return "turkeyutil:Duck_Single_Quack";
	 }

	 protected Item getDropItem()
	 {
		 return Items.feather;
	 }

	 /**
	  * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
	  * par2 - Level of Looting used to kill this mob.
	  */
	 protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
	 {
		 int j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);

		 for (int k = 0; k < j; ++k)
		 {
			 this.dropItem(Items.feather, 1);
		 }

		 if (this.isBurning())
		 {
			 this.dropItem(UtilFood.cookedDuck, 1);
		 }
		 else
		 {
			 this.dropItem(UtilFood.rawDuck, 1);
		 }
	 }

	 public EntityDuck createChild(EntityAgeable p_90011_1_)
	 {
		 return new EntityDuck(this.worldObj);
	 }

	 /**
	  * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
	  * the animal type)
	  */
	 public boolean isBreedingItem(ItemStack p_70877_1_)
	 {
		 return p_70877_1_ != null && p_70877_1_.getItem() instanceof ItemSeeds;
	 }

	 /**
	  * Get the experience points the entity currently has.
	  */
	 protected int getExperiencePoints(EntityPlayer p_70693_1_)
	 {
		 return this.func_152116_bZ() ? 10 : super.getExperiencePoints(p_70693_1_);
	 }
	 
	 public boolean func_152116_bZ()
	 {
		 return this.field_152118_bv;
	 }
	 
	 public boolean interact(EntityPlayer p_70085_1_)
	    {
	        ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

	        if (this.isTamed())
	        {
	            if (this.func_152114_e(p_70085_1_) && !this.worldObj.isRemote && !this.isBreedingItem(itemstack))
	            {
	                this.aiSit.setSitting(!this.isSitting());
	                this.isJumping = false;
	                this.setPathToEntity((PathEntity)null);
	                this.setTarget((Entity)null);
	                this.setAttackTarget((EntityLivingBase)null);
	            }
	        }
	        else if (itemstack != null && itemstack.getItem() == Items.bone)
	        {
	            if (!p_70085_1_.capabilities.isCreativeMode)
	            {
	                --itemstack.stackSize;
	            }

	            if (itemstack.stackSize <= 0)
	            {
	                p_70085_1_.inventory.setInventorySlotContents(p_70085_1_.inventory.currentItem, (ItemStack)null);
	            }

	            if (!this.worldObj.isRemote)
	            {
	                if (this.rand.nextInt(3) == 0)
	                {
	                    this.setTamed(true);
	                    this.setPathToEntity((PathEntity)null);
	                    this.setAttackTarget((EntityLivingBase)null);
	                    this.aiSit.setSitting(true);
	                    this.setHealth(20.0F);
	                    this.func_152115_b(p_70085_1_.getUniqueID().toString());
	                    this.playTameEffect(true);
	                    this.worldObj.setEntityState(this, (byte)7);
	                }
	                else
	                {
	                    this.playTameEffect(false);
	                    this.worldObj.setEntityState(this, (byte)6);
	                }
	            }

	            return true;
	        }

	        return super.interact(p_70085_1_);
	    }
}
