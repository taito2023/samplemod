package com.example.samplemod;

import com.example.samplemod.provider.ExampleModItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.EntityMobGriefingEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

//イベントを設定するクラスにはクラス定義の前にアノテーション@Mod.EventBusSubscriberを付与します。
// 第一引数にはMODID, 第二引数はFORGEを設定する必要があります。
@Mod.EventBusSubscriber(modid = ExampleMOD.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ExampleModHooks {
    //このクラス内部にはpublic static void で定義したメソッドを記述することができます。
    // このメソッドの引数にフックしたいイベントを設定することで、イベントが処理された際にこのメソッドが呼ばれることになります。

    @SubscribeEvent
    //ここでは爆破の処理を行っている
    //爆発に巻き込まれたItemEntityのうち内容物がSMALL_TNTであるもののみ誘爆する処理を追加しました。
    public static void explosionEvent(ExplosionEvent.Detonate event) {
        event.getAffectedEntities().forEach(entity -> {
            if (entity instanceof ItemEntity item && !item.isRemoved() && item.getItem().getItem() == ExampleModItems.SMALL_TNT.get()) {
                entity.discard();
                entity.getLevel().explode(null, entity.getX(), entity.getY(), entity.getZ(), 6f, Level.ExplosionInteraction.TNT);
            }
        });
    }

    @SubscribeEvent
    //爆発のグラフィティックの処理
    public static void entityMobGriefingEvent(EntityMobGriefingEvent event) {
        if (event.getEntity() instanceof EnderMan) {
            if (!event.getEntity().getLevel().isClientSide()) {
                ((EnderMan) event.getEntity()).addEffect(new MobEffectInstance(MobEffects.GLOWING));
            }
            //特定の事象が発生する場合処理を中止
            event.setResult(Event.Result.DENY);
        }
    }

    @SubscribeEvent
    public static void serverChatEvent(ServerChatEvent event) {
        //tntを含むchatをキャンセル
        if (event.getRawText().contains("tnt")) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    //setCanceledでキャンセルできるのはスポーン時の追加処理のみであり、setSpawnCancelledを利用することで始めてスポーン自体をキャンセルできます
    public static void mobSpawnEvent(MobSpawnEvent.FinalizeSpawn event) {
        //この利用例ではファントムをスポーンしないように変更しています
        if (event.getEntity() instanceof Phantom) {
            event.setSpawnCancelled(true);
        }
    }

    @SubscribeEvent
    public static void itemTossEvent(ItemTossEvent event) {
        if (event.getEntity().getItem().is(ExampleModItems.SMALL_TNT.get()) && event.getPlayer() instanceof ServerPlayer serverPlayer) {
            serverPlayer.getAdvancements().award(serverPlayer.getServer().getAdvancements().getAdvancement(new ResourceLocation(ExampleMOD.MOD_ID, "small_tnt")), "toss_small_tnt");
        }
        //今回新しく実装したアイテムのタグExampleTNTItemTagsProvider.TOSS_EXPLOSIVEを持つアイテムをドロップした際に爆発が起こるように設定しています。
        if (event.getEntity().getItem().is(ExampleModItemTagsProvider.TOSS_EXPLOSIVE) && !event.getEntity().getLevel().isClientSide()) {
            event.getEntity().getLevel().explode(event.getPlayer(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), 1f, true, Level.ExplosionInteraction.TNT);
            //タグは材料の色を問わないレシピや登れるブロックの判定などにも利用されています。実装したいバニラ要素に関して、先にタグが存在するか確認した上で行うと効率的かつ拡張性高く実装ができます。
        }
    }
    //チェスト追加する場合のコード
//    @SubscribeEvent
//    public void onPlayerRightClick(PlayerInteractEvent.RightClickBlock event) {
//        if (!event.getLevel().isClientSide && event.getPlayer().isCrouching() && event.getLevel().getBlockState(event.getPos()).getBlock() instanceof ChestBlock) {
//            event.getPlayer().sendSystemMessage(Component.literal("チェストを開けました！"));
//        }
//    }
}
