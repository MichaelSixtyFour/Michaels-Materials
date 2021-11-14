package io.github.michaelsixtyfour.materials;

import io.github.michaelsixtyfour.materials.blocks.BlockFactory;
import io.github.michaelsixtyfour.materials.blocks.GrinderBlock;
import io.github.michaelsixtyfour.materials.blocks.GrinderBlockEntity;
import io.github.michaelsixtyfour.materials.blocks.RawBlockFactory;
import io.github.michaelsixtyfour.materials.items.DustFactory;
import io.github.michaelsixtyfour.materials.items.IngotFactory;
import io.github.michaelsixtyfour.materials.items.RawOreFactory;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Materials implements ModInitializer {

    public static final String MOD_ID = "materials";

    public static final ItemGroup MATERIALS_GROUP = FabricItemGroupBuilder.build(
            new Identifier("materials","general"),
            () -> new ItemStack(Materials.TIN_ORE));

    public static final GrinderBlock GRINDER_BLOCK = new GrinderBlock(FabricBlockSettings.of(Material.STONE));
    public static BlockEntityType<GrinderBlockEntity> GRINDER_BLOCK_ENTITY;

    public static final Block TIN_ORE = new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE)
            .strength(5, 6.0f));

    public static final Block LEAD_ORE = new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE)
            .strength(5, 6.0f));

    public static final Block SILVER_ORE = new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE)
            .strength(5, 6.0f));

    public static final Block PLATINUM_ORE = new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE)
            .strength(5, 6.0f));

    public static final Block TITANIUM_ORE = new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE)
            .strength(5, 6.0f));

    public static final Item COAL_NUGGET = new Item(new FabricItemSettings().group(Materials.MATERIALS_GROUP));
    public static final Item CHARCOAL_NUGGET = new Item(new FabricItemSettings().group(Materials.MATERIALS_GROUP));

    public void runFactories() {
        String[] metals = {"tin", "lead", "silver", "platinum", "titanium"};
        String[] vanilla = {"copper", "iron", "gold"};
        //String[] alloys = {"bronze", "steel"};

        for (String metal : metals) {
            RawOreFactory.rawOreFactory("raw_" + metal);
            IngotFactory.ingotFactory(metal + "_ingot");
            BlockFactory.blockFactory(metal + "_block");
            RawBlockFactory.rawBlockFactory("raw_" + metal + "_block");
            DustFactory.dustFactory(metal + "_dust");
        }

        for (String van : vanilla ) {
            DustFactory.dustFactory(van + "_dust");
        }

        //for (String alloy : alloys) {
        //    IngotFactory.ingotFactory(alloy + "_ingot");
        //    BlockFactory.blockFactory(alloy + "_block");
        //}
    }

    @Override
    public void onInitialize() {
        // GRINDER
        Registry.register(Registry.BLOCK, new Identifier(Materials.MOD_ID,"grinder_block"), GRINDER_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(Materials.MOD_ID, "grinder_block"), new BlockItem(GRINDER_BLOCK, new FabricItemSettings().group(Materials.MATERIALS_GROUP)));
        GRINDER_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "materials:grinder_block_entity", FabricBlockEntityTypeBuilder.create(GrinderBlockEntity::new, GRINDER_BLOCK).build(null));

        // TIN ORE
        Registry.register(Registry.BLOCK, new Identifier(Materials.MOD_ID,"tin_ore"), TIN_ORE);
        Registry.register(Registry.ITEM, new Identifier(Materials.MOD_ID, "tin_ore"), new BlockItem(TIN_ORE, new FabricItemSettings().group(Materials.MATERIALS_GROUP)));

        // LEAD ORE
        Registry.register(Registry.BLOCK, new Identifier(Materials.MOD_ID,"lead_ore"), LEAD_ORE);
        Registry.register(Registry.ITEM, new Identifier(Materials.MOD_ID, "lead_ore"), new BlockItem(LEAD_ORE, new FabricItemSettings().group(Materials.MATERIALS_GROUP)));

        // SILVER ORE
        Registry.register(Registry.BLOCK, new Identifier(Materials.MOD_ID, "silver_ore"), SILVER_ORE);
        Registry.register(Registry.ITEM, new Identifier(Materials.MOD_ID, "silver_ore"), new BlockItem(SILVER_ORE, new FabricItemSettings().group(Materials.MATERIALS_GROUP)));

        // PLATINUM ORE
        Registry.register(Registry.BLOCK, new Identifier(Materials.MOD_ID, "platinum_ore"), PLATINUM_ORE);
        Registry.register(Registry.ITEM, new Identifier(Materials.MOD_ID, "platinum_ore"), new BlockItem(PLATINUM_ORE, new FabricItemSettings().group(Materials.MATERIALS_GROUP)));

        // TITANIUM ORE
        Registry.register(Registry.BLOCK, new Identifier(Materials.MOD_ID, "titanium_ore"), TITANIUM_ORE);
        Registry.register(Registry.ITEM, new Identifier(Materials.MOD_ID, "titanium_ore"), new BlockItem(TITANIUM_ORE, new FabricItemSettings().group(Materials.MATERIALS_GROUP)));

        // generate ores/raw ores/ingots
        runFactories();
        OreGenerator.oreInit();

        // nuggets
        Registry.register(Registry.ITEM, new Identifier(Materials.MOD_ID, "coal_nugget"), COAL_NUGGET);
        Registry.register(Registry.ITEM, new Identifier(Materials.MOD_ID, "charcoal_nugget"), CHARCOAL_NUGGET);

        // fuel registry
        FuelRegistry.INSTANCE.add(COAL_NUGGET, 200);
        FuelRegistry.INSTANCE.add(CHARCOAL_NUGGET, 200);


    }
}
