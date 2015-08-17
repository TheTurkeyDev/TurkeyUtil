package com.turkey.turkeyUtil.hookins;

import net.minecraft.item.ItemStack;
import chanceCubes.registry.ChanceCubeRegistry;
import chanceCubes.rewards.BasicReward;
import chanceCubes.rewards.type.EntityRewardType;
import chanceCubes.rewards.type.ItemRewardType;

import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.blocks.UtilBlocks;

public class ChanceCubesHook extends UtilHookin
{

	@Override
	public void load()
	{
		ChanceCubeRegistry.INSTANCE.registerReward(new BasicReward(TurkeyUtil.MODID + ":Gertrude", 50, new EntityRewardType("{id:\"Duck\",CustomName:\"Gertrude\",CustomNameVisible:1,ActiveEffects:[{Id:11,Amplifier:100,Duration:999999999,ShowParticles:1b}]}")));
		ChanceCubeRegistry.INSTANCE.registerReward(new BasicReward(TurkeyUtil.MODID + ":Hex_Compressed_Coal", 100, new ItemRewardType(new ItemStack(UtilBlocks.hextuplecompressedCoal, 1))));
	}
}
