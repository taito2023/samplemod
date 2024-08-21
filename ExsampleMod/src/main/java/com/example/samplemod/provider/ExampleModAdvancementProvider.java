package com.example.samplemod.provider;

import com.example.samplemod.ExampleMOD;
import com.example.samplemod.ExampleModBlocks;
import com.example.samplemod.ExampleModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlacedBlockTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

//ForgeAdvancementProviderを継承することで進捗を生成することができます。
// 他のプロバイダーと同様にregisterProvidersで登録を行う必要があります
public class ExampleModAdvancementProvider extends ForgeAdvancementProvider {
    public ExampleModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new ExampleModAdvancementGenerator()));
    }

    public static class ExampleModAdvancementGenerator implements AdvancementGenerator {

        @Override
        //AdvancementProvider.generate()内でAdvancement.Builderの処理を行うことで、各進捗を生成することが可能です
        public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper helper) {
            Advancement root = Advancement.Builder.advancement()

                    //各引数についての説明ページURL
                    //https://www.tntmodders.com/tutorial/advancement-1194/

                    .display(new ItemStack(Blocks.TNT), Component.literal("ExampleTNT"), Component.translatable("block.minecraft.tnt"), new ResourceLocation(ExampleMOD.MOD_ID, "textures/block/large_tnt.png"), FrameType.TASK, true, false, true)
                    .addCriterion("has_tnt", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TNT))
                    .save(saver, new ResourceLocation(ExampleMOD.MOD_ID, "root"), helper);

            Advancement large_tnt = Advancement.Builder.advancement()
                    .display(new ItemStack(ExampleModBlocks.LARGE_TNT.get()), Component.translatable("block.samplemod.large_tnt"), Component.translatable("block.samplemod.large_tnt"), null, FrameType.CHALLENGE, true, true, false)
                    .addCriterion("place_large_tnt", PlacedBlockTrigger.TriggerInstance.placedBlock(ExampleModBlocks.LARGE_TNT.get()))
                    .addCriterion("has_large_tnt", InventoryChangeTrigger.TriggerInstance.hasItems(ExampleModBlocks.LARGE_TNT.get()))
                    .parent(root)
                    .save(saver, new ResourceLocation(ExampleMOD.MOD_ID, "large_tnt"), helper);

            Advancement small_tnt = Advancement.Builder.advancement()
                    .display(new ItemStack(ExampleModItems.SMALL_TNT.get()), Component.translatable("item.samplemod.small_tnt"), Component.translatable("item.samplemod.small_tnt"), null, FrameType.GOAL, true, true, true)
                    .addCriterion("toss_small_tnt", new ImpossibleTrigger.TriggerInstance())
                    .rewards(AdvancementRewards.Builder.loot(new ResourceLocation("chests/spawn_bonus_chest")))
                    .parent(root)
                    .save(saver, new ResourceLocation(ExampleMOD.MOD_ID, "small_tnt"), helper);
        }
    }
}
