package net.funkystudios.funkyweapons.util;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponets {
    public static final FoodComponent HOT_CHOCOLATE = new FoodComponent.Builder()
            .saturationModifier(2f)
            .statusEffect(ModEffectInstances.Vanilla.SHORT_SPEED, 1)
            .alwaysEdible()
            .build(),
            ROASTED_HOT_CHOCOLATE = new FoodComponent.Builder()
                    .alwaysEdible()
                    .statusEffect(ModEffectInstances.Vanilla.LONG_SPEED, 1)
                    .saturationModifier(3f)
                    .build(),
            POBLANO = new FoodComponent.Builder()
                    .hunger(2)
                    .saturationModifier(3f)
                    .snack()
                    .statusEffect(ModEffectInstances.Vanilla.SHORT_FIRE_RES,1)
                    .build(),
            ROASTED_POBLANO = new FoodComponent.Builder()
                    .hunger(3)
                    .saturationModifier(3.5f)
                    .snack()
                    .statusEffect(ModEffectInstances.Vanilla.SHORT_FIRE_RES,1)
                    .build();
}
