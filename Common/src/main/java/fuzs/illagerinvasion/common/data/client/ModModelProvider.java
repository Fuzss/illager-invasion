package fuzs.illagerinvasion.common.data.client;

import com.google.common.collect.ImmutableMap;
import fuzs.illagerinvasion.common.IllagerInvasion;
import fuzs.illagerinvasion.common.init.ModBlockFamilies;
import fuzs.illagerinvasion.common.init.ModBlocks;
import fuzs.illagerinvasion.common.init.ModItems;
import fuzs.puzzleslib.common.api.client.data.v2.AbstractModelProvider;
import fuzs.puzzleslib.common.api.client.data.v2.models.ItemModelGenerationHelper;
import fuzs.puzzleslib.common.api.client.data.v2.models.ModelLocationHelper;
import fuzs.puzzleslib.common.api.client.data.v2.models.ModelTemplateHelper;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.common.api.init.v3.family.BlockSetFamily;
import fuzs.puzzleslib.common.api.init.v3.family.BlockSetVariant;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.Collections;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * TODO cut platinum side texture is not correct, also stairs and slabs should probably use a separate texture
 */
public class ModModelProvider extends AbstractModelProvider {
    public static final Map<BlockSetVariant, BiConsumer<BlockModelGenerators, Block>> VARIANT_BLOCK_PROVIDERS = ImmutableMap.<BlockSetVariant, BiConsumer<BlockModelGenerators, Block>>builder()
            .put(BlockSetVariant.CUT, BlockModelGenerators::createTrivialCube)
            .build();
    public static final ModelTemplate LANTERN_TEMPLATE = ModelTemplateHelper.createBlockModelTemplate(IllagerInvasion.id(
            "template_lantern"), TextureSlot.LANTERN, TextureSlot.END);
    public static final ModelTemplate HANGING_LANTERN_TEMPLATE = ModelTemplateHelper.createBlockModelTemplate(
            IllagerInvasion.id("template_hanging_lantern"),
            "_hanging",
            TextureSlot.LANTERN,
            TextureSlot.END);
    public static final ModelTemplate CHAIN_TEMPLATE = ModelTemplateHelper.createBlockModelTemplate(IllagerInvasion.id(
            "template_chain"), TextureSlot.TEXTURE);
    public static final TexturedModel.Provider CHAIN_PROVIDER = TexturedModel.createDefault(TextureMapping::defaultTexture,
            CHAIN_TEMPLATE);

    public ModModelProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addBlockModels(BlockModelGenerators generators) {
        generators.createTrivialCube(ModBlocks.PLATINUM_BLOCK.value());
        ModBlockFamilies.getAllBlockSetFamilies().forEach((BlockSetFamily family) -> {
            this.generateForBlocks(generators, family, VARIANT_BLOCK_PROVIDERS);
        });
        generators.createTrivialCube(ModBlocks.PLATED_PLATINUM.value());
        generators.createBarsAndItem(ModBlocks.PLATINUM_BARS.value());
        generators.registerSimpleFlatItemModel(ModBlocks.PLATINUM_CHAIN.value());
        generators.createAxisAlignedPillarBlockCustomModel(ModBlocks.PLATINUM_CHAIN.value(),
                BlockModelGenerators.plainVariant(CHAIN_PROVIDER.create(ModBlocks.PLATINUM_CHAIN.value(),
                        generators.modelOutput)));
        this.createLantern(ModBlocks.PLATINUM_LANTERN.value(), generators);
        generators.createNormalTorch(ModBlocks.PLATINUM_TORCH.value(), ModBlocks.PLATINUM_WALL_TORCH.value());
        generators.createPumpkinVariant(ModBlocks.PLATINUM_JACK_O_LANTERN.value(),
                TextureMapping.column(Blocks.PUMPKIN));
        this.createImbuingTable(ModBlocks.IMBUING_TABLE.value(), generators);
        this.createSimpleFire(ModBlocks.MAGIC_FIRE.value(), generators);
    }

    /**
     * @see BlockModelGenerators#createLantern(Block)
     */
    public final void createLantern(Block block, BlockModelGenerators generators) {
        TextureMapping mapping = TextureMapping.lantern(block)
                .put(TextureSlot.END, ModelLocationHelper.getBlockTexture(ModBlocks.PLATINUM_BLOCK.value()));
        MultiVariant ground = BlockModelGenerators.plainVariant(LANTERN_TEMPLATE.create(block,
                mapping,
                generators.modelOutput));
        MultiVariant hanging = BlockModelGenerators.plainVariant(HANGING_LANTERN_TEMPLATE.create(block,
                mapping,
                generators.modelOutput));
        generators.registerSimpleFlatItemModel(block.asItem());
        generators.blockStateOutput.accept(MultiVariantGenerator.dispatch(block)
                .with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.HANGING, hanging, ground)));
    }

    public final void createImbuingTable(Block block, BlockModelGenerators generators) {
        TextureMapping textureMapping = TextureMapping.craftingTable(block, block)
                .put(TextureSlot.DOWN, TextureMapping.getBlockTexture(block, "_bottom"));
        Identifier identifier = ModelTemplates.CUBE.create(block, textureMapping, generators.modelOutput);
        generators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block,
                BlockModelGenerators.plainVariant(identifier)));
    }

    /**
     * @see BlockModelGenerators#createSoulFire()
     */
    public final void createSimpleFire(Block block, BlockModelGenerators generators) {
        MultiVariant floorFireModels = generators.createFloorFireModels(block);
        MultiVariant sideFireModels = generators.createSideFireModels(block);
        generators.blockStateOutput.accept(MultiPartGenerator.multiPart(block)
                .with(floorFireModels)
                .with(sideFireModels)
                .with(sideFireModels.with(BlockModelGenerators.Y_ROT_90))
                .with(sideFireModels.with(BlockModelGenerators.Y_ROT_180))
                .with(sideFireModels.with(BlockModelGenerators.Y_ROT_270)));
    }

    @Override
    public void addItemModels(ItemModelGenerators generators) {
        this.generateForItems(generators, ModBlockFamilies.PLATINUM, Collections.emptyMap());
        generators.generateFlatItem(ModItems.HALLOWED_GEM.value(), ModelTemplates.FLAT_ITEM);
        generators.generateFlatItem(ModItems.ILLUSIONARY_DUST.value(), ModelTemplates.FLAT_ITEM);
        generators.generateFlatItem(ModItems.PLATINUM_NUGGET.value(), ModelTemplates.FLAT_ITEM);
        generators.generateFlatItem(ModItems.PLATINUM_INGOT.value(), ModelTemplates.FLAT_ITEM);
        generators.generateFlatItem(ModItems.PRIMAL_ESSENCE.value(), ModelTemplates.FLAT_ITEM);
        generators.generateFlatItem(ModItems.UNUSUAL_DUST.value(), ModelTemplates.FLAT_ITEM);
        generators.generateFlatItem(ModItems.LOST_CANDLE.value(), ModelTemplates.FLAT_ITEM);
        generators.generateFlatItem(ModItems.PLATINUM_INFUSED_HATCHET.value(), ModelTemplates.FLAT_HANDHELD_ITEM);
        ItemModelGenerationHelper.generateFlatItem(ModItems.MAGICAL_FIRE_CHARGE.value(),
                new Material(ModAtlasProvider.DRAGON_FIREBALL_LOCATION.texture()),
                ModelTemplates.FLAT_ITEM,
                generators);
        generators.generateFlatItem(ModItems.ALCHEMIST_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generators.generateFlatItem(ModItems.ARCHIVIST_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generators.generateFlatItem(ModItems.BASHER_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generators.generateFlatItem(ModItems.FIRECALLER_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generators.generateFlatItem(ModItems.INQUISITOR_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generators.generateFlatItem(ModItems.MARAUDER_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generators.generateFlatItem(ModItems.INVOKER_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generators.generateFlatItem(ModItems.NECROMANCER_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generators.generateFlatItem(ModItems.PROVOKER_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generators.generateFlatItem(ModItems.SORCERER_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generators.generateFlatItem(ModItems.SURRENDERED_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generators.generateFlatItem(ModItems.ILLUSIONER_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        ItemModelGenerationHelper.generateHorn(ModItems.HORN_OF_SIGHT.value(), generators);
    }
}
