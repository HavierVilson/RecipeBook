package pro.sky.recipebook.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipebook.models.entities.RecipeBook;
import pro.sky.recipebook.models.entities.recipe.Recipe;
import pro.sky.recipebook.models.entities.recipe.ingredient.Ingredient;
import pro.sky.recipebook.services.RecipeBookService;

import java.util.ArrayList;

@Service
public class RecipeBookServiceImpl implements RecipeBookService {
    private RecipeBook recipeBook;

    @Override
    public void add(int id, String title, int time, ArrayList<Ingredient> ingredients, String...steps) {
        recipeBook.addRecipe(id,title,time,ingredients, steps);
    }

    @Override
    public Recipe find(int id) {
        return recipeBook.getRecipe(id);
    }
}
