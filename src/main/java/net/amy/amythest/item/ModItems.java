package net.amy.amythest.item;

import net.amy.amythest.AmysAmethyst;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;


public class ModItems {

    public static final Item AMETHYST_DUST = registerItem("amethyst_dust", new Item(new Item.Settings()));

    public static final Item AMETHYST_SOUP = registerItem("amethyst_soup", new Item(new Item.Settings().food(ModFoodComponents.AMETHYST_SOUP)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.amysamethyst.amethyst_soup.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item AMETHYST_ARROW = registerItem("amethyst_arrow", new AmethystArrowItem(new Item.Settings()));

    public static final Item AMETHYST_TRIDENT = registerItem("amethyst_trident", new AmethystTridentItem(new Item.Settings().maxDamage(1000)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AmysAmethyst.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AmysAmethyst.LOGGER.info("Registering Mod Items for " + AmysAmethyst.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(AMETHYST_DUST);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(AMETHYST_ARROW);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(AMETHYST_TRIDENT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(AMETHYST_SOUP);
        });
    }
}
