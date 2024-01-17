package net.funkystudios.funkyweapons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.funkystudios.funkyweapons.block.ModBlocks;
import net.funkystudios.funkyweapons.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TURQUOISE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_TURQUOISE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TURQUOISE_CRYING_OBSIDIAN);

        registerCauldronLikeModel(blockStateModelGenerator, ModBlocks.OBSIDIAN_TEAR_CAULDRON);
        registerCauldronLikeModel(blockStateModelGenerator, ModBlocks.APACHE_TEAR_CAULDRON);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.TURQUOISE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TURQUOISE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WOODEN_SPIKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STONE_SPIKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_SPIKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_SPIKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_SPIKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_SPIKE, Models.GENERATED);

        itemModelGenerator.register(ModItems.MUG, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOT_CHOCOLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROASTED_HOT_CHOCOLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.TURQUOISE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.WOODEN_MACUAHUITL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_MACUAHUITL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_MACUAHUITL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLDEN_MACUAHUITL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_MACUAHUITL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_MACUAHUITL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_MACUAHUITL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_OBSIDIAN_MACUAHUITL, Models.HANDHELD);

    }

    private static void registerCauldronLikeModel(BlockStateModelGenerator blockStateModelGenerator, Block block){
        blockStateModelGenerator.registerParented(Blocks.WATER_CAULDRON,block);
    }

}
