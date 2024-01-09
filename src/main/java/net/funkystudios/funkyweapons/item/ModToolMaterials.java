package net.funkystudios.funkyweapons.item;

import net.funkystudios.funkyweapons.block.ModBlocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {
    TURQUOISE(5, 287, 6.7f,5.3f,54,
            ()-> Ingredient.ofItems(ModItems.TURQUOISE)),
    OBSIDIAN(5,3561,10.5f,5.0f,6,
            () -> Ingredient.ofItems(Items.CRYING_OBSIDIAN)),
    TURQUOISE_OBSIDIAN(5,5031, 12.3f,6.0f, 45,
            () -> Ingredient.ofItems(ModBlocks.TURQUOISE_OBSIDIAN));
    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attckDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attckDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
