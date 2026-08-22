package fuzs.illagerinvasion.common;

import fuzs.illagerinvasion.common.config.ServerConfig;
import fuzs.illagerinvasion.common.handler.VillagerGoalHandler;
import fuzs.illagerinvasion.common.init.*;
import fuzs.puzzleslib.common.api.config.v3.ConfigHolder;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.common.api.core.v1.context.EntityAttributesContext;
import fuzs.puzzleslib.common.api.core.v1.context.SpawnPlacementsContext;
import fuzs.puzzleslib.common.api.event.v1.entity.ServerEntityEvents;
import fuzs.puzzleslib.common.api.event.v1.server.LootTableLoadCallback;
import fuzs.puzzleslib.common.api.event.v1.server.RegisterPotionBrewingMixesCallback;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.PatrollingMonster;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.levelgen.Heightmap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IllagerInvasion implements ModConstructor {
    public static final String MOD_ID = "illagerinvasion";
    public static final String MOD_NAME = "Illager Invasion";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static final ConfigHolder CONFIG = ConfigHolder.builder(MOD_ID).server(ServerConfig.class);

    @Override
    public void onConstructMod() {
        ModRegistry.bootstrap();
        registerEventHandlers();
    }

    @Override
    public void onCommonSetup() {
        ModEnumConstants.bootstrap();
    }

    private static void registerEventHandlers() {
        ServerEntityEvents.LOAD.register(VillagerGoalHandler::onEntityLoad);
        LootTableLoadCallback.EVENT.register(ModLootTables::onLootTableLoad);
        RegisterPotionBrewingMixesCallback.EVENT.register(IllagerInvasion::registerPotionRecipes);
    }

    private static void registerPotionRecipes(RegisterPotionBrewingMixesCallback.Builder builder) {
        builder.registerPotionRecipe(Potions.AWKWARD, Items.GOAT_HORN, ModPotions.BERSERKING);
        builder.registerPotionRecipe(ModPotions.BERSERKING, Items.REDSTONE, ModPotions.LONG_BERSERKING);
        builder.registerPotionRecipe(ModPotions.BERSERKING,
                Items.GLOWSTONE_DUST,
                ModPotions.STRONG_BERSERKING);
    }

    @Override
    public void onRegisterEntityAttributes(EntityAttributesContext context) {
        context.registerAttributes(ModEntityTypes.ALCHEMIST.value(),
                Monster.createMonsterAttributes()
                        .add(Attributes.MAX_HEALTH, 24.0)
                        .add(Attributes.MOVEMENT_SPEED, 0.38));
        context.registerAttributes(ModEntityTypes.ARCHIVIST.value(),
                Monster.createMonsterAttributes()
                        .add(Attributes.MAX_HEALTH, 24.0)
                        .add(Attributes.MOVEMENT_SPEED, 0.36));
        context.registerAttributes(ModEntityTypes.BASHER.value(),
                Monster.createMonsterAttributes()
                        .add(Attributes.MAX_HEALTH, 32.0)
                        .add(Attributes.MOVEMENT_SPEED, 0.31)
                        .add(Attributes.ATTACK_DAMAGE, 3.0)
                        .add(Attributes.ATTACK_KNOCKBACK, 0.2));
        context.registerAttributes(ModEntityTypes.FIRECALLER.value(),
                Monster.createMonsterAttributes()
                        .add(Attributes.MAX_HEALTH, 32.0)
                        .add(Attributes.MOVEMENT_SPEED, 0.38));
        context.registerAttributes(ModEntityTypes.INQUISITOR.value(),
                Monster.createMonsterAttributes()
                        .add(Attributes.MAX_HEALTH, 80.0)
                        .add(Attributes.MOVEMENT_SPEED, 0.33)
                        .add(Attributes.ATTACK_DAMAGE, 10.0)
                        .add(Attributes.ATTACK_KNOCKBACK, 1.6)
                        .add(Attributes.KNOCKBACK_RESISTANCE, 0.8));
        context.registerAttributes(ModEntityTypes.INVOKER.value(),
                Monster.createMonsterAttributes()
                        .add(Attributes.MAX_HEALTH, 250.0)
                        .add(Attributes.MOVEMENT_SPEED, 0.36)
                        .add(Attributes.KNOCKBACK_RESISTANCE, 0.3)
                        .add(Attributes.ATTACK_DAMAGE, 8.0));
        context.registerAttributes(ModEntityTypes.MARAUDER.value(),
                Monster.createMonsterAttributes()
                        .add(Attributes.MAX_HEALTH, 24.0)
                        .add(Attributes.MOVEMENT_SPEED, 0.30));
        context.registerAttributes(ModEntityTypes.PROVOKER.value(),
                Monster.createMonsterAttributes()
                        .add(Attributes.MAX_HEALTH, 24.0)
                        .add(Attributes.MOVEMENT_SPEED, 0.38));
        context.registerAttributes(ModEntityTypes.SORCERER.value(),
                Monster.createMonsterAttributes()
                        .add(Attributes.MAX_HEALTH, 32.0)
                        .add(Attributes.MOVEMENT_SPEED, 0.38));
        context.registerAttributes(ModEntityTypes.SURRENDERED.value(),
                Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 14.0).add(Attributes.ATTACK_DAMAGE, 5.0));
        context.registerAttributes(ModEntityTypes.NECROMANCER.value(),
                Monster.createMonsterAttributes()
                        .add(Attributes.MAX_HEALTH, 32.0)
                        .add(Attributes.MOVEMENT_SPEED, 0.38));
    }

    @Override
    public void onRegisterSpawnPlacements(SpawnPlacementsContext context) {
        context.registerSpawnPlacement(ModEntityTypes.ALCHEMIST.value(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                PatrollingMonster::checkPatrollingMonsterSpawnRules);
        context.registerSpawnPlacement(ModEntityTypes.ARCHIVIST.value(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                PatrollingMonster::checkPatrollingMonsterSpawnRules);
        context.registerSpawnPlacement(ModEntityTypes.BASHER.value(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                PatrollingMonster::checkPatrollingMonsterSpawnRules);
        context.registerSpawnPlacement(ModEntityTypes.FIRECALLER.value(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                PatrollingMonster::checkPatrollingMonsterSpawnRules);
        context.registerSpawnPlacement(ModEntityTypes.INQUISITOR.value(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                PatrollingMonster::checkPatrollingMonsterSpawnRules);
        context.registerSpawnPlacement(ModEntityTypes.INVOKER.value(),
                SpawnPlacementTypes.NO_RESTRICTIONS,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);
        context.registerSpawnPlacement(ModEntityTypes.MARAUDER.value(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                PatrollingMonster::checkPatrollingMonsterSpawnRules);
        context.registerSpawnPlacement(ModEntityTypes.PROVOKER.value(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                PatrollingMonster::checkPatrollingMonsterSpawnRules);
        context.registerSpawnPlacement(ModEntityTypes.SORCERER.value(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                PatrollingMonster::checkPatrollingMonsterSpawnRules);
        context.registerSpawnPlacement(ModEntityTypes.SURRENDERED.value(),
                SpawnPlacementTypes.NO_RESTRICTIONS,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);
        context.registerSpawnPlacement(ModEntityTypes.NECROMANCER.value(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                PatrollingMonster::checkPatrollingMonsterSpawnRules);
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
