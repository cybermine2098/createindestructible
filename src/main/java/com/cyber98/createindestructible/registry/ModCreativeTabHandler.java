package com.cyber98.createindestructible.registry;

import com.cyber98.createindestructible.CreateIndestructible;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CreateIndestructible.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeTabHandler {

    @SubscribeEvent
    public static void addItemsToCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.FORGECORE_ITEM);
            event.accept(ModBlocks.LEWITE_ITEM);
        }else if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS){
            event.accept(ModBlocks.IMMORTAL_COOKIE);
        }else if(event.getTabKey() == CreativeModeTabs.COMBAT){
            event.accept(ModBlocks.SWORD);
        }else if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModBlocks.CARBON);
        }
    }
}
