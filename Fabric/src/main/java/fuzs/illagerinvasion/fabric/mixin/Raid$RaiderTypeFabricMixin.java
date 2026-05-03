package fuzs.illagerinvasion.fabric.mixin;

import fuzs.illagerinvasion.common.config.RaidWavesConfigHelper;
import fuzs.illagerinvasion.common.init.ModEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.entity.raid.Raider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Raid.RaiderType.class)
enum Raid$RaiderTypeFabricMixin {
    ILLAGERINVASION_BASHER(ModEntityTypes.BASHER_ENTITY_TYPE.value(), RaidWavesConfigHelper.BASHER_RAID_WAVES),
    ILLAGERINVASION_PROVOKER(ModEntityTypes.PROVOKER_ENTITY_TYPE.value(), RaidWavesConfigHelper.PROVOKER_RAID_WAVES),
    ILLAGERINVASION_NECROMANCER(ModEntityTypes.NECROMANCER_ENTITY_TYPE.value(),
            RaidWavesConfigHelper.NECROMANCER_RAID_WAVES),
    ILLAGERINVASION_SORCERER(ModEntityTypes.SORCERER_ENTITY_TYPE.value(), RaidWavesConfigHelper.SORCERER_RAID_WAVES),
    ILLAGERINVASION_ILLUSIONER(EntityType.ILLUSIONER, RaidWavesConfigHelper.ILLUSIONER_RAID_WAVES),
    ILLAGERINVASION_ARCHIVIST(ModEntityTypes.ARCHIVIST_ENTITY_TYPE.value(), RaidWavesConfigHelper.ARCHIVIST_RAID_WAVES),
    ILLAGERINVASION_MARAUDER(ModEntityTypes.MARAUDER_ENTITY_TYPE.value(), RaidWavesConfigHelper.MARAUDER_RAID_WAVES),
    ILLAGERINVASION_INQUISITOR(ModEntityTypes.INQUISITOR_ENTITY_TYPE.value(),
            RaidWavesConfigHelper.INQUISITOR_RAID_WAVES),
    ILLAGERINVASION_ALCHEMIST(ModEntityTypes.ALCHEMIST_ENTITY_TYPE.value(), RaidWavesConfigHelper.ALCHEMIST_RAID_WAVES),
    ILLAGERINVASION_INVOKER(ModEntityTypes.INVOKER_ENTITY_TYPE.value(), RaidWavesConfigHelper.INVOKER_RAID_WAVES);

    @Shadow
    Raid$RaiderTypeFabricMixin(final EntityType<? extends Raider> entityType, final int[] spawnsPerWaveBeforeBonus) {
        // NO-OP
    }
}
