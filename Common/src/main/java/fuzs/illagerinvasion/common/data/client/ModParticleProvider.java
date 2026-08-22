package fuzs.illagerinvasion.common.data.client;

import fuzs.illagerinvasion.common.init.ModParticleTypes;
import fuzs.puzzleslib.common.api.client.data.v2.AbstractParticleProvider;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;

public class ModParticleProvider extends AbstractParticleProvider {

    public ModParticleProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addParticles() {
        this.add(ModParticleTypes.MAGIC_FLAME.value());
        this.add(ModParticleTypes.PLATINUM_FIRE_FLAME.value());
        this.add(ModParticleTypes.NECROMANCER_BUFF.value());
    }
}
