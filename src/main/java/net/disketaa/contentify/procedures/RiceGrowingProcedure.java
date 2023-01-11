package net.disketaa.contentify.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.disketaa.contentify.block.RicePodsBlock;
import net.disketaa.contentify.ContentifyMod;

import java.util.Map;

public class RiceGrowingProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ContentifyMod.LOGGER.warn("Failed to load dependency world for procedure RiceGrowing!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ContentifyMod.LOGGER.warn("Failed to load dependency x for procedure RiceGrowing!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ContentifyMod.LOGGER.warn("Failed to load dependency y for procedure RiceGrowing!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ContentifyMod.LOGGER.warn("Failed to load dependency z for procedure RiceGrowing!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double age = 0;
		if (!((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == RicePodsBlock.block) && world.getLight(new BlockPos(x, y, z)) >= 9) {
			if (Math.random() < 0.05) {
				world.setBlockState(new BlockPos(x, y + 1, z), RicePodsBlock.block.getDefaultState(), 3);
			}
		}
	}
}
