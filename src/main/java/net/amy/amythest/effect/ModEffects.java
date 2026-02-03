package net.amy.amythest.effect;

import net.amy.amythest.AmysAmethyst;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> CRYSTALLISATION = registerStatusEffect("crystallisation",
            new CrystallisationEffect(StatusEffectCategory.HARMFUL, 0xbf84d9)
                    .addAttributeModifier(EntityAttributes.GENERIC_OXYGEN_BONUS,
                    Identifier.of(AmysAmethyst.MOD_ID, "crystallisation"), -1.0f,
            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(AmysAmethyst.MOD_ID, name), statusEffect);
    }
    public static void registerEffects() {
        AmysAmethyst.LOGGER.info("Registering Mod Effects for " + AmysAmethyst.MOD_ID);
    }
}
