package pro.sky.recipebook.models.entities;

import pro.sky.recipebook.models.entities.recipe.Recipe;
import pro.sky.recipebook.models.entities.recipe.ingredient.Ingredient;

import java.util.*;

public class RecipeBook {
    private Map<Integer, Recipe> recipeBook;

    public RecipeBook(){
        this.recipeBook=new HashMap<>();

        recipeBook.put(1, new Recipe("Шарлотка", 30, new ArrayList<>(List.of(new Ingredient("Яблоки", 5, "шт"),
                new Ingredient("Мука", 500, "гр"), new Ingredient("Сахар", 200, "гр"),
                new Ingredient("Разрыхлитель", 10, "гр"))), new LinkedList<>(List.of("Нарезаем яблоки", "кладем в духовку", "смешиваем яйца, сахар и муку", "выливаем в противень поверх яблок", "запекаем полчаса при 180 градусах"))));
    }

    public void addRecipe(int id, String title, int time, ArrayList<Ingredient> ingredients, String...steps){

        recipeBook.put(id, new Recipe(title, time, ingredients, new LinkedList<>(List.of(steps))));

    }

    public Recipe getRecipe(int id){
        return recipeBook.get(id);
    }
}
