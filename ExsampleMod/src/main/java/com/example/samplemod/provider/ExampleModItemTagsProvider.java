package com.example.samplemod.provider;

import com.example.samplemod.ExampleMOD;
import com.example.samplemod.ExampleModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ExampleModItemTagsProvider extends ItemTagsProvider{
    public static final TagKey<Item> TOSS_EXPLOSIVE = ItemTags.create(new ResourceLocation(ExampleMOD.MOD_ID, "toss_explosive"));

    public ExampleModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> future, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, future, ExampleMOD.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(TOSS_EXPLOSIVE).add(Items.CREEPER_SPAWN_EGG, ExampleModItems.SMALL_TNT.get());
    }
}
