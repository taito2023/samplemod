package com.example.samplemod;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExampleModBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMOD.MOD_ID);
    //ブロックの追加で特製の設定ここでは明るさの設定を行っている
    public static final RegistryObject<Block> LARGE_TNT = BLOCKS.register("large_tnt", () -> new Block(BlockBehaviour.Properties.of(Material.EXPLOSIVE).lightLevel(value -> 15)));
    public static final RegistryObject<Block> TRAVIS_SCOTT = BLOCKS.register("travis_scott", () -> new Block(BlockBehaviour.Properties.of(Material.EXPLOSIVE).strength(3.0f, 6.0f)));
    public static void register(IEventBus eventBus) {

        BLOCKS.register(eventBus);
    }
}
