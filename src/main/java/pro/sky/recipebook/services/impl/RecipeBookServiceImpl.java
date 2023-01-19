package pro.sky.recipebook.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipebook.model.Ingredient;
import pro.sky.recipebook.model.Recipe;
import pro.sky.recipebook.services.RecipeBookService;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class RecipeBookServiceImpl implements RecipeBookService {
    private static HashMap<Integer, Recipe> recipeHashMap;

    @Override
    public void add(int id, String name, int time, ArrayList<Ingredient> ingredients, ArrayList<String> steps) {
        recipeHashMap.put(id, new Recipe(id, name, time, ingredients, steps));
    }

    @Override
    public Recipe get(int id) {
        for (Recipe res : recipeHashMap.values()) {
            if (res != null && res.getId() == id) {
                return res;
            }
        }
        return null;
    }

    @Override
    public void edit(int id, String name, int time, ArrayList<Ingredient> ingredients, ArrayList<String> steps) {
        recipeHashMap.replace(id, new Recipe(id, name, time, ingredients, steps));
    }

    @Override
    public boolean delete(int id) {
        if (recipeHashMap.get(id) != null) {
            recipeHashMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public String getAll() {
        return recipeHashMap.values().iterator().toString();
    }
}
