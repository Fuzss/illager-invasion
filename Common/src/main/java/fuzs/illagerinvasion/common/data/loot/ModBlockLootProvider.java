package fuzs.illagerinvasion.common.data.loot;

import fuzs.illagerinvasion.common.init.ModBlockFamilies;
import fuzs.illagerinvasion.common.init.ModBlocks;
import fuzs.puzzleslib.common.api.data.v2.AbstractLootProvider;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;

public class ModBlockLootProvider extends AbstractLootProvider.Blocks {

    public ModBlockLootProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addLootTables() {
        this.generateFor(ModBlockFamilies.PLATINUM, VARIANT_PROVIDERS);
        this.dropSelf(ModBlocks.PLATINUM_BLOCK.value());
        this.dropSelf(ModBlocks.PLATED_PLATINUM.value());
        this.dropSelf(ModBlocks.PLATINUM_BARS.value());
        this.dropSelf(ModBlocks.PLATINUM_CHAIN.value());
        this.dropSelf(ModBlocks.PLATINUM_LANTERN.value());
        this.dropSelf(ModBlocks.PLATINUM_TORCH.value());
        this.dropSelf(ModBlocks.PLATINUM_JACK_O_LANTERN.value());
        this.dropSelf(ModBlocks.IMBUING_TABLE.value());
        this.dropNothing(ModBlocks.MAGIC_FIRE.value());
    }
}
