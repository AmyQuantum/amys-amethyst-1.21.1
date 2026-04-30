package net.amy.amythest.registry.tag;

import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomeTags {

    public static final TagKey<Biome> SPAWNS_CHERRY_FOXES = of("spawns_cherry_foxes");

    private ModBiomeTags() {
    }

    private static TagKey<Biome> of(String id) {
        return TagKey.of(RegistryKeys.BIOME, Identifier.ofVanilla(id));
    }
}
