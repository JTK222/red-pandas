package cat.tophat.redpandas.common;

import com.google.common.collect.Lists;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class PandasConfig {

    public static final ServerConfig SERVER;
    public static final ForgeConfigSpec SERVER_SPECIFICATION;

    static {
        Pair<ServerConfig, ForgeConfigSpec> specificationPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
        SERVER_SPECIFICATION = specificationPair.getRight();
        SERVER = specificationPair.getLeft();
    }

    public static class ServerConfig {
        public final ForgeConfigSpec.BooleanValue redPandaSpawnNaturally;
        public final ForgeConfigSpec.IntValue redPandaSpawnWeight;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> biomeWhitelist;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> biomeBlacklist;

        ServerConfig(ForgeConfigSpec.Builder builder) {
            redPandaSpawnNaturally = builder.comment("If Red Pandas should spawn naturally in the world.")
                    .define("enableNaturalSpawning", true);

            redPandaSpawnWeight = builder.comment("If -1, the default spawn weight will be used. "
                    + "(The higher the value the more will spawn)")
                    .defineInRange("spawnWeight", 4, -1, Integer.MAX_VALUE);

            biomeWhitelist = builder.comment("If biomes are specified here,"
                    + " Red Pandas will ONLY spawn in these biomes. (The blacklist is ignored while this is set!)")
                    .defineList("whitelist", Lists.newArrayList(
                            "minecraft:bamboo_jungle",
                            "minecraft:bamboo_jungle_hills"
                    ), o -> o instanceof String);

            biomeBlacklist = builder.comment("If the whitelist is not used, use this list to specify the"
                    + " biomes that Red Pandas should not spawn in.")
                    .defineList("blacklist",
                            Lists.newArrayList(
                                    "minecraft:the_void",
                                    "minecraft:ocean",
                                    "minecraft:nether",
                                    "minecraft:frozen_river",
                                    "minecraft:frozen_ocean",
                                    "minecraft:desert",
                                    "minecraft:warm_ocean",
                                    "minecraft:lukewarm_ocean",
                                    "minecraft:cold_ocean",
                                    "minecraft:deep_lukewarm_ocean",
                                    "minecraft:deep_cold_ocean",
                                    "minecraft:deep_frozen_ocean"
                            ), o -> o instanceof String);
        }
    }
}
