package pro.sky.recipebook.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipebook.model.Recipe;
import pro.sky.recipebook.services.RecipeBookService;

import java.util.HashMap;

@Service
public class RecipeBookServiceImpl implements RecipeBookService {
    private static HashMap<Integer, Recipe> recipeHashMap;
    private static int id;

    @Override
    public void add(Recipe recipe) {
        recipeHashMap.put(id++, recipe);
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
    public void edit(int id, Recipe recipe) {
        recipeHashMap.replace(id, recipe);
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
