
package net.disketaa.contentify.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.disketaa.contentify.itemgroup.ContentifyItemGroup;
import net.disketaa.contentify.ContentifyModElements;

import java.util.List;
import java.util.Collections;

@ContentifyModElements.ModElement.Tag
public class BambooStairsBlock extends ContentifyModElements.ModElement {
	@ObjectHolder("contentify:bamboo_stairs")
	public static final Block block = null;

	public BambooStairsBlock(ContentifyModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ContentifyItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(() -> new Block(Block.Properties.create(Material.WOOD).sound(SoundType.BAMBOO).hardnessAndResistance(1.5f, 6f).setLightLevel(s -> 0)
					.harvestLevel(0).harvestTool(ToolType.AXE)).getDefaultState(),
					Block.Properties.create(Material.WOOD).sound(SoundType.BAMBOO).hardnessAndResistance(1.5f, 6f).setLightLevel(s -> 0)
							.harvestLevel(0).harvestTool(ToolType.AXE));
			setRegistryName("bamboo_stairs");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
