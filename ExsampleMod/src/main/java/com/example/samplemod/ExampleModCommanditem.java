package com.example.samplemod;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class ExampleModCommanditem extends Item {

    private final String command;

    public ExampleModCommanditem(Properties properties, String command) {
        super(properties);
        this.command = command;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (!level.isClientSide) {
            ServerPlayer player = (ServerPlayer) context.getPlayer();
            if (player != null) {
                MinecraftServer server = player.getServer();
                if (server != null) {
                    CommandSourceStack commandSource = player.createCommandSourceStack();
                    server.getCommands().performPrefixedCommand(commandSource, command);
                }
            }
        }
        return InteractionResult.SUCCESS;
    }
}
