package com.example.samplemod;

import com.example.samplemod.provider.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(ExampleMOD.MOD_ID)
public class ExampleMOD {

    public static final String MOD_ID = "samplemod";

    public ExampleMOD() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::registerProviders);
        ExampleModBlocks.register(modEventBus);
        //ここでアイテムの追加処理をしています。
        ExampleModItems.register(modEventBus);
    }
    private void registerProviders(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        gen.addProvider(event.includeClient(), new ExampleModItemModelProvider(packOutput, fileHelper));
        gen.addProvider(event.includeClient(), new ExampleModBlockStateProvider(packOutput, fileHelper));
        gen.addProvider(event.includeClient(), new ExampleModLangProvider.ExampleModLangUS(gen.getPackOutput()));
        gen.addProvider(event.includeClient(), new ExampleModLangProvider.ExampleModLangJP(gen.getPackOutput()));
//event.includeServer()を第一引数に指定することで保存場所がgenerated/resources/data/examplemod/になります
        gen.addProvider(event.includeServer(), new ExampleModRecipeProvider(gen.getPackOutput()));
        gen.addProvider(event.includeServer(), new ExampleModAdvancementProvider(packOutput, event.getLookupProvider(), fileHelper));

        ExampleModBlockTagsProvider blockTagsProvider = new ExampleModBlockTagsProvider(packOutput, event.getLookupProvider(), fileHelper);
        gen.addProvider(event.includeServer(), blockTagsProvider);
        gen.addProvider(event.includeServer(), new ExampleModItemTagsProvider(packOutput, event.getLookupProvider(), blockTagsProvider.contentsGetter(), fileHelper));
    }
}
