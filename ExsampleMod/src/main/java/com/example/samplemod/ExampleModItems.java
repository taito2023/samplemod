package com.example.samplemod;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExampleModItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMOD.MOD_ID);
    //ITEMS.register("small_○○"...でITEMSに任意のアイテムを追加することができる
    public static final RegistryObject<Item> SMALL_TNT = ITEMS.register("small_tnt", () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> C_QUIZ = ITEMS.register("c_quiz", () -> new ExampleModCommanditem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1), "/setblock 3 -33 4 minecraft:stone"));
    public static final RegistryObject<Item> L_QUIZ = ITEMS.register("l_quiz", () -> new ExampleModCommanditem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1), "/setblock 12 -33 4 minecraft:stone"));
    public static final RegistryObject<Item> S_QUIZ = ITEMS.register("s_quiz", () -> new ExampleModCommanditem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1), "/setblock 22 -33 4 minecraft:stone"));
    public static final RegistryObject<Item> H_LEVEL = ITEMS.register("h_level", () -> new ExampleModCommanditem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1), "/setblock 31 -33 4 minecraft:stone"));
    public static final RegistryObject<Item> M_LEVEL = ITEMS.register("m_level", () -> new ExampleModCommanditem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1), "/setblock 40 -33 4 minecraft:stone"));
    public static final RegistryObject<Item> L_LEVEL = ITEMS.register("l_level", () -> new ExampleModCommanditem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1), "/setblock 50 -33 4 minecraft:stone"));
    //回答選択肢アイテム四つ
    public static final RegistryObject<Item> Q_1 = ITEMS.register("q_1", () -> new ExampleModCommanditem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1), "/setblock -41 -33 60 minecraft:stone"));
    public static final RegistryObject<Item> Q_2 = ITEMS.register("q_2", () -> new ExampleModCommanditem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1), "/setblock -41 -33 63 minecraft:stone"));
    public static final RegistryObject<Item> Q_3 = ITEMS.register("q_3", () -> new ExampleModCommanditem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1), "/setblock -41 -33 66 minecraft:stone"));
    public static final RegistryObject<Item> Q_4 = ITEMS.register("q_4", () -> new ExampleModCommanditem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1), "/setblock -41 -33 69 minecraft:stone"));
    //


    //public static final RegistryObject<Item> # = ITEMS.register("clang_item", () -> new ExampleModCommanditem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1), "/setblock 4 -33 -2 minecraft:stone"));
    //public static final RegistryObject<Item> TP_C = ITEMS.register("tp_c", () -> new ExampleModCommanditem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1), "/tp @p @e[name=C"));
    //クリエイティブタブに追加するためnew BlockItem()を利用することでアイテムの追加を行う
    public static final RegistryObject<Item> LARGE_TNT = ITEMS.register("large_tnt", () -> new BlockItem(ExampleModBlocks.LARGE_TNT.get(), new Item.Properties()));
    public static final RegistryObject<Item> TRAVIS_SCOTT = ITEMS.register("travis_scott", () -> new BlockItem(ExampleModBlocks.TRAVIS_SCOTT.get(), new Item.Properties()));

    //ITEMSで作成したリストをここでまとめて登録しています
    public static void register(IEventBus eventBus) {

        ITEMS.register(eventBus);
    }
}