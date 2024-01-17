package net.funkystudios.funkyweapons;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.funkystudios.funkyweapons.alchemy.effect.ModEffects;
import net.funkystudios.funkyweapons.alchemy.potion.ModPotions;
import net.funkystudios.funkyweapons.block.ModBlocks;
import net.funkystudios.funkyweapons.fluid.ModFluids;
import net.funkystudios.funkyweapons.item.ModItemTabs;
import net.funkystudios.funkyweapons.item.ModItems;
import net.funkystudios.funkyweapons.util.ModCauldronBehavior;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunkyWeapons implements ModInitializer {
	public static final String MOD_ID = "funkyweapons";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemTabs.registerItemTabs();


		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModCauldronBehavior.registerBehavior();

		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModCauldronBehavior.registerBehavior();

	}

}