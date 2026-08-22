package fuzs.illagerinvasion.common.data.loot;

import fuzs.illagerinvasion.common.init.ModBlocks;
import fuzs.puzzleslib.common.api.data.v2.AbstractLootProvider;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;

public class ModBlockLootProvider extends AbstractLootProvider.Blocks {

    public ModBlockLootProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addLootTables() {
        this.dropSelf(ModBlocks.IMBUING_TABLE.value());
        this.dropNothing(ModBlocks.MAGIC_FIRE.value());
    }
}
