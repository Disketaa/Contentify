
package net.disketaa.contentify.village;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicTrade;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.entity.merchant.villager.VillagerProfession;

import net.disketaa.contentify.item.RiceItem;
import net.disketaa.contentify.item.RiceBallItem;
import net.disketaa.contentify.block.RiceSeedsBlock;

import java.util.List;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RiceTradeTrade {
	@SubscribeEvent
	public static void registerWanderingTrades(WandererTradesEvent event) {
		event.getGenericTrades().add(new BasicTrade(new ItemStack(Items.EMERALD), new ItemStack(RiceSeedsBlock.block), 12, 5, 0.05f));
		event.getGenericTrades().add(new BasicTrade(new ItemStack(Items.EMERALD, (int) (2)), new ItemStack(RiceBallItem.block), 10, 5, 0.05f));
	}

	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
		if (event.getType() == VillagerProfession.FARMER) {
			trades.get(1).add(new BasicTrade(new ItemStack(RiceItem.block, (int) (18)), new ItemStack(Items.EMERALD), 14, 2, 0.05f));
		}
	}
}
