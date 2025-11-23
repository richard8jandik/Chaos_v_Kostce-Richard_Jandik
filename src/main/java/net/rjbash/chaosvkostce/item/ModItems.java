package net.rjbash.chaosvkostce.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rjbash.chaosvkostce.ChaosvKostce;
import net.rjbash.chaosvkostce.item.custom.MagicStickItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ChaosvKostce.MOD_ID);

    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ALEXANDRITE  = ITEMS.register("raw_alexandrite",
            () -> new Item(new Item.Properties()));

    // Tools
    public static final RegistryObject<Item> MAGICK_STICK = ITEMS.register("magic_stick",
            () -> new MagicStickItem(new Item.Properties().durability(64)));
    public static final RegistryObject<Item> KATANA  = ITEMS.register("katana",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}
