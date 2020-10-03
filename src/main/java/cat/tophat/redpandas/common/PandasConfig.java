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
        public final ForgeConfigSpec.BooleanValue redPandaUseSpawnCost;
        public final ForgeConfigSpec.IntValue redPandaSpawnWeight;
        public final ForgeConfigSpec.IntValue redPandaSpawnMinGroup;
        public final ForgeConfigSpec.IntValue redPandaSpawnMaxGroup;
        public final ForgeConfigSpec.DoubleValue redPandaSpawnCostPer;
        public final ForgeConfigSpec.DoubleValue redPandaSpawnCostMax;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> biomeWhitelist;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> biomeBlacklist;

        ServerConfig(ForgeConfigSpec.Builder builder) {
            redPandaSpawnNaturally = builder.comment("If Red Pandas should spawn naturally in the world.")
                    .define("enableNaturalSpawning", true);

            redPandaSpawnWeight = builder.comment("The higher the value the more likely a Red Panda is to spawn (as opposed to spawning another entity in its place)")
                    .defineInRange("spawnWeight", 7, 0, Integer.MAX_VALUE);

            redPandaSpawnMinGroup = builder.comment("The minimum group size for spawning red pandas.")
            .defineInRange("spawnMinGroup", 1, 1, Integer.MAX_VALUE);

            redPandaSpawnMaxGroup = builder.comment("The maximum group size for spawning red pandas. Must be greater than or equal to the minimum")
            .defineInRange("spawnMaxGroup", 5, 1, Integer.MAX_VALUE);

            redPandaUseSpawnCost = builder.comment("If Red Pandas should utilize spawn costs or not.")
            .define("spawnCostEnabled", false);

            redPandaSpawnCostPer = builder.comment("The spawn cost per red panda spawned.")
            .defineInRange("spawnCostPer", 1, Double.MIN_NORMAL, Double.MAX_VALUE);

            redPandaSpawnCostMax = builder.comment("The maximum spawn cost that can be spent on red pandas.")
            .defineInRange("spawnCostMax", 0.2, Double.MIN_NORMAL, Double.MAX_VALUE);

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
