package com.example.samplemod.provider;

import com.example.samplemod.ExampleMOD;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ExampleModItemModelProvider extends ItemModelProvider {
    public ExampleModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ExampleMOD.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.singleTexture("small_tnt", mcLoc(folder + "/generated"), "layer0",
                new ResourceLocation("examplemod", folder + "/" + "small_tnt"));
    }
}