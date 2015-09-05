package com.turkey.turkeyUtil.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.blocks.Container.LightHealingContainer;
import com.turkey.turkeyUtil.blocks.TileEntities.LightHealingTileEntity;

public class LightHealingGui extends GuiContainer
{
	private LightHealingTileEntity te;
	public static ResourceLocation texture = new ResourceLocation(TurkeyUtil.MODID + ":textures/gui/GuiLightCollector.png");

	public LightHealingGui(InventoryPlayer inventory, LightHealingTileEntity tileEntity)
	{
		super(new LightHealingContainer(inventory, tileEntity));
		te = tileEntity;
		this.xSize = 176;
		this.ySize = 165;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
	{
		this.fontRendererObj.drawString(te.getInventoryName(), 8, 70, 4210752);
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