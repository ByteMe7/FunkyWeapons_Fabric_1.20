package net.funkystudios.funkyweapons.item.custom;

import net.funkystudios.funkyweapons.item.ModItems;
import net.funkystudios.funkyweapons.util.ModTags;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoneyBottleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

import java.util.Objects;

public class DrinkItem extends HoneyBottleItem {
    private final int USE_TIME;
    private final ItemStack RETURN_ITEM;

    public DrinkItem(Settings settings, int useTime, Item returnItem) {
        super(settings);
        this.USE_TIME = useTime;
        this.RETURN_ITEM = new ItemStack(returnItem);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if(user instanceof ServerPlayerEntity){
            ServerPlayerEntity serverPlayer = ((ServerPlayerEntity) user);
            Criteria.CONSUME_ITEM.trigger(serverPlayer,stack);
            serverPlayer.incrementStat(Stats.USED.getOrCreateStat(this));
        }
        if (!world.isClient){
            Objects.requireNonNull(stack.getItem().getFoodComponent()).getStatusEffects().forEach(effect ->{
                user.addStatusEffect(effect.getFirst());
            });
            if (stack.isEmpty()){
                return this.RETURN_ITEM;
            }
            if (user instanceof PlayerEntity && !((PlayerEntity) user).getAbilities().creativeMode){
                PlayerEntity player = (PlayerEntity) user;
               if(!player.getInventory().insertStack(this.RETURN_ITEM)) player.dropItem(this.RETURN_ITEM,false);
            }

        }
        return stack;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return this.USE_TIME;
    }
}
