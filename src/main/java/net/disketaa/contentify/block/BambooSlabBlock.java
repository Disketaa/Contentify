
package net.disketaa.contentify.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.disketaa.contentify.itemgroup.ContentifyItemGroup;
import net.disketaa.contentify.ContentifyModElements;

@ContentifyModElements.ModElement.Tag
public class BambooSlabBlock extends ContentifyModElements.ModElement {
	@ObjectHolder("contentify:bamboo_slab")
	public static final Block block = null;

	public BambooSlabBlock(ContentifyModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ContentifyItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends SlabBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.BAMBOO).hardnessAndResistance(1.5f, 6f).setLightLevel(s -> 0).harvestLevel(0)
					.harvestTool(ToolType.AXE));
			setRegistryName("bamboo_slab");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}
	}
}
