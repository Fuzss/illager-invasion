package fuzs.illagerinvasion.common.init;

import net.minecraft.core.Holder;
import net.minecraft.core.particles.SimpleParticleType;

public class ModParticleTypes {

    public static final Holder.Reference<SimpleParticleType> MAGIC_FLAME = ModRegistry.REGISTRIES.registerParticleType(
            "magic_flame");
    public static final Holder.Reference<SimpleParticleType> PLATINUM_FIRE_FLAME = ModRegistry.REGISTRIES.registerParticleType(
            "platinum_fire_flame");
    public static final Holder.Reference<SimpleParticleType> NECROMANCER_BUFF = ModRegistry.REGISTRIES.registerParticleType(
            "necromancer_buff");

    public static void bootstrap() {
        // NO-OP
    }
}
