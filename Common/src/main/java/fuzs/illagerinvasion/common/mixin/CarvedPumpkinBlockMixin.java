package fuzs.illagerinvasion.common.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import fuzs.illagerinvasion.common.init.ModBlocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CarvedPumpkinBlock.class)
abstract class CarvedPumpkinBlockMixin extends HorizontalDirectionalBlock {

    protected CarvedPumpkinBlockMixin(Properties properties) {
        super(properties);
    }

    @ModifyReturnValue(method = "lambda$static$0(Lnet/minecraft/world/level/block/state/BlockState;)Z",
                       at = @At("RETURN"))
    private static boolean isPumpkin(boolean isPumpkin, BlockState input) {
        return isPumpkin || input.is(ModBlocks.PLATINUM_JACK_O_LANTERN);
    }
}
