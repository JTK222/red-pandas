package cat.tophat.redpandas;

import cat.tophat.redpandas.common.PandasConfig;
import cat.tophat.redpandas.common.entities.RedPandaEntity;
import com.google.common.collect.Sets;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.awt.Color;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mod(modid = RedPandas.MODID, name = "Red Pandas", version = "1.0.3", acceptedMinecraftVersions = "[1.12,1.12.2]")
@EventBusSubscriber(modid = RedPandas.MODID)
public class RedPandas {

    public static final String MODID = "redpandas";

    @SubscribeEvent
    public static void registerEntity(RegistryEvent.Register<EntityEntry> event) {

        EntityEntryBuilder<Entity> RED_PANDA_ENTRY = EntityEntryBuilder.create()
                .entity(RedPandaEntity.class)
                .factory(RedPandaEntity::new)
                .id(new ResourceLocation(MODID, "red_panda"), 0)
                .name(MODID + ".red_panda")
                .tracker(80, 1, true)
                .egg(Color.RED.getRGB(), Color.BLACK.getRGB());

        Collection<Biome> biomes = ForgeRegistries.BIOMES.getValuesCollection();

        if (PandasConfig.biomeWhitelist != null && PandasConfig.biomeWhitelist.length > 0) {
            Set<String> whitelist = Sets.newHashSet(PandasConfig.biomeWhitelist);
            biomes = biomes.stream().filter(b -> whitelist.contains(b.getRegistryName()
                    .toString())).collect(Collectors.toList());
        } else if (PandasConfig.biomeBlacklist != null && PandasConfig.biomeBlacklist.length > 0) {
            Set<String> blacklist = Sets.newHashSet(PandasConfig.biomeBlacklist);
            biomes = biomes.stream().filter(b -> !blacklist.contains(b.getRegistryName()
                    .toString())).collect(Collectors.toList());
        }

        RED_PANDA_ENTRY.spawn(EnumCreatureType.CREATURE, PandasConfig.spawnWeight, 1, 5, biomes);

        event.getRegistry().register(RED_PANDA_ENTRY.build());
    }
}
