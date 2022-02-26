/*
 * Red Pandas - https://tophatcat.dev/red-pandas
 * Copyright (C) 2016-2022 <KiriCattus>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.redpandas.common;

import com.google.common.collect.Lists;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PandaConfig {

    public static Set<String> allowList, disallowList;
    public static int weight;
    public static final ServerConfig SERVER;
    public static final ForgeConfigSpec SERVER_SPECIFICATION;

    public static void onLoad(ModConfigEvent.Loading event) {
        allowList = new HashSet<>(PandaConfig.SERVER.biomeAllowList.get());
        disallowList = new HashSet<>(PandaConfig.SERVER.biomeDisallowList.get());
        weight = PandaConfig.SERVER.redPandaSpawnWeight.get() == -1 ? 45 : PandaConfig.SERVER.redPandaSpawnWeight.get();
    }

    public static void onReload(ModConfigEvent.Reloading event) {
        allowList = new HashSet<>(PandaConfig.SERVER.biomeAllowList.get());
        disallowList = new HashSet<>(PandaConfig.SERVER.biomeDisallowList.get());
        weight = PandaConfig.SERVER.redPandaSpawnWeight.get() == -1 ? 45 : PandaConfig.SERVER.redPandaSpawnWeight.get();
    }

    static {
        Pair<ServerConfig, ForgeConfigSpec> specificationPair =
            new ForgeConfigSpec.Builder().configure(ServerConfig::new);
        SERVER_SPECIFICATION = specificationPair.getRight();
        SERVER = specificationPair.getLeft();
    }

    public static class ServerConfig {
        public final ForgeConfigSpec.BooleanValue redPandaSpawnNaturally;
        public final ForgeConfigSpec.IntValue redPandaSpawnWeight;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> biomeAllowList;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> biomeDisallowList;

        ServerConfig(ForgeConfigSpec.Builder builder) {
            redPandaSpawnNaturally = builder.comment("If Red Pandas should spawn naturally in the world.")
                .define("enableNaturalSpawning", true);

            redPandaSpawnWeight = builder.comment("If -1, the default spawn weight will be used. "
                    + "(The higher the value the more will spawn)")
                .defineInRange("spawnWeight", 4, -1, Integer.MAX_VALUE);

            biomeAllowList = builder.comment("If biomes are specified here,"
                    + " Red Pandas will ONLY spawn in these biomes. (The disallowList is ignored while this is set!)")
                .defineList("allowList", Lists.newArrayList(
                    "minecraft:bamboo_jungle",
                    "minecraft:bamboo_jungle_hills"
                ), o -> o instanceof String);

            biomeDisallowList = builder.comment("If the allowlist is not used, use this list to specify the"
                    + " biomes that Red Pandas should not spawn in.")
                .defineList("disallowList",
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
