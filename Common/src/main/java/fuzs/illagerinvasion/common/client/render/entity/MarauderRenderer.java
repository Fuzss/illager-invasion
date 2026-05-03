package fuzs.illagerinvasion.common.client.render.entity;

import fuzs.illagerinvasion.common.IllagerInvasion;
import fuzs.illagerinvasion.common.client.model.geom.ModModelLayers;
import fuzs.illagerinvasion.common.client.model.MarauderModel;
import fuzs.illagerinvasion.common.client.render.entity.state.MarauderRenderState;
import fuzs.illagerinvasion.common.world.entity.monster.Marauder;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.IllagerRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class MarauderRenderer extends IllagerRenderer<Marauder, MarauderRenderState> {
    private static final Identifier TEXTURE_LOCATION = IllagerInvasion.id("textures/entity/marauder.png");

    public MarauderRenderer(EntityRendererProvider.Context context) {
        super(context, new MarauderModel(context.bakeLayer(ModModelLayers.MARAUDER)), 0.5F);
        this.addLayer(new ItemInHandLayer<>(this));
    }

    @Override
    public MarauderRenderState createRenderState() {
        return new MarauderRenderState();
    }

    @Override
    public void extractRenderState(Marauder entity, MarauderRenderState reusedState, float partialTick) {
        super.extractRenderState(entity, reusedState, partialTick);
        reusedState.chargingProgress = entity.getChargingProgress(partialTick);
    }

    @Override
    public Identifier getTextureLocation(MarauderRenderState renderState) {
        return TEXTURE_LOCATION;
    }
}
