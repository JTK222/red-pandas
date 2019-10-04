package com.mcmoddev.redpandas;

import java.awt.Color;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mcmoddev.redpandas.common.entities.RedPandaEntity;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

@Mod(modid = RedPandas.MODID, name = "Red Pandas", acceptedMinecraftVersions = "[1.12,1.12.2]", version = RedPandas.VERSION)
@EventBusSubscriber(modid = RedPandas.MODID)
public class RedPandas {

    //TODO Note for porters: Don't worry about the strings usually found here as long as it runs I (Proxy)
    // can sort the rest of those out later since it's linked to gradle.
    public static final String MODID = "redpandas";
    private static final Logger LOGGER = LogManager.getLogger("Red Pandas");
    public static final String VERSION = "@MOD_VERSION@";

    @EventHandler
    public static void fingerprintViolation(FMLFingerprintViolationEvent event) {
        LOGGER.warn("Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been " +
                "tampered with. This version will NOT be supported! Please download the mod from CurseForge for a " +
                "supported and signed version of the mod.");
    }
    
    public static final EntityEntry RED_PANDA_ENTRY = EntityEntryBuilder.create().entity(RedPandaEntity.class).id(new ResourceLocation(MODID, "red_panda"), 0).name(MODID + ".red_panda").tracker(80, 1, true).egg(Color.RED.getRGB(), Color.BLACK.getRGB()).build();

    @SubscribeEvent
    public static void registerEntity(RegistryEvent.Register<EntityEntry> event) {
        event.getRegistry().register(RED_PANDA_ENTRY);
    }

}
