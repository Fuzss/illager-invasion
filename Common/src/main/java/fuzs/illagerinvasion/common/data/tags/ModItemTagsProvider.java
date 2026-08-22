package fuzs.illagerinvasion.common.data.tags;

import fuzs.illagerinvasion.common.init.ModBlockFamilies;
import fuzs.illagerinvasion.common.init.ModItems;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.common.api.data.v2.tags.AbstractTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;

public class ModItemTagsProvider extends AbstractTagProvider<Item> {

    public ModItemTagsProvider(DataProviderContext context) {
        super(Registries.ITEM, context);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.generateFor(ModBlockFamilies.PLATINUM.getItemVariants(), VARIANT_ITEM_TAGS);
        this.tag(ItemTags.TRIM_MATERIALS).add(ModItems.PLATINUM_INGOT);
        this.tag(ItemTags.DURABILITY_ENCHANTABLE).add(ModItems.PLATINUM_INFUSED_HATCHET);
        this.tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(ModItems.PLATINUM_INFUSED_HATCHET);
        this.tag(ItemTags.METAL_NUGGETS).add(ModItems.PLATINUM_NUGGET);
        this.tag("c:bars").add(ModItems.PLATINUM_BARS);
        this.tag("c:chains").add(ModItems.PLATINUM_CHAIN);
        this.tag("c:pumpkins/jack_o_lanterns").add(ModItems.PLATINUM_JACK_O_LANTERN);
    }
}
