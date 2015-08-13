package com.turkey.turkeyUtil.blocks.Agriculture;

import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import com.turkey.turkeyUtil.Items.food.UtilFood;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LimePlant extends TurkeyPlant
{

    public LimePlant()
    {
        setBlockName("Lime_Plant");
        setBlockTextureName("turkeyUtil:Lime_Stage_1");
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(int parMetadata, int parFortune, Random parRand)
    {
        return (parMetadata/2);
    }

    @Override
    public Item getItemDropped(int parMetadata, Random parRand, int parFortune)  
    {
        return UtilFood.lime;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister parIIconRegister)
    {
          iIcon = new IIcon[maxGrowthStage+1];
          iIcon[0] = parIIconRegister.registerIcon("turkeyUtil:Lime_Stage_1");
          iIcon[1] = parIIconRegister.registerIcon("turkeyUtil:Lime_Stage_1");
          iIcon[2] = parIIconRegister.registerIcon("turkeyUtil:Lime_Stage_1");
          iIcon[3] = parIIconRegister.registerIcon("turkeyUtil:Lime_Stage_2");
          iIcon[4] = parIIconRegister.registerIcon("turkeyUtil:Lime_Stage_2");
          iIcon[5] = parIIconRegister.registerIcon("turkeyUtil:Lime_Stage_3");
          iIcon[6] = parIIconRegister.registerIcon("turkeyUtil:Lime_Stage_3");
          iIcon[7] = parIIconRegister.registerIcon("turkeyUtil:Lime_Stage_4");
    }
}