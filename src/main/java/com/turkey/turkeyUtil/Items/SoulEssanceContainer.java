package com.turkey.turkeyUtil.items;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.theprogrammingturkey.gobblecore.items.BaseItem;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SoulEssanceContainer extends BaseItem
{

	public SoulEssanceContainer(String type)
	{
		super("soul_Essence_Container_" + type);
		this.setHasSubtypes(true);
		this.setMaxDamage(100);
		this.setMaxStackSize(1);
		
		super.addLore("Stores essence and once full (100 essence) will allow the container to spawn random mob");
		super.addLore("Note, spawning this item in and not crafting it currently does not work.");
	}

	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
		stack.setItemDamage(100);
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack)
	{
		if(stack.getTagCompound() == null || !stack.getTagCompound().hasKey("Completed") || !stack.getTagCompound().getBoolean("Completed"))
			return false;
		return true;
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
		if(world.isRemote)
		{
			return true;
		}
		else
		{
			if(stack.getTagCompound() == null || !stack.getTagCompound().hasKey("Completed") || !stack.getTagCompound().getBoolean("Completed"))
				return false;
			p_77648_4_ += Facing.offsetsXForSide[p_77648_7_];
			p_77648_5_ += Facing.offsetsYForSide[p_77648_7_];
			p_77648_6_ += Facing.offsetsZForSide[p_77648_7_];

			boolean passive = stack.getItem().equals(UtilItems.passiveEssenceContainer);
			List<Entity> ents = new ArrayList<Entity>();

			for(Object i : EntityList.entityEggs.keySet())
			{
				int id = (Integer) i;
				Entity ent = EntityList.createEntityByID(id, world);
				if(!passive && ent instanceof EntityMob)
					ents.add(ent);
				else if(passive && !(ent instanceof EntityMob))
					ents.add(ent);
			}

			if(ents.size() == 0)
				return false;

			int r = new Random().nextInt(ents.size());

			Entity entity = spawnCreature(ents.get(r), world, (double) p_77648_4_ + 0.5D, (double) p_77648_5_ + 2, (double) p_77648_6_ + 0.5D);

			if(entity != null)
				if(!player.capabilities.isCreativeMode)
					stack.setItemDamage(100);

			return true;
		}
	}

	public static Entity spawnCreature(Entity ent, World world, double x, double y, double z)
	{

		for(int j = 0; j < 1; ++j)
		{

			if(ent != null && ent instanceof EntityLivingBase)
			{
				ent.setLocationAndAngles((double) x + 0.5D, (double) y - 1.95D, (double) z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(ent);

				for(int l = 0; l < 120; ++l)
				{
					world.spawnParticle(EnumParticleTypes.SNOWBALL, (double) x + world.rand.nextDouble(), (double) (y - 2) + world.rand.nextDouble() * 3.9D, (double) z + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}
			}
		}
		return ent;
	}
}