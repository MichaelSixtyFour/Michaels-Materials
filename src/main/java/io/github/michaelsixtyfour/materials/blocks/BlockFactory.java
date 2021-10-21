package io.github.michaelsixtyfour.materials.blocks;

import io.github.michaelsixtyfour.materials.Materials;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;

public class BlockFactory {

    public static ArrayList<Block> blocks = new ArrayList<>();
    public static ArrayList<Item> items = new ArrayList<>();

    public static void blockFactory(String name) {
        final Block METAL_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.METAL)
                .strength(5, 6.0f));
        final Item METAL_ITEM = new BlockItem(METAL_BLOCK, new FabricItemSettings().group(Materials.MATERIALS_GROUP));

        Registry.register(Registry.BLOCK, new Identifier(Materials.MOD_ID, name), METAL_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(Materials.MOD_ID, name), METAL_ITEM);

        blocks.add(METAL_BLOCK);
        items.add(METAL_ITEM);
    }
}
