package cat.tophat.redpandas.common;

import cat.tophat.redpandas.RedPandas;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = RedPandas.MODID)
public class PandasConfig {

    @Config.Comment("If Red Pandas should spawn naturally in the world. Default: true")
    @Config.RequiresMcRestart()
    public static boolean enableNaturalSpawning = true;

    @Config.Comment("If -1 the default spawn weight will be used. (The higher the value the more will spawn)")
    @Config.RequiresMcRestart
    public static int spawnWeight = 4;

    @Config.Comment("If biomes are specified here, Red Pandas will ONLY spawn in these biomes. (The blacklist "
            + "is ignored while the whitelist is in use, please empty to enable the blacklist)")
    @Config.RequiresMcRestart
    public static String[] biomeWhitelist = new String[0];

    @Config.Comment("If the whitelist is unused, list the biomes Red Pandas should not spawn in. "
            + "(Unused when the whitelist contains biomes)")
    @Config.RequiresMcRestart
    public static String[] biomeBlacklist = new String[]{
            "minecraft:the_void", "minecraft:ocean", "minecraft:nether", "minecraft:frozen_river",
            "minecraft:frozen_ocean", "minecraft:desert", "minecraft:warm_ocean", "minecraft:lukewarm_ocean",
            "minecraft:cold_ocean", "minecraft:deep_lukewarm_ocean",
            "minecraft:deep_cold_ocean", "minecraft:deep_frozen_ocean"
    };

    @Mod.EventBusSubscriber(modid = RedPandas.MODID)
    private static class EventHandler {
        @SubscribeEvent
        public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(RedPandas.MODID)) {
                ConfigManager.sync(RedPandas.MODID, Config.Type.INSTANCE);
            }
        }
    }
}
