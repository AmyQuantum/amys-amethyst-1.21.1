package net.amy.amythest.item;

import net.amy.amythest.AmysAmethyst;
import net.amy.amythest.entity.projectile.AmethystArrowEntity;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {

    public static final Item AMETHYST_DUST = registerItem("amethyst_dust", new Item(new Item.Settings()));

    public static final Item AMETHYST_ARROW = registerItem("amethyst_arrow", new AmethystArrowItem(new Item.Settings()));

    public static final Item AMETHYST_TRIDENT = registerItem("amethyst_trident", new AmethystTridentItem(new Item.Settings()));

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
    }
}
