package fuzs.illagerinvasion.common.data.client;

import fuzs.illagerinvasion.common.IllagerInvasion;
import fuzs.illagerinvasion.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.client.data.v2.AbstractAtlasProvider;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import net.minecraft.client.data.AtlasProvider;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.client.renderer.texture.atlas.sources.PalettedPermutations;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.data.AtlasIds;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimPattern;
import net.minecraft.world.item.equipment.trim.TrimPatterns;

import org.jspecify.annotations.Nullable;

import java.util.*;

public class ModAtlasProvider extends AbstractAtlasProvider {
    public static final SpriteId DRAGON_FIREBALL_LOCATION = new SpriteId(TextureAtlas.LOCATION_ITEMS,
            Identifier.withDefaultNamespace("entity/enderdragon/dragon_fireball"));
    public static final MaterialAssetGroup PLATINUM_GROUP = MaterialAssetGroup.create("platinum");
    public static final List<ItemModelGenerators.TrimMaterialData> TRIM_MATERIAL_MODELS = List.of(new ItemModelGenerators.TrimMaterialData(
            PLATINUM_GROUP,
            ModRegistry.PLATINUM_TRIM_MATERIAL));

    public ModAtlasProvider(DataProviderContext context) {
        super(context);
    }

    /**
     * @see AtlasProvider#armorTrims()
     */
    public static TrimPatternBuilder armorTrims() {
        return armorTrims(null, true);
    }

    /**
     * @see AtlasProvider#armorTrims()
     */
    public static TrimPatternBuilder armorTrims(@Nullable String fallbackNamespace, boolean defaultPermutations) {
        return new TrimPatternBuilder(fallbackNamespace,
                defaultPermutations ? new ArrayList<>(AtlasProvider.VANILLA_PATTERNS) : new ArrayList<>(),
                defaultPermutations ? new ArrayList<>(AtlasProvider.HUMANOID_LAYERS) : new ArrayList<>(),
                defaultPermutations ? new TreeMap<>(AtlasProvider.TRIM_PALETTE_VALUES) : new TreeMap<>());
    }

    @Override
    public void addAtlases() {
        this.addMaterial(DRAGON_FIREBALL_LOCATION);
        this.add(AtlasIds.ARMOR_TRIMS,
                armorTrims(IllagerInvasion.MOD_ID, true).addPermutation(IllagerInvasion.id("platinum"))
                        .addPermutation(PLATINUM_GROUP)
                        .addPermutations(TRIM_MATERIAL_MODELS)
                        .build());
    }

    public static class TrimPatternBuilder {
        private final @Nullable String fallbackNamespace;
        private final List<ResourceKey<TrimPattern>> patterns;
        private final List<EquipmentClientInfo.LayerType> layers;
        private final Map<String, Identifier> permutations;
        private Identifier palette = AtlasProvider.TRIM_PALETTE_KEY;

        TrimPatternBuilder(@Nullable String fallbackNamespace, List<ResourceKey<TrimPattern>> patterns, List<EquipmentClientInfo.LayerType> layers, Map<String, Identifier> permutations) {
            this.fallbackNamespace = fallbackNamespace;
            this.patterns = patterns;
            this.layers = layers;
            this.permutations = permutations;
        }

        public TrimPatternBuilder addPattern(ResourceKey<TrimPattern> pattern) {
            this.patterns.add(pattern);
            return this;
        }

        public TrimPatternBuilder addPatterns(List<ResourceKey<TrimPattern>> patterns) {
            this.patterns.addAll(patterns);
            return this;
        }

        public TrimPatternBuilder addLayer(EquipmentClientInfo.LayerType layer) {
            this.layers.add(layer);
            return this;
        }

        public TrimPatternBuilder addLayers(List<EquipmentClientInfo.LayerType> layers) {
            this.layers.addAll(layers);
            return this;
        }

        public TrimPatternBuilder addPermutation(ItemModelGenerators.TrimMaterialData data) {
            return this.addPermutation(data.assets());
        }

        public TrimPatternBuilder addPermutations(List<ItemModelGenerators.TrimMaterialData> data) {
            data.forEach(this::addPermutation);
            return this;
        }

        /**
         * @see AtlasProvider#extractAllMaterialAssets()
         */
        public TrimPatternBuilder addPermutation(MaterialAssetGroup group) {
            group.overrides().values().forEach(this::addPermutation);
            return this.addPermutation(group.base());
        }

        public TrimPatternBuilder addPermutation(MaterialAssetGroup.AssetInfo asset) {
            Objects.requireNonNull(this.fallbackNamespace, "namespace is null");
            return this.addPermutation(Identifier.fromNamespaceAndPath(this.fallbackNamespace, asset.suffix()));
        }

        public TrimPatternBuilder addPermutation(Identifier base, Map<ResourceKey<EquipmentAsset>, Identifier> overrides) {
            overrides.values().forEach(this::addPermutation);
            return this.addPermutation(base);
        }

        /**
         * @see AtlasProvider#TRIM_PALETTE_VALUES
         */
        public TrimPatternBuilder addPermutation(Identifier asset) {
            this.permutations.put(asset.getPath(), asset.withPrefix("trims/color_palettes/"));
            return this;
        }

        public TrimPatternBuilder addPermutation(String suffix, Identifier palette) {
            this.permutations.put(suffix, palette);
            return this;
        }

        public TrimPatternBuilder addPermutations(Map<String, Identifier> permutations) {
            this.permutations.putAll(permutations);
            return this;
        }

        public TrimPatternBuilder setPalette(Identifier palette) {
            this.palette = palette;
            return this;
        }

        /**
         * @see AtlasProvider#armorTrims()
         */
        public List<SpriteSource> build() {
            return List.of(new PalettedPermutations(patternTextures(this.patterns, this.layers),
                    this.palette,
                    this.permutations));
        }

        /**
         * @see AtlasProvider#patternTextures()
         */
        private static List<Identifier> patternTextures(List<ResourceKey<TrimPattern>> patterns, List<EquipmentClientInfo.LayerType> layers) {
            List<Identifier> result = new ArrayList<>(patterns.size() * layers.size());
            for (ResourceKey<TrimPattern> vanillaPattern : patterns) {
                Identifier assetId = TrimPatterns.defaultAssetId(vanillaPattern);
                for (EquipmentClientInfo.LayerType humanoidLayer : layers) {
                    result.add(assetId.withPath(patternPath -> humanoidLayer.trimAssetPrefix() + "/" + patternPath));
                }
            }

            return result;
        }
    }
}
