package io.github.michaelsixtyfour.materials.utils;

import io.github.michaelsixtyfour.materials.Materials;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class InitUtility {
    public static <I extends Item> I setup(I item, String name) {
        MaterialsRegistry.registerIdent(item, new Identifier(Materials.MOD_ID, name));
        return item;
    }

    public static <B extends Block> B setup(B block, String name) {
        MaterialsRegistry.registerIdent(block, new Identifier(Materials.MOD_ID, name));
        return block;
    }
}
