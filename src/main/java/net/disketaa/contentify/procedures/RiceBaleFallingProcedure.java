package net.disketaa.contentify.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.disketaa.contentify.block.RiceBaleBlock;
import net.disketaa.contentify.ContentifyMod;

import java.util.Map;
import java.util.HashMap;

public class RiceBaleFallingProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityFall(LivingFallEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				double damagemultiplier = event.getDamageMultiplier();
				double distance = event.getDistance();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("damagemultiplier", damagemultiplier);
				dependencies.put("distance", distance);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ContentifyMod.LOGGER.warn("Failed to load dependency world for procedure RiceBaleFalling!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ContentifyMod.LOGGER.warn("Failed to load dependency entity for procedure RiceBaleFalling!");
			return;
		}
		if (dependencies.get("distance") == null) {
			if (!dependencies.containsKey("distance"))
				ContentifyMod.LOGGER.warn("Failed to load dependency distance for procedure RiceBaleFalling!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		double distance = dependencies.get("distance") instanceof Integer
				? (int) dependencies.get("distance")
				: (double) dependencies.get("distance");
		if ((world.getBlockState(new BlockPos(entity.getPosX(), entity.getPosY() - 1, entity.getPosZ()))).getBlock() == RiceBaleBlock.block) {
			if (distance > 3) {
				if (dependencies.get("event") != null) {
					Object _obj = dependencies.get("event");
					if (_obj instanceof Event) {
						Event _evt = (Event) _obj;
						if (_evt.isCancelable())
							_evt.setCanceled(true);
					}
				}
				entity.attackEntityFrom(DamageSource.FALL, (float) (distance / 5));
			}
		}
	}
}
