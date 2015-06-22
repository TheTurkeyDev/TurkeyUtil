package com.turkey.turkeyUtil.Mobs;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.turkey.turkeyUtil.TurkeyUtil;

import cpw.mods.fml.common.registry.EntityRegistry;

public class UtilMobs 
{

	
	public static void loadMobs()
	{
		createEntity(EntityTurkey.class, "Turkey" , 0x522900, 0xE68A00);
		createEntity(EntityDuck.class, "Duck" , 0xA65300, 0x005300);
		createEntity(EntityRhea.class, "Rhea" , 0x291400, 0x694016);
		createEntity(EntityVoxel.class, "Voxel" , 0x999999, 0xEBEBEB);
		//createHostileEntity(EntityPoisonSkeleton.class, "Poison_Skeleton" , 0xCCCCCC, 0x009933);
		createHostileEntity(EntityDamageSkeleton.class, "Damage_Skeleton" , 0xCCCCCC, 0x800000);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor)
	{
		int id = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
		EntityRegistry.registerModEntity(entityClass, entityName, id, TurkeyUtil.instance, 64, 1, true);
		EntityRegistry.addSpawn(entityClass, 5, 5, 5, EnumCreatureType.creature, BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.forestHills, BiomeGenBase.roofedForest);
		
		EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, solidColor, spotColor));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void createHostileEntity(Class entityClass, String entityName, int solidColor, int spotColor)
	{
		int id = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
		EntityRegistry.registerModEntity(entityClass, entityName, id, TurkeyUtil.instance, 64, 1, true);
		EntityRegistry.addSpawn(entityClass, 10, 5, 5, EnumCreatureType.monster);
		
		EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, solidColor, spotColor));
	}
}
