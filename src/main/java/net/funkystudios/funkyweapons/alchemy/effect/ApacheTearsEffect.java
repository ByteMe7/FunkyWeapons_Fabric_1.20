package net.funkystudios.funkyweapons.alchemy.effect;

import net.funkystudios.funkyweapons.util.NumberFuctions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.world.World;

public class ApacheTearsEffect extends InstantStatusEffect {
    protected ApacheTearsEffect() {
        super(StatusEffectCategory.HARMFUL, NumberFuctions.hexToInt("07f5ed"));
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        World world = entity.getWorld();
        if(!world.isClient){
            entity.addStatusEffect(new StatusEffectInstance(ModEffects.SHARDS, 600));
        }
    }
}
