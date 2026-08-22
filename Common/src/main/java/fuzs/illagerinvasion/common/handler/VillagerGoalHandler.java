package fuzs.illagerinvasion.common.handler;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import fuzs.illagerinvasion.common.init.ModEntityTypes;
import fuzs.illagerinvasion.common.world.entity.monster.*;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.sensing.VillagerHostilesSensor;
import net.minecraft.world.entity.npc.villager.AbstractVillager;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.function.BiConsumer;

public class VillagerGoalHandler {
    private static final List<VillagerEnemy<?>> VILLAGER_ENEMIES = ImmutableList.<VillagerEnemy<?>>builder()
            .add(new VillagerEnemy<>(Alchemist.class, ModEntityTypes.ALCHEMIST, 12.0F))
            .add(new VillagerEnemy<>(Archivist.class, ModEntityTypes.ARCHIVIST, 12.0F))
            .add(new VillagerEnemy<>(Basher.class, ModEntityTypes.BASHER, 8.0F))
            .add(new VillagerEnemy<>(Firecaller.class, ModEntityTypes.FIRECALLER, 12.0F))
            .add(new VillagerEnemy<>(Inquisitor.class, ModEntityTypes.INQUISITOR, 15.0F))
            .add(new VillagerEnemy<>(Invoker.class, ModEntityTypes.INVOKER, 15.0F))
            .add(new VillagerEnemy<>(Marauder.class, ModEntityTypes.MARAUDER, 12.0F))
            .add(new VillagerEnemy<>(Necromancer.class, ModEntityTypes.NECROMANCER, 15.0F))
            .add(new VillagerEnemy<>(Provoker.class, ModEntityTypes.PROVOKER, 12.0F))
            .add(new VillagerEnemy<>(Sorcerer.class, ModEntityTypes.SORCERER, 12.0F))
            .add(new VillagerEnemy<>(Surrendered.class, ModEntityTypes.SURRENDERED, 8.0F))
            .build();

    public static void forEach(BiConsumer<Holder<? extends EntityType<?>>, Float> consumer) {
        for (VillagerEnemy<?> villagerEnemy : VILLAGER_ENEMIES) {
            consumer.accept(villagerEnemy.type(), villagerEnemy.acceptableDistance());
        }
    }

    public static void onEntityLoad(Entity entity, ServerLevel serverLevel, boolean isLoadedFromDisk, @Nullable EntitySpawnReason entitySpawnReason) {
        // do not do this for generic abstract villager, villagers that use the brain system instead of the goals seem to try to run both and flee much slower than they should
        if (entity.is(EntityTypeIds.WANDERING_TRADER)) {
            for (VillagerEnemy<?> villagerEnemy : VILLAGER_ENEMIES) {
                villagerEnemy.addGoal((AbstractVillager) entity);
            }
        }
    }

    public static void registerAcceptableDistanceFromHostiles() {
        ImmutableMap.Builder<EntityType<?>, Float> builder = ImmutableMap.<EntityType<?>, Float>builder()
                .putAll(VillagerHostilesSensor.ACCEPTABLE_DISTANCE_FROM_HOSTILES);
        for (VillagerEnemy<?> villagerEnemy : VILLAGER_ENEMIES) {
            villagerEnemy.addAcceptableDistance(builder::put);
        }

        VillagerHostilesSensor.ACCEPTABLE_DISTANCE_FROM_HOSTILES = builder.build();
    }

    private record VillagerEnemy<T extends LivingEntity>(Class<T> clazz,
                                                         Holder<EntityType<T>> type,
                                                         float acceptableDistance) {

        public void addGoal(AbstractVillager abstractVillager) {
            abstractVillager.goalSelector.addGoal(1, this.makeGoal(abstractVillager));
        }

        private Goal makeGoal(AbstractVillager abstractVillager) {
            return new AvoidEntityGoal<>(abstractVillager, this.clazz, this.acceptableDistance, 0.5, 0.5);
        }

        public void addAcceptableDistance(BiConsumer<EntityType<?>, Float> consumer) {
            consumer.accept(this.type.value(), this.acceptableDistance);
        }
    }
}
