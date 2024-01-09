package net.funkystudios.funkyweapons;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.funkystudios.funkyweapons.datagen.ModItemTagProvider;
import net.funkystudios.funkyweapons.datagen.ModLangProvider;
import net.funkystudios.funkyweapons.datagen.ModRecipeProvider;

public class FunkyWeaponsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModLangProvider::new);
	}
}
