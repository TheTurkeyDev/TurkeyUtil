package com.turkey.turkeyUtil.Items.food;

import com.turkey.turkeyUtil.TurkeyUtil;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Juice extends TurkeyItemFood
{	
	public Juice()
	{
		super(4, .25f, false, "Juice", "juice", 64);
		super.addLore("Property of Scetchlink");
		super.addLore("Scetchlink, Member of NoodleCraft");
		this.setCreativeTab(TurkeyUtil.noodlecraftModTab);
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
