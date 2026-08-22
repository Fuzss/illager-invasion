package fuzs.illagerinvasion.common.init;

import fuzs.puzzleslib.common.api.data.v2.AbstractDatapackRegistriesProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Instrument;

public class ModInstruments {
    public static final ResourceKey<Instrument> REVEAL = ModRegistry.REGISTRIES.makeResourceKey(Registries.INSTRUMENT,
            "reveal");

    public static void bootstrap(BootstrapContext<Instrument> context) {
        AbstractDatapackRegistriesProvider.registerInstrument(context,
                REVEAL,
                ModSoundEvents.HORN_OF_SIGHT_SOUND_EVENT,
                7.0F,
                64.0F);
    }
}
