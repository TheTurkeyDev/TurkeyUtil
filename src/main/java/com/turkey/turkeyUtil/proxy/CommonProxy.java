package com.turkey.turkeyUtil.proxy;

import com.theprogrammingturkey.gobblecore.proxy.IBaseProxy;

import net.minecraft.entity.player.EntityPlayer;

public class CommonProxy implements IBaseProxy
{

	public boolean isClient()
	{
		return false;
	}

	public void registerGuis()
	{

	}

	public void registerRenderings()
	{

	}
	
	public void registerEvents()
	{
		
	}

	@Override
	public EntityPlayer getClientPlayer()
	{
		return null;
	}
}
