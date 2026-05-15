package net.rjbash.chaosvkostce.entity;

import net.rjbash.chaosvkostce.ChaosvKostce;
import net.rjbash.chaosvkostce.entity.custom.SmrkEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ChaosvKostce.MOD_ID);

    public static final RegistryObject<EntityType<SmrkEntity>> SMRK =
            ENTITY_TYPES.register("smrk", () -> EntityType.Builder.of(SmrkEntity::new, MobCategory.CREATURE)
                    .sized(1.5f, 1.5f).build("smrk"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}