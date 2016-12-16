package com.plutomc.power.init;

import com.plutomc.core.common.crafting.QuernStoneRecipes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

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
public class RecipeRegistry
{
	public static void init()
	{
		registerQuernGrinding();
	}

	private static void registerQuernGrinding()
	{
		QuernStoneRecipes.instance().addGrinding(new ItemStack(Items.QUARTZ), new ItemStack(ItemRegistry.SILICA));
	}
}
