package com.cyber98.createindestructible.registry;

import com.cyber98.createindestructible.CreateIndestructible;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CreateIndestructible.MOD_ID);

    public static final RegistryObject<BlockEntityType<ForgecoreBlockEntity>> FORGECORE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("forgecore",
                    () -> BlockEntityType.Builder.of(
                            ForgecoreBlockEntity::new,
                            ModBlocks.FORGECORE_BLOCK.get()
                    ).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
