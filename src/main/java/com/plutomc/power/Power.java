package com.plutomc.power;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Power.MOD_ID, name = Power.NAME, version = Power.VERSION)
public class Power
{
    @Mod.Instance(Power.MOD_ID)
    private static Object instance;

    public static final String MOD_ID = "plutomc_power";
    public static final String NAME = "PlutoMC Power";
    public static final String VERSION = "0.1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }

    public static Object instance()
    {
        return instance;
    }
}
