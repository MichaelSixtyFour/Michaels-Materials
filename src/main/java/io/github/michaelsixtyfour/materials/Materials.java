package io.github.michaelsixtyfour.materials;

import io.github.michaelsixtyfour.materials.init.Creator;
import io.github.michaelsixtyfour.materials.utils.MaterialsRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;

import java.util.Arrays;

public class Materials implements ModInitializer {

    public static final String MOD_ID = "materials";

    public static final ItemGroup MATERIALS_GROUP = FabricItemGroupBuilder.build(
            new Identifier("materials","general"),
            () -> new ItemStack(Creator.Ingots.TIN));

    @Override
    public void onInitialize() {
        Item.Settings itemGroup = new Item.Settings().group(MATERIALS_GROUP);

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
