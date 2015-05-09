package com.turkey.turkeyUtil.Items;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.TurkeyUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WyldWhiskey  extends Item
{

	private PotionEffect[] effects = new PotionEffect[46];
	
    public WyldWhiskey()
    {
		super.setTextureName("turkeyutil:wyldWhiskey");
		super.setUnlocalizedName("Wylds_Drink_of_Choice");
        this.setMaxStackSize(16);
        this.setCreativeTab(TurkeyUtil.modTab);
        
        effects[0] = new PotionEffect(Potion.blindness.id, 200, 1);
        effects[1] = new PotionEffect(Potion.blindness.id, 2000, 1);
        effects[2] = new PotionEffect(Potion.confusion.id, 100, 1);
        effects[3] = new PotionEffect(Potion.confusion.id, 1000, 1);
        effects[4] = new PotionEffect(Potion.damageBoost.id, 300, 1);
        effects[5] = new PotionEffect(Potion.damageBoost.id, 3000, 1);
        effects[6] = new PotionEffect(Potion.digSlowdown.id, 240, 1);
        effects[7] = new PotionEffect(Potion.digSlowdown.id, 1000, 3);
        effects[8] = new PotionEffect(Potion.digSpeed.id, 100, 5);
        effects[9] = new PotionEffect(Potion.digSpeed.id, 500, 1);
        effects[10] = new PotionEffect(Potion.fireResistance.id, 2000, 1);
        effects[11] = new PotionEffect(Potion.fireResistance.id, 20000, 1);
        effects[12] = new PotionEffect(Potion.harm.id, 1, 1);
        effects[13] = new PotionEffect(Potion.harm.id, 1, 3);
        effects[14] = new PotionEffect(Potion.heal.id, 1, 1);
        effects[15] = new PotionEffect(Potion.heal.id, 1, 5);
        effects[16] = new PotionEffect(Potion.hunger.id, 200, 3);
        effects[17] = new PotionEffect(Potion.hunger.id, 500, 1);
        effects[18] = new PotionEffect(Potion.invisibility.id, 200, 1);
        effects[19] = new PotionEffect(Potion.invisibility.id, 2000, 1);
        effects[20] = new PotionEffect(Potion.jump.id, 200, 10);
        effects[21] = new PotionEffect(Potion.jump.id, 500, 2);
        effects[22] = new PotionEffect(Potion.moveSlowdown.id, 500, 2);
        effects[23] = new PotionEffect(Potion.moveSlowdown.id, 100, 5);
        effects[24] = new PotionEffect(Potion.moveSpeed.id, 100, 10);
        effects[25] = new PotionEffect(Potion.moveSpeed.id, 400, 1);
        effects[26] = new PotionEffect(Potion.nightVision.id, 200, 1);
        effects[27] = new PotionEffect(Potion.nightVision.id, 2000, 1);
        effects[28] = new PotionEffect(Potion.poison.id, 200, 0);
        effects[29] = new PotionEffect(Potion.poison.id, 100, 3);
        effects[30] = new PotionEffect(Potion.regeneration.id, 200, 1);
        effects[31] = new PotionEffect(Potion.regeneration.id, 100, 4);
        effects[32] = new PotionEffect(Potion.resistance.id, 2000, 1);
        effects[33] = new PotionEffect(Potion.resistance.id, 1000, 5);
        effects[34] = new PotionEffect(Potion.waterBreathing.id, 200, 1);
        effects[35] = new PotionEffect(Potion.waterBreathing.id, 2000, 10);
        effects[36] = new PotionEffect(Potion.weakness.id, 2000, 1);
        effects[37] = new PotionEffect(Potion.weakness.id, 2000, 5);
        effects[38] = new PotionEffect(Potion.wither.id, 100, 0);
        effects[39] = new PotionEffect(Potion.wither.id, 60, 2);
        effects[40] = new PotionEffect(Potion.field_76434_w.id, 2000, 1);
        effects[41] = new PotionEffect(Potion.field_76434_w.id, 2000, 4);
        effects[42] = new PotionEffect(Potion.field_76444_x.id, 2000, 1);
        effects[43] = new PotionEffect(Potion.field_76444_x.id, 2000, 4);
        effects[44] = new PotionEffect(Potion.field_76443_y.id, 20, 1);
        effects[45] = new PotionEffect(Potion.field_76443_y.id, 20, 10);
    }

    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
    {
        if (!player.capabilities.isCreativeMode)
        {
            --stack.stackSize;
        }

        if (!world.isRemote)
        {
        	int r = new Random().nextInt(effects.length);
        	PotionEffect effect = effects[r];
        	player.addPotionEffect(new PotionEffect(effect.getPotionID(), effect.getDuration(), effect.getAmplifier()));
        	player.addChatMessage(new ChatComponentText(player.getCommandSenderName() + " received " + effect.toString()));
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
        return EnumAction.drink;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
    	player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        return stack;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) 
	{
    	//Receive
		list.add("Take a drink of Wyld's drink of choice and receive magical effects");
		list.add("WyldWhiskey");
	}
}
