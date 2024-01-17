package net.funkystudios.funkyweapons.fluid;

import net.funkystudios.funkyweapons.FunkyWeapons;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static FlowableFluid OBSIDIAN_TEARS_STILL, OBSIDIAN_TEARS_FLOWING, APACHE_TEARS_STILL, APACHE_TEARS_FLOWING;

    public static FlowableFluid register(String name, FlowableFluid fluid){
        return Registry.register(Registries.FLUID, new Identifier(FunkyWeapons.MOD_ID, name), fluid);
    }

    static {
        OBSIDIAN_TEARS_STILL = register("obsidian_tears_still", new ObsidianTearsFluid.Still());
        OBSIDIAN_TEARS_FLOWING = register("obsidian_tears_flowing", new ObsidianTearsFluid.Flowing());
        APACHE_TEARS_STILL = register("apache_tears_still", new ApacheTearsFluid.Still());
        APACHE_TEARS_FLOWING = register("apache_tears_flowing", new ApacheTearsFluid.Flowing());
    }
}
