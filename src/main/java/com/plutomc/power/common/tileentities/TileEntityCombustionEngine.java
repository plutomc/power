package com.plutomc.power.common.tileentities;

import com.plutomc.core.common.tileentities.BaseTileEntityInventory;
import com.plutomc.power.init.BlockRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

import javax.annotation.Nonnull;

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
public class TileEntityCombustionEngine extends BaseTileEntityInventory
{
	private static final int[] SLOTS_TOP = new int[] { 0 };
	private static final int[] SLOTS_SIDES = new int[] { 1 };
	private static final int[] SLOTS_BOTTOM = new int[0];

	public TileEntityCombustionEngine()
	{
		super(BlockRegistry.Data.COMBUSTION_ENGINE);
	}

	@Override
	public String getDefaultName()
	{
		return "plutomc_power:engine_combustion";
	}

	@Nonnull
	@Override
	public int[] getSlotsForFace(EnumFacing side)
	{
		return side == EnumFacing.DOWN ? SLOTS_BOTTOM : (side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES);
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
	{
		return isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
	{
		return true;
	}

	@Override
	public int getSizeInventory()
	{
		return 2;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack)
	{
		ItemStack itemStack = getStackInSlot(index);
		boolean flag = !stack.isEmpty() && stack.isItemEqual(itemStack) && ItemStack.areItemStackTagsEqual(stack, itemStack);
		setStackInSlot(index, stack);

		if (stack.getCount() > getInventoryStackLimit())
		{
			stack.setCount(getInventoryStackLimit());
		}

		if (!flag)
		{
			markDirty();
		}
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		//  TODO: Move checks to Slots.
		if (index == 0)
		{
			return stack.isItemEqual(new ItemStack(Items.COAL));
		}
		else
		{
			return stack.isItemEqual(new ItemStack(Items.FLINT));
		}
	}

	@Override
	public int getField(int id)
	{
		return 0;
	}

	@Override
	public void setField(int id, int value)
	{

	}

	@Override
	public int getFieldCount()
	{
		return 0;
	}

	@Override
	public void update()
	{

	}
}
