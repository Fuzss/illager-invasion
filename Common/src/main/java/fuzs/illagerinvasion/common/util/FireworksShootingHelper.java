package fuzs.illagerinvasion.common.util;

import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntLists;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ChargedProjectiles;
import net.minecraft.world.item.component.FireworkExplosion;
import net.minecraft.world.item.component.Fireworks;

import java.util.Arrays;
import java.util.List;

public class FireworksShootingHelper {

    public static boolean performShooting(LivingEntity shooter, LivingEntity target) {
        ItemStack itemStack = createLoadedWeapon();
        if (itemStack.isEmpty()) {
            return false;
        } else {
            Difficulty difficulty = shooter.level().getDifficulty();
            float inaccuracy = getInaccuracyForDifficulty(difficulty);
            ((CrossbowItem) Items.CROSSBOW).performShooting(shooter.level(),
                    shooter,
                    InteractionHand.MAIN_HAND,
                    itemStack,
                    1.6F,
                    inaccuracy,
                    target);
            return true;
        }
    }

    private static int getInaccuracyForDifficulty(Difficulty difficulty) {
        return 14 - difficulty.getId() * 4;
    }

    private static ItemStack createLoadedWeapon() {
        Fireworks fireworks = createFireworks(1, DyeColor.PURPLE, DyeColor.BLUE, DyeColor.GREEN);
        DataComponentPatch patch = DataComponentPatch.builder().set(DataComponents.FIREWORKS, fireworks).build();
        ItemStackTemplate template = new ItemStackTemplate(Items.FIREWORK_ROCKET, patch);
        ItemStack weaponItem = new ItemStack(Items.CROSSBOW);
        weaponItem.set(DataComponents.CHARGED_PROJECTILES, ChargedProjectiles.of(template));
        return weaponItem;
    }

    private static Fireworks createFireworks(int flightDuration, DyeColor... dyeColors) {
        List<FireworkExplosion> fireworkExplosions = Arrays.stream(dyeColors)
                .map(FireworksShootingHelper::createFireworkExplosion)
                .toList();
        return new Fireworks(flightDuration, fireworkExplosions);
    }

    private static FireworkExplosion createFireworkExplosion(DyeColor dyeColor) {
        IntList intList = IntLists.singleton(dyeColor.getFireworkColor());
        return new FireworkExplosion(FireworkExplosion.Shape.LARGE_BALL, intList, intList, false, false);
    }
}
