package com.plutomc.power.client.gui;

import com.plutomc.power.Power;
import com.plutomc.power.common.containers.ContainerCombustionEngine;
import com.plutomc.power.common.tileentities.TileEntityCombustionEngine;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * plutomc_power
 * Copyright (C) 2016  Kevin Boxhoorn
 *
 * plutomc_power is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * plutomc_power is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with plutomc_power.  If not, see <http://www.gnu.org/licenses/>.
 */
@SideOnly(Side.CLIENT)
public class GuiCombustionEngine extends GuiContainer
{
	private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(Power.MOD_ID + ":textures/gui/container/engine_combustion.png");
	private final InventoryPlayer playerInventory;
	private final TileEntityCombustionEngine tileEntity;

	public GuiCombustionEngine(InventoryPlayer playerInventory, TileEntityCombustionEngine tileEntity)
	{
		super(new ContainerCombustionEngine(playerInventory, tileEntity));
		this.playerInventory = playerInventory;
		this.tileEntity = tileEntity;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		String s = tileEntity.getDisplayName().getUnformattedText();
		fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		fontRendererObj.drawString(playerInventory.getDisplayName().getUnformattedText(), 8, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1, 1, 1, 1);
		mc.getTextureManager().bindTexture(GUI_TEXTURE);
		int i = (width - xSize) / 2;
		int j = (height - ySize) / 2;
		drawTexturedModalRect(i, j, 0, 0, xSize, ySize);
	}
}
