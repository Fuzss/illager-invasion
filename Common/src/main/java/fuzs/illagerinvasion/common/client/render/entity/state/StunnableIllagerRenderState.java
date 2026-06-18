package fuzs.illagerinvasion.common.client.render.entity.state;

import fuzs.illagerinvasion.common.world.entity.monster.Stunnable;
import fuzs.puzzleslib.common.api.item.v2.ToolTypeHelper;
import net.minecraft.client.renderer.entity.state.IllagerRenderState;
import net.minecraft.world.entity.LivingEntity;

public class StunnableIllagerRenderState extends IllagerRenderState {
    public boolean isStunned;
    public boolean shieldInMainHand;
    public boolean shieldInOffHand;

    public <T extends LivingEntity & Stunnable> void extractRenderState(T entity) {
        this.isStunned = entity.isStunned();
        this.shieldInMainHand = ToolTypeHelper.INSTANCE.isShield(entity.getMainHandItem());
        this.shieldInOffHand = ToolTypeHelper.INSTANCE.isShield(entity.getOffhandItem());
    }
}
