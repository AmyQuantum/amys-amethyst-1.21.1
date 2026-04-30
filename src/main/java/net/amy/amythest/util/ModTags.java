package net.amy.amythest.util;

import net.amy.amythest.AmysAmethyst;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_AMETHYST_TOOL = createTag("needs_amethyst_tool");
        public static final TagKey<Block> INCORRECT_FOR_AMETHYST_TOOL = createTag("incorrect_for_amethyst_tool");

        public static final TagKey<Block> NEEDS_RESIN_TOOL = createTag("needs_resin_tool");
        public static final TagKey<Block> INCORRECT_FOR_RESIN_TOOL = createTag("incorrect_for_resin_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(AmysAmethyst.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> SCYTHE_ENCHANTABLE = createTag("scythe_enchantable");


        private static TagKey<Item> createTag(String name) {

            return TagKey.of(RegistryKeys.ITEM, Identifier.of(AmysAmethyst.MOD_ID, name));
        }
    }
}
