package net.amy.amythest.datagen;

import net.amy.amythest.block.ModBlocks;
import net.amy.amythest.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.AMETHYST_BRICKS);
        addDrop(ModBlocks.AMETHYST_BRICK_SLAB, slabDrops(ModBlocks.AMETHYST_BRICK_SLAB));
        addDrop(ModBlocks.AMETHYST_BRICK_STAIRS);
        addDrop(ModBlocks.AMETHYST_INFUSED_STONE, multipleOreDrops(ModBlocks.AMETHYST_INFUSED_STONE, ModItems.AMETHYST_DUST,2,4));
        addDrop(ModBlocks.AMETHYST_INFUSED_DEEPSLATE, multipleOreDrops(ModBlocks.AMETHYST_INFUSED_DEEPSLATE, ModItems.AMETHYST_DUST, 3, 5));
        addDrop(ModBlocks.AMETHYST_LANTERN);
        addDrop(ModBlocks.AMETHYST_TORCH);
        addDrop(ModBlocks.AMETHYST_SAND);

    }
    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
