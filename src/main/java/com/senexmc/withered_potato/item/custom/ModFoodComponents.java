package com.senexmc.withered_potato.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent WITHERED_POTATO =
            new FoodComponent
                    .Builder()
                    .hunger(6)
                    .saturationModifier(1.5f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 200, 1), 0.6f)
                    .build();
}