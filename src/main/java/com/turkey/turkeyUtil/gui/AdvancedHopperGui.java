package com.turkey.turkeyUtil.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.turkey.turkeyUtil.TurkeyUtil;
import com.turkey.turkeyUtil.blocks.Container.AdvancedHopperContainer;
import com.turkey.turkeyUtil.blocks.TileEntities.AdvancedHopperTileEntity;

public class AdvancedHopperGui extends GuiContainer
{
	private AdvancedHopperTileEntity hopper;
	public static ResourceLocation textureFive = new ResourceLocation(TurkeyUtil.MODID + ":textures/gui/hopper5Slot.png");
	public static ResourceLocation textureTen = new ResourceLocation(TurkeyUtil.MODID + ":textures/gui/hopper10Slot.png");

	public AdvancedHopperGui(InventoryPlayer inventory, AdvancedHopperTileEntity tileEntity)
	{
		super(new AdvancedHopperContainer(inventory, tileEntity));
		hopper = tileEntity;
		this.xSize = 176;
		this.ySize = 165;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
	{
		this.fontRendererObj.drawString(hopper.getInventoryName(), 8, 6, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
	{
		if(hopper.getSizeInventory() <= 5)
			Minecraft.getMinecraft().getTextureManager().bindTexture(textureFive);
		else
			Minecraft.getMinecraft().getTextureManager().bindTexture(textureTen);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
	}
}