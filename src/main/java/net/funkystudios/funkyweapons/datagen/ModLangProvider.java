package net.funkystudios.funkyweapons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.funkystudios.funkyweapons.item.ModItems;
import net.minecraft.text.Text;

import java.nio.file.Path;

public class ModLangProvider extends FabricLanguageProvider {


    public ModLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        generateItemTranslations(translationBuilder);

    }

    private static void generateItemTranslations(TranslationBuilder translationBuilder){

        translationBuilder.add(ModItems.RAW_TURQUOISE, "Raw Turquoise");
        translationBuilder.add(ModItems.TURQUOISE, "Turquoise");

        translationBuilder.add(ModItems.WOODEN_SPIKE, "Wooden Spike");
        translationBuilder.add(ModItems.STONE_SPIKE, "Stone Spike");
        translationBuilder.add(ModItems.IRON_SPIKE, "Iron Spike");
        translationBuilder.add(ModItems.GOLDEN_SPIKE, "Golden Spike");
        translationBuilder.add(ModItems.DIAMOND_SPIKE, "Diamond Spike");
        translationBuilder.add(ModItems.NETHERITE_SPIKE, "Netherite Spike");
        translationBuilder.add(ModItems.OBSIDAIAN_SPIKE, "Obsidian Spike");
        translationBuilder.add(ModItems.TURQUOISE_OBSIDIAN_SPIKE, "Turquoise-Obsidian Spike");

        translationBuilder.add(ModItems.MUG, "Mug");
        translationBuilder.add(ModItems.HOT_CHOCOLATE, "Hot Chocolate");
    }
}
