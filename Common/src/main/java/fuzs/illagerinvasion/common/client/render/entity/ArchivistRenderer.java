package fuzs.illagerinvasion.common.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import fuzs.illagerinvasion.common.IllagerInvasion;
import fuzs.illagerinvasion.common.client.model.CustomIllagerModel;
import fuzs.illagerinvasion.common.client.model.geom.ModModelLayers;
import fuzs.illagerinvasion.common.client.render.entity.state.ArchivistRenderState;
import fuzs.illagerinvasion.common.world.entity.monster.Archivist;
import net.minecraft.client.model.object.book.BookModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.EnchantTableRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.IllagerRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

public class ArchivistRenderer extends IllagerRenderer<Archivist, ArchivistRenderState> {
    private static final Identifier TEXTURE_LOCATION = IllagerInvasion.id("textures/entity/archivist.png");
    public static final BookModel.State DEFAULT_BOOK_STATE = new BookModel.State(0.0F, 0.0F, 0.0F);

    private final SpriteGetter sprites;

    public ArchivistRenderer(EntityRendererProvider.Context context) {
        super(context, new CustomIllagerModel<>(context.bakeLayer(ModModelLayers.ARCHIVIST)), 0.5F);
        this.sprites = context.getSprites();
        this.addLayer(new ItemInHandLayer<>(this) {
            private final BookModel book = new BookModel(context.bakeLayer(ModModelLayers.ARCHIVIST_BOOK));

            @Override
            public void submit(PoseStack poseStack, SubmitNodeCollector nodeCollector, int packedLight, ArchivistRenderState renderState, float yRot, float xRot) {
                if (renderState.isCastingSpell) {
                    super.submit(poseStack, nodeCollector, packedLight, renderState, yRot, xRot);
                }

                poseStack.pushPose();
                poseStack.translate(0.0F, 0.362F, -0.5F);
                poseStack.mulPose(Axis.YP.rotationDegrees(270.0F));
                if (renderState.isCastingSpell) {
                    poseStack.translate(-0.4F, 0.0F, 0.0F);
                    poseStack.mulPose(Axis.ZN.rotationDegrees(30.0F));
                }

                nodeCollector.submitModel(this.book,
                        renderState.book,
                        poseStack,
                        renderState.lightCoords,
                        OverlayTexture.NO_OVERLAY,
                        -1,
                        EnchantTableRenderer.BOOK_TEXTURE,
                        ArchivistRenderer.this.sprites,
                        renderState.outlineColor,
                        null);
                poseStack.popPose();
            }
        });
        this.model.getHat().visible = true;
    }

    @Override
    public ArchivistRenderState createRenderState() {
        return new ArchivistRenderState();
    }

    @Override
    public void extractRenderState(Archivist entity, ArchivistRenderState renderState, float partialTick) {
        super.extractRenderState(entity, renderState, partialTick);
        renderState.isCastingSpell = entity.isCastingSpell();
        if (renderState.isCastingSpell) {
            renderState.book = BookModel.State.forAnimation(0.0F,
                    10.0F + Mth.cos(renderState.ageInTicks) * 0.55F,
                    0.0F,
                    1.05F);
        } else {
            renderState.book = DEFAULT_BOOK_STATE;
        }
    }

    @Override
    public Identifier getTextureLocation(ArchivistRenderState renderState) {
        return TEXTURE_LOCATION;
    }
}
