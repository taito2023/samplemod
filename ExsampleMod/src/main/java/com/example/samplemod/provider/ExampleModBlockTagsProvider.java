package com.example.samplemod.provider;

import com.example.samplemod.ExampleMOD;
import com.example.samplemod.ExampleModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ExampleModBlockTagsProvider extends BlockTagsProvider {
    public ExampleModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ExampleMOD.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //TagsProvider.tag()メソッドで任意のタグを指定し生成するファイルを決めます。ここでは、LARGE_TNTの適正ツールをクワにするためBlockTags.MINEABLE_WITH_HOEを指定します。
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(ExampleModBlocks.LARGE_TNT.get());
    }

}
