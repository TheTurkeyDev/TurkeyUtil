package com.turkey.turkeyUtil.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class ClientProxy extends CommonProxy
{

	@Override
	public boolean isClient()
	{
		return true;
	}

	public void registerGuis()
	{
		super.registerGuis();
	}

	public void registerRenderings()
	{
		super.registerRenderings();
	}

	public void registerEvents()
	{
		super.registerEvents();
	}

	@Override
	public EntityPlayer getClientPlayer()
	{
		return Minecraft.getMinecraft().thePlayer;
	}
}
