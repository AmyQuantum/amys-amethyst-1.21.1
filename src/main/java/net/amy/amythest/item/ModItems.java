package net.amy.amythest.item;

import net.amy.amythest.AmysAmethyst;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item AMETHYST_DUST = registerItem("amethyst_dust", new Item(new Item.Settings()));




    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AmysAmethyst.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AmysAmethyst.LOGGER.info("Registering Mod Items for " + AmysAmethyst.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(AMETHYST_DUST);
        });
    }
}
