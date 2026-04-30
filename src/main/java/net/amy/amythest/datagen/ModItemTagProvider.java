package net.amy.amythest.datagen;

import net.amy.amythest.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

import static net.amy.amythest.item.ModItems.*;


public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ItemTags.TRIDENT_ENCHANTABLE)
                .add(AMETHYST_TRIDENT);

        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE)
                .add(AMETHYST_SWORD)
                .add(AMETHYST_AXE)
                .add(AMETHYST_SCYTHE)
                .add(AMETHYST_GLAIVE);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(AMETHYST_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(AMETHYST_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(AMETHYST_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(AMETHYST_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(AMETHYST_HOE);


        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(AMETHYST_PICKAXE)
                .add(AMETHYST_HOE)
                .add(AMETHYST_AXE)
                .add(AMETHYST_SHOVEL);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(AMETHYST_HELMET)
                .add(AMETHYST_CHESTPLATE)
                .add(AMETHYST_LEGGINGS)
                .add(AMETHYST_SHOVEL);
    }
}
