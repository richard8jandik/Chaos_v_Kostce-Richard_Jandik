package net.rjbash.chaosvkostce.block;

import com.google.common.base.Supplier;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rjbash.chaosvkostce.ChaosvKostce;
import net.rjbash.chaosvkostce.block.custom.RichardBlock;
import net.rjbash.chaosvkostce.item.ModItems;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ChaosvKostce.MOD_ID);

    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> MICROFON = registerBlock("microfon",
            () -> new Block(BlockBehaviour.Properties.of()
                    .lightLevel(state-> 15)
                    .noOcclusion()
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> KRTECEK = registerBlock("krtecek",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> BRNAK = registerBlock("brnak",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> ALEXANDRITE_ORE_BLOCK = registerBlock("alexandrite_ore_block",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops())));

    public static final RegistryObject<Block> RAW_ALEXANDRITE_ORE_BLOCK = registerBlock("raw_alexandrite_ore_block",
            () -> new DropExperienceBlock(UniformInt.of(3,6),BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> RICHARD_BLOCK = registerBlock("richard_block",
            () -> new RichardBlock(BlockBehaviour.Properties.of()
                    .strength(1f)
                    .friction(1)
                    .jumpFactor(2)
                    .sound(SoundType.WET_SPONGE)));


    public static final RegistryObject<Block> ABSOLUTE_ALEXANDRITE_BLOCK = registerBlock("absolute_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
