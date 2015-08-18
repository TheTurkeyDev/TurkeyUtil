package com.turkey.turkeyUtil.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.TurkeyUtil;

public class KiraeysTurkeyFeather extends Item
{
	public KiraeysTurkeyFeather()
	{
		super.setTextureName("turkeyutil:kiraeys_turkey_feather");
		super.setUnlocalizedName("Kiraeys_Turkey_Feather");
		super.setCreativeTab(TurkeyUtil.baseModTab);
	}
	
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
    	stack.stackSize--;
    	player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 100, 5));
    	player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 100, 2));
        return true;
    }
}
