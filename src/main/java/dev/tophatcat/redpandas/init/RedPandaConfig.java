package dev.tophatcat.redpandas.init;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class RedPandaConfig {

    public static final RedPandaConfigs CONFIG;
    public static final ForgeConfigSpec SERVER_SPEC;

    static {
        Pair<RedPandaConfigs, ForgeConfigSpec> specificationPair
            = new ForgeConfigSpec.Builder().configure(RedPandaConfigs::new);
        SERVER_SPEC = specificationPair.getRight();
        CONFIG = specificationPair.getLeft();
    }

    public static class RedPandaConfigs {
        public final ForgeConfigSpec.IntValue weightMultiplierRedPanda;
        public final ForgeConfigSpec.IntValue minSpawnGroupRedPanda;
        public final ForgeConfigSpec.IntValue maxSpawnGroupRedPanda;

        public RedPandaConfigs(ForgeConfigSpec.Builder builder) {
            builder.push("Red Panda");
            builder.comment("Set how much of a chance a Red Panda will have to spawn in the world and the min/max "
                + "group size. (Set Spawn Weight to 0 to prevent them spawning)");
            weightMultiplierRedPanda = builder.defineInRange("Spawn Weight",
                1, 0, 300);
            minSpawnGroupRedPanda = builder.defineInRange("Minimum Group Spawn Count",
                2, 1, 64);
            maxSpawnGroupRedPanda = builder.defineInRange("Maximum Group Spawn Count",
                3, 1, 64);
            builder.pop();
        }
    }
}
