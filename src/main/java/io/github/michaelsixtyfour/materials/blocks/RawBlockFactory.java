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

public class RawBlockFactory {

    public static ArrayList<Block> blocks = new ArrayList<>();
    public static ArrayList<Item> items = new ArrayList<>();

    public static void rawBlockFactory(String name) {
        final Block RAW_ORE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE)
                .strength(5, 6.0f));
        final Item RAW_ORE_ITEM = new BlockItem(RAW_ORE_BLOCK, new FabricItemSettings().group(Materials.MATERIALS_GROUP));

        Registry.register(Registry.BLOCK, new Identifier(Materials.MOD_ID, name), RAW_ORE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(Materials.MOD_ID, name), RAW_ORE_ITEM);

        blocks.add(RAW_ORE_BLOCK);
        items.add(RAW_ORE_ITEM);
    }
}
