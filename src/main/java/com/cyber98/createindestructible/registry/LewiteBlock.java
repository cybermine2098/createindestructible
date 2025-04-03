package com.cyber98.createindestructible.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

public class LewiteBlock extends Block{
    public LewiteBlock(Properties properties) {
        super(properties);
    }
    @Nullable
    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (!level.isClientSide && placer instanceof Player player) {
           if(!(player instanceof ServerPlayer)){
               player.sendSystemMessage(Component.literal("Hmm... You shouldn't be able to do that..."));
           }
        }
    }
    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            if(!(player instanceof ServerPlayer)){
                level.setBlock(pos, state, 3);
                return;
            }
        }

        super.playerWillDestroy(level, pos, state, player);
    }
    @Override
    public float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        if (player.hasPermissions(2)) {
            return 1.0F;//very easy break for admins with kick and ban perms
        }else{
            return -1.0F;//not so easy breaking (impossible) for non-admins
        }
    }
}
