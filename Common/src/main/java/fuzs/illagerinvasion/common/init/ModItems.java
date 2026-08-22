package fuzs.illagerinvasion.common.init;

import fuzs.illagerinvasion.common.world.item.*;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.component.InstrumentComponent;
import net.minecraft.world.level.block.Block;

public class ModItems {
    public static final Holder.Reference<Item> PLATINUM_BLOCK = ModRegistry.REGISTRIES.registerBlockItem(ModBlocks.PLATINUM_BLOCK);
    public static final Holder.Reference<Item> PLATED_PLATINUM = ModRegistry.REGISTRIES.registerBlockItem(ModBlocks.PLATED_PLATINUM);
    public static final Holder.Reference<Item> PLATINUM_CHAIN = ModRegistry.REGISTRIES.registerBlockItem(ModBlocks.PLATINUM_CHAIN);
    public static final Holder.Reference<Item> PLATINUM_BARS = ModRegistry.REGISTRIES.registerBlockItem(ModBlocks.PLATINUM_BARS);
    public static final Holder.Reference<Item> PLATINUM_LANTERN = ModRegistry.REGISTRIES.registerBlockItem(ModBlocks.PLATINUM_LANTERN);
    public static final Holder.Reference<Item> PLATINUM_TORCH = ModRegistry.REGISTRIES.registerBlockItem(ModBlocks.PLATINUM_TORCH,
            (Block block, Item.Properties properties) -> new StandingAndWallBlockItem(block,
                    ModBlocks.PLATINUM_WALL_TORCH.value(),
                    Direction.DOWN,
                    properties));
    public static final Holder.Reference<Item> PLATINUM_JACK_O_LANTERN = ModRegistry.REGISTRIES.registerBlockItem(
            ModBlocks.PLATINUM_JACK_O_LANTERN);
    public static final Holder.Reference<Item> IMBUING_TABLE = ModRegistry.REGISTRIES.registerBlockItem(ModBlocks.IMBUING_TABLE);
    public static final Holder.Reference<Item> UNUSUAL_DUST = ModRegistry.REGISTRIES.registerItem("unusual_dust");
    public static final Holder.Reference<Item> MAGICAL_FIRE_CHARGE = ModRegistry.REGISTRIES.registerItem(
            "magical_fire_charge",
            MagicalFireChargeItem::new,
            Item.Properties::new);
    public static final Holder.Reference<Item> ILLUSIONARY_DUST = ModRegistry.REGISTRIES.registerItem("illusionary_dust",
            IllusionaryDustItem::new,
            Item.Properties::new);
    public static final Holder.Reference<Item> LOST_CANDLE = ModRegistry.REGISTRIES.registerItem("lost_candle",
            LostCandleItem::new,
            Item.Properties::new);
    public static final Holder.Reference<Item> HORN_OF_SIGHT = ModRegistry.REGISTRIES.registerItem("horn_of_sight",
            HornOfSightItem::new,
            () -> new Item.Properties().rarity(Rarity.UNCOMMON)
                    .stacksTo(1)
                    .delayedComponent(DataComponents.INSTRUMENT, (HolderLookup.Provider context) -> {
                        return new InstrumentComponent(context.getOrThrow(ModInstruments.REVEAL));
                    }));
    public static final Holder.Reference<Item> HALLOWED_GEM = ModRegistry.REGISTRIES.registerItem("hallowed_gem",
            () -> new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final Holder.Reference<Item> PRIMAL_ESSENCE = ModRegistry.REGISTRIES.registerItem("primal_essence",
            () -> new Item.Properties().rarity(Rarity.RARE));
    public static final Holder.Reference<Item> PLATINUM_NUGGET = ModRegistry.REGISTRIES.registerItem("platinum_nugget");
    public static final Holder.Reference<Item> PLATINUM_INGOT = ModRegistry.REGISTRIES.registerItem("platinum_ingot",
            () -> new Item.Properties().trimMaterial(ModTrimMaterials.PLATINUM));
    public static final Holder.Reference<Item> PLATINUM_INFUSED_HATCHET = ModRegistry.REGISTRIES.registerItem(
            "platinum_infused_hatchet",
            HatchetItem::new,
            () -> new Item.Properties().rarity(Rarity.EPIC)
                    .durability(327)
                    .attributes(HatchetItem.createAttributes())
                    .component(DataComponents.TOOL, HatchetItem.createToolProperties())
                    .enchantable(1)
                    .repairable(ModItems.PLATINUM_INGOT.value()));
    public static final Holder.Reference<Item> PROVOKER_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.PROVOKER);
    public static final Holder.Reference<Item> BASHER_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.BASHER);
    public static final Holder.Reference<Item> SORCERER_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.SORCERER);
    public static final Holder.Reference<Item> ARCHIVIST_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.ARCHIVIST);
    public static final Holder.Reference<Item> INQUISITOR_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.INQUISITOR);
    public static final Holder.Reference<Item> MARAUDER_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.MARAUDER);
    public static final Holder.Reference<Item> INVOKER_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.INVOKER);
    public static final Holder.Reference<Item> ALCHEMIST_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.ALCHEMIST);
    public static final Holder.Reference<Item> FIRECALLER_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.FIRECALLER);
    public static final Holder.Reference<Item> NECROMANCER_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.NECROMANCER);
    public static final Holder.Reference<Item> SURRENDERED_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.SURRENDERED);
    public static final Holder.Reference<Item> ILLUSIONER_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem((Holder<? extends EntityType<? extends Mob>>) (Holder<?>) EntityTypes.ILLUSIONER.builtInRegistryHolder());

    public static void bootstrap() {
        // NO-OP
    }
}
