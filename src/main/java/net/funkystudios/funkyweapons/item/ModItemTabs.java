package net.funkystudios.funkyweapons.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.funkystudios.funkyweapons.FunkyWeapons;
import net.funkystudios.funkyweapons.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemTabs {
    public static ItemGroup FUNKY_MATERIALS  = Registry.register(Registries.ITEM_GROUP,
            new Identifier(FunkyWeapons.MOD_ID, "materials"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemtab.materials"))
                    .icon(() -> new ItemStack(ModItems.TURQUOISE))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_TURQUOISE);
                        entries.add(ModItems.TURQUOISE);
                    })
                    .build());

    public static ItemGroup FUNKY_BLOCKS
            = Registry.register(Registries.ITEM_GROUP,
            new Identifier(FunkyWeapons.MOD_ID,"funkyblocks"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.funkyblocks"))
                    .icon(() -> new ItemStack(ModBlocks.TURQUOISE_BLOCK))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.TURQUOISE_BLOCK);
                    })
                    .build());
    public static void registerItemTabs(){
        FunkyWeapons.LOGGER.info("Registering Item Tabs for " + FunkyWeapons.MOD_ID);
    }
}
