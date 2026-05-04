package net.amy.amythest.datagen;

import net.amy.amythest.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.amy.amythest.AmysAmethyst;
import net.amy.amythest.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static void offerAmethystUpgradeRecipe(RecipeExporter exporter, Item input, RecipeCategory category, Item result) {
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.AMETHYST_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(input), Ingredient.ofItems(Items.AMETHYST_SHARD), category, result
                )
                .criterion("has_amethyst_shard", conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, getItemPath(result) + "_smithing");
    }

    @Override
    public void generate(RecipeExporter exporter) {

        offerAmethystUpgradeRecipe(exporter, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, ModItems.AMETHYST_CHESTPLATE);
        offerAmethystUpgradeRecipe(exporter, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, ModItems.AMETHYST_LEGGINGS);
        offerAmethystUpgradeRecipe(exporter, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, ModItems.AMETHYST_HELMET);
        offerAmethystUpgradeRecipe(exporter, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, ModItems.AMETHYST_BOOTS);
        offerAmethystUpgradeRecipe(exporter, Items.NETHERITE_SWORD, RecipeCategory.COMBAT, ModItems.AMETHYST_SWORD);
        offerAmethystUpgradeRecipe(exporter, Items.NETHERITE_AXE, RecipeCategory.TOOLS, ModItems.AMETHYST_AXE);
        offerAmethystUpgradeRecipe(exporter, Items.NETHERITE_PICKAXE, RecipeCategory.TOOLS, ModItems.AMETHYST_PICKAXE);
        offerAmethystUpgradeRecipe(exporter, Items.NETHERITE_HOE, RecipeCategory.TOOLS, ModItems.AMETHYST_HOE);
        offerAmethystUpgradeRecipe(exporter, Items.NETHERITE_SHOVEL, RecipeCategory.TOOLS, ModItems.AMETHYST_SHOVEL);

        offerSmithingTemplateCopyingRecipe(exporter, ModItems.AMETHYST_UPGRADE_SMITHING_TEMPLATE, Items.AMETHYST_BLOCK);

        List<ItemConvertible> AMETHYST_SMELTABLES = List.of(ModBlocks.AMETHYST_INFUSED_STONE, ModBlocks.AMETHYST_INFUSED_DEEPSLATE);


        offerSmelting(exporter, AMETHYST_SMELTABLES, RecipeCategory.MISC, ModItems.AMETHYST_DUST, 2.0f, 20, "amethyst_dust");
        offerBlasting(exporter, AMETHYST_SMELTABLES, RecipeCategory.MISC, ModItems.AMETHYST_DUST, 2.0f, 20, "amethyst_dust");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AMETHYST_TRIDENT)
                .pattern(" AA")
                .pattern(" NA")
                .pattern("N  ")
                .input('A', Items.AMETHYST_SHARD)
                .input('N', Items.NETHERITE_INGOT)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AMETHYST_ARROW)
                .pattern(" A ")
                .pattern(" S ")
                .pattern(" F ")
                .input('A', Items.AMETHYST_SHARD)
                .input('S', Items.STICK)
                .input('F', Items.FEATHER)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.BUDDING_AMETHYST)
                .pattern("BCB")
                .pattern("CAC")
                .pattern("BCB")
                .input('A', Items.AMETHYST_CLUSTER)
                .input('C', Items.CALCITE)
                .input('B', Items.SMOOTH_BASALT)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AMETHYST_SCYTHE)
                .pattern("AA ")
                .pattern(" N ")
                .pattern(" N ")
                .input('A', Items.AMETHYST_SHARD)
                .input('N', Items.NETHERITE_INGOT)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AMETHYST_LANTERN)
                .pattern("NNN")
                .pattern("NAN")
                .pattern("NNN")
                .input('A', ModBlocks.AMETHYST_TORCH)
                .input('N', Items.IRON_NUGGET)
                .criterion(hasItem(ModItems.AMETHYST_DUST), conditionsFromItem(ModItems.AMETHYST_DUST))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AMETHYST_GLAIVE)
                .pattern("  A")
                .pattern(" N ")
                .pattern("N  ")
                .input('A', Items.AMETHYST_BLOCK)
                .input('N', Items.NETHERITE_INGOT)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AMETHYST_TORCH)
                .pattern(" A ")
                .pattern(" S ")
                .pattern(" S ")
                .input('A', ModItems.AMETHYST_DUST)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.AMETHYST_DUST), conditionsFromItem(ModItems.AMETHYST_DUST))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AMETHYST_SOUP)
                .input(ModItems.AMETHYST_DUST)
                .input(Items.BOWL)
                .input(Items.BROWN_MUSHROOM)
                .input(Items.RED_MUSHROOM)
                .criterion(hasItem(ModItems.AMETHYST_DUST), conditionsFromItem(ModItems.AMETHYST_DUST))
                .offerTo(exporter);

        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_SAND, ModItems.AMETHYST_DUST);




        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModItems.AMETHYST_DUST, Items.AMETHYST_SHARD, 4);
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModBlocks.AMETHYST_BRICKS, Blocks.AMETHYST_BLOCK, 1);

        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICK_SLAB, ModBlocks.AMETHYST_BRICKS);
        createStairsRecipe(ModBlocks.AMETHYST_BRICK_STAIRS, Ingredient.ofItems(ModBlocks.AMETHYST_BRICKS))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter);


    }
}