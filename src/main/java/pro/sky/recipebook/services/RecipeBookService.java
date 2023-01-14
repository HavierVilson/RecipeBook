package pro.sky.recipebook.services;

import pro.sky.recipebook.models.entities.recipe.Recipe;
import pro.sky.recipebook.models.entities.recipe.ingredient.Ingredient;

import java.util.ArrayList;

public interface RecipeBookService {
    void add(int id, String title, int time, ArrayList<Ingredient> ingredients, String...strings);
    Recipe find(int id);
}
