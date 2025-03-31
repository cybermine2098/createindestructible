package com.cyber98.createindestructible.registry;

import com.cyber98.createindestructible.CreateIndestructible;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;

public class ModBlocks {


    // REGISTER REGISTERS... or something idrk

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CreateIndestructible.MOD_ID);

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreateIndestructible.MOD_ID);

    //
    // REGISTER ALL BLOCKS
    //
    public static final RegistryObject<Block> FORGECORE_BLOCK = BLOCKS.register("forgecore",
            () -> new ForgecoreBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(500.0F, 12000.0F)
                    .requiresCorrectToolForDrops()
            ));

    //
    // REGISTER ALL ITEMS
    //
    public static final RegistryObject<Item> FORGECORE_INCOMPLETE = ITEMS.register("forgecore_incomplete",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_INCOMPLETE = ITEMS.register("diamond_incomplete",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_INCOMPLETE = ITEMS.register("lapis_incomplete",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INCOMPLETE_SWORD = ITEMS.register("incomplete_sword",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SWORD = ITEMS.register("sword",
            () -> new SwordItem(Tiers.DIAMOND, 50, -3.9F, // Attack damage and attack speed
                    new Item.Properties()
                            .stacksTo(1)
                            .fireResistant()
                            .rarity(Rarity.EPIC)
            ));

    public static final RegistryObject<Item> IMMORTAL_COOKIE = ITEMS.register("immortal_cookie", () ->
            new Item(new Item.Properties()
                    .stacksTo(16)
                    .food(new FoodProperties.Builder()
                            .nutrition(2)
                            .saturationMod(0.1F)
                            .alwaysEat() //even if full
                            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 20 * 60 * 5, 4), 1.0F) //100% chance for absorption 5 (4) for 5 mins, 20tps*60s)
                            .build())) {
                @Override
                public boolean isFoil(ItemStack stack) {
                    return true; // oooh shiny!
                }
                @Override
                public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
                    tooltip.add(Component.literal("Grants 5 minutes of superpower").withStyle(ChatFormatting.GOLD));
                }
            });
    //
    //  REGISTER ALL BLOCK ITEMS
    //

    public static final RegistryObject<Item> FORGECORE_ITEM = ITEMS.register("forgecore",
            () -> new BlockItem(FORGECORE_BLOCK.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
