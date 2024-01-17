package net.funkystudios.funkyweapons.item.custom;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;

public class CustomBucketItem extends BucketItem {
    private final int fluidColor;

    public CustomBucketItem(Fluid fluid, Item. Settings settings, int fluidColor) {
        super(fluid, settings);
        this.fluidColor = fluidColor;
    }

    public int getColor(int tintIndex) {
        return tintIndex == 1 ? fluidColor: -1;
    }
}