package fuzs.illagerinvasion.common.init;

import fuzs.puzzleslib.common.api.data.v2.AbstractDatapackRegistriesProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.TrimMaterial;

public class ModTrimMaterials {
    public static final ResourceKey<TrimMaterial> PLATINUM = ModRegistry.REGISTRIES.makeResourceKey(Registries.TRIM_MATERIAL,
            "platinum");

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        AbstractDatapackRegistriesProvider.registerTrimMaterial(context,
                PLATINUM,
                ModItems.PLATINUM_INGOT.value(),
                0x527D7C);
    }
}
