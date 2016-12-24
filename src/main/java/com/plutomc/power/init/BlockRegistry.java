package com.plutomc.power.init;

import com.plutomc.core.common.data.IDataBlock;
import com.plutomc.core.common.items.BaseItemBlock;
import com.plutomc.power.Power;
import com.plutomc.power.common.blocks.BlockCombustionEngine;
import com.plutomc.power.common.tileentities.TileEntityCombustionEngine;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;

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
public class BlockRegistry
{
	public enum Data implements IDataBlock
	{
		COMBUSTION_ENGINE("engine_combustion", null, CreativeTabs.DECORATIONS, Material.ANVIL, TileEntityCombustionEngine.class);

		private final String name;
		private final String oreDictName;
		private final CreativeTabs tab;
		private final Material material;
		private final Class<? extends TileEntity> tileEntity;
		private int tileEntityID;

		Data(String name, String oreDictName, CreativeTabs tab, Material material, Class<? extends TileEntity> tileEntity)
		{
			this.name = name;
			this.oreDictName = oreDictName;
			this.tab = tab;
			this.material = material;
			this.tileEntity = tileEntity;
		}

		@Override
		public String getUnlocalizedName()
		{
			return name;
		}

		@Override
		public String getRegistryName()
		{
			return name;
		}

		@Override
		public String getOreDictName()
		{
			return oreDictName;
		}

		@Override
		public CreativeTabs getCreativeTab()
		{
			return tab;
		}

		@Override
		public Material getMaterial()
		{
			return material;
		}

		@Override
		public Class<? extends TileEntity> getTileEntityClass()
		{
			return tileEntity;
		}

		@Override
		public String getTileEntityName()
		{
			return Power.MOD_ID + ":" + getRegistryName() + "_tileentity";
		}

		@Override
		public void setTileEntityID(int tileEntityID)
		{
			this.tileEntityID = tileEntityID;
		}

		@Override
		public int getTileEntityID()
		{
			return tileEntityID;
		}
	}

	public static final BaseItemBlock COMBUSTION_ENGINE = new BaseItemBlock(new BlockCombustionEngine());

	public static void preInit()
	{
		register(COMBUSTION_ENGINE);
	}

	private static void register(BaseItemBlock block)
	{
		com.plutomc.core.init.BlockRegistry.register(block);
	}

	public static void registerRenders()
	{
		registerRender(COMBUSTION_ENGINE);
	}

	private static void registerRender(BaseItemBlock block)
	{
		com.plutomc.core.init.BlockRegistry.registerRender(block);
	}
}
