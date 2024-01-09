package net.funkystudios.funkyweapons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.funkystudios.funkyweapons.item.ModItems;
import net.funkystudios.funkyweapons.util.ModTags;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider{
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Items.SHARD_INFLICTING_ITEMS)
                .add(ModItems.OBSIDIAN_MACUAHUITL)
                .add(ModItems.TURQUOISE_OBSIDIAN_MACUAHUITL);

        getOrCreateTagBuilder(ModTags.Items.BLEEDING_INFLICTING_ITEMS)
                .add(ModItems.IRON_MACUAHUITL)
                .add(ModItems.GOLDEN_MACUAHUITL)
                .add(ModItems.DIAMOND_MACUAHUITL)
                .add(ModItems.NETHERITE_MACUAHUITL);


    }
}
