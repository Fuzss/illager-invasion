package fuzs.illagerinvasion.common.data.tags;

import fuzs.illagerinvasion.common.init.ModTags;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.common.api.data.v2.tags.AbstractTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

public class ModBiomeTagProvider extends AbstractTagProvider<Biome> {

    public ModBiomeTagProvider(DataProviderContext context) {
        super(Registries.BIOME, context);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Biomes.HAS_FIRECALLER_HUT_BIOME_TAG).addTag(BiomeTags.IS_BADLANDS);
        this.tag(ModTags.Biomes.HAS_ILLAGER_FORT_BIOME_TAG).addTag(BiomeTags.IS_TAIGA).add(Biomes.SNOWY_PLAINS);
        this.tag(ModTags.Biomes.HAS_ILLUSIONER_TOWER_BIOME_TAG)
                .add(Biomes.TAIGA,
                        Biomes.OLD_GROWTH_PINE_TAIGA,
                        Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                        Biomes.DARK_FOREST,
                        Biomes.SWAMP);
        this.tag(ModTags.Biomes.HAS_SORCERER_HUT_BIOME_TAG).add(Biomes.DARK_FOREST);
        this.tag(ModTags.Biomes.HAS_LABYRINTH_BIOME_TAG)
                .addTag(BiomeTags.IS_TAIGA, BiomeTags.IS_JUNGLE, BiomeTags.IS_FOREST, BiomeTags.IS_SAVANNA);
    }
}
