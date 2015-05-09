package com.turkey.turkeyUtil.Armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.TurkeyUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MiscItemArmor extends ItemArmor
{
	public MiscItemArmor(String unlocalizedName, ArmorMaterial material, int pos) 
	{
		super(material, 0, pos);
		this.setUnlocalizedName(unlocalizedName);
		super.setCreativeTab(TurkeyUtil.baseModTab);
		this.setMaxDamage(0);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem().getUnlocalizedName().equalsIgnoreCase("item.Gas_Mask"))
			return "turkeyutil:models/armor/Gask_Mask_layer_1.png";
		else if(stack.getItem().getUnlocalizedName().equalsIgnoreCase("item.Walking_Wounded_Headband"))
			return "turkeyutil:models/armor/HeadWound_Band_layer_1.png";
		else if(stack.getItem().getUnlocalizedName().equalsIgnoreCase("item.pandaaburr's_Panda_Mask"))
			return "turkeyutil:models/armor/Panda_Mask_layer_1.png";
		else if(stack.getItem().getUnlocalizedName().equalsIgnoreCase("item.J3D_Wig"))
			return "turkeyutil:models/armor/J3D_Wig.png";
		else
			return "turkeyutil:models/armor/Gask_Mask_layer_1.png";
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		
		if (itemStack.getItem().getUnlocalizedName().equalsIgnoreCase("item.Walking_Wounded_Headband"))
		{
			player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 20, 0));
		}
		if (itemStack.getItem().getUnlocalizedName().equalsIgnoreCase("item.pandaaburr's_Panda_Mask"))
		{
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 210, 0));
			player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20, 0));
			player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 20, 0));
		}
	}
	
	@SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
    {
		if(itemStack.getItem().getUnlocalizedName().equalsIgnoreCase("item.J3D_Wig"))
		{
			return ModelJedsWig.modelWig;
		}
        return null;
    }
}
