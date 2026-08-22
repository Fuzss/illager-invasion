package fuzs.illagerinvasion.common.init;

import com.mojang.serialization.MapCodec;
import fuzs.illagerinvasion.common.IllagerInvasion;
import fuzs.illagerinvasion.common.world.inventory.ImbuingMenu;
import fuzs.illagerinvasion.common.world.item.enchantment.ImbuingEnchantmentLevel;
import fuzs.illagerinvasion.common.world.level.levelgen.structure.templatesystem.DataMarkerStructureProcessor;
import fuzs.multiloaderdataextensions.common.api.v2.DataMapRegistrar;
import fuzs.multiloaderdataextensions.common.api.v2.DataMapToken;
import fuzs.puzzleslib.common.api.init.v3.registry.RegistryManager;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

public class ModRegistry {
    public static final RegistrySetBuilder REGISTRIES_BUILDER = new RegistrySetBuilder().add(Registries.TRIM_MATERIAL,
                    ModTrimMaterials::bootstrap)
            .add(Registries.INSTRUMENT, ModInstruments::bootstrap)
            .add(Registries.STRUCTURE, ModStructures::bootstrap)
            .add(Registries.STRUCTURE_SET, ModStructureSets::bootstrap)
            .add(Registries.TEMPLATE_POOL, ModTemplatePools::bootstrap)
            .add(Registries.PROCESSOR_LIST, ModProcessorLists::bootstrap);
    static final RegistryManager REGISTRIES = RegistryManager.from(IllagerInvasion.MOD_ID);
    public static final Holder.Reference<MenuType<ImbuingMenu>> IMBUING_MENU_TYPE = REGISTRIES.registerMenuType(
            "imbuing",
            ImbuingMenu::new);
    public static final Holder.Reference<CreativeModeTab> CREATIVE_MODE_TAB = REGISTRIES.registerCreativeModeTab(() -> new ItemStack(
            ModItems.HORN_OF_SIGHT), (CreativeModeTab.DisplayItemsGenerator generator) -> {
        return (CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) -> {
            output.accept(ModItems.PLATINUM_BLOCK.value());
            ModBlockFamilies.PLATINUM.getItemVariants()
                    .values()
                    .stream()
                    .map(Holder.Reference::value)
                    .forEach(output::accept);
            generator.accept(parameters, output);
        };
    });
    public static final Holder.Reference<MapCodec<DataMarkerStructureProcessor>> DATA_MARKER_STRUCTURE_PROCESSOR = REGISTRIES.register(
            Registries.STRUCTURE_PROCESSOR,
            "data_marker",
            () -> DataMarkerStructureProcessor.MAP_CODEC);

    public static final DataMapToken<Enchantment, ImbuingEnchantmentLevel> IMBUING_LEVELS_DATA_MAP_TYPE = DataMapRegistrar.register(
            IllagerInvasion.id("imbuing_levels"),
            Registries.ENCHANTMENT,
            ImbuingEnchantmentLevel.CODEC,
            ImbuingEnchantmentLevel.INLINE_CODEC,
            true);

    public static void bootstrap() {
        ModBlocks.bootstrap();
        ModItems.bootstrap();
        ModEntityTypes.bootstrap();
        ModBlockFamilies.bootstrap();
        ModPotions.bootstrap();
        ModParticleTypes.bootstrap();
        ModSoundEvents.bootstrap();
        ModLootTables.bootstrap();
    }
}
