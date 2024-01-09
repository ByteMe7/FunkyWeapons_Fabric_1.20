package net.funkystudios.funkyweapons.alchemy.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class ShardsEffect extends StatusEffect {
    Vec3d currentPos, lastPos;
    protected ShardsEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getWorld();
        if(!world.isClient){
            currentPos = entity.getPos();
            if(!currentPos.equals(lastPos)){
                entity.damage(entity.getDamageSources().generic(),0.2f * amplifier);
            }
            lastPos = entity.getPos();
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }


}
