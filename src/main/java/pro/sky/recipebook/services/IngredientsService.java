package pro.sky.recipebook.services;

import pro.sky.recipebook.models.entities.recipe.ingredient.Ingredient;

public interface IngredientsService {
    void add(int id, String name, int count, String format);

    Ingredient get(int id, String name);
}
