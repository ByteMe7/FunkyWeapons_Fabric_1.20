package net.funkystudios.funkyweapons.mixin;

import net.funkystudios.funkyweapons.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(CauldronBehavior.class)
public abstract class CauldronMixin{
    @Unique
    private static final Map<Item, CauldronBehavior> OBSIDIAN_TEARS_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    @Unique
    private static final  CauldronBehavior FILL_WITH_TEARS = (state, world, pos, player, hand, stack) -> CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState) ModBlocks.OBSIDIAN_TEAR_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL,3),null);

    @Unique
    private static final CauldronBehavior CREATE_CRYING_OBSIDIAN = (state, world, pos, player, hand, stack) -> {
        Block block = Block.getBlockFromItem(stack.getItem());
        if(block != Blocks.CRYING_OBSIDIAN) return ActionResult.PASS;
        if(!world.isClient){
            ItemStack itemStack = new ItemStack(Blocks.CRYING_OBSIDIAN);
            if(!player.getAbilities().creativeMode) stack.decrement(1);
            if (stack.isEmpty()) player.setStackInHand(hand,itemStack);
            if(!player.getInventory().insertStack(itemStack)) player.dropItem(itemStack,false);
            LeveledCauldronBlock.decrementFluidLevel(state,world,pos);
           return ActionResult.SUCCESS;
        }
        return  ActionResult.success(world.isClient);
    };

    @Inject(method = "registerBehavior", at = @At("HEAD"))
    private static void registerBehavior(CallbackInfo info){
        CauldronBehavior.registerBucketBehavior(OBSIDIAN_TEARS_CAULDRON_BEHAVIOR);
        OBSIDIAN_TEARS_CAULDRON_BEHAVIOR.put(Blocks.OBSIDIAN.asItem(),CREATE_CRYING_OBSIDIAN);
    }
}
