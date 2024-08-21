package com.example.samplemod.provider;

import com.example.samplemod.ExampleMOD;
import com.example.samplemod.ExampleModBlocks;
import com.example.samplemod.ExampleModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

public class ExampleModRecipeProvider extends RecipeProvider {
    public ExampleModRecipeProvider(PackOutput output) {
        super(output);
    }
    @Override
    //レシピを登録できるメソッド
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        //不定形レシピの登録に使います。
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ExampleModItems.SMALL_TNT.get(), 3)
                //第一引数にはレシピのカテゴリを登録
                //このメソッドは複数回使うことができ、必要なアイテムを何種類でも指定することが可能です
                .requires(ExampleModBlocks.LARGE_TNT.get())
                //第二引数に出力するアイテムを指定します。
                //グループ名を指定できます。同じグループのレシピはレシピブックでまとめて表示されます
                .group("samplemod")
                //第三引数として出力個性も指定できます。
                //レシピの解禁条件を指定できます。第一引数にcriteria名、第二引数に条件を設定します。
                // なお、レシピの解禁条件が存在しない場合jsonファイルの書き出しには失敗します
                .unlockedBy("has_large_tnt", has(ExampleModBlocks.LARGE_TNT.get()))
                //最後にsaveでResourceLocationを設定し、レシピをセーブすることができます
                .save(consumer, new ResourceLocation(ExampleMOD.MOD_ID, "small_tnt"));

        //定形レシピの登録に使います
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ExampleModBlocks.LARGE_TNT.get(), 2)
                //特定のItemLikeに文字を割り当てられます
                //このメソッドは複数回使うことができますが、一つのレシピ中で同じ文字を別のItemLikeに紐付けることはできません。
                .define('#', Blocks.TNT)
                .define('G', Items.GUNPOWDER)

                ////defineで紐づけた文字の並びで作業台での配置を指示します
                //patternメソッド一つで作業台の上から1行ずつ指定することができます。空白はスペースを用いて記述して下さい
                //patternメソッドは必ずしも3行設定する必要はなく、また列についても省略することができます。
                // 例えば、列に関しては、ドアのレシピは以下のように指定できます
                .pattern(" # ").pattern("GGG").pattern(" # ")
                .group("samplemod")
                .unlockedBy("has_tnt", has(Blocks.TNT))
                .save(consumer, new ResourceLocation(ExampleMOD.MOD_ID, "large_tnt"));
    }
}
