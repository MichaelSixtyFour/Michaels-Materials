package io.github.michaelsixtyfour.materials.items;

import io.github.michaelsixtyfour.materials.Materials;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;

public class RawOreFactory {
    public static ArrayList<Item> items = new ArrayList<>();

    public static void rawOreFactory(String name) {
        final Item RAW_ORE = new Item(new FabricItemSettings().group(Materials.MATERIALS_GROUP));

        Registry.register(Registry.ITEM, new Identifier(Materials.MOD_ID, name), RAW_ORE);

        items.add(RAW_ORE);
    }
}
