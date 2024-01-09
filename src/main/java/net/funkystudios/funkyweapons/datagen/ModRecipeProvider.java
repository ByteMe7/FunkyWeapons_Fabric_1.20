package net.funkystudios.funkyweapons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.funkystudios.funkyweapons.block.ModBlocks;
import net.funkystudios.funkyweapons.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.TURQUOISE,
                RecipeCategory.MISC, ModBlocks.TURQUOISE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_TURQUOISE,
                RecipeCategory.MISC, ModBlocks.RAW_TURQUOISE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.WOODEN_MACUAHUITL, 1)
                .pattern(" ^#")
                .pattern("^#^")
                .pattern("!^ ")
                .input('#', ItemTags.PLANKS)
                .input('^', ModItems.WOODEN_SPIKE)
                .input('!', Items.STICK)
                .criterion("has_wood_spike", conditionsFromItem(ModItems.WOODEN_SPIKE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.WOODEN_MACUAHUITL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.STONE_MACUAHUITL,1)
                .pattern(" ^ ")
                .pattern("^#^")
                .pattern(" ^ ")
                .input('^',ModItems.STONE_SPIKE)
                .input('#', ModItems.WOODEN_MACUAHUITL)
                .criterion("has_wooden_macuahuitl", conditionsFromItem(ModItems.WOODEN_MACUAHUITL))
                .criterion("has_stone_spike", conditionsFromItem(ModItems.STONE_SPIKE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STONE_MACUAHUITL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.IRON_MACUAHUITL,1)
                .pattern(" ^ ")
                .pattern("^#^")
                .pattern(" ^ ")
                .input('^',ModItems.IRON_SPIKE)
                .input('#', ModItems.STONE_MACUAHUITL)
                .criterion("has_stone_macuahuitl", conditionsFromItem(ModItems.STONE_MACUAHUITL))
                .criterion("has_iron_spike", conditionsFromItem(ModItems.IRON_SPIKE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.IRON_MACUAHUITL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.GOLDEN_MACUAHUITL,1)
                .pattern(" ^ ")
                .pattern("^#^")
                .pattern(" ^ ")
                .input('^',ModItems.GOLDEN_SPIKE)
                .input('#', ModItems.IRON_MACUAHUITL)
                .criterion("has_iron_macuahuitl", conditionsFromItem(ModItems.IRON_MACUAHUITL))
                .criterion("has_gold_spike", conditionsFromItem(ModItems.GOLDEN_SPIKE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GOLDEN_MACUAHUITL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.DIAMOND_MACUAHUITL,1)
                .pattern(" ^ ")
                .pattern("^#^")
                .pattern(" ^ ")
                .input('^',ModItems.DIAMOND_SPIKE)
                .input('#', ModItems.GOLDEN_MACUAHUITL)
                .criterion("has_golden_macuahuitl", conditionsFromItem(ModItems.GOLDEN_MACUAHUITL))
                .criterion("has_diamond_spike", conditionsFromItem(ModItems.DIAMOND_SPIKE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DIAMOND_MACUAHUITL)));


        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.DIAMOND_MACUAHUITL), Ingredient.ofStacks(new ItemStack(ModItems.NETHERITE_SPIKE, 4)),
                RecipeCategory.COMBAT, ModItems.NETHERITE_MACUAHUITL)
                .criterion("has_netherite_spike", conditionsFromItem(ModItems.NETHERITE_SPIKE))
                .criterion("has_upgrade_template", conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.NETHERITE_MACUAHUITL)));
    }
}
