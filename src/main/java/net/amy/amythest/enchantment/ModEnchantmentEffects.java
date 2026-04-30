package net.amy.amythest.enchantment;

import com.mojang.serialization.MapCodec;
import net.amy.amythest.AmysAmethyst;

import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.amy.amythest.AmysAmethyst.MOD_ID;

public class ModEnchantmentEffects {

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        AmysAmethyst.LOGGER.info("Registering Mod Enchantment Effects for " + MOD_ID);
    }



}
