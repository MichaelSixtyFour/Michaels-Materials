package io.github.michaelsixtyfour.materials;

import io.github.michaelsixtyfour.materials.init.Creator;
import io.github.michaelsixtyfour.materials.craft.GrindingRecipeSerializer;
import io.github.michaelsixtyfour.materials.tools.MortarAndPestleTool;
import io.github.michaelsixtyfour.materials.tools.MortarAndPestleToolMaterial;
import io.github.michaelsixtyfour.materials.utils.InitUtility;
import io.github.michaelsixtyfour.materials.utils.MaterialsRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Arrays;

public class Materials implements ModInitializer {

    public static final String MOD_ID = "materials";

    public static final ItemGroup MATERIALS_GROUP = FabricItemGroupBuilder.build(
            new Identifier("materials","general"),
            () -> new ItemStack(Creator.Ingots.TIN));

    public static final Item MORTAR_AND_PESTLE = new MortarAndPestleTool(new MortarAndPestleToolMaterial(), new FabricItemSettings().group(MATERIALS_GROUP));

    @Override
    public void onInitialize() {
        Item.Settings itemGroup = new Item.Settings().group(MATERIALS_GROUP);

        Registry.register(Registry.RECIPE_SERIALIZER, InitUtility.makeId("grinding"), GrindingRecipeSerializer.INSTANCE);

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "mortar_and_pestle"), MORTAR_AND_PESTLE);

        // Bulk Registry
        Arrays.stream(Creator.Ores.values()).forEach(value -> MaterialsRegistry.registerBlock(value.block, itemGroup));
        Arrays.stream(Creator.StorageBlocks.values()).forEach(value -> MaterialsRegistry.registerBlock(value.block, itemGroup));
        Arrays.stream(Creator.RawStorageBlocks.values()).forEach(value -> MaterialsRegistry.registerBlock(value.block, itemGroup));

        Arrays.stream(Creator.Ingots.values()).forEach(value -> MaterialsRegistry.registerItem(value.item));
        Arrays.stream(Creator.Nuggets.values()).forEach(value -> MaterialsRegistry.registerItem(value.item));
        Arrays.stream(Creator.Dusts.values()).forEach(value -> MaterialsRegistry.registerItem(value.item));
        Arrays.stream(Creator.RawOres.values()).forEach(value -> MaterialsRegistry.registerItem(value.item));

        // Fuels
        FuelRegistry.INSTANCE.add(Creator.Nuggets.COAL, 200);
        FuelRegistry.INSTANCE.add(Creator.Nuggets.CHARCOAL, 200);


    }
}
