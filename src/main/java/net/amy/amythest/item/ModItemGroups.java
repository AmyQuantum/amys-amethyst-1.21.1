package net.amy.amythest.item;

import net.amy.amythest.AmysAmethyst;
import net.amy.amythest.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.amy.amythest.AmysAmethyst.MOD_ID;

public class ModItemGroups {
    public static final ItemGroup AMETHYST_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(MOD_ID, "time_blade_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.AMETHYST_DUST))
                    .displayName(Text.translatable("itemgroup.amysamethyst.time_blades_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.AMETHYST_SWORD);
                        entries.add(ModItems.AMETHYST_AXE);
                      entries.add(ModItems.AMETHYST_PICKAXE);
                      entries.add(ModItems.AMETHYST_SHOVEL);
                      entries.add(ModItems.AMETHYST_HOE);
                      entries.add(ModItems.AMETHYST_GLAIVE);
                      entries.add(ModItems.AMETHYST_SCYTHE);
                      entries.add(ModItems.AMETHYST_ARROW);
                      entries.add(ModItems.AMETHYST_TRIDENT);
                      entries.add(ModItems.AMETHYST_UPGRADE_SMITHING_TEMPLATE);
                      entries.add(ModItems.AMETHYST_HELMET);
                      entries.add(ModItems.AMETHYST_CHESTPLATE);
                      entries.add(ModItems.AMETHYST_LEGGINGS);
                      entries.add(ModItems.AMETHYST_BOOTS);
                      entries.add(ModItems.AMETHYST_HORSE_ARMOR);
                      entries.add(ModItems.AMETHYST_DUST);
                      entries.add(ModItems.AMETHYST_SOUP);
                      entries.add(Items.SMALL_AMETHYST_BUD);
                      entries.add(Items.MEDIUM_AMETHYST_BUD);
                      entries.add(Items.LARGE_AMETHYST_BUD);
                      entries.add(Items.AMETHYST_CLUSTER);
                      entries.add(Items.AMETHYST_SHARD);
                      entries.add(Items.AMETHYST_BLOCK);
                      entries.add(Items.BUDDING_AMETHYST);
                      entries.add(ModBlocks.AMETHYST_BRICKS);
                      entries.add(ModBlocks.AMETHYST_BRICK_STAIRS);
                      entries.add(ModBlocks.AMETHYST_BRICK_SLAB);
                      entries.add(ModBlocks.AMETHYST_LANTERN);
                      entries.add(ModBlocks.AMETHYST_TORCH);
                      entries.add(ModBlocks.AMETHYST_SAND);




                    })
                    .build());

    public static void registerItemGroups() {
        AmysAmethyst.LOGGER.info("Registering Item Groups for " + MOD_ID);
    }
}
