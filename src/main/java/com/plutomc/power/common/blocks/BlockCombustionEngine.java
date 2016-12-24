package com.plutomc.power.common.blocks;

import com.plutomc.core.common.blocks.BlockMetal;
import com.plutomc.power.Power;
import com.plutomc.power.common.tileentities.TileEntityCombustionEngine;
import com.plutomc.power.init.BlockRegistry;
import com.plutomc.power.init.GuiHandler;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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
public class BlockCombustionEngine extends BlockMetal implements ITileEntityProvider
{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public BlockCombustionEngine()
	{
		super(BlockRegistry.Data.COMBUSTION_ENGINE);
		setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	@Nonnull
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, FACING);
	}

	@Nonnull
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand)
	{
		return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Nonnull
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(FACING).getIndex();
	}

	@Nullable
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityCombustionEngine();
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		TileEntity tileEntity = worldIn.getTileEntity(pos);
		if (tileEntity instanceof TileEntityCombustionEngine)
		{
			InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityCombustionEngine) tileEntity);
			worldIn.updateComparatorOutputLevel(pos, this);
		}

		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (!worldIn.isRemote)
		{
			playerIn.openGui(Power.instance(), GuiHandler.ENGINE_COMBUSTION, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}

		return true;
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		TileEntity tileEntity = worldIn.getTileEntity(pos);
		if (tileEntity instanceof TileEntityCombustionEngine)
		{
			((TileEntityCombustionEngine) tileEntity).setCustomName(stack.getDisplayName());
		}
	}
}
