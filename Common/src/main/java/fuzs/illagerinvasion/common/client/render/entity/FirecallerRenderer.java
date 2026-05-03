package fuzs.illagerinvasion.common.client.render.entity;

import fuzs.illagerinvasion.common.IllagerInvasion;
import fuzs.illagerinvasion.common.client.model.geom.ModModelLayers;
import fuzs.illagerinvasion.common.client.model.FirecallerModel;
import fuzs.illagerinvasion.common.world.entity.monster.Firecaller;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.IllagerRenderer;
import net.minecraft.client.renderer.entity.state.IllagerRenderState;
import net.minecraft.resources.Identifier;

public class FirecallerRenderer extends IllagerRenderer<Firecaller, IllagerRenderState> {
    private static final Identifier TEXTURE_LOCATION = IllagerInvasion.id("textures/entity/firecaller.png");

    public FirecallerRenderer(EntityRendererProvider.Context context) {
        super(context, new FirecallerModel(context.bakeLayer(ModModelLayers.FIRECALLER)), 0.5F);
        this.model.getHat().visible = true;
    }

    @Override
    public IllagerRenderState createRenderState() {
        return new IllagerRenderState();
    }

    @Override
    public Identifier getTextureLocation(IllagerRenderState renderState) {
        return TEXTURE_LOCATION;
    }
}
