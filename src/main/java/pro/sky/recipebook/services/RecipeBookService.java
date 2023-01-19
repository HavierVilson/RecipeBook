package pro.sky.recipebook.services;

import pro.sky.recipebook.model.Recipe;
import pro.sky.recipebook.model.Ingredient;

import java.util.ArrayList;

public interface RecipeBookService {
    void add(int id, String name, int time, ArrayList<Ingredient> ingredients, ArrayList<String> steps);

    Recipe get(int id);

    void edit(int id, String name, int time, ArrayList<Ingredient> ingredients, ArrayList<String> steps);

    boolean delete(int id);

    String getAll();
}
