package fuzs.illagerinvasion.common.init;

import fuzs.illagerinvasion.common.world.level.block.ImbuingTableBlock;
import fuzs.illagerinvasion.common.world.level.block.MagicFireBlock;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class ModBlocks {
    public static final Holder.Reference<Block> IMBUING_TABLE = ModRegistry.REGISTRIES.registerBlock("imbuing_table",
            ImbuingTableBlock::new,
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK.weathering().unaffected()));
    public static final Holder.Reference<Block> MAGIC_FIRE = ModRegistry.REGISTRIES.registerBlock("magic_fire",
            MagicFireBlock::new,
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_FIRE).mapColor(MapColor.COLOR_PURPLE).randomTicks());

    public static void bootstrap() {
        // NO-OP
    }
}
