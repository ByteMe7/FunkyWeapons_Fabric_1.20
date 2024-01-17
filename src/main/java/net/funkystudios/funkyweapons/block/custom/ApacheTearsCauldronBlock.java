package net.funkystudios.funkyweapons.block.custom;

import net.funkystudios.funkyweapons.block.ModBlocks;
import net.funkystudios.funkyweapons.util.ModCauldronBehavior;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;

import java.util.Map;

public class ApacheTearsCauldronBlock extends LeveledCauldronBlock {

    public ApacheTearsCauldronBlock() {
        super(AbstractBlock.Settings.copy(Blocks.CAULDRON), null, ModCauldronBehavior.APACHE_TEARS_CAULDRON);
        this.setDefaultState((BlockState) ((BlockState) this.stateManager.getDefaultState().with(LEVEL,1)));
    }

    @Override
    public boolean isFull(BlockState state) {
        return false;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
    }
}