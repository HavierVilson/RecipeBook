package pro.sky.recipebook.services.impl;

import pro.sky.recipebook.models.entities.recipe.ingredient.Ingredient;
import pro.sky.recipebook.services.IngredientsService;
import pro.sky.recipebook.services.RecipeBookService;

public class IngredientsServiceImpl implements IngredientsService {
    private RecipeBookService recipeBookService;

    @Override
    public void add(int id, String name, int count, String format) {
        recipeBookService.find(id).getIngredients().add(new Ingredient(name,count,format));
    }

    @Override
    public Ingredient get(int id, String name) {
        return recipeBookService.find(id).getIngredients().stream().filter(ingredient -> ingredient.getName().equals(name)).findAny().orElse(null);
    }
}
