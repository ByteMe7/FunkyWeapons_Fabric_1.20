package net.funkystudios.funkyweapons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.funkystudios.funkyweapons.FunkyWeapons;
import net.funkystudios.funkyweapons.block.ModBlocks;
import net.funkystudios.funkyweapons.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TURQUOISE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_TURQUOISE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TURQUOISE_CRYING_OBSIDIAN);

        registerWaterCauldronLikeModel(blockStateModelGenerator, ModBlocks.OBSIDIAN_TEAR_CAULDRON);
        registerWaterCauldronLikeModel(blockStateModelGenerator, ModBlocks.APACHE_TEAR_CAULDRON);

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

        itemModelGenerator.register(ModItems.APACHE_TEARS_BUCKET, item("template_bucket"));
        itemModelGenerator.register(ModItems.OBSIDIAN_TEARS_BUCKET, item("template_bucket"));


    }

    private static void registerWaterCauldronLikeModel(BlockStateModelGenerator blockStateModelGenerator, Block block){

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap.create(LeveledCauldronBlock.LEVEL)
                .register((Integer)1, BlockStateVariant.create()
                        .put(VariantSettings.MODEL,
                                Models.TEMPLATE_CAULDRON_LEVEL1.upload(block, "_level1", TextureMap.cauldron(TextureMap.getSubId(Blocks.WATER, "_still")), blockStateModelGenerator.modelCollector)))
                .register((Integer)2, BlockStateVariant.create()
                        .put(VariantSettings.MODEL,
                                Models.TEMPLATE_CAULDRON_LEVEL2.upload(block, "_level2", TextureMap.cauldron(TextureMap.getSubId(Blocks.WATER, "_still")), blockStateModelGenerator.modelCollector)))
                .register((Integer)3, BlockStateVariant.create()
                        .put(VariantSettings.MODEL,
                                Models.TEMPLATE_CAULDRON_FULL.upload(block, "_full", TextureMap.cauldron(TextureMap.getSubId(Blocks.WATER, "_still")), blockStateModelGenerator.modelCollector)))));

    }

    private static Model item(String parent) {
        return new Model(Optional.of(new Identifier(FunkyWeapons.MOD_ID, "item/" + parent)), Optional.empty());
    }

}
