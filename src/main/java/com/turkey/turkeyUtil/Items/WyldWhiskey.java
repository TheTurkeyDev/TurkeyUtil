package com.turkey.turkeyUtil.items;

import java.util.Random;

import com.theprogrammingturkey.gobblecore.items.BaseItem;
import com.theprogrammingturkey.gobblecore.util.MessageUtil;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class WyldWhiskey extends BaseItem
{

	private PotionEffect[] effects = new PotionEffect[46];

	public WyldWhiskey()
	{
		super("Wylds_Drink_of_Choice");
		this.setMaxStackSize(16);

		super.addLore("Take a drink of Wyld's drink of choice and receive magical effects");
		super.addLore("Wyld, Member of the Build Guild");

		effects[0] = new PotionEffect(MobEffects.BLINDNESS, 200, 1);
		effects[1] = new PotionEffect(MobEffects.BLINDNESS, 2000, 1);
		effects[2] = new PotionEffect(MobEffects.NAUSEA, 100, 1);
		effects[3] = new PotionEffect(MobEffects.NAUSEA, 1000, 1);
		effects[4] = new PotionEffect(MobEffects.STRENGTH, 300, 1);
		effects[5] = new PotionEffect(MobEffects.STRENGTH, 3000, 1);
		effects[6] = new PotionEffect(MobEffects.MINING_FATIGUE, 240, 1);
		effects[7] = new PotionEffect(MobEffects.MINING_FATIGUE, 1000, 3);
		effects[8] = new PotionEffect(MobEffects.HASTE, 100, 5);
		effects[9] = new PotionEffect(MobEffects.HASTE, 500, 1);
		effects[10] = new PotionEffect(MobEffects.FIRE_RESISTANCE, 2000, 1);
		effects[11] = new PotionEffect(MobEffects.FIRE_RESISTANCE, 20000, 1);
		effects[12] = new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, 1);
		effects[13] = new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, 3);
		effects[14] = new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 1);
		effects[15] = new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 5);
		effects[16] = new PotionEffect(MobEffects.HUNGER, 200, 3);
		effects[17] = new PotionEffect(MobEffects.HUNGER, 500, 1);
		effects[18] = new PotionEffect(MobEffects.INVISIBILITY, 200, 1);
		effects[19] = new PotionEffect(MobEffects.INVISIBILITY, 2000, 1);
		effects[20] = new PotionEffect(MobEffects.JUMP_BOOST, 200, 10);
		effects[21] = new PotionEffect(MobEffects.JUMP_BOOST, 500, 2);
		effects[22] = new PotionEffect(MobEffects.SLOWNESS, 500, 2);
		effects[23] = new PotionEffect(MobEffects.SLOWNESS, 100, 5);
		effects[24] = new PotionEffect(MobEffects.SPEED, 100, 10);
		effects[25] = new PotionEffect(MobEffects.SPEED, 400, 1);
		effects[26] = new PotionEffect(MobEffects.NIGHT_VISION, 200, 1);
		effects[27] = new PotionEffect(MobEffects.NIGHT_VISION, 2000, 1);
		effects[28] = new PotionEffect(MobEffects.POISON, 200, 0);
		effects[29] = new PotionEffect(MobEffects.POISON, 100, 3);
		effects[30] = new PotionEffect(MobEffects.REGENERATION, 200, 1);
		effects[31] = new PotionEffect(MobEffects.REGENERATION, 100, 4);
		effects[32] = new PotionEffect(MobEffects.RESISTANCE, 2000, 1);
		effects[33] = new PotionEffect(MobEffects.RESISTANCE, 1000, 5);
		effects[34] = new PotionEffect(MobEffects.WATER_BREATHING, 200, 1);
		effects[35] = new PotionEffect(MobEffects.WATER_BREATHING, 2000, 10);
		effects[36] = new PotionEffect(MobEffects.WEAKNESS, 2000, 1);
		effects[37] = new PotionEffect(MobEffects.WEAKNESS, 2000, 5);
		effects[38] = new PotionEffect(MobEffects.WITHER, 100, 0);
		effects[39] = new PotionEffect(MobEffects.WITHER, 60, 2);
		effects[40] = new PotionEffect(MobEffects.HEALTH_BOOST, 2000, 1);
		effects[41] = new PotionEffect(MobEffects.HEALTH_BOOST, 2000, 4);
		effects[42] = new PotionEffect(MobEffects.SATURATION, 2000, 1);
		effects[43] = new PotionEffect(MobEffects.SATURATION, 2000, 4);
		effects[44] = new PotionEffect(MobEffects.ABSORPTION, 20, 1);
		effects[45] = new PotionEffect(MobEffects.ABSORPTION, 20, 10);
	}

	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		if(!player.capabilities.isCreativeMode)
		{
			--stack.stackSize;
		}

		if(!world.isRemote)
		{
			int r = new Random().nextInt(effects.length);
			PotionEffect effect = effects[r];
			player.addPotionEffect(new PotionEffect(effect.getPotion(), effect.getDuration(), effect.getAmplifier()));
			MessageUtil.sendMessageToPlayer(player, player.getName() + " received " + effect.toString());
		}

		return stack;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	public int getMaxItemUseDuration(ItemStack p_77626_1_)
	{
		return 32;
	}

	/**
	 * returns the action that specifies what animation to play when the items is being used
	 */
	public EnumAction getItemUseAction(ItemStack stack)
	{
		return EnumAction.DRINK;
	}
}
