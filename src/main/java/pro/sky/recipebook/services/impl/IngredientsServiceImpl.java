package pro.sky.recipebook.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipebook.model.Ingredient;
import pro.sky.recipebook.services.IngredientsService;

import java.util.HashMap;

@Service
public class IngredientsServiceImpl implements IngredientsService {

    private IngredientsService ingredientsService;
    private static HashMap<Integer, Ingredient> ingredientHashMap;

    @Override
    public void add(int id, String name, int count, String format) {
        ingredientHashMap.getOrDefault(id, new Ingredient(id, name, count, format));
    }

    @Override
    public Ingredient get(int id) {
        for (Ingredient ing : ingredientHashMap.values()) {
            if (ing != null && ing.getId() == id) {
                return ing;
            }
        }
        return null;
    }

    @Override
    public void edit(int id, String name, int count, String format) {
        ingredientHashMap.replace(id, new Ingredient(id, name, count, format));
    }

    @Override
    public boolean delete(int id) {
        if (ingredientHashMap.get(id) != null) {
            ingredientHashMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public String getAll() {
        return ingredientHashMap.values().iterator().toString();
    }
}
