package com.turkey.turkeyUtil.Armor;

import com.turkey.turkeyUtil.TurkeyUtil;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class SuperFabulousItemArmor extends ItemArmor
{
	public SuperFabulousItemArmor(String unlocalizedName, ArmorMaterial material, String textureName, int type) {
		super(material, 0, type);
		this.setUnlocalizedName(unlocalizedName);
		super.setCreativeTab(TurkeyUtil.baseModTab);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return "turkeyutil:models/armor/Super_Fabulous_layer_" + (this.armorType == 2 ? "2" : "1") + ".png";
	}
	
}