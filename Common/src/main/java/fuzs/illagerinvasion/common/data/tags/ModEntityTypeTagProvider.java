package fuzs.illagerinvasion.common.data.tags;

import fuzs.illagerinvasion.common.init.ModEntityTypes;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.common.api.data.v2.tags.AbstractTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;

public class ModEntityTypeTagProvider extends AbstractTagProvider<EntityType<?>> {

    public ModEntityTypeTagProvider(DataProviderContext context) {
        super(Registries.ENTITY_TYPE, context);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.tag(EntityTypeTags.RAIDERS)
                .add(ModEntityTypes.BASHER,
                        ModEntityTypes.PROVOKER,
                        ModEntityTypes.NECROMANCER,
                        ModEntityTypes.SORCERER,
                        ModEntityTypes.ARCHIVIST,
                        ModEntityTypes.MARAUDER,
                        ModEntityTypes.INQUISITOR,
                        ModEntityTypes.ALCHEMIST,
                        ModEntityTypes.INVOKER);
        this.tag(EntityTypeTags.ILLAGER)
                .add(ModEntityTypes.BASHER,
                        ModEntityTypes.PROVOKER,
                        ModEntityTypes.NECROMANCER,
                        ModEntityTypes.SORCERER,
                        ModEntityTypes.ARCHIVIST,
                        ModEntityTypes.MARAUDER,
                        ModEntityTypes.INQUISITOR,
                        ModEntityTypes.ALCHEMIST,
                        ModEntityTypes.INVOKER,
                        ModEntityTypes.FIRECALLER);
        this.tag(EntityTypeTags.FALL_DAMAGE_IMMUNE).add(ModEntityTypes.INVOKER);
        this.tag("numismatic-overhaul:the_bourgeoisie")
                .add(ModEntityTypes.BASHER,
                        ModEntityTypes.PROVOKER,
                        ModEntityTypes.NECROMANCER,
                        ModEntityTypes.SORCERER,
                        ModEntityTypes.ARCHIVIST,
                        ModEntityTypes.MARAUDER,
                        ModEntityTypes.INQUISITOR,
                        ModEntityTypes.ALCHEMIST);
    }
}
