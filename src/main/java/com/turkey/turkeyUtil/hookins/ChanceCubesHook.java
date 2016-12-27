package com.turkey.turkeyUtil.hookins;

import com.theprogrammingturkey.gobblecore.modhooks.BaseModHook;
import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.blocks.UtilBlocks;

import chanceCubes.registry.ChanceCubeRegistry;
import chanceCubes.rewards.defaultRewards.BasicReward;
import chanceCubes.rewards.rewardparts.EntityPart;
import chanceCubes.rewards.rewardparts.ItemPart;
import chanceCubes.rewards.type.EntityRewardType;
import chanceCubes.rewards.type.ItemRewardType;
import net.minecraft.item.ItemStack;

public class ChanceCubesHook extends BaseModHook
{
	public ChanceCubesHook()
	{
		super("chancecubes");
	}

	@Override
	public void initHook()
	{
		ChanceCubeRegistry.INSTANCE.registerReward(new BasicReward(TurkeyUtil.MODID + ":Gertrude", 50, new EntityRewardType(new EntityPart("{id:\"Duck\",CustomName:\"Gertrud\",CustomNameVisible:1,ActiveEffects:[{Id:11,Amplifier:100,Duration:999999999,ShowParticles:1b}]}"))));
		ChanceCubeRegistry.INSTANCE.registerReward(new BasicReward(TurkeyUtil.MODID + ":Hex_Compressed_Coal", 100, new ItemRewardType(new ItemPart(new ItemStack(UtilBlocks.hextuplecompressedCoal, 1)))));
	}
}
