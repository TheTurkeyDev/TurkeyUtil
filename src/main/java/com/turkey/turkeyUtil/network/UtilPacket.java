package com.turkey.turkeyUtil.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.server.MinecraftServer;

import org.apache.logging.log4j.Level;

import com.turkey.turkeyUtil.TurkeyUtil;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class UtilPacket  implements IMessage
{
	private NBTTagCompound tags;

	public UtilPacket(){
	}

	public UtilPacket(NBTTagCompound tags) 
	{
		this.tags = tags;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.tags = ByteBufUtils.readTag(buf);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeTag(buf, this.tags);
	}

	public static class HandlerServer implements IMessageHandler<UtilPacket,IMessage>
	{
		@Override
		public IMessage onMessage(UtilPacket packet, MessageContext ctx)
		{
			int id = packet.tags.hasKey("id")? packet.tags.getInteger("id") : -1;

			if(id == 1)
			{
				NBTTagCompound itemData = (NBTTagCompound) packet.tags.getTag("ItemData");
				short itemID = itemData.getShort("ItemID");
				byte stackSize = itemData.getByte("ItemStackSize");
				short itemDamage = itemData.getShort("ItemDamage");
				
				ItemStack itemstack = new ItemStack(Item.getItemById(itemID), stackSize, itemDamage);
				ItemStack itemstack1 = MinecraftServer.getServer().getEntityWorld().getPlayerEntityByName(packet.tags.getString("editor")).inventory.getCurrentItem();
				
				if (itemstack1 != null)
                {
                    if (itemstack.getItem() == itemstack1.getItem())
                    {
                    	NBTTagCompound itemTags = (NBTTagCompound)packet.tags.getTag("ItemTags");
                    	itemstack1.setTagInfo("author", new NBTTagString(itemTags.getString("author")));
                    	itemstack1.setTagInfo("authorName", new NBTTagString(itemTags.getString("authorName")));
                    	itemstack1.setTagInfo("title", new NBTTagString(itemTags.getString("title")));
                        itemstack1.setTagInfo("pages", itemTags.getTagList("pages", 8));
                    }
                    return null;
                }
			}
			else
				TurkeyUtil.logger.log(Level.ERROR, "Server received invalid packet!");
			return null;
		}
	}

	public static class HandlerClient implements IMessageHandler<UtilPacket,IMessage>
	{
		@Override
		public IMessage onMessage(UtilPacket packet, MessageContext ctx)
		{
			int id = packet.tags.hasKey("id")? packet.tags.getInteger("id") : -1;

			if(id == 1)
			{
				NBTTagCompound itemData = (NBTTagCompound) packet.tags.getTag("ItemData");
				short itemID = itemData.getShort("ItemID");
				byte stackSize = itemData.getByte("ItemStackSize");
				short itemDamage = itemData.getShort("ItemDamage");
				
				ItemStack itemstack = new ItemStack(Item.getItemById(itemID), stackSize, itemDamage);
				ItemStack itemstack1 = MinecraftServer.getServer().getEntityWorld().getPlayerEntityByName(packet.tags.getString("editor")).inventory.getCurrentItem();
				
				if (itemstack1 != null)
                {
                    if (itemstack.getItem() == itemstack1.getItem())
                    {
                    	NBTTagCompound itemTags = (NBTTagCompound)packet.tags.getTag("ItemTags");
                    	itemstack1.setTagInfo("author", new NBTTagString(itemTags.getString("author")));
                    	itemstack1.setTagInfo("authorName", new NBTTagString(itemTags.getString("authorName")));
                    	itemstack1.setTagInfo("title", new NBTTagString(itemTags.getString("title")));
                        itemstack1.setTagInfo("pages", itemTags.getTagList("pages", 8));
                    }
                    return null;
                }
			} 
			else
				TurkeyUtil.logger.log(Level.ERROR, "Received invalid packet on clientside!");
			return null;
		}
	}
}