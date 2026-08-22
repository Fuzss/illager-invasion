package fuzs.illagerinvasion.common.init;

import fuzs.puzzleslib.common.api.init.v3.family.BlockSetFamily;
import fuzs.puzzleslib.common.api.init.v3.family.BlockSetVariant;
import net.minecraft.data.BlockFamily;

import java.util.stream.Stream;

public class ModBlockFamilies {
    public static final BlockSetFamily PLATINUM = BlockSetFamily.base(ModRegistry.REGISTRIES,
                    ModBlocks.PLATINUM_BLOCK,
                    "platinum")
            .configureBlockFamily(BlockFamily.Builder::generateStonecutterRecipe)
            .generateFor(BlockSetVariant.DOOR)
            .generateFor(BlockSetVariant.TRAPDOOR)
            .generateFor(BlockSetVariant.CUT);
    public static final BlockSetFamily CUT_PLATINUM = BlockSetFamily.base(ModRegistry.REGISTRIES,
                    PLATINUM.getBlock(BlockSetVariant.CUT),
                    "cut_platinum")
            .configureBlockFamily(BlockFamily.Builder::generateStonecutterRecipe)
            .generateFor(BlockSetVariant.CHISELED, "chiseled_platinum")
            .generateFor(BlockSetVariant.STAIRS)
            .generateFor(BlockSetVariant.SLAB);

    public static void bootstrap() {
        // NO-OP
    }

    public static Stream<BlockSetFamily> getAllBlockSetFamilies() {
        return Stream.of(PLATINUM, CUT_PLATINUM);
    }
}
