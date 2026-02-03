package net.amy.amythest.item;

import net.amy.amythest.effect.ModEffects;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;

public class ModFoodComponents {
    public static final FoodComponent AMETHYST_SOUP = new FoodComponent.Builder().nutrition(6).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(ModEffects.CRYSTALLISATION, 200), 1f).build();
}
