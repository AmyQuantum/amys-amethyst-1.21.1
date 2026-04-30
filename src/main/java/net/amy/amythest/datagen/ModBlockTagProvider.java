package net.amy.amythest.datagen;

import net.amy.amythest.block.ModBlocks;
import net.amy.amythest.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(ModBlocks.AMETHYST_BRICKS)
            .add(ModBlocks.AMETHYST_INFUSED_STONE)
            .add(ModBlocks.AMETHYST_INFUSED_DEEPSLATE)
                .add(ModBlocks.AMETHYST_LANTERN);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_AMETHYST_TOOL);
                //.addTag(BlockTags.NEEDS_IRON_TOOL);

    }
}
