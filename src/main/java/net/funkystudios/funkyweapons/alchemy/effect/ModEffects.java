package net.funkystudios.funkyweapons.alchemy.effect;

import net.funkystudios.funkyweapons.FunkyWeapons;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static StatusEffect SHARDS, BLEEDING, OBSIDIAN_TEARS, APACHE_TEARS;
    public static StatusEffect registerStatusEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(FunkyWeapons.MOD_ID,name),
                effect);
    }

    public static void registerEffects() {
        SHARDS = registerStatusEffect("shards", new ShardsEffect(StatusEffectCategory.NEUTRAL,1441840));
        BLEEDING = registerStatusEffect("bleeding", new BleedingEffect(StatusEffectCategory.HARMFUL,5177862));
        OBSIDIAN_TEARS = registerStatusEffect("obsidian_tears", new ObsidianTearsEffect());
        APACHE_TEARS = registerStatusEffect("apache_tears", new ApacheTearsEffect());
    }
}
