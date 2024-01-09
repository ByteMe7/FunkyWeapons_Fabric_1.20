package net.funkystudios.funkyweapons.util;

import net.funkystudios.funkyweapons.FunkyWeapons;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {


        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(FunkyWeapons.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> SHARD_INFLICTING_ITEMS =
                createTag("shard_inflicting_items");
        public static final TagKey<Item> BLEEDING_INFLICTING_ITEMS =
                createTag("bleeding_inflicting_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(FunkyWeapons.MOD_ID, name));
        }
    }
}
