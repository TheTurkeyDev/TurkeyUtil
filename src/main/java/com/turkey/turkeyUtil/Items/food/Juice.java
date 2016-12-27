package com.turkey.turkeyUtil.items.food;

import com.theprogrammingturkey.gobblecore.items.BaseFoodItem;
import com.turkey.turkeyUtil.TurkeyUtil;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Juice extends BaseFoodItem
{	
	public Juice()
	{
		super(4, .25f, "Juice");
		super.addLore("Property of Scetchlink");
		super.addLore("Scetchlink, Member of NoodleCraft");
	}
	
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.drink;
    }
    
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
    {
    	if(!player.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle)) && world.isRemote)
    		world.spawnEntityInWorld(new EntityItem(world,player.lastTickPosX,player.lastTickPosY,player.lastTickPosZ,new ItemStack(Items.glass_bottle)));
    	return super.onEaten(stack, world, player);
    }
}
