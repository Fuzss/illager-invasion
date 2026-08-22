package fuzs.illagerinvasion.common.data.client;

import fuzs.illagerinvasion.common.init.ModBlocks;
import fuzs.illagerinvasion.common.init.ModItems;
import fuzs.puzzleslib.common.api.client.data.v2.AbstractModelProvider;
import fuzs.puzzleslib.common.api.client.data.v2.models.ItemModelGenerationHelper;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;

public class ModModelProvider extends AbstractModelProvider {

    public ModModelProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addBlockModels(BlockModelGenerators generator) {
        this.createImbuingTable(ModBlocks.IMBUING_TABLE.value(), generator);
        this.createSimpleFire(ModBlocks.MAGIC_FIRE.value(), generator);
    }

    public final void createImbuingTable(Block block, BlockModelGenerators generator) {
        TextureMapping textureMapping = TextureMapping.craftingTable(block, block)
                .put(TextureSlot.DOWN, TextureMapping.getBlockTexture(block, "_bottom"));
        Identifier identifier = ModelTemplates.CUBE.create(block, textureMapping, generator.modelOutput);
        generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block,
                BlockModelGenerators.plainVariant(identifier)));
    }

    public final void createSimpleFire(Block block, BlockModelGenerators generator) {
        MultiVariant multiVariant = generator.createFloorFireModels(block);
        MultiVariant multiVariant2 = generator.createSideFireModels(block);
        generator.blockStateOutput.accept(MultiPartGenerator.multiPart(block)
                .with(multiVariant)
                .with(multiVariant2)
                .with(multiVariant2.with(BlockModelGenerators.Y_ROT_90))
                .with(multiVariant2.with(BlockModelGenerators.Y_ROT_180))
                .with(multiVariant2.with(BlockModelGenerators.Y_ROT_270)));
    }

    @Override
    public void addItemModels(ItemModelGenerators generator) {
        generator.generateFlatItem(ModItems.HALLOWED_GEM.value(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.ILLUSIONARY_DUST.value(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.PLATINUM_NUGGET.value(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.PLATINUM_INGOT.value(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.PRIMAL_ESSENCE.value(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.UNUSUAL_DUST.value(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.LOST_CANDLE.value(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.PLATINUM_INFUSED_HATCHET.value(), ModelTemplates.FLAT_HANDHELD_ITEM);
        ItemModelGenerationHelper.generateFlatItem(ModItems.MAGICAL_FIRE_CHARGE.value(),
                new Material(ModAtlasProvider.DRAGON_FIREBALL_LOCATION.texture()),
                ModelTemplates.FLAT_ITEM,
                generator);
        generator.generateFlatItem(ModItems.ALCHEMIST_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.ARCHIVIST_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.BASHER_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.FIRECALLER_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.INQUISITOR_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.MARAUDER_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.INVOKER_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.NECROMANCER_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.PROVOKER_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.SORCERER_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.SURRENDERED_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.ILLUSIONER_SPAWN_EGG.value(), ModelTemplates.FLAT_ITEM);
        ItemModelGenerationHelper.generateHorn(ModItems.HORN_OF_SIGHT.value(), generator);
    }
}
