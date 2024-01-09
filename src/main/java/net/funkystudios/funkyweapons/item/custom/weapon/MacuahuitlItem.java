package net.funkystudios.funkyweapons.item.custom.weapon;

import net.funkystudios.funkyweapons.alchemy.effect.ModEffects;
import net.funkystudios.funkyweapons.util.ModTags;
import net.funkystudios.funkyweapons.util.NumberFuctions;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class MacuahuitlItem extends SwordItem {
    public MacuahuitlItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        if (!world.isClient) {
            if (NumberFuctions.random(1, 5) == 1) {
                if (stack.isIn(ModTags.Items.SHARD_INFLICTING_ITEMS)) {
                    target.addStatusEffect(new StatusEffectInstance(ModEffects.SHARDS, 160));
                    stack.damage(5, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
                }
                if (stack.isIn(ModTags.Items.BLEEDING_INFLICTING_ITEMS)) {
                    target.addStatusEffect(new StatusEffectInstance(ModEffects.BLEEDING, 400));
                    stack.damage(2, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
                }
            } else if (target instanceof PlayerEntity) {
                PlayerEntity tPlayer = ((PlayerEntity) target);
                if (NumberFuctions.random(1, 8) == 1) {
                    tPlayer.disableShield(tPlayer.isSprinting());
                    stack.damage(2, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
                }
            } else {
                stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
            }
        }
        return true;
    }


}


