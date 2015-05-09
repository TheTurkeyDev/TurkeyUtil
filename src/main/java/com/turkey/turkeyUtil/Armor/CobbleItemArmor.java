package com.turkey.turkeyUtil.Armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.TurkeyUtil;

public class CobbleItemArmor extends ItemArmor
{
	public CobbleItemArmor(String unlocalizedName, ArmorMaterial material, String textureName, int type) {
		super(material, 0, type);
		this.setUnlocalizedName(unlocalizedName);
		super.setCreativeTab(TurkeyUtil.baseModTab);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return "turkeyutil:models/armor/Cobblestone_layer_" + (this.armorType == 2 ? "2" : "1") + ".png";
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		int stack = 0;
		
		if (itemStack.getItem().equals(UtilArmor.cobbleBoots))
		{
			player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 90, 0));
			stack++;
		}
		if (itemStack.getItem().equals(UtilArmor.cobblePants))
		{
			player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 90, 0));
			stack++;
		}
		if (itemStack.getItem().equals(UtilArmor.cobbleChest))
		{
			if(stack == 2)
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 90, 2));
			else if(stack == 0)
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 90, 0));
			stack++;
		}
		if (itemStack.getItem().equals(UtilArmor.cobbleHelm))
		{
			if(stack == 2)
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 90, 2));
			else if(stack == 0)
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 90, 0));
		}
	}
}