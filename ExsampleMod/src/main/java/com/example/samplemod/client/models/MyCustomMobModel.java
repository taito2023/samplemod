package com.example.samplemod.client.models;

import com.example.samplemod.entities.MyCustomMob;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;

public class MyCustomMobModel extends EntityModel<MyCustomMob> {

    private final ModelPart body;

    public MyCustomMobModel(ModelPart root) {
        this.body = root.getChild("body");
    }

    @Override
    public void setupAnim(MyCustomMob entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        // カスタムモブのアニメーションロジックをここに追加
    }
    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        // モデルパーツの描画ロジックをここに追加
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
//    @Override
//    public ModelPart root() {
//        return this.body;
//    }
}