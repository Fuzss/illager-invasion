package fuzs.illagerinvasion.data.client;

import fuzs.puzzleslib.common.api.client.data.v2.AbstractAtlasProvider;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.resources.Identifier;

public class ModAtlasProvider extends AbstractAtlasProvider {
    public static final SpriteId DRAGON_FIREBALL_LOCATION = new SpriteId(TextureAtlas.LOCATION_ITEMS,
            Identifier.withDefaultNamespace("entity/enderdragon/dragon_fireball"));

    public ModAtlasProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addAtlases() {
        this.addMaterial(DRAGON_FIREBALL_LOCATION);
    }
}
