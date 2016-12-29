package com.plutomc.power.init;

import com.plutomc.core.common.crafting.AlloyFurnaceRecipes;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

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
		registerAlloySmelting();
		registerQuernGrinding();
	}

	private static void registerAlloySmelting()
	{
		AlloyFurnaceRecipes.instance().addSmeltingRecipe(new ArrayList<ItemStack>() {{
			add(new ItemStack(com.plutomc.core.init.ItemRegistry.SILICA));
			add(new ItemStack(com.plutomc.core.init.ItemRegistry.ASH));
		}}, new ItemStack(ItemRegistry.SILICON), 1.4f);
	}

	private static void registerQuernGrinding()
	{
	}
}
