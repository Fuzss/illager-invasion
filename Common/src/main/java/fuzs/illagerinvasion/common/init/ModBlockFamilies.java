package fuzs.illagerinvasion.common.init;

import fuzs.puzzleslib.common.api.init.v3.family.BlockSetFamily;
import fuzs.puzzleslib.common.api.init.v3.family.BlockSetVariant;
import fuzs.puzzleslib.common.api.init.v3.registry.RegistryManager;
import net.minecraft.core.Holder;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;

/**
 * TODO add separate family for cut copper which has stairs and slabs, not the default one. Also move the chiseled block to that.
 * TODO also add manual stonecutter recipes from the base platinum block
 */
public class ModBlockFamilies {
    public static final BlockSetFamily PLATINUM = BlockSetFamily.metal(ModRegistry.REGISTRIES,
            ModBlocks.PLATINUM_BLOCK,
            "platinum").generateFor(BlockSetVariant.CHISELED).generateFor(BlockSetVariant.CUT);

    public static void bootstrap() {
        // NO-OP
    }

    private static BlockSetFamily.Writable metal(RegistryManager registries, Holder.Reference<Block> baseBlock, String baseName) {
        return BlockSetFamily.base(registries, baseBlock, baseName)
                .configureBlockFamily(BlockFamily.Builder::generateStonecutterRecipe)
                .generateFor(BlockSetVariant.DOOR)
                .generateFor(BlockSetVariant.TRAPDOOR)
                .generateFor(BlockSetVariant.PRESSURE_PLATE);
    }
}
