package net.rjbash.chaosvkostce.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.rjbash.chaosvkostce.ChaosvKostce;
import net.rjbash.chaosvkostce.entity.custom.SmrkEntity;

public class SmrkRenderer extends MobRenderer<SmrkEntity, SmrkModel<SmrkEntity>> {
    public SmrkRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SmrkModel<>(pContext.bakeLayer(SmrkModel.LAYER_LOCATION)),0.85f);
    }

    @Override
    public ResourceLocation getTextureLocation(SmrkEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(ChaosvKostce.MOD_ID, "textures/entity/smrk/maple");
    }
    @Override
    public void render(SmrkEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            pPoseStack.scale(1f, 1f, 1f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
