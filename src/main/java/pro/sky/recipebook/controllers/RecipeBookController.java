package pro.sky.recipebook.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.recipebook.models.entities.recipe.Recipe;
import pro.sky.recipebook.models.entities.recipe.ingredient.Ingredient;
import pro.sky.recipebook.services.impl.RecipeBookServiceImpl;

import java.util.ArrayList;

@RestController
@RequestMapping("/recipes")
public class RecipeBookController {
    private RecipeBookServiceImpl recipeBookService;

    public RecipeBookController(RecipeBookServiceImpl recipeBookService) {
        this.recipeBookService = recipeBookService;
    }

    @GetMapping("/add")
    public void addRecipe(@RequestParam int id, @RequestParam String title, @RequestParam int time, @RequestParam ArrayList<Ingredient> ingredients, @RequestParam String... steps) {
        recipeBookService.add(id, title, time, ingredients, steps);
    }

    @GetMapping("/get")
    public Recipe getRecipeById(@RequestParam int id) {
        return recipeBookService.find(id);
    }
}
