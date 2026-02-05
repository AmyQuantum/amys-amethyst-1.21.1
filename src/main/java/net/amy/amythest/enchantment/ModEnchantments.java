package net.amy.amythest.enchantment;

import net.amy.amythest.AmysAmethyst;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.enchantment.effect.entity.DamageEntityEnchantmentEffect;
import net.minecraft.enchantment.effect.value.AddEnchantmentEffect;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.EntityTypePredicate;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.command.EnchantCommand;
import net.minecraft.util.Identifier;

public class ModEnchantments {

    public static final RegistryKey<Enchantment> STRIKING =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(AmysAmethyst.MOD_ID, "striking"));

    public static void bootstrap(Registerable<Enchantment> registerable) {
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        register(registerable, STRIKING, new Enchantment.Builder(Enchantment.definition(
                items.getOrThrow(ItemTags.TRIDENT_ENCHANTABLE),
                2,
                5,
                Enchantment.leveledCost(1, 8),
                Enchantment.leveledCost(21, 8),
                4,
                AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(
                        EnchantmentEffectComponentTypes.DAMAGE,
                        new AddEnchantmentEffect(EnchantmentLevelBasedValue.linear(2.5F)),
                        EntityPropertiesLootCondition.builder(
                                LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().type(EntityTypePredicate.create(EntityTypeTags.SENSITIVE_TO_IMPALING)).build()
                        )
                ));
    }



    private static void register(Registerable<Enchantment> registry, RegistryKey key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
}
