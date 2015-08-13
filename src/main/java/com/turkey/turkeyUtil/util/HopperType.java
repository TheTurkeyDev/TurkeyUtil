package com.turkey.turkeyUtil.util;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.google.common.collect.Lists;

public class HopperType
{
	
	private static List<HopperType> hopperTypes = Lists.newArrayList();
	
	private String name;
	private int slots;
	private int speed;
	private int stackSize;
	private Block block;
	private Item item;
	
	public HopperType(String name, int slots, int speed, int stackSize, Block block, Item item)
	{
		this.name = name;
		this.slots = slots;
		this.speed = speed;
		this.stackSize = stackSize;
		this.block = block;
		this.item = item;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getInventorySlots()
	{
		return this.slots;
	}
	
	public int getTransferSpeed()
	{
		return this.speed;
	}
	
	public int getMaxStackSize()
	{
		return this.stackSize;
	}
	
	public Block getBlock()
	{
		return block;
	}
	
	public Item getItem()
	{
		return item;
	}
	
	public static HopperType createNewHopperType(String name, int slots, int speed, int stackSize, Block block, Item item)
	{
		HopperType hopper = new HopperType(name, slots, speed, stackSize, block, item);
		hopperTypes.add(hopper);
		return hopper;
	}
	
	public static HopperType getHopperTypeFromName(String name)
	{
		for(HopperType h : hopperTypes)
			if(h.getName().equalsIgnoreCase(name))
				return h;
		return null;
	}
	
	public static List<HopperType> getHopperTypes()
	{
		return hopperTypes;
	}
}
