package com.example.samplemod.client.render;

import com.example.samplemod.ExampleMOD;
import com.example.samplemod.client.models.MyCustomMobModel;
import com.example.samplemod.entities.MyCustomMob;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;

public class MyCustomMobRenderer extends MobRenderer<MyCustomMob,MyCustomMobModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(ExampleMOD.MOD_ID, "textures/entity/#.png");

    public MyCustomMobRenderer(EntityRendererProvider.Context context) {
        super(context, new MyCustomMobModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(MyCustomMob entity) {
        return TEXTURE;
    }
}