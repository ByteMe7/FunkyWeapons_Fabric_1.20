package net.funkystudios.funkyweapons.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.funkystudios.funkyweapons.FunkyWeapons;
import net.funkystudios.funkyweapons.block.ModBlocks;
import net.funkystudios.funkyweapons.fluid.ModFluids;
import net.funkystudios.funkyweapons.fluid.ObsidianTearsFluid;
import net.funkystudios.funkyweapons.item.custom.CustomBucketItem;
import net.funkystudios.funkyweapons.item.custom.DrinkItem;
import net.funkystudios.funkyweapons.item.custom.weapon.MacuahuitlItem;
import net.funkystudios.funkyweapons.util.ModFoodComponets;
import net.funkystudios.funkyweapons.util.NumberFuctions;
import net.minecraft.block.FluidBlock;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item TURQUOISE,
            RAW_TURQUOISE,
            WOODEN_SPIKE,
            WOODEN_MACUAHUITL,
            STONE_SPIKE,
            STONE_MACUAHUITL,
            IRON_SPIKE,
            IRON_MACUAHUITL,
            GOLDEN_SPIKE,
            GOLDEN_MACUAHUITL,
            DIAMOND_SPIKE,
            DIAMOND_MACUAHUITL,
            NETHERITE_SPIKE,
            NETHERITE_MACUAHUITL,
            OBSIDAIAN_SPIKE,
            OBSIDIAN_MACUAHUITL,
            TURQUOISE_OBSIDIAN_SPIKE,
            TURQUOISE_OBSIDIAN_MACUAHUITL,
            TURQUOISE_SWORD,
            TURQUOISE_PICKAXE,
            TURQUOISE_AXE,
            TURQUOISE_SHOVEL,
            TURQUOISE_HOE,
            MUG,
            HOT_CHOCOLATE,
            ROASTED_HOT_CHOCOLATE,
    OBSIDIAN_TEARS_BUCKET,
    APACHE_TEARS_BUCKET;

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FunkyWeapons.MOD_ID, name), item);
    }

    private static void addItemsToIngredientTab(FabricItemGroupEntries entries) {
        entries.add(TURQUOISE);
        entries.add(RAW_TURQUOISE);
        entries.add(WOODEN_SPIKE);
        entries.add(STONE_SPIKE);
        entries.add(IRON_SPIKE);
        entries.add(GOLDEN_SPIKE);

    }

    private static void addItemsToCombatTab(FabricItemGroupEntries entries){
        entries.add(WOODEN_MACUAHUITL);
        entries.add(STONE_MACUAHUITL);
        entries.add(IRON_MACUAHUITL);
        entries.add(GOLDEN_MACUAHUITL);
        entries.add(DIAMOND_MACUAHUITL);
        entries.add(NETHERITE_MACUAHUITL);
        entries.add(OBSIDIAN_MACUAHUITL);
        entries.add(TURQUOISE_OBSIDIAN_MACUAHUITL);
    }
    public static void registerModItems() {
        FunkyWeapons.LOGGER.info("Registering Items for " + FunkyWeapons.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatTab);
    }

    static {
        TURQUOISE = registerItem("turquoise", new Item(new FabricItemSettings()));
        RAW_TURQUOISE = registerItem("raw_turquoise", new Item(new Item.Settings()));


        WOODEN_SPIKE = registerItem("wooden_spike", new Item(new Item.Settings()));
        STONE_SPIKE = registerItem("stone_spike", new Item(new Item.Settings()));
        IRON_SPIKE = registerItem("iron_spike", new Item(new Item.Settings()));
        GOLDEN_SPIKE = registerItem("gold_spike", new Item(new Item.Settings()));
        DIAMOND_SPIKE = registerItem("diamond_spike", new Item(new Item.Settings()));
        NETHERITE_SPIKE = registerItem("netherite_spike", new Item(new Item.Settings().fireproof()));
        OBSIDAIAN_SPIKE = registerItem("obsidian_spike", new Item(new Item.Settings().fireproof()));
        TURQUOISE_OBSIDIAN_SPIKE = registerItem("turquoise_obsidian_spike", new Item(new Item.Settings().fireproof()));

        WOODEN_MACUAHUITL = registerItem("wooden_macuahuitl", new MacuahuitlItem(ToolMaterials.WOOD,4,-1.6f,new Item.Settings()));
        STONE_MACUAHUITL = registerItem("stone_macuahuitl", new MacuahuitlItem(ToolMaterials.STONE,4,-1.6f,new Item.Settings()));
        IRON_MACUAHUITL = registerItem("iron_macuahuitl", new MacuahuitlItem(ToolMaterials.IRON, 4,-1.6f, new Item.Settings()));
        GOLDEN_MACUAHUITL = registerItem("gold_macuahuitl", new MacuahuitlItem(ToolMaterials.GOLD, 4,-1.6f, new Item.Settings()));
        DIAMOND_MACUAHUITL = registerItem("diamond_macuahuitl", new MacuahuitlItem(ToolMaterials.DIAMOND, 4,-1.6f, new Item.Settings()));
        NETHERITE_MACUAHUITL = registerItem("netherite_macuahuitl", new MacuahuitlItem(ToolMaterials.NETHERITE, 4,-1.6f, new Item.Settings().fireproof()));
        OBSIDIAN_MACUAHUITL = registerItem("obsidian_macuahuitl", new MacuahuitlItem(ModToolMaterials.OBSIDIAN, 4,-1.6f, new Item.Settings().fireproof()));
        TURQUOISE_OBSIDIAN_MACUAHUITL = registerItem("turquoise_obsidian_macuahuitl", new MacuahuitlItem(ModToolMaterials.TURQUOISE_OBSIDIAN, 4,-1.6f, new Item.Settings().fireproof()));

        TURQUOISE_SWORD = registerItem("turquoise_sword", new SwordItem(ModToolMaterials.TURQUOISE,4,0.6f, new Item.Settings()));
        TURQUOISE_PICKAXE = registerItem("turquoise_pickaxe", new PickaxeItem(ModToolMaterials.TURQUOISE,3,0.5f,new Item.Settings()));
        TURQUOISE_AXE = registerItem("turquoise_axe", new AxeItem(ModToolMaterials.TURQUOISE,3,0.5f,new Item.Settings()));
        TURQUOISE_SHOVEL = registerItem("turquoise_shovel", new ShovelItem(ModToolMaterials.TURQUOISE,3,0.5f,new Item.Settings()));
        TURQUOISE_HOE = registerItem("turquoise_hoe", new HoeItem(ModToolMaterials.TURQUOISE,-2,0.5f,new Item.Settings()));

        MUG = registerItem("mug", new Item(new Item.Settings()));
        HOT_CHOCOLATE = registerItem("hot_chocolate", new DrinkItem(new Item.Settings().food(ModFoodComponets.HOT_CHOCOLATE),40, MUG));
        ROASTED_HOT_CHOCOLATE = registerItem("roasted_hot_chocolate", new DrinkItem(new Item.Settings().food(ModFoodComponets.ROASTED_HOT_CHOCOLATE),40, MUG));

        OBSIDIAN_TEARS_BUCKET = registerItem("obsidian_tears_bucket", new CustomBucketItem(ModFluids.OBSIDIAN_TEARS_STILL, new Item.Settings(), NumberFuctions.hexToInt("210a39")));
        APACHE_TEARS_BUCKET = registerItem("apache_tears_bucket", new CustomBucketItem(ModFluids.APACHE_TEARS_STILL, new Item.Settings(), NumberFuctions.hexToInt("07f5ed")));
    }

}

