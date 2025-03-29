package com.cyber98.createindestructible.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

public class ForgecoreBlock extends Block implements EntityBlock {

    public ForgecoreBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ForgecoreBlockEntity(pos, state);
    }

    // 🔧 THIS is called after placement and after the BlockEntity exists
    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (!level.isClientSide && placer instanceof Player player) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof ForgecoreBlockEntity forgecore) {
                forgecore.setOwnerUUID(player.getStringUUID());
            }
        }
    }

    // 🔒 Only allow the owner to destroy it
    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof ForgecoreBlockEntity forgecore) {
                if (!player.getStringUUID().equals(forgecore.getOwnerUUID())) {
                    // Reset the block so it doesn't disappear
                    level.setBlock(pos, state, 3);
                    if (player instanceof ServerPlayer sp) {
                        sp.sendSystemMessage(Component.literal("Successfully broke block that you didn't place!"));
                    }
                    return;
                }
            }
        }

        super.playerWillDestroy(level, pos, state, player);
    }

    // 🧱 Make it much faster for the owner to break
    @Override
    public float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof ForgecoreBlockEntity forgecore) {
            if (player.getStringUUID().equals(forgecore.getOwnerUUID())) {
                return 1.0F; // Like obsidian-ish
            } else {
                return 0.0001F; // Basically unbreakable
            }
        }

        return 0.0001F;
    }
}
