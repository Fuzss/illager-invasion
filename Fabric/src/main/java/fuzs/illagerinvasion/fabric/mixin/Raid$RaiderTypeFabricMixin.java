package fuzs.illagerinvasion.fabric.mixin;

import fuzs.illagerinvasion.common.config.RaidWavesConfigHelper;
import fuzs.illagerinvasion.common.init.ModEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.entity.raid.Raider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Raid.RaiderType.class)
enum Raid$RaiderTypeFabricMixin {
    ILLAGERINVASION_BASHER(ModEntityTypes.BASHER.value(), RaidWavesConfigHelper.BASHER_RAID_WAVES),
    ILLAGERINVASION_PROVOKER(ModEntityTypes.PROVOKER.value(), RaidWavesConfigHelper.PROVOKER_RAID_WAVES),
    ILLAGERINVASION_NECROMANCER(ModEntityTypes.NECROMANCER.value(),
            RaidWavesConfigHelper.NECROMANCER_RAID_WAVES),
    ILLAGERINVASION_SORCERER(ModEntityTypes.SORCERER.value(), RaidWavesConfigHelper.SORCERER_RAID_WAVES),
    ILLAGERINVASION_ILLUSIONER(EntityTypes.ILLUSIONER, RaidWavesConfigHelper.ILLUSIONER_RAID_WAVES),
    ILLAGERINVASION_ARCHIVIST(ModEntityTypes.ARCHIVIST.value(), RaidWavesConfigHelper.ARCHIVIST_RAID_WAVES),
    ILLAGERINVASION_MARAUDER(ModEntityTypes.MARAUDER.value(), RaidWavesConfigHelper.MARAUDER_RAID_WAVES),
    ILLAGERINVASION_INQUISITOR(ModEntityTypes.INQUISITOR.value(),
            RaidWavesConfigHelper.INQUISITOR_RAID_WAVES),
    ILLAGERINVASION_ALCHEMIST(ModEntityTypes.ALCHEMIST.value(), RaidWavesConfigHelper.ALCHEMIST_RAID_WAVES),
    ILLAGERINVASION_INVOKER(ModEntityTypes.INVOKER.value(), RaidWavesConfigHelper.INVOKER_RAID_WAVES);

    @Shadow
    Raid$RaiderTypeFabricMixin(final EntityType<? extends Raider> entityType, final int[] spawnsPerWaveBeforeBonus) {
        // NO-OP
    }
}
