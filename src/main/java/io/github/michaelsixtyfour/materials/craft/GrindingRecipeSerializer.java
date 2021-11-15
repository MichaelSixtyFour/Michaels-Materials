package io.github.michaelsixtyfour.materials.craft;

import com.google.gson.JsonObject;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.util.Identifier;

public class GrindingRecipeSerializer extends ShapelessRecipe.Serializer {

    public static final GrindingRecipeSerializer INSTANCE = new GrindingRecipeSerializer();

    @Override
    public ShapelessRecipe read(Identifier identifier, JsonObject jsonObject) {
        return new GrindingRecipe(super.read(identifier, jsonObject));
    }

    @Override
    public ShapelessRecipe read(Identifier identifier, PacketByteBuf packetByteBuf) {
        return new GrindingRecipe(super.read(identifier, packetByteBuf));
    }


}
