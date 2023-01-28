package pro.sky.recipebook.services;

import pro.sky.recipebook.model.Recipe;
import pro.sky.recipebook.model.Ingredient;

import java.util.ArrayList;

public interface RecipeBookService {
    void add(Recipe recipe);

    Recipe get(int id);

    void edit(int id, Recipe recipe);

    boolean delete(int id);

    String getAll();
}
