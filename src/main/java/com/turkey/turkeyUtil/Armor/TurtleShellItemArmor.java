package com.turkey.turkeyUtil.Armor;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.turkey.turkeyUtil.TurkeyUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TurtleShellItemArmor extends ItemArmor 
{
	public TurtleShellItemArmor(String unlocalizedName, ArmorMaterial material, int pos) {
		super(material, 0, pos);
		this.setUnlocalizedName(unlocalizedName);
		super.setCreativeTab(TurkeyUtil.noodlecraftModTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return "turkeyutil:models/armor/Turtle_Shell_layer_1.png";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) 
	{
		list.add("Blocks all damage taken in the back");
	}
}
