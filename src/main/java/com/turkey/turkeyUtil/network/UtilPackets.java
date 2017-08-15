package com.turkey.turkeyUtil.network;

import com.theprogrammingturkey.gobblecore.network.INetworkHandler;
import com.theprogrammingturkey.gobblecore.network.NetworkLoader;

import net.minecraftforge.fml.relauncher.Side;

public class UtilPackets implements INetworkHandler
{
	@Override
	public void registerPacket(NetworkLoader loader)
	{
		loader.registerPacket(UtilPacket.HandlerServer.class, UtilPacket.class, Side.SERVER);
		loader.registerPacket(UtilPacket.HandlerClient.class, UtilPacket.class, Side.CLIENT);
	}
}