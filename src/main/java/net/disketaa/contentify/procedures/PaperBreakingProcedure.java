package net.disketaa.contentify.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.BlockState;

import net.disketaa.contentify.ContentifyMod;

import java.util.Map;

public class PaperBreakingProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ContentifyMod.LOGGER.warn("Failed to load dependency world for procedure PaperBreaking!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ContentifyMod.LOGGER.warn("Failed to load dependency x for procedure PaperBreaking!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ContentifyMod.LOGGER.warn("Failed to load dependency y for procedure PaperBreaking!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ContentifyMod.LOGGER.warn("Failed to load dependency z for procedure PaperBreaking!");
			return;
		}
		if (dependencies.get("blockstate") == null) {
			if (!dependencies.containsKey("blockstate"))
				ContentifyMod.LOGGER.warn("Failed to load dependency blockstate for procedure PaperBreaking!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		BlockState blockstate = (BlockState) dependencies.get("blockstate");
		if (!world.isRemote()) {
			if ((new Object() {
				public boolean get(BlockState _bs, String _property) {
					Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
					return _prop instanceof BooleanProperty ? _bs.get((BooleanProperty) _prop) : false;
				}
			}.get(blockstate, "powered")) == true) {
				world.destroyBlock(new BlockPos(x, y, z), false);
			}
		}
	}
}
