package com.cyber98.createindestructible.registry;

import com.cyber98.createindestructible.CreateIndestructible;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CreateIndestructible.MOD_ID);

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreateIndestructible.MOD_ID);

    public static final RegistryObject<Block> FORGECORE_BLOCK = BLOCKS.register("forgecore",
            () -> new ForgecoreBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(50.0F, 1200.0F)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Item> FORGECORE_INCOMPLETE = ITEMS.register("forgecore_incomplete",
            () -> new Item(new Item.Properties()));



    public static final RegistryObject<Item> FORGECORE_ITEM = ITEMS.register("forgecore",
            () -> new BlockItem(FORGECORE_BLOCK.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
