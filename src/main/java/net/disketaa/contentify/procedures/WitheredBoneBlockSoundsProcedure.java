package net.disketaa.contentify.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.state.EnumProperty;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.disketaa.contentify.ContentifyMod;

import java.util.Map;

public class WitheredBoneBlockSoundsProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ContentifyMod.LOGGER.warn("Failed to load dependency world for procedure WitheredBoneBlockSounds!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ContentifyMod.LOGGER.warn("Failed to load dependency x for procedure WitheredBoneBlockSounds!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ContentifyMod.LOGGER.warn("Failed to load dependency y for procedure WitheredBoneBlockSounds!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ContentifyMod.LOGGER.warn("Failed to load dependency z for procedure WitheredBoneBlockSounds!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.NOTE_BLOCK) {
			{
				String _value = "xylophone";
				BlockPos _pos = new BlockPos(x, y + 1, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateContainer().getProperty("instrument");
				if (_property instanceof EnumProperty && _property.parseValue(_value).isPresent())
					world.setBlockState(_pos, _bs.with((EnumProperty) _property, (Enum) _property.parseValue(_value).get()), 3);
			}
		}
	}
}
