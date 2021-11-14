package io.github.michaelsixtyfour.materials.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

public class BlockStorage extends Block {

    public BlockStorage() {
        super(FabricBlockSettings.of(Material.METAL).strength(2f, 2f).sounds(BlockSoundGroup.METAL));
    }
}
