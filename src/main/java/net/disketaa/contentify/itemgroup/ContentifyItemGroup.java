
package net.disketaa.contentify.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.disketaa.contentify.item.RiceItem;
import net.disketaa.contentify.ContentifyModElements;

@ContentifyModElements.ModElement.Tag
public class ContentifyItemGroup extends ContentifyModElements.ModElement {
	public ContentifyItemGroup(ContentifyModElements instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabcontentify") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(RiceItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
