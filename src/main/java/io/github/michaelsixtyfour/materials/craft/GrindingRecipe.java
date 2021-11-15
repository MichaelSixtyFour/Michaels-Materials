package io.github.michaelsixtyfour.materials.craft;

import io.github.michaelsixtyfour.materials.tools.MortarAndPestleTool;
import io.github.michaelsixtyfour.materials.mixins.ShapelessRecipeMixin;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.util.collection.DefaultedList;

public class GrindingRecipe extends ShapelessRecipe {

    public GrindingRecipe(ShapelessRecipe original) {
        super(
                original.getId(),
                ((ShapelessRecipeMixin) original).getGroup(),
                original.getOutput(),
                original.getIngredients()
        );
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return GrindingRecipeSerializer.INSTANCE;
    }

    @Override
    public DefaultedList<ItemStack> getRemainder(CraftingInventory inventory) {
        DefaultedList<ItemStack> defaultedList = DefaultedList.ofSize(inventory.size(), ItemStack.EMPTY);

        for (int i = 0; i < defaultedList.size(); ++i) {
            ItemStack stack = inventory.getStack(i);
            Item item = stack.getItem();
            if (item instanceof MortarAndPestleTool) {
                // If it still has durability left, put a more damaged one back, otherwise consume
                int newDamage = stack.getDamage() + 1;
                if (newDamage < stack.getMaxDamage()) {
                    stack = stack.copy();
                    stack.setDamage(newDamage);
                    defaultedList.set(i, stack);
                }
            } else if (item.hasRecipeRemainder()) {
                defaultedList.set(i, new ItemStack(item.getRecipeRemainder()));
            }
        }

        return defaultedList;
    }

}