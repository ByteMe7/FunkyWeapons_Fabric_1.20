package net.funkystudios.funkyweapons;

import net.fabricmc.api.ModInitializer;

import net.funkystudios.funkyweapons.block.ModBlocks;
import net.funkystudios.funkyweapons.item.ModItemTabs;
import net.funkystudios.funkyweapons.item.ModItems;
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
	}
}