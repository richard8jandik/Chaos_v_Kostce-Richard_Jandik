package net.rjbash.chaosvkostce.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.rjbash.chaosvkostce.ChaosvKostce;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static final Holder<ArmorMaterial> ALEXANDRITE_ARMOR_MATERIAL =
            register("alexandrite",
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 3);
                    }),
                    15,
                    0f,
                    0f,
                    () -> Ingredient.of(ModItems.ALEXANDRITE.get())
            );

    private static Holder<ArmorMaterial> register(String name,
                                                  EnumMap<ArmorItem.Type, Integer> protection,
                                                  int enchantability,
                                                  float toughness,
                                                  float knockbackResistance,
                                                  Supplier<Ingredient> ingredient) {

        ResourceLocation location =
                ResourceLocation.fromNamespaceAndPath(ChaosvKostce.MOD_ID, name);

        Holder<SoundEvent> equipSound =
                SoundEvents.ARMOR_EQUIP_IRON;

        List<ArmorMaterial.Layer> layers =
                List.of(new ArmorMaterial.Layer(location));

        return Registry.registerForHolder(
                BuiltInRegistries.ARMOR_MATERIAL,
                location,
                new ArmorMaterial(
                        protection,
                        enchantability,
                        equipSound,
                        ingredient,
                        layers,
                        toughness,
                        knockbackResistance
                )
        );
    }
}