package net.funkystudios.funkyweapons;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.funkystudios.funkyweapons.block.ModBlocks;
import net.funkystudios.funkyweapons.fluid.ModFluids;
import net.funkystudios.funkyweapons.item.ModItems;
import net.funkystudios.funkyweapons.item.custom.CustomBucketItem;


public class FunkyWeaponsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.OBSIDIAN_TEARS_STILL.getStill(), SimpleFluidRenderHandler.coloredWater(0x210A39));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.OBSIDIAN_TEARS_FLOWING.getFlowing(), SimpleFluidRenderHandler.coloredWater(0x210A39));
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0x210A39, ModBlocks.OBSIDIAN_TEAR_CAULDRON);


        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.APACHE_TEARS_STILL.getStill(), SimpleFluidRenderHandler.coloredWater(0x07f5ed));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.APACHE_TEARS_FLOWING.getFlowing(), SimpleFluidRenderHandler.coloredWater(0x07f5ed));
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0x07f5ed, ModBlocks.APACHE_TEAR_CAULDRON);

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((CustomBucketItem) stack.getItem()).getColor(tintIndex),
                ModItems.APACHE_TEARS_BUCKET, ModItems.OBSIDIAN_TEARS_BUCKET);

    }
}
