package fuzs.illagerinvasion.common.data.loot;

import fuzs.illagerinvasion.common.init.ModItems;
import fuzs.illagerinvasion.common.init.ModLootTables;
import fuzs.puzzleslib.common.api.data.v2.AbstractLootProvider;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithEnchantedBonusCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ModEntityAdditionsLootProvider extends AbstractLootProvider.Simple {

    public ModEntityAdditionsLootProvider(DataProviderContext context) {
        super(LootContextParamSets.ENTITY, context);
    }

    @Override
    public void addLootTables() {
        HolderLookup.Provider context = this.registries();
        this.add(ModLootTables.ILLUSIONER,
                ModEntityLootProvider.illagerTable(context)
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(Items.ARROW)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(context,
                                                UniformGenerator.between(0.0F, 1.0F)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.ILLUSIONARY_DUST.value()))
                                .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(
                                        context,
                                        0.4F,
                                        0.2F))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())));
        this.add(ModLootTables.PILLAGER, ModEntityLootProvider.platinumTable(context));
        this.add(ModLootTables.RAVAGER,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.PLATINUM_INGOT.value())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(context,
                                                UniformGenerator.between(0.0F, 1.0F))))));
    }
}
