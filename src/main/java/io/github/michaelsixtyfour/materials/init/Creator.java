package io.github.michaelsixtyfour.materials.init;

import io.github.michaelsixtyfour.materials.Materials;
import io.github.michaelsixtyfour.materials.blocks.BlockStorage;
import io.github.michaelsixtyfour.materials.tools.MortarAndPestleTool;
import io.github.michaelsixtyfour.materials.world.DataDrivenFeature;
import io.github.michaelsixtyfour.materials.utils.InitUtility;
import io.github.michaelsixtyfour.materials.utils.MiningLevel;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Creator {

    /** Ores **/
    public enum Ores implements ItemConvertible {
        TIN(16, 16, 10, 72, MiningLevel.IRON),
        LEAD(12, 16, 10, 64, MiningLevel.IRON),
        SILVER(8, 12, 0, 48, MiningLevel.IRON),
        PLATINUM(8, 8, 0, 32, MiningLevel.IRON),
        TITANIUM(8, 8, 0, 32, MiningLevel.IRON);

        public final String name;
        public final Block block;
        public final int veinSize;
        public final int veinsPerChunk;
        public final int minY;
        public final int maxY;

        Ores(int veinSize, int veinsPerChunk, int minY, int maxY, MiningLevel miningLevel) {
            name = this.toString().toLowerCase(Locale.ROOT);
            block = new Block(FabricBlockSettings.of(Material.STONE)
                    .breakByTool(FabricToolTags.PICKAXES, miningLevel.intLevel)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
                    .strength(2f, 2f)
            );
            this.veinSize = veinSize;
            this.veinsPerChunk = veinsPerChunk;
            this.minY = minY;
            this.maxY = maxY;
            InitUtility.setup(block, name + "_ore");
        }

        @Override
        public Item asItem() {
            return block.asItem();
        }

        public DataDrivenFeature asNewOres(Identifier identifier, Predicate<BiomeSelectionContext> targetType, RuleTest ruleTest) {
            return new DataDrivenFeature(identifier, targetType, ruleTest, block.getDefaultState(), maxY, veinSize, veinsPerChunk);
        }
    }

    /** Metal Blocks **/
    public enum StorageBlocks implements ItemConvertible {
        TIN, LEAD, SILVER, PLATINUM, TITANIUM;

        public final String name;
        public final Block block;

        StorageBlocks() {
            name = this.toString().toLowerCase(Locale.ROOT);
            block = new BlockStorage();
            InitUtility.setup(block, name + "_block");
        }

        @Override
        public Item asItem() {
            return block.asItem();
        }

        public static Stream<Block> blockStream() {
            return Arrays.stream(values())
                    .map(StorageBlocks::allBlocks)
                    .flatMap(Collection::stream);
        }

        private List<Block> allBlocks() {
            return List.of(block);
        }
    }

    /** Raw Ore Blocks **/
    public enum RawStorageBlocks implements ItemConvertible {
        TIN, LEAD, SILVER, PLATINUM, TITANIUM;

        public final String name;
        public final Block block;

        RawStorageBlocks() {
            name = this.toString().toLowerCase(Locale.ROOT);
            block = new BlockStorage();
            InitUtility.setup(block, "raw_" + name + "_block");
        }

        @Override
        public Item asItem() {
            return block.asItem();
        }

        public static Stream<Block> blockStream() {
            return Arrays.stream(values())
                    .map(RawStorageBlocks::allBlocks)
                    .flatMap(Collection::stream);
        }

        private List<Block> allBlocks() {
            return List.of(block);
        }
    }

    /** Ingots **/
    public enum Ingots implements ItemConvertible {
        TIN, LEAD, SILVER, PLATINUM, TITANIUM;

        public final String name;
        public final Item item;

        Ingots() {
            name = this.toString().toLowerCase(Locale.ROOT);
            item = new Item(new Item.Settings().group(Materials.MATERIALS_GROUP));
            InitUtility.setup(item, name + "_ingot");
        }

        public ItemStack getStack() {
            return new ItemStack(item);
        }

        public ItemStack getStack(int amount) {
            return new ItemStack(item, amount);
        }

        @Override
        public Item asItem() {
            return item;
        }
    }

    /** Raw Ores **/
    public enum RawOres implements ItemConvertible {
        TIN, LEAD, SILVER, PLATINUM, TITANIUM;

        public final String name;
        public final Item item;

        RawOres() {
            name = this.toString().toLowerCase(Locale.ROOT);
            item = new Item(new Item.Settings().group(Materials.MATERIALS_GROUP));
            InitUtility.setup(item, "raw_" + name);
        }

        public ItemStack getStack() {
            return new ItemStack(item);
        }

        public ItemStack getStack(int amount) {
            return new ItemStack(item, amount);
        }

        @Override
        public Item asItem() {
            return item;
        }
    }

    /** Dusts **/
    public enum Dusts implements ItemConvertible {
        TIN, LEAD, SILVER, PLATINUM, TITANIUM;

        public final String name;
        public final Item item;

        Dusts() {
            name = this.toString().toLowerCase(Locale.ROOT);
            item = new Item(new Item.Settings().group(Materials.MATERIALS_GROUP));
            InitUtility.setup(item, name + "_dust");
        }

        public ItemStack getStack() {
            return new ItemStack(item);
        }

        public ItemStack getStack(int amount) {
            return new ItemStack(item, amount);
        }

        @Override
        public Item asItem() {
            return item;
        }
    }

    /** Nuggets **/
    public enum Nuggets implements ItemConvertible {
        COAL, CHARCOAL, TIN, LEAD, SILVER, PLATINUM, TITANIUM;

        public final String name;
        public final Item item;

        Nuggets() {
            name = this.toString().toLowerCase(Locale.ROOT);
            item = new Item(new Item.Settings().group(Materials.MATERIALS_GROUP));
            InitUtility.setup(item, name + "_nugget");
        }

        public ItemStack getStack() {
            return new ItemStack(item);
        }

        public ItemStack getStack(int amount) {
            return new ItemStack(item, amount);
        }

        @Override
        public Item asItem() {
            return item;
        }
    }
}
