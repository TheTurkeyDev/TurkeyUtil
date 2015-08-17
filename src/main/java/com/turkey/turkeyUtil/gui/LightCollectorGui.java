package com.turkey.turkeyUtil.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.blocks.Container.LightCollectorContainer;
import com.turkey.turkeyUtil.blocks.TileEntities.LightCollectorTileEntity;

public class LightCollectorGui extends GuiContainer
{
	private LightCollectorTileEntity te;
	public static ResourceLocation texture = new ResourceLocation(TurkeyUtil.MODID + ":textures/gui/GuiLightCollector.png");

	public LightCollectorGui(InventoryPlayer inventory, LightCollectorTileEntity tileEntity)
	{
		super(new LightCollectorContainer(inventory, tileEntity));
		te = tileEntity;
		this.xSize = 176;
		this.ySize = 165;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
	{
		this.fontRendererObj.drawString(te.getInventoryName(), 8, 70, 4210752);
		this.fontRendererObj.drawString(te.getCollectorStatus(), (this.xSize / 2) - (this.fontRendererObj.getStringWidth(te.getCollectorStatus()) / 2), 5, 4210752);
		this.fontRendererObj.drawString("Progress: " + te.getCollectorProgress() + "%", (this.xSize / 2) - (this.fontRendererObj.getStringWidth("Progress: " + te.getCollectorProgress() + "%") / 2), 15, 4210752);
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