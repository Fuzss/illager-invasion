package fuzs.illagerinvasion.common.init;

import fuzs.puzzleslib.common.api.init.v3.family.BlockSetFamily;
import fuzs.puzzleslib.common.api.init.v3.family.BlockSetVariant;

public class ModBlockFamilies {
    public static final BlockSetFamily PLATINUM = BlockSetFamily.metal(ModRegistry.REGISTRIES,
            ModBlocks.PLATINUM_BLOCK,
            "platinum").generateFor(BlockSetVariant.CHISELED).generateFor(BlockSetVariant.CUT);

    public static void bootstrap() {
        // NO-OP
    }
}
