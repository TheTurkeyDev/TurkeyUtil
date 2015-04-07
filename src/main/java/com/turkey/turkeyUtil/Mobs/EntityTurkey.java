package com.turkey.turkeyUtil.Mobs;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.Items.UtilItems;
import com.turkey.turkeyUtil.Items.food.UtilFood;

public class EntityTurkey extends EntityAnimal
{

	public EntityTurkey(World p_i1738_1_) {
		super(p_i1738_1_);
		this.setSize(0.7F, 0.8F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.5D));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.tasks.addTask(5, new EntityAITempt(this, 3.0D, UtilItems.fabulousDiamond, false));
	}
	
	public boolean isAIEnabled()
	{
		return true;
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	} 

	@Override
    public EntityTurkey createChild(EntityAgeable ent)
    {
        return new EntityTurkey(this.worldObj);
    }
	
    protected String getLivingSound()
    {
        return "turkeyutil:Turkey_Gobble";
    }
    
    @Override
    public boolean canMateWith(EntityAnimal p_70878_1_)
    {
        return false;
    }
    
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);

        for (int k = 0; k < j; ++k)
        {
            this.dropItem(Items.feather, 1);
        }

        if (this.isBurning())
        {
            this.dropItem(UtilFood.cookedTurkey, 1);
        }
        else
        {
            this.dropItem(UtilFood.rawTurkey, 1);
        }
    }
}