package com.cyber98.createindestructible;

import com.cyber98.createindestructible.registry.ModBlocks;
import com.cyber98.createindestructible.registry.ModBlockEntities;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CreateIndestructible.MOD_ID)
public class CreateIndestructible {
    public static final String MOD_ID = "createindestructible";

    public CreateIndestructible() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
    }
}



