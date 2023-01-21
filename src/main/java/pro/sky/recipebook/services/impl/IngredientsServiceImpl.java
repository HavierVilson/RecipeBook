package pro.sky.recipebook.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipebook.model.Ingredient;
import pro.sky.recipebook.services.IngredientsService;

import java.util.HashMap;

@Service
public class IngredientsServiceImpl implements IngredientsService {

    private IngredientsService ingredientsService;
    private static HashMap<Integer, Ingredient> ingredientHashMap;
    private static int id = 1;

    @Override
    public void add(Ingredient ingredient) {
        ingredientHashMap.getOrDefault(IngredientsServiceImpl.id++, ingredient);
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
    public void edit(int id, Ingredient ingredient) {
        ingredientHashMap.replace(id, ingredient);
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
