package net.funkystudios.funkyweapons.alchemy.effect;

import net.funkystudios.funkyweapons.util.NumberFuctions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.*;
import net.minecraft.world.World;

import java.util.*;

public class ObsidianTearsEffect extends InstantStatusEffect {
    private static final List<Map<Integer,String>> Effects = new ArrayList<>();


    public ObsidianTearsEffect() {
        super(StatusEffectCategory.HARMFUL, NumberFuctions.hexToInt("210a39"));
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        World world = entity.getWorld();
        if(!world.isClient){
            int key = NumberFuctions.random(1,Effects.size()-1);
            switch (getEffect(key)){
                case "fire":
                    entity.setOnFireFor(NumberFuctions.random(4,20));
                    break;
                case "res_poison":
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 600));
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 600));
                    break;
                case "absorption_wither":
                    entity.setAbsorptionAmount(NumberFuctions.random(3,12));
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,200,1));
                    break;
            }
        }
    }

    static {
        addPair(1,"fire");
        addPair(2,"res_poison");
        addPair(3,"absorption_wither");
    }

    private static String getEffect(int key){
        for(Map<Integer,String> pair : Effects){
            if(pair.containsKey(key)) return pair.get(key);
        }
        throw new RuntimeException("Invalid Key Detected");
    }
    private static void addPair(int key, String effect){
        Map<Integer,String> pair = new HashMap<>();
        pair.put(key,effect);
        Effects.add(pair);
    }
}
