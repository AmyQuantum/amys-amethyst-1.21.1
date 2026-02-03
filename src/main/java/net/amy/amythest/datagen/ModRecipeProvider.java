package net.amy.amythest.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.amy.amythest.AmysAmethyst;
import net.amy.amythest.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AMETHYST_TRIDENT)
                .pattern(" AA")
                .pattern(" NA")
                .pattern("N  ")
                .input('A', ModItems.AMETHYST_DUST)
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

        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModItems.AMETHYST_DUST, Items.AMETHYST_SHARD, 4);
    }
}