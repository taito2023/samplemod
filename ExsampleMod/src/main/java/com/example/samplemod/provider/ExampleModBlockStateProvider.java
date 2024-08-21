package com.example.samplemod.provider;

import com.example.samplemod.ExampleMOD;
import com.example.samplemod.ExampleModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ExampleModBlockStateProvider extends BlockStateProvider {
    public ExampleModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ExampleMOD.MOD_ID, exFileHelper);
    }
    @Override
    //registerStatesAndModels()内に、モデルの追加方法を指定して記述します。
    protected void registerStatesAndModels() {
        //今回は単純な6面同テクスチャモデルを利用するため、simpleBlockWithItem(Block block, ModelFile file)を親クラスから呼び出しています。
        this.simpleBlockWithItem(ExampleModBlocks.LARGE_TNT.get(), this.cubeAll(ExampleModBlocks.LARGE_TNT.get()));
        this.simpleBlockWithItem(ExampleModBlocks.TRAVIS_SCOTT.get(), this.cubeAll(ExampleModBlocks.TRAVIS_SCOTT.get()));
    }
}
