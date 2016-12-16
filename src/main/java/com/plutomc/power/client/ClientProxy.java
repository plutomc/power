package com.plutomc.power.client;

import com.plutomc.core.common.ICommonProxy;
import com.plutomc.power.init.ItemRegistry;

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
public class ClientProxy implements ICommonProxy
{
	@Override
	public void preInit()
	{
		ItemRegistry.registerRenders();
	}

	@Override
	public void init()
	{

	}

	@Override
	public void postInit()
	{

	}
}
