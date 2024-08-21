package com.example.samplemod;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

//ここでアノテーションされたクラス内のメソッドは@SubscribeEventをアノテーションしイベントの引数を入れることで街頭のイベントが呼ばれた際に作動します。
@Mod.EventBusSubscriber(modid = ExampleMOD.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExampleModEvents {

    public static CreativeModeTab TAB_TNT;

    @SubscribeEvent
    public static void creativeTabsBuildEvent(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ExampleModItems.SMALL_TNT.get());
            event.accept(ExampleModItems.C_QUIZ.get());
            event.accept(ExampleModItems.L_QUIZ.get());
            event.accept(ExampleModItems.S_QUIZ.get());
            event.accept(ExampleModItems.H_LEVEL.get());
            event.accept(ExampleModItems.M_LEVEL.get());
            event.accept(ExampleModItems.L_LEVEL.get());
            event.accept(ExampleModItems.Q_1.get());
            event.accept(ExampleModItems.Q_2.get());
            event.accept(ExampleModItems.Q_3.get());
            event.accept(ExampleModItems.Q_4.get());

            //event.accept(ExampleModItems.TP_C.get());
        } else if (event.getTab() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(ExampleModBlocks.LARGE_TNT.get());
        } else if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ExampleModBlocks.TRAVIS_SCOTT.get());
        }
    }
    @SubscribeEvent
    //CreativeModeTabEvent.Registerを呼ぶことでタブの登録処理ができます
    //今回はあとから参照の必要がありませんが、必要になったとき用にstaticフィールドとして保持しておくことをおすすめします。
    public static void creativeTabRegisterEvent(CreativeModeTabEvent.Register event) {
        TAB_TNT = event.registerCreativeModeTab(new ResourceLocation(ExampleMOD.MOD_ID, "tab_tnt"),
                builder -> builder

                        //タブのアイコンになるアイテムを設定します。今回はsmall_tntをItemStackとして呼び出しアイコンにしています。
                        .icon(() -> ExampleModItems.SMALL_TNT.get().getDefaultInstance())

                        //creativeTabsBuildEventで利用したようにタブに表示するアイテムをacceptすることができます
                        //複数のタブで表示させることもできるので、このチュートリアルではcreativeTabsBuildEventで
                        // 他のタブに表示させたMOD追加アイテムや、バニラのTNTを表示させています
                        .displayItems((parameters, output) -> {
                            output.accept(ExampleModItems.SMALL_TNT.get());
                            output.accept(ExampleModBlocks.LARGE_TNT.get());
                            output.accept(ExampleModItems.C_QUIZ.get());
                            output.accept(ExampleModItems.L_QUIZ.get());
                            output.accept(ExampleModItems.S_QUIZ.get());
                            output.accept(ExampleModItems.H_LEVEL.get());
                            output.accept(ExampleModItems.M_LEVEL.get());
                            output.accept(ExampleModItems.L_LEVEL.get());
                            output.accept(ExampleModItems.Q_1.get());
                            output.accept(ExampleModItems.Q_2.get());
                            output.accept(ExampleModItems.Q_3.get());
                            output.accept(ExampleModItems.Q_4.get());

                            //output.accept(ExampleModItems.TP_C.get());
                            output.accept(ExampleModBlocks.TRAVIS_SCOTT.get());
                            output.accept(Blocks.TNT);
                        })

                        //titleでは、表示名を設定できます。Component.translatableで.langファイルに設定した翻訳鍵を渡すことで、
                        // 各言語に翻訳されて表示されます。今回はバニラのTNTの翻訳鍵を設定しました
                        .title(Component.translatable("block.minecraft.tnt")));
    }
//    @SubscribeEvent
//    //CreativeModeTabEvent.Registerを呼ぶことでタブの登録処理ができます
//    //今回はあとから参照の必要がありませんが、必要になったとき用にstaticフィールドとして保持しておくことをおすすめします。
//    public static void creativeTabRegisterEvent(CreativeModeTabEvent.Register event) {
//        # = event.registerCreativeModeTab(new ResourceLocation(ExampleMOD.MOD_ID, "#"),
//                builder -> builder
//
//                        //タブのアイコンになるアイテムを設定します。今回はsmall_tntをItemStackとして呼び出しアイコンにしています。
//                        .icon(() -> ExampleModItems.#.get().getDefaultInstance())
//
//                        //creativeTabsBuildEventで利用したようにタブに表示するアイテムをacceptすることができます
//                        //複数のタブで表示させることもできるので、このチュートリアルではcreativeTabsBuildEventで
//                        // 他のタブに表示させたMOD追加アイテムや、バニラのTNTを表示させています
//                        .displayItems((parameters, output) -> {
//                            output.accept(ExampleModItems.#.get());
//                            output.accept(ExampleModBlocks.#.get());
//                            output.accept(ExampleModBlocks.#.get());
//                            output.accept(Blocks.#);
//                        })
//
//                        //titleでは、表示名を設定できます。Component.translatableで.langファイルに設定した翻訳鍵を渡すことで、
//                        // 各言語に翻訳されて表示されます。今回はバニラのTNTの翻訳鍵を設定しました
//                        .title("#"));
//    }
}
