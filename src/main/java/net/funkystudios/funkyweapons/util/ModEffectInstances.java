package net.funkystudios.funkyweapons.util;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModEffectInstances {
    public static class Vanilla{
        public static final StatusEffectInstance SHORT_SPEED = new StatusEffectInstance(StatusEffects.SPEED,60);
        public static final StatusEffectInstance LONG_SPEED = new StatusEffectInstance(StatusEffects.SPEED,240);
        public static final StatusEffectInstance SHORT_FIRE_RES = new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,160);
    }
}
