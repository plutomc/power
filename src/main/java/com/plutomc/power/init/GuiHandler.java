package com.plutomc.power.init;

import com.plutomc.power.client.gui.GuiCombustionEngine;
import com.plutomc.power.common.containers.ContainerCombustionEngine;
import com.plutomc.power.common.tileentities.TileEntityCombustionEngine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

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
public class GuiHandler implements IGuiHandler
{
	public static final int ENGINE_COMBUSTION = 0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = getTileInventory(world, x, y, z);

		switch (ID)
		{
			case ENGINE_COMBUSTION:
				return tileEntity instanceof TileEntityCombustionEngine ? new ContainerCombustionEngine(player.inventory, (TileEntityCombustionEngine) tileEntity) : null;
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = getTileInventory(world, x, y, z);

		switch (ID)
		{
			case ENGINE_COMBUSTION:
				return tileEntity instanceof TileEntityCombustionEngine ? new GuiCombustionEngine(player.inventory, (TileEntityCombustionEngine) tileEntity) : null;
			default:
				return null;
		}
	}

	private TileEntity getTileInventory(World world, int x, int y, int z)
	{
		return world.getTileEntity(new BlockPos(x, y, z));
	}
}
