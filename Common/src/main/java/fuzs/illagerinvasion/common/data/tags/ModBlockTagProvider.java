package fuzs.illagerinvasion.common.data.tags;

import fuzs.illagerinvasion.common.init.ModRegistry;
import fuzs.illagerinvasion.common.init.ModTags;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.common.api.data.v2.tags.AbstractTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemIds;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

public class ModBlockTagProvider extends AbstractTagProvider<Block> {

    public ModBlockTagProvider(DataProviderContext context) {
        super(Registries.BLOCK, context);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.IMBUING_TABLE_BLOCK);
        this.tag(BlockTags.FIRE).add(ModRegistry.MAGIC_FIRE_BLOCK);
        this.tag(ModTags.MAGIC_FIRE_REPLACEABLE_BLOCK_TAG)
                .add(BlockItemIds.AIR.block(),
                        BlockItemIds.SHORT_GRASS.block(),
                        BlockItemIds.FERN.block(),
                        BlockItemIds.TALL_GRASS.block());
    }
}
