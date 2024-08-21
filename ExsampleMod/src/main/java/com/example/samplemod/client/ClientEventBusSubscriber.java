package com.example.samplemod.client;

import com.example.samplemod.ExampleMOD;
import com.example.samplemod.client.render.MyCustomMobRenderer;
import com.example.samplemod.init.ExampleModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod.EventBusSubscriber(modid = ExampleMOD.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    public static void register(IEventBus eventBus) {
        eventBus.addListener(ClientEventBusSubscriber::onClientSetup);
        eventBus.addListener(ClientEventBusSubscriber::registerRenderers);
    }

    private static void onClientSetup(final FMLClientSetupEvent event) {
        // Client-side setup
    }

    private static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ExampleModEntities.MY_CUSTOM_MOB.get(), MyCustomMobRenderer::new);
    }
}
