package com.plutomc.power.init;

import com.plutomc.core.common.data.IDataItem;
import com.plutomc.core.common.items.BaseItem;
import net.minecraft.creativetab.CreativeTabs;

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
public class ItemRegistry
{
	public enum Data implements IDataItem
	{
		SILICA("silica", null, CreativeTabs.MATERIALS),
		SILICON("silicon", null, CreativeTabs.MATERIALS);

		private final String name;
		private final String oreDictName;
		private final CreativeTabs tab;

		Data(String name, String oreDictName, CreativeTabs tab)
		{
			this.name = name;
			this.oreDictName = oreDictName;
			this.tab = tab;
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
	}

	public static final BaseItem SILICA = new BaseItem(Data.SILICA);
	public static final BaseItem SILICON = new BaseItem(Data.SILICON);

	public static void preInit()
	{
		register(SILICA);
		register(SILICON);
	}

	private static void register(BaseItem item)
	{
		com.plutomc.core.init.ItemRegistry.register(item);
	}

	public static void registerRenders()
	{
		registerRender(SILICA);
		registerRender(SILICON);
	}

	private static void registerRender(BaseItem item)
	{
		com.plutomc.core.init.ItemRegistry.registerRender(item);
	}
}
