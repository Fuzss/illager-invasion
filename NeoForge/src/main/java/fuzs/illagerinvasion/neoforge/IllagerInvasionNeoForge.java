package fuzs.illagerinvasion.neoforge;

import fuzs.illagerinvasion.common.IllagerInvasion;
import fuzs.illagerinvasion.common.data.ModRecipeProvider;
import fuzs.illagerinvasion.common.data.loot.ModBlockLootProvider;
import fuzs.illagerinvasion.common.data.loot.ModChestLootProvider;
import fuzs.illagerinvasion.common.data.loot.ModEntityAdditionsLootProvider;
import fuzs.illagerinvasion.common.data.loot.ModEntityLootProvider;
import fuzs.illagerinvasion.common.data.tags.ModBiomeTagsProvider;
import fuzs.illagerinvasion.common.data.tags.ModBlockTagsProvider;
import fuzs.illagerinvasion.common.data.tags.ModEntityTagsProvider;
import fuzs.illagerinvasion.common.data.tags.ModItemTagsProvider;
import fuzs.illagerinvasion.common.init.ModRegistry;
import fuzs.illagerinvasion.neoforge.data.ModDataMapProvider;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v2.core.DataProviderHelper;
import net.neoforged.fml.common.Mod;

@Mod(IllagerInvasion.MOD_ID)
public class IllagerInvasionNeoForge {

    public IllagerInvasionNeoForge() {
        ModConstructor.construct(IllagerInvasion.MOD_ID, IllagerInvasion::new);
        DataProviderHelper.registerDataProviders(IllagerInvasion.MOD_ID,
                ModRegistry.REGISTRIES_BUILDER,
                ModBiomeTagsProvider::new,
                ModBlockTagsProvider::new,
                ModEntityTagsProvider::new,
                ModItemTagsProvider::new,
                ModBlockLootProvider::new,
                ModChestLootProvider::new,
                ModEntityAdditionsLootProvider::new,
                ModEntityLootProvider::new,
                ModRecipeProvider::new,
                ModDataMapProvider::new);
    }
}
