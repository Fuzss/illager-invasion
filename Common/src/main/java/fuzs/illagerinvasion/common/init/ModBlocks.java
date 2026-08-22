package fuzs.illagerinvasion.common.init;

import fuzs.illagerinvasion.common.world.level.block.ImbuingTableBlock;
import fuzs.illagerinvasion.common.world.level.block.MagicFireBlock;
import fuzs.illagerinvasion.common.world.level.block.PlatinumChainBlock;
import fuzs.illagerinvasion.common.world.level.block.PlatinumLanternBlock;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class ModBlocks {
    public static final Holder.Reference<Block> PLATINUM_BLOCK = ModRegistry.REGISTRIES.registerBlock("platinum_block",
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final Holder.Reference<Block> PLATED_PLATINUM = ModRegistry.REGISTRIES.registerBlock("plated_platinum",
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final Holder.Reference<Block> PLATINUM_BARS = ModRegistry.REGISTRIES.registerBlock("platinum_bars",
            IronBarsBlock::new,
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BARS));
    public static final Holder.Reference<Block> PLATINUM_CHAIN = ModRegistry.REGISTRIES.registerBlock("platinum_chain",
            PlatinumChainBlock::new,
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_CHAIN));
    public static final Holder.Reference<Block> PLATINUM_LANTERN = ModRegistry.REGISTRIES.registerBlock(
            "platinum_lantern",
            PlatinumLanternBlock::new,
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN));
    public static final Holder.Reference<Block> PLATINUM_TORCH = ModRegistry.REGISTRIES.registerBlock("platinum_torch",
            (BlockBehaviour.Properties properties) -> new TorchBlock(ModParticleTypes.PLATINUM_FIRE_FLAME.value(),
                    properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH));
    public static final Holder.Reference<Block> PLATINUM_WALL_TORCH = ModRegistry.REGISTRIES.registerBlock(
            "platinum_wall_torch",
            (BlockBehaviour.Properties properties) -> new WallTorchBlock(ModParticleTypes.PLATINUM_FIRE_FLAME.value(),
                    properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH)
                    .overrideLootTable(PLATINUM_TORCH.value().getLootTable())
                    .overrideDescription(PLATINUM_TORCH.value().getDescriptionId()));
    public static final Holder.Reference<Block> PLATINUM_JACK_O_LANTERN = ModRegistry.REGISTRIES.registerBlock(
            "platinum_jack_o_lantern",
            CarvedPumpkinBlock::new,
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.JACK_O_LANTERN));
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
