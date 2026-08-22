package fuzs.illagerinvasion.common.init;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import fuzs.illagerinvasion.common.util.WoodlandMansionPieceHelper;
import fuzs.illagerinvasion.common.world.level.levelgen.structure.templatesystem.DataMarkerStructureProcessor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class ModProcessorLists {
    public static final ResourceKey<StructureProcessorList> WOODLAND_MANSION_1X2_A4 = ResourceKey.create(Registries.PROCESSOR_LIST,
            Identifier.withDefaultNamespace("woodland_mansion/1x2_a4"));
    public static final ResourceKey<StructureProcessorList> WOODLAND_MANSION_1X2_A9 = ResourceKey.create(Registries.PROCESSOR_LIST,
            Identifier.withDefaultNamespace("woodland_mansion/1x2_a9"));
    public static final ResourceKey<StructureProcessorList> WOODLAND_MANSION_1X2_B3 = ResourceKey.create(Registries.PROCESSOR_LIST,
            Identifier.withDefaultNamespace("woodland_mansion/1x2_b3"));
    public static final ResourceKey<StructureProcessorList> WOODLAND_MANSION_1X2_C1 = ResourceKey.create(Registries.PROCESSOR_LIST,
            Identifier.withDefaultNamespace("woodland_mansion/1x2_c1"));
    public static final ResourceKey<StructureProcessorList> WOODLAND_MANSION_1X2_C4 = ResourceKey.create(Registries.PROCESSOR_LIST,
            Identifier.withDefaultNamespace("woodland_mansion/1x2_c4"));
    public static final ResourceKey<StructureProcessorList> WOODLAND_MANSION_1X2_C_STAIRS = ResourceKey.create(
            Registries.PROCESSOR_LIST,
            Identifier.withDefaultNamespace("woodland_mansion/1x2_c_stairs"));
    public static final ResourceKey<StructureProcessorList> WOODLAND_MANSION_1X2_D5 = ResourceKey.create(Registries.PROCESSOR_LIST,
            Identifier.withDefaultNamespace("woodland_mansion/1x2_d5"));
    public static final ResourceKey<StructureProcessorList> WOODLAND_MANSION_1X2_D_STAIRS = ResourceKey.create(
            Registries.PROCESSOR_LIST,
            Identifier.withDefaultNamespace("woodland_mansion/1x2_d_stairs"));
    public static final ResourceKey<StructureProcessorList> WOODLAND_MANSION_2X2_A3 = ResourceKey.create(Registries.PROCESSOR_LIST,
            Identifier.withDefaultNamespace("woodland_mansion/2x2_a3"));
    public static final ResourceKey<StructureProcessorList> WOODLAND_MANSION_2X2_B1 = ResourceKey.create(Registries.PROCESSOR_LIST,
            Identifier.withDefaultNamespace("woodland_mansion/2x2_b1"));
    public static final ResourceKey<StructureProcessorList> WOODLAND_MANSION_2X2_B2 = ResourceKey.create(Registries.PROCESSOR_LIST,
            Identifier.withDefaultNamespace("woodland_mansion/2x2_b2"));
    public static final ResourceKey<StructureProcessorList> WOODLAND_MANSION_2X2_B3 = ResourceKey.create(Registries.PROCESSOR_LIST,
            Identifier.withDefaultNamespace("woodland_mansion/2x2_b3"));
    public static final ResourceKey<StructureProcessorList> WOODLAND_MANSION_2X2_B5 = ResourceKey.create(Registries.PROCESSOR_LIST,
            Identifier.withDefaultNamespace("woodland_mansion/2x2_b5"));

    public static void bootstrap(BootstrapContext<StructureProcessorList> context) {
        context.register(WOODLAND_MANSION_1X2_A4,
                new StructureProcessorList(ImmutableList.of(new DataMarkerStructureProcessor(ImmutableMap.of(new BlockPos(
                        3,
                        2,
                        11), WoodlandMansionPieceHelper.PROVOKER_DATA_MARKER)))));
        context.register(WOODLAND_MANSION_1X2_A9,
                new StructureProcessorList(ImmutableList.of(new DataMarkerStructureProcessor(ImmutableMap.of(new BlockPos(
                        2,
                        1,
                        7), WoodlandMansionPieceHelper.PROVOKER_DATA_MARKER)))));
        context.register(WOODLAND_MANSION_1X2_B3,
                new StructureProcessorList(ImmutableList.of(new DataMarkerStructureProcessor(ImmutableMap.of(new BlockPos(
                        3,
                        1,
                        8), WoodlandMansionPieceHelper.PROVOKER_DATA_MARKER)))));
        context.register(WOODLAND_MANSION_1X2_C1,
                new StructureProcessorList(ImmutableList.of(new DataMarkerStructureProcessor(ImmutableMap.of(new BlockPos(
                                1,
                                1,
                                10),
                        WoodlandMansionPieceHelper.ARCHIVIST_DATA_MARKER,
                        new BlockPos(5, 1, 10),
                        WoodlandMansionPieceHelper.ARCHIVIST_DATA_MARKER)))));
        context.register(WOODLAND_MANSION_1X2_C4,
                new StructureProcessorList(ImmutableList.of(new DataMarkerStructureProcessor(ImmutableMap.of(new BlockPos(
                                3,
                                1,
                                2),
                        WoodlandMansionPieceHelper.ARCHIVIST_DATA_MARKER,
                        new BlockPos(3, 1, 12),
                        WoodlandMansionPieceHelper.BASHER_DATA_MARKER)))));
        context.register(WOODLAND_MANSION_1X2_C_STAIRS,
                new StructureProcessorList(ImmutableList.of(new DataMarkerStructureProcessor(ImmutableMap.of(new BlockPos(
                        3,
                        11,
                        11), WoodlandMansionPieceHelper.INVOKER_DATA_MARKER)))));
        context.register(WOODLAND_MANSION_1X2_D5,
                new StructureProcessorList(ImmutableList.of(new DataMarkerStructureProcessor(ImmutableMap.of(new BlockPos(
                        3,
                        1,
                        10), WoodlandMansionPieceHelper.PROVOKER_DATA_MARKER)))));
        context.register(WOODLAND_MANSION_1X2_D_STAIRS,
                new StructureProcessorList(ImmutableList.of(new DataMarkerStructureProcessor(ImmutableMap.of(new BlockPos(
                        3,
                        11,
                        3), WoodlandMansionPieceHelper.INVOKER_DATA_MARKER)))));
        context.register(WOODLAND_MANSION_2X2_A3,
                new StructureProcessorList(ImmutableList.of(new DataMarkerStructureProcessor(ImmutableMap.of(new BlockPos(
                                6,
                                1,
                                5),
                        WoodlandMansionPieceHelper.PROVOKER_DATA_MARKER,
                        new BlockPos(8, 1, 5),
                        WoodlandMansionPieceHelper.BASHER_DATA_MARKER)))));
        context.register(WOODLAND_MANSION_2X2_B1,
                new StructureProcessorList(ImmutableList.of(new DataMarkerStructureProcessor(ImmutableMap.of(new BlockPos(
                        9,
                        1,
                        6), WoodlandMansionPieceHelper.PROVOKER_DATA_MARKER, new BlockPos(0, 1, 0), "ChestEast")))));
        context.register(WOODLAND_MANSION_2X2_B2,
                new StructureProcessorList(ImmutableList.of(new DataMarkerStructureProcessor(ImmutableMap.of(new BlockPos(
                        12,
                        1,
                        6), WoodlandMansionPieceHelper.ARCHIVIST_DATA_MARKER)))));
        context.register(WOODLAND_MANSION_2X2_B3,
                new StructureProcessorList(ImmutableList.of(new DataMarkerStructureProcessor(ImmutableMap.of(new BlockPos(
                                1,
                                1,
                                2),
                        WoodlandMansionPieceHelper.ARCHIVIST_DATA_MARKER,
                        new BlockPos(1, 1, 4),
                        WoodlandMansionPieceHelper.BASHER_DATA_MARKER,
                        new BlockPos(1, 1, 12),
                        WoodlandMansionPieceHelper.ARCHIVIST_DATA_MARKER,
                        new BlockPos(0, 1, 7),
                        "ChestEast")))));
        context.register(WOODLAND_MANSION_2X2_B5,
                new StructureProcessorList(ImmutableList.of(new DataMarkerStructureProcessor(ImmutableMap.of(new BlockPos(
                                7,
                                1,
                                12),
                        WoodlandMansionPieceHelper.PROVOKER_DATA_MARKER,
                        new BlockPos(7, 1, 2),
                        WoodlandMansionPieceHelper.BASHER_DATA_MARKER)))));
    }
}
