package net.amy.amythest.item;

import net.amy.amythest.AmysAmethyst;
import net.amy.amythest.block.ModBlocks;
import net.amy.amythest.entity.ModEntityType;
import net.amy.amythest.item.custom.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Direction;

import java.util.List;

import static net.amy.amythest.AmysAmethyst.MOD_ID;


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

    public static final Item AMETHYST_UPGRADE_SMITHING_TEMPLATE = registerItem("amethyst_upgrade_smithing_template",
            ModSmithingTemplateItem.createAmethystUpgrade());


    public static final Item CHERRY_FOX_SPAWN_EGG = registerItem("cherry_fox_spawn_egg",
            new SpawnEggItem(ModEntityType.CHERRY_FOX, 0xFF54FF, 0xFF10FF, new Item.Settings()));



    //Tools
    public static final Item AMETHYST_SCYTHE = registerItem("amethyst_scythe",
            new ScytheItem(ModToolMaterials.AMETHYST, new Item.Settings()
            .attributeModifiers(ScytheItem.createAttributeModifiers(ModToolMaterials.AMETHYST, 7, -3.0f, 0.7f))
                    .fireproof()
                    .rarity(Rarity.EPIC)));

    public static final Item AMETHYST_GLAIVE = registerItem("amethyst_glaive",
            new GlaiveItem(ModToolMaterials.AMETHYST,  new Item.Settings()
                    .attributeModifiers(GlaiveItem.createAttributeModifiers(ModToolMaterials.AMETHYST, 6, -2.0f, 0.5f))
                    .fireproof()
                    .rarity(Rarity.EPIC)));

    public static final Item AMETHYST_TRIDENT = registerItem("amethyst_trident", new AmethystTridentItem(new Item.Settings()
            .maxDamage(2404)
            .fireproof()
            .rarity(Rarity.EPIC)));

    public static final Item AMETHYST_SWORD = registerItem("amethyst_sword",
            new SwordItem(ModToolMaterials.AMETHYST, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.AMETHYST, 5, -2.4f))
                    .fireproof()
                    .rarity(Rarity.EPIC)));

    public static final Item AMETHYST_PICKAXE = registerItem("amethyst_pickaxe",
            new PickaxeItem(ModToolMaterials.AMETHYST, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.AMETHYST, 0, -2.8f))
                    .fireproof()
                    .rarity(Rarity.EPIC)));

    public static final Item AMETHYST_AXE = registerItem("amethyst_axe",
            new AxeItem(ModToolMaterials.AMETHYST, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.AMETHYST, 6, -3.0f))
                    .fireproof()
                    .rarity(Rarity.EPIC)));

    public static final Item AMETHYST_SHOVEL = registerItem("amethyst_shovel",
            new ShovelItem(ModToolMaterials.AMETHYST, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.AMETHYST, -2, -3.0f))
                    .fireproof()
                    .rarity(Rarity.EPIC)));

    public static final Item AMETHYST_HOE = registerItem("amethyst_hoe",
            new HoeItem(ModToolMaterials.AMETHYST, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.AMETHYST, -3, 0f))
                    .fireproof()
                    .rarity(Rarity.EPIC)));

    //armour
    public static final Item AMETHYST_HELMET = registerItem("amethyst_helmet",
            new ModArmorItem(ModArmorMaterials.AMETHYST_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(55))
                    .fireproof()
                    .rarity(Rarity.EPIC)));
    public static final Item AMETHYST_CHESTPLATE = registerItem("amethyst_chestplate",
            new ModArmorItem(ModArmorMaterials.AMETHYST_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(65))
                    .fireproof()
                    .rarity(Rarity.EPIC)));
    public static final Item AMETHYST_LEGGINGS = registerItem("amethyst_leggings",
            new ModArmorItem(ModArmorMaterials.AMETHYST_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(60))
                    .fireproof()
                    .rarity(Rarity.EPIC)));
    public static final Item AMETHYST_BOOTS = registerItem("amethyst_boots",
            new ModArmorItem(ModArmorMaterials.AMETHYST_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(58))
                    .fireproof()
                    .rarity(Rarity.EPIC)));

    public static final Item AMETHYST_HORSE_ARMOR = registerItem("amethyst_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.AMETHYST_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings()
                    .maxCount(1)
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(40))
                    .fireproof()
                    .rarity(Rarity.EPIC)));

    public static final Item AMETHYST_TORCH = registerItem( "amethyst_torch", new VerticallyAttachableBlockItem(ModBlocks.AMETHYST_TORCH, ModBlocks.AMETHYST_WALL_TORCH, new Item.Settings(), Direction.DOWN));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
    }

    public static void registerModItems() {
        AmysAmethyst.LOGGER.info("Registering Mod Items for " + MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(AMETHYST_DUST);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(AMETHYST_UPGRADE_SMITHING_TEMPLATE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(AMETHYST_ARROW);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(AMETHYST_SOUP);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(CHERRY_FOX_SPAWN_EGG);
        });


        //Tools
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(AMETHYST_TRIDENT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(AMETHYST_SCYTHE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(AMETHYST_SWORD);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(AMETHYST_PICKAXE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(AMETHYST_AXE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(AMETHYST_AXE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(AMETHYST_SHOVEL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(AMETHYST_HOE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(AMETHYST_HELMET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(AMETHYST_CHESTPLATE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(AMETHYST_LEGGINGS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(AMETHYST_BOOTS);
        });


    }

}
