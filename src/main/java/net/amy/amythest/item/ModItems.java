package net.amy.amythest.item;

import net.amy.amythest.AmysAmethyst;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;

import static net.amy.amythest.AmysAmethyst.MOD_ID;


public class ModItems {

    public static final Identifier BASE_ENTITY_INTERACTION_RANGE_MODIFIER_ID = Identifier.of(MOD_ID, "base_entity_attack_range");

    public static final Item AMETHYST_DUST = registerItem("amethyst_dust", new Item(new Item.Settings()));

    public static final Item AMETHYST_SOUP = registerItem("amethyst_soup", new Item(new Item.Settings().food(ModFoodComponents.AMETHYST_SOUP)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.amysamethyst.amethyst_soup.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item AMETHYST_ARROW = registerItem("amethyst_arrow", new AmethystArrowItem(new Item.Settings()));

    public static final Item AMETHYST_TRIDENT = registerItem("amethyst_trident", new AmethystTridentItem(new Item.Settings(
            .maxDamage(2404)
            .fireproof()
            .rarity(Rarity.EPIC)));

    //Tools
    public static final Item AMETHYST_SCYTHE = registerItem("amethyst_scythe",
            new SwordItem(ModToolMaterials.AMETHYST, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.AMETHYST, 7, -2.4f))
                    .fireproof()
                    .rarity(Rarity.EPIC)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
    }

    public static void registerModItems() {
        AmysAmethyst.LOGGER.info("Registering Mod Items for " + MOD_ID);

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
