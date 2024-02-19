package net.mcreator.directionalturntable.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class DirectionalTurntableRedstoneOnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BlockState above = Blocks.AIR.defaultBlockState();
		BlockState above0 = Blocks.AIR.defaultBlockState();
		Direction dir = Direction.NORTH;
		int dirInt = world instanceof Level _lvl_getIndPow ? _lvl_getIndPow.getBestNeighborSignal(new BlockPos(x, y, z)) : 0;
		above0 = (world.getBlockState(new BlockPos(x, y + 1, z)));
		BlockPos posAbove = new BlockPos(x, y + 1, z);
		if (above0.getBlock().getStateDefinition().getProperty("rotation") instanceof IntegerProperty propR && propR.getPossibleValues().contains(dirInt)) {
			world.setBlock(posAbove, above0.setValue(propR, dirInt), 3);
		} else {
			if (dirInt <= 7) {
				dir = dirInt <= 3 ? Direction.SOUTH : Direction.WEST;
			} else {
				dir = dirInt <= 11 ? Direction.NORTH : Direction.EAST;
			}
			Property<?> _property = above0.getBlock().getStateDefinition().getProperty("facing");
			if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(dir)) {
				world.setBlock(posAbove, above0.setValue(_dp, dir), 3);
			} else {
				_property = above0.getBlock().getStateDefinition().getProperty("axis");
				if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(dir)) {
					world.setBlock(posAbove, above0.setValue(_ap, dir.getAxis()), 3);
				}
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.fail")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.fail")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
	}
}
