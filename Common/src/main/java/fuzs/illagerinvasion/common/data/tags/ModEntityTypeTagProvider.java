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
                .add(ModEntityTypes.BASHER_ENTITY_TYPE,
                        ModEntityTypes.PROVOKER_ENTITY_TYPE,
                        ModEntityTypes.NECROMANCER_ENTITY_TYPE,
                        ModEntityTypes.SORCERER_ENTITY_TYPE,
                        ModEntityTypes.ARCHIVIST_ENTITY_TYPE,
                        ModEntityTypes.MARAUDER_ENTITY_TYPE,
                        ModEntityTypes.INQUISITOR_ENTITY_TYPE,
                        ModEntityTypes.ALCHEMIST_ENTITY_TYPE,
                        ModEntityTypes.INVOKER_ENTITY_TYPE);
        this.tag(EntityTypeTags.ILLAGER)
                .add(ModEntityTypes.BASHER_ENTITY_TYPE,
                        ModEntityTypes.PROVOKER_ENTITY_TYPE,
                        ModEntityTypes.NECROMANCER_ENTITY_TYPE,
                        ModEntityTypes.SORCERER_ENTITY_TYPE,
                        ModEntityTypes.ARCHIVIST_ENTITY_TYPE,
                        ModEntityTypes.MARAUDER_ENTITY_TYPE,
                        ModEntityTypes.INQUISITOR_ENTITY_TYPE,
                        ModEntityTypes.ALCHEMIST_ENTITY_TYPE,
                        ModEntityTypes.INVOKER_ENTITY_TYPE,
                        ModEntityTypes.FIRECALLER_ENTITY_TYPE);
        this.tag(EntityTypeTags.FALL_DAMAGE_IMMUNE).add(ModEntityTypes.INVOKER_ENTITY_TYPE);
        this.tag("numismatic-overhaul:the_bourgeoisie")
                .add(ModEntityTypes.BASHER_ENTITY_TYPE,
                        ModEntityTypes.PROVOKER_ENTITY_TYPE,
                        ModEntityTypes.NECROMANCER_ENTITY_TYPE,
                        ModEntityTypes.SORCERER_ENTITY_TYPE,
                        ModEntityTypes.ARCHIVIST_ENTITY_TYPE,
                        ModEntityTypes.MARAUDER_ENTITY_TYPE,
                        ModEntityTypes.INQUISITOR_ENTITY_TYPE,
                        ModEntityTypes.ALCHEMIST_ENTITY_TYPE);
    }
}
