package net.rjbash.chaosvkostce.event;


import net.minecraft.world.entity.EntityType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.rjbash.chaosvkostce.ChaosvKostce;
import net.rjbash.chaosvkostce.entity.ModEntities;
import net.rjbash.chaosvkostce.entity.client.SmrkModel;
import net.rjbash.chaosvkostce.entity.custom.SmrkEntity;

@Mod.EventBusSubscriber(modid = ChaosvKostce.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SmrkModel.LAYER_LOCATION, SmrkModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.SMRK.get(), SmrkEntity.createAttributes().build());
    }
}
