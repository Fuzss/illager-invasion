package fuzs.illagerinvasion.common.data;

import fuzs.illagerinvasion.common.IllagerInvasion;
import fuzs.illagerinvasion.common.init.ModItems;
import fuzs.puzzleslib.common.api.data.v2.AbstractRecipeProvider;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class ModRecipeProvider extends AbstractRecipeProvider {

    public ModRecipeProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(this.items(), RecipeCategory.MISC, ModItems.HALLOWED_GEM.value())
                .define('#', Items.AMETHYST_SHARD)
                .define('B', ModItems.UNUSUAL_DUST.value())
                .define('R', ModItems.ILLUSIONARY_DUST.value())
                .define('D', Items.DIAMOND)
                .pattern("#B#")
                .pattern("RDR")
                .pattern("#B#")
                .unlockedBy(getHasName(ModItems.UNUSUAL_DUST.value()), this.has(ModItems.UNUSUAL_DUST.value()))
                .unlockedBy(getHasName(ModItems.ILLUSIONARY_DUST.value()), this.has(ModItems.ILLUSIONARY_DUST.value()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(this.items(), RecipeCategory.DECORATIONS, ModItems.IMBUING_TABLE.value())
                .define('#',
                        Ingredient.of(Items.COPPER_BLOCK.weathering().unaffected(),
                                Items.COPPER_BLOCK.waxed().unaffected()))
                .define('P', Items.PAPER)
                .define('O', Items.DARK_OAK_LOG)
                .define('S', ModItems.PRIMAL_ESSENCE.value())
                .define('E', Items.EXPERIENCE_BOTTLE)
                .pattern("#P#")
                .pattern("OSO")
                .pattern("#E#")
                .unlockedBy(getHasName(ModItems.PRIMAL_ESSENCE.value()), this.has(ModItems.PRIMAL_ESSENCE.value()))
                .save(recipeOutput);
        this.nineBlockStorageRecipesWithCustomPacking(RecipeCategory.MISC,
                ModItems.PLATINUM_NUGGET.value(),
                RecipeCategory.MISC,
                ModItems.PLATINUM_INGOT.value(),
                IllagerInvasion.id(getConversionRecipeName(ModItems.PLATINUM_INGOT.value(),
                        ModItems.PLATINUM_NUGGET.value())).toString(),
                IllagerInvasion.id(getItemName(ModItems.PLATINUM_INGOT.value())).toString());
        ShapedRecipeBuilder.shaped(this.items(), RecipeCategory.TOOLS, ModItems.HORN_OF_SIGHT.value())
                .define('#', Items.GOLD_INGOT)
                .define('H', Items.GOAT_HORN)
                .define('G', ModItems.HALLOWED_GEM.value())
                .pattern(" G ")
                .pattern("#H#")
                .pattern(" # ")
                .unlockedBy(getHasName(ModItems.HALLOWED_GEM.value()), this.has(ModItems.HALLOWED_GEM.value()))
                .save(recipeOutput);
    }
}
