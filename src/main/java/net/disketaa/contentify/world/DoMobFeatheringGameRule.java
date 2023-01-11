package net.disketaa.contentify.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import net.disketaa.contentify.ContentifyModElements;

import java.lang.reflect.Method;

@ContentifyModElements.ModElement.Tag
public class DoMobFeatheringGameRule extends ContentifyModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.BooleanValue> gamerule = GameRules.register("doMobFeathering", GameRules.Category.DROPS,
			create(true));

	public DoMobFeatheringGameRule(ContentifyModElements instance) {
		super(instance, 42);
	}

	public static GameRules.RuleType<GameRules.BooleanValue> create(boolean defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.BooleanValue.class, "func_223568_b", boolean.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.BooleanValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
