package com.cyber98.createindestructible.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ForgecoreBlockEntity extends BlockEntity {

    private String ownerUUID = "";

    public ForgecoreBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FORGECORE_BLOCK_ENTITY.get(), pos, state);
    }

    public void setOwnerUUID(String uuid) {
        this.ownerUUID = uuid;
    }

    public String getOwnerUUID() {
        return this.ownerUUID;
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putString("ownerUUID", ownerUUID);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        ownerUUID = tag.getString("ownerUUID");
    }
}
