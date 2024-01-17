package net.funkystudios.funkyweapons.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.funkystudios.funkyweapons.FunkyWeapons;
import net.funkystudios.funkyweapons.block.custom.ApacheTearsCauldronBlock;
import net.funkystudios.funkyweapons.block.custom.ObsidianTearsCauldronBlock;
import net.funkystudios.funkyweapons.fluid.ModFluids;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block TURQUOISE_BLOCK,
            RAW_TURQUOISE_BLOCK,
            TURQUOISE_CRYING_OBSIDIAN,
    OBSIDIAN_TEAR_CAULDRON,
    APACHE_TEAR_CAULDRON,
    OBSIDIAN_TEARS_BLOCK,
    APACHE_TEARS_BLOCK;

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK,
                new Identifier(FunkyWeapons.MOD_ID, name),
                block);
    }
    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(FunkyWeapons.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM,
                new Identifier(FunkyWeapons.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks(){
        FunkyWeapons.LOGGER.info("Registering Blocks for " + FunkyWeapons.MOD_ID);
    }

    static {
        TURQUOISE_BLOCK = registerBlock("turquoise_block", new Block(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS)));
        RAW_TURQUOISE_BLOCK = registerBlock("raw_turquoise_block", new Block(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS)));
        TURQUOISE_CRYING_OBSIDIAN = registerBlock("turquoise_crying_obsidian_block", new Block(FabricBlockSettings.copyOf(Blocks.CRYING_OBSIDIAN)));
        OBSIDIAN_TEAR_CAULDRON = registerBlockWithoutBlockItem("obsidian_tear_cauldron", new ObsidianTearsCauldronBlock());
        APACHE_TEAR_CAULDRON = registerBlockWithoutBlockItem("apache_tear_cauldron", new ApacheTearsCauldronBlock());
        OBSIDIAN_TEARS_BLOCK = registerBlockWithoutBlockItem("obsidian_tears_block", new FluidBlock(ModFluids.OBSIDIAN_TEARS_STILL,FabricBlockSettings.copyOf(Blocks.WATER)));
        APACHE_TEARS_BLOCK = registerBlockWithoutBlockItem("apache_tears_block", new FluidBlock(ModFluids.APACHE_TEARS_STILL,FabricBlockSettings.copyOf(Blocks.WATER)));
    }
}
