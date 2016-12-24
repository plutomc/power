package com.plutomc.power.common.containers;

import com.plutomc.power.common.containers.slots.SlotCombustionEngineFuel;
import com.plutomc.power.common.containers.slots.SlotCombustionEngineSpark;
import com.plutomc.power.common.tileentities.TileEntityCombustionEngine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

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
public class ContainerCombustionEngine extends Container
{
	private TileEntityCombustionEngine tileEntity;

	public ContainerCombustionEngine(InventoryPlayer playerInventory, TileEntityCombustionEngine tileEntity)
	{
		this.tileEntity = tileEntity;

		addSlotToContainer(new SlotCombustionEngineSpark(tileEntity, 0, 80, 17));
		addSlotToContainer(new SlotCombustionEngineFuel(tileEntity, 1, 57, 26));

		for (int i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int k = 0; k < 9; ++k)
		{
			addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
		}

	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn)
	{
		return tileEntity.isUsableByPlayer(playerIn);
	}

	@Nonnull
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{
		ItemStack defaultStack = ItemStack.EMPTY;
		Slot slot = inventorySlots.get(index);

		if (slot != null && slot.getHasStack())
		{
			ItemStack stack = slot.getStack();
			defaultStack = stack.copy();

			if (index > 1)
			{
				if (SlotCombustionEngineSpark.isItemSpark(stack))
				{
					if (!mergeItemStack(stack, 0, 1, false))
					{
						return ItemStack.EMPTY;
					}
				}
				else if (SlotCombustionEngineFuel.isItemFuel(stack))
				{
					if (!mergeItemStack(stack, 1, 2, false))
					{
						return ItemStack.EMPTY;
					}
				}
				else if (index >= 2 && index < 29)
				{
					if (!mergeItemStack(stack, 29, 38, false))
					{
						return ItemStack.EMPTY;
					}
				}
				else if (index >= 29 && index < 38 && !mergeItemStack(stack, 2, 29, false))
				{
					return ItemStack.EMPTY;
				}
			}
			else if (!mergeItemStack(stack, 2, 38, false))
			{
				return ItemStack.EMPTY;
			}

			if (stack.isEmpty())
			{
				slot.putStack(ItemStack.EMPTY);
			}
			else
			{
				slot.onSlotChanged();
			}

			if (stack.getCount() == defaultStack.getCount())
			{
				return ItemStack.EMPTY;
			}

			slot.onTake(playerIn, stack);
		}

		return defaultStack;
	}

	@Override
	public void updateProgressBar(int id, int data)
	{
		tileEntity.setField(id, data);
	}

	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
	}

	@Override
	public void addListener(IContainerListener listener)
	{
		super.addListener(listener);
		listener.sendAllWindowProperties(this, tileEntity);
	}
}
