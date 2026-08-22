package fuzs.illagerinvasion.common.init;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.HashMap;
import java.util.Map;

public class ModLootTables {
    private static final Map<Identifier, ResourceKey<LootTable>> LOOT_TABLE_ADDITIONS = new HashMap<>();
    public static final ResourceKey<LootTable> ILLAGER_FORT_TOWER = ModRegistry.REGISTRIES.makeResourceKey(Registries.LOOT_TABLE,
            "chests/illager_fort_tower");
    public static final ResourceKey<LootTable> ILLAGER_FORT_GROUND = ModRegistry.REGISTRIES.makeResourceKey(Registries.LOOT_TABLE,
            "chests/illager_fort_ground");
    public static final ResourceKey<LootTable> ILLUSIONER_TOWER_ENTRANCE = ModRegistry.REGISTRIES.makeResourceKey(
            Registries.LOOT_TABLE,
            "chests/illusioner_tower_entrance");
    public static final ResourceKey<LootTable> ILLUSIONER_TOWER_STAIRS = ModRegistry.REGISTRIES.makeResourceKey(
            Registries.LOOT_TABLE,
            "chests/illusioner_tower_stairs");
    public static final ResourceKey<LootTable> LABYRINTH = ModRegistry.REGISTRIES.makeResourceKey(Registries.LOOT_TABLE,
            "chests/labyrinth");
    public static final ResourceKey<LootTable> LABYRINTH_MAP = ModRegistry.REGISTRIES.makeResourceKey(Registries.LOOT_TABLE,
            "chests/labyrinth_map");
    public static final ResourceKey<LootTable> SORCERER_HUT = ModRegistry.REGISTRIES.makeResourceKey(Registries.LOOT_TABLE,
            "chests/sorcerer_hut");
    public static final ResourceKey<LootTable> ILLUSIONER = registerLootTableAddition(EntityTypes.ILLUSIONER.getDefaultLootTable()
            .orElseThrow());
    public static final ResourceKey<LootTable> PILLAGER = registerLootTableAddition(EntityTypes.PILLAGER.getDefaultLootTable()
            .orElseThrow());
    public static final ResourceKey<LootTable> RAVAGER = registerLootTableAddition(EntityTypes.RAVAGER.getDefaultLootTable()
            .orElseThrow());

    public static void bootstrap() {
        // NO-OP
    }

    private static ResourceKey<LootTable> registerLootTableAddition(ResourceKey<LootTable> key) {
        ResourceKey<LootTable> updatedKey = ModRegistry.REGISTRIES.makeResourceKey(Registries.LOOT_TABLE,
                "inject/" + key.identifier().getPath());
        LOOT_TABLE_ADDITIONS.put(key.identifier(), updatedKey);
        return updatedKey;
    }

    public static void onLootTableLoad(Identifier identifier, LootTable.Builder lootTable, HolderLookup.Provider registries) {
        if (LOOT_TABLE_ADDITIONS.containsKey(identifier)) {
            lootTable.withPool(LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1.0F))
                    .add(NestedLootTable.lootTableReference(LOOT_TABLE_ADDITIONS.get(identifier))));
        }
    }
}
