package net.rjbash.chaosvkostce.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.rjbash.chaosvkostce.ChaosvKostce;
import net.rjbash.chaosvkostce.entity.custom.SmrkEntity;

import javax.swing.text.html.parser.Entity;

public class SmrkModel <T extends SmrkEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ChaosvKostce.MOD_ID, "smrk"), "main");
    private final ModelPart bone3;
    private final ModelPart bone2;
    private final ModelPart bone;
    private final ModelPart bb_main;

    public SmrkModel(ModelPart root) {
        this.bone3 = root.getChild("bone3");
        this.bone2 = root.getChild("bone2");
        this.bone = root.getChild("bone");
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone3 = partdefinition.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(32, 18).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -2.0F, 0.0F));

        PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(32, 29).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -2.0F, 0.0F));

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(28, 0).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 25).addBox(9.0F, -3.0F, -1.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 11.0F, 0.0F));

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -30.0F, -2.0F, 10.0F, 21.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 25).addBox(-3.0F, -37.0F, -4.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(SmrkEntity entity, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {

        // obě nohy
        this.bone.xRot = Mth.cos(limbSwing * 0.6662F)
                * 1.4F * limbSwingAmount;

        // pravá ruka
        this.bone2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI)
                * 1.4F * limbSwingAmount;

        // levá ruka
        this.bone3.xRot = Mth.cos(limbSwing * 0.6662F)
                * 1.4F * limbSwingAmount;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color ) {
        bone3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return null;
    }


}