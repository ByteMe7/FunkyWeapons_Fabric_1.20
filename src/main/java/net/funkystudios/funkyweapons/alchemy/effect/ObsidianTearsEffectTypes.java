package net.funkystudios.funkyweapons.alchemy.effect;

import net.funkystudios.funkyweapons.util.ModEffectInstances;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.jetbrains.annotations.Nullable;

public enum ObsidianTearsEffectTypes {
    NAUSEA_FIRERES_ONFIRE(1,
            new StatusEffectInstance[]{
                    ModEffectInstances.Vanilla.SHORT_FIRE_RES,
                    ModEffectInstances.Vanilla.LONG_NAUSEA
            });
    private final StatusEffectInstance[] effects;
    private final int extra;


    ObsidianTearsEffectTypes(int extra, StatusEffectInstance... effects) {
        this.effects = effects;
        this.extra = extra;
    }

    public StatusEffectInstance[] getEffects(){
        return this.effects;
    }

   public int getExtra(){
        return  this.extra;
   }
}
