package net.funkystudios.funkyweapons.alchemy.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class BleedingEffect extends StatusEffect {
    protected BleedingEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getWorld();
        if(!world.isClient){
            if(entity instanceof PlayerEntity){
                PlayerEntity player = ((PlayerEntity) entity);
                HungerManager hunger = player.getHungerManager();
                hunger.setFoodLevel(17);
                hunger.setSaturationLevel(0);
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
