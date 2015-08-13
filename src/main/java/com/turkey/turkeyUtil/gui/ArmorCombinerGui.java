package com.turkey.turkeyUtil.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import com.turkey.turkeyUtil.blocks.Container.ArmorCombinerContainer;
import com.turkey.turkeyUtil.blocks.TileEntities.ArmorCombinerTileEntity;

public class ArmorCombinerGui extends GuiContainer
{

	public static ResourceLocation texture = new ResourceLocation("turkeyutil:textures/gui/GuiArmorCombiner.png");

	public ArmorCombinerGui(InventoryPlayer inventory, ArmorCombinerTileEntity tileEntity, World world)
	{
		super(new ArmorCombinerContainer(inventory, tileEntity, world));
		this.xSize = 176;
		this.ySize = 165;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
	{
		this.fontRendererObj.drawString("Armor Combiner", 8, 6, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
	}
}