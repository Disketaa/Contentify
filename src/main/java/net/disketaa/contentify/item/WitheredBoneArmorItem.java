
package net.disketaa.contentify.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;

import net.disketaa.contentify.itemgroup.ContentifyItemGroup;
import net.disketaa.contentify.ContentifyModElements;

import java.util.List;

@ContentifyModElements.ModElement.Tag
public class WitheredBoneArmorItem extends ContentifyModElements.ModElement {
	@ObjectHolder("contentify:withered_bone_helmet")
	public static final Item helmet = null;
	@ObjectHolder("contentify:withered_bone_chestplate")
	public static final Item body = null;
	@ObjectHolder("contentify:withered_bone_leggings")
	public static final Item legs = null;
	@ObjectHolder("contentify:withered_bone_boots")
	public static final Item boots = null;

	public WitheredBoneArmorItem(ContentifyModElements instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 16;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 4, 2, 1}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 4;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
						.getValue(new ResourceLocation("contentify:item.armor.equip_bone"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(WitheredBoneItem.block));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "withered_bone";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};
		elements.items.add(
				() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ContentifyItemGroup.tab).isImmuneToFire()) {
					@Override
					public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
						super.addInformation(itemstack, world, list, flag);
						list.add(new StringTextComponent(""));
						list.add(new TranslationTextComponent ("item.modifiers.fullset"));
						list.add(new TranslationTextComponent ("attribute.name.generic.armor_withering"));
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "contentify:textures/models/armor/withered_bone___layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}
				}.setRegistryName("withered_bone_helmet"));
		elements.items.add(
				() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ContentifyItemGroup.tab).isImmuneToFire()) {
					@Override
					public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
						super.addInformation(itemstack, world, list, flag);
						list.add(new StringTextComponent(""));
						list.add(new TranslationTextComponent ("item.modifiers.fullset"));
						list.add(new TranslationTextComponent ("attribute.name.generic.armor_withering"));
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "contentify:textures/models/armor/withered_bone___layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}
				}.setRegistryName("withered_bone_chestplate"));
		elements.items.add(
				() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(ContentifyItemGroup.tab).isImmuneToFire()) {
					@Override
					public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
						super.addInformation(itemstack, world, list, flag);
						list.add(new StringTextComponent(""));
						list.add(new TranslationTextComponent ("item.modifiers.fullset"));
						list.add(new TranslationTextComponent ("attribute.name.generic.armor_withering"));

					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "contentify:textures/models/armor/withered_bone___layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}
				}.setRegistryName("withered_bone_leggings"));
		elements.items.add(
				() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ContentifyItemGroup.tab).isImmuneToFire()) {
					@Override
					public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
						super.addInformation(itemstack, world, list, flag);
						list.add(new StringTextComponent(""));
						list.add(new TranslationTextComponent ("item.modifiers.fullset"));
						list.add(new TranslationTextComponent ("attribute.name.generic.armor_withering"));
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "contentify:textures/models/armor/withered_bone___layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}
				}.setRegistryName("withered_bone_boots"));
	}

}
