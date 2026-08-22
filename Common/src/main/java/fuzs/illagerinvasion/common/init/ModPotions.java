package fuzs.illagerinvasion.common.init;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;

public class ModPotions {
    public static final Holder.Reference<Potion> BERSERKING = ModRegistry.REGISTRIES.registerPotion("berserking",
            (String name) -> new Potion(name,
                    new MobEffectInstance(MobEffects.STRENGTH, 600, 1),
                    new MobEffectInstance(MobEffects.SPEED, 600, 1)));
    public static final Holder.Reference<Potion> LONG_BERSERKING = ModRegistry.REGISTRIES.registerPotion(
            "long_berserking",
            () -> new Potion("berserking",
                    new MobEffectInstance(MobEffects.STRENGTH, 1200, 0),
                    new MobEffectInstance(MobEffects.SPEED, 1200, 0)));
    public static final Holder.Reference<Potion> STRONG_BERSERKING = ModRegistry.REGISTRIES.registerPotion(
            "strong_berserking",
            () -> new Potion("berserking",
                    new MobEffectInstance(MobEffects.STRENGTH, 300, 2),
                    new MobEffectInstance(MobEffects.SPEED, 300, 2)));

    public static void bootstrap() {
        // NO-OP
    }
}
