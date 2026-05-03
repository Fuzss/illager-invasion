package fuzs.illagerinvasion.common.data.loot;

import fuzs.illagerinvasion.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.data.v2.AbstractLootProvider;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;

public class ModBlockLootProvider extends AbstractLootProvider.Blocks {

    public ModBlockLootProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addLootTables() {
        this.dropSelf(ModRegistry.IMBUING_TABLE_BLOCK.value());
        this.dropNothing(ModRegistry.MAGIC_FIRE_BLOCK.value());
    }
}
