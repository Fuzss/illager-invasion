package fuzs.illagerinvasion.common.init;

import fuzs.illagerinvasion.common.IllagerInvasion;
import fuzs.puzzleslib.common.api.init.v3.tags.TagFactory;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class ModTags {
    private static final TagFactory TAGS = TagFactory.make(IllagerInvasion.MOD_ID);

    public static class Blocks {
        public static final TagKey<Block> MAGIC_FIRE_REPLACEABLE = create("magic_fire_replaceable");
        public static final TagKey<Block> ORES_BLOCK_TAG = TagFactory.COMMON.registerBlockTag("ores");

        private static TagKey<Block> create(String name) {
            return TAGS.registerBlockTag(name);
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> HAS_LABYRINTH_BIOME_TAG = create("has_structure/labyrinth");
        public static final TagKey<Biome> HAS_SORCERER_HUT_BIOME_TAG = create("has_structure/sorcerer_hut");
        public static final TagKey<Biome> HAS_ILLUSIONER_TOWER_BIOME_TAG = create("has_structure/illusioner_tower");
        public static final TagKey<Biome> HAS_ILLAGER_FORT_BIOME_TAG = create("has_structure/illager_fort");
        public static final TagKey<Biome> HAS_FIRECALLER_HUT_BIOME_TAG = create("has_structure/firecaller_hut");

        private static TagKey<Biome> create(String name) {
            return TAGS.registerBiomeTag(name);
        }
    }
}
