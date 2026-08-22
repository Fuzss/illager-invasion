package fuzs.illagerinvasion.common.data;

import fuzs.illagerinvasion.common.IllagerInvasion;
import fuzs.illagerinvasion.common.init.ModBlockFamilies;
import fuzs.illagerinvasion.common.init.ModItems;
import fuzs.puzzleslib.common.api.data.v2.AbstractRecipeProvider;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.common.api.init.v3.family.BlockSetVariant;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

public class ModRecipeProvider extends AbstractRecipeProvider {

    public ModRecipeProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addRecipes(RecipeOutput recipeOutput) {
        // We deliberately do not generate the default platinum family, as most recipes use ingots, not full blocks for crafting.
        this.generateFor(ModBlockFamilies.CUT_PLATINUM);
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
        this.nineBlockStorageRecipesRecipesWithCustomUnpacking(RecipeCategory.MISC,
                ModItems.PLATINUM_INGOT.value(),
                RecipeCategory.BUILDING_BLOCKS,
                ModItems.PLATINUM_BLOCK.value(),
                IllagerInvasion.id(getConversionRecipeName(ModItems.PLATINUM_BLOCK.value(),
                        ModItems.PLATINUM_INGOT.value())).toString(),
                IllagerInvasion.id(getItemName(ModItems.PLATINUM_BLOCK.value())).toString());
        this.nineBlockStorageRecipesWithCustomPacking(RecipeCategory.MISC,
                ModItems.PLATINUM_NUGGET.value(),
                RecipeCategory.MISC,
                ModItems.PLATINUM_INGOT.value(),
                IllagerInvasion.id(getConversionRecipeName(ModItems.PLATINUM_INGOT.value(),
                        ModItems.PLATINUM_NUGGET.value())).toString(),
                IllagerInvasion.id(getItemName(ModItems.PLATINUM_INGOT.value())).toString());
        this.cut(RecipeCategory.BUILDING_BLOCKS,
                ModBlockFamilies.PLATINUM.getItem(BlockSetVariant.CUT).value(),
                ModItems.PLATINUM_BLOCK.value());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS,
                ModBlockFamilies.PLATINUM.getItem(BlockSetVariant.CUT).value(),
                ModItems.PLATINUM_BLOCK.value());
        this.doorBuilder(ModBlockFamilies.PLATINUM.getItem(BlockSetVariant.DOOR).value(),
                        Ingredient.of(ModItems.PLATINUM_INGOT.value()))
                .unlockedBy(getHasName(ModItems.PLATINUM_INGOT.value()), this.has(ModItems.PLATINUM_INGOT.value()))
                .save(recipeOutput);
        this.twoByTwoPacker(RecipeCategory.REDSTONE,
                ModBlockFamilies.PLATINUM.getItem(BlockSetVariant.TRAPDOOR).value(),
                ModItems.PLATINUM_INGOT.value());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS,
                ModBlockFamilies.CUT_PLATINUM.getItem(BlockSetVariant.CHISELED).value(),
                ModItems.PLATINUM_BLOCK.value());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS,
                ModBlockFamilies.CUT_PLATINUM.getItem(BlockSetVariant.SLAB).value(),
                ModItems.PLATINUM_BLOCK.value(),
                2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS,
                ModBlockFamilies.CUT_PLATINUM.getItem(BlockSetVariant.STAIRS).value(),
                ModItems.PLATINUM_BLOCK.value());
        this.shaped(RecipeCategory.DECORATIONS, ModItems.PLATED_PLATINUM.value(), 4)
                .define('#', ModItems.PLATINUM_BLOCK.value())
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .unlockedBy(getHasName(ModItems.PLATINUM_BLOCK.value()), this.has(ModItems.PLATINUM_BLOCK.value()))
                .save(recipeOutput);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS,
                ModItems.PLATED_PLATINUM.value(),
                ModItems.PLATINUM_BLOCK.value());
        this.shaped(RecipeCategory.DECORATIONS, ModItems.PLATINUM_BARS.value(), 16)
                .define('#', ModItems.PLATINUM_INGOT.value())
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(ModItems.PLATINUM_INGOT.value()), this.has(ModItems.PLATINUM_INGOT.value()))
                .save(recipeOutput);
        this.shaped(RecipeCategory.DECORATIONS, ModItems.PLATINUM_CHAIN.value())
                .define('I', ModItems.PLATINUM_INGOT.value())
                .define('N', ModItems.PLATINUM_NUGGET.value())
                .pattern("N")
                .pattern("I")
                .pattern("N")
                .unlockedBy(getHasName(ModItems.PLATINUM_NUGGET.value()), this.has(ModItems.PLATINUM_NUGGET.value()))
                .unlockedBy(getHasName(ModItems.PLATINUM_INGOT.value()), this.has(ModItems.PLATINUM_INGOT.value()))
                .save(recipeOutput);
        this.shaped(RecipeCategory.DECORATIONS, ModItems.PLATINUM_TORCH.value(), 4)
                .define('X', Ingredient.of(Items.COAL, Items.CHARCOAL))
                .define('#', Items.STICK)
                .define('C', ModItems.PLATINUM_NUGGET.value())
                .pattern("C")
                .pattern("X")
                .pattern("#")
                .unlockedBy(getHasName(ModItems.PLATINUM_NUGGET.value()), this.has(ModItems.PLATINUM_NUGGET.value()))
                .save(recipeOutput);
        this.shaped(RecipeCategory.DECORATIONS, ModItems.PLATINUM_LANTERN.value())
                .define('#', Items.TORCH)
                .define('X', ModItems.PLATINUM_NUGGET.value())
                .pattern("XXX")
                .pattern("X#X")
                .pattern("XXX")
                .unlockedBy(getHasName(ModItems.PLATINUM_NUGGET.value()), this.has(ModItems.PLATINUM_NUGGET.value()))
                .unlockedBy(getHasName(ModItems.PLATINUM_INGOT.value()), this.has(ModItems.PLATINUM_INGOT.value()))
                .save(recipeOutput);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.PLATINUM_JACK_O_LANTERN.value())
                .define('A', Blocks.CARVED_PUMPKIN)
                .define('B', ModItems.PLATINUM_TORCH.value())
                .pattern("A")
                .pattern("B")
                .unlockedBy(getHasName(Blocks.CARVED_PUMPKIN), this.has(Blocks.CARVED_PUMPKIN))
                .save(recipeOutput);
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
