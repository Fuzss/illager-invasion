package fuzs.illagerinvasion.mixin;


import fuzs.illagerinvasion.util.WoodlandMansionPieceHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.structures.WoodlandMansionPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WoodlandMansionPieces.WoodlandMansionPiece.class)
abstract class WoodlandMansionPieceMixin {

    @Inject(method = "handleDataMarker", at = @At("HEAD"), cancellable = true)
    public void handleDataMarker(String markerId, BlockPos pos, ServerLevelAccessor level, RandomSource random, BoundingBox chunkBB, CallbackInfo callback) {
        if (WoodlandMansionPieceHelper.createIllagerType(markerId, pos, level, random)) {
            callback.cancel();
        }
    }
}
