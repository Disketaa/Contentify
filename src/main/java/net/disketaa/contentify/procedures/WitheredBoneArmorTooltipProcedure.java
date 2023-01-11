package net.disketaa.contentify.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.disketaa.contentify.ContentifyMod;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class WitheredBoneArmorTooltipProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void onItemTooltip(ItemTooltipEvent event) {
			if (event != null && event.getPlayer() != null) {
				Entity entity = event.getPlayer();
				ItemStack itemStack = event.getItemStack();
				List<ITextComponent> tooltip = event.getToolTip();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("tooltip", tooltip);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				dependencies.put("itemstack", itemStack);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				ContentifyMod.LOGGER.warn("Failed to load dependency itemstack for procedure WitheredBoneArmorTooltip!");
			return;
		}
		if (dependencies.get("tooltip") == null) {
			if (!dependencies.containsKey("tooltip"))
				ContentifyMod.LOGGER.warn("Failed to load dependency tooltip for procedure WitheredBoneArmorTooltip!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		List<ITextComponent> tooltip = (List<ITextComponent>) dependencies.get("tooltip");
		if (ItemTags.getCollection().getTagByID(new ResourceLocation("contentify:withered_bone_armor")).contains(itemstack.getItem())) {
			tooltip.add(new StringTextComponent(""));
			tooltip.add(new StringTextComponent((new TranslationTextComponent("item.modifiers.fullset").getString())));
			tooltip.add(new StringTextComponent((new TranslationTextComponent("attribute.name.generic.armor_withering").getString())));
		}
	}
}
