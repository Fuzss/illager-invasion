package fuzs.illagerinvasion.common.world.item;

import fuzs.illagerinvasion.common.init.ModSoundEvents;
import fuzs.illagerinvasion.common.init.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class LostCandleItem extends Item {

    public LostCandleItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        if (level.isClientSide()) {
            for (BlockPos blockPos : BlockPos.withinManhattan(player.blockPosition(), 8, 8, 8)) {
                BlockState blockState = level.getBlockState(blockPos);
                if (blockState.is(ModTags.Blocks.ORES_BLOCK_TAG)) {
                    level.playSound(player,
                            player.blockPosition(),
                            ModSoundEvents.LOST_CANDLE_FIND_ORE_SOUND_EVENT.value(),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F);
                    Component component = blockState.getBlock()
                            .getName()
                            .withColor(blockState.getMapColor(level, blockPos).col);
                    player.sendOverlayMessage(Component.translatable(this.getDescriptionId() + ".foundNearby",
                            component));
                    return InteractionResult.SUCCESS;
                }
            }

            level.playSound(player,
                    player.blockPosition(),
                    SoundEvents.FIRE_EXTINGUISH,
                    SoundSource.BLOCKS,
                    0.6F,
                    1.0F);
        } else {
            player.getCooldowns().addCooldown(context.getItemInHand(), 60);
        }

        return InteractionResult.SUCCESS;
    }
}
