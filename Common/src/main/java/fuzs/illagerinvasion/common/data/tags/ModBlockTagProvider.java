package fuzs.illagerinvasion.common.data.tags;

import fuzs.illagerinvasion.common.init.ModBlocks;
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
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(ModBlocks.IMBUING_TABLE);
        this.tag(BlockTags.FIRE).add(ModBlocks.MAGIC_FIRE);
        this.tag(ModTags.Blocks.MAGIC_FIRE_REPLACEABLE)
                .add(BlockItemIds.AIR.block(),
                        BlockItemIds.SHORT_GRASS.block(),
                        BlockItemIds.FERN.block(),
                        BlockItemIds.TALL_GRASS.block());
    }
}
