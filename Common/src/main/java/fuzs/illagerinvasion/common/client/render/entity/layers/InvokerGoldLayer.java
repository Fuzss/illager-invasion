package fuzs.illagerinvasion.common.client.render.entity.layers;

import fuzs.illagerinvasion.common.IllagerInvasion;
import fuzs.illagerinvasion.common.client.render.entity.state.InvokerRenderState;
import net.minecraft.client.model.monster.illager.IllagerModel;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;

public class InvokerGoldLayer extends EyesLayer<InvokerRenderState, IllagerModel<InvokerRenderState>> {
    private static final RenderType RENDER_TYPE = RenderTypes.eyes(IllagerInvasion.id("textures/entity/invoker_gold.png"));

    public InvokerGoldLayer(RenderLayerParent<InvokerRenderState, IllagerModel<InvokerRenderState>> renderLayerParent) {
        super(renderLayerParent);
    }

    @Override
    public RenderType renderType() {
        return RENDER_TYPE;
    }
}
