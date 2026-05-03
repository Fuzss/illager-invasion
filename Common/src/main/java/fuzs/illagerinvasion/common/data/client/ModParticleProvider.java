package fuzs.illagerinvasion.common.data.client;

import fuzs.illagerinvasion.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.client.data.v2.AbstractParticleProvider;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;

public class ModParticleProvider extends AbstractParticleProvider {

    public ModParticleProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addParticles() {
        this.add(ModRegistry.MAGIC_FLAME_PARTICLE_TYPE.value());
        this.add(ModRegistry.NECROMANCER_BUFF_PARTICLE_TYPE.value());
    }
}
