package net.funkystudios.funkyweapons.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.funkystudios.funkyweapons.FunkyWeapons;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block TURQUOISE_BLOCK,
            RAW_TURQUOISE_BLOCK,
    TURQUOISE_OBSIDIAN,
    OBSIDIAN_TEAR_CAULDRON;

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK,
                new Identifier(FunkyWeapons.MOD_ID, name),
                block);
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
        TURQUOISE_OBSIDIAN = registerBlock("turquoise_obsidian_block", new Block(FabricBlockSettings.copyOf(Blocks.CRYING_OBSIDIAN)));
        OBSIDIAN_TEAR_CAULDRON = registerBlock("obsidian_tear_cauldron", new LeveledCauldronBlock(AbstractBlock.Settings.copy(Blocks.CAULDRON), null,null));
    }
}
