package pro.sky.recipebook.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipebook.model.Recipe;
import pro.sky.recipebook.model.Ingredient;
import pro.sky.recipebook.services.impl.RecipeBookServiceImpl;

import java.util.ArrayList;

@RestController
@RequestMapping("/recipes")
public class RecipeBookController {
    private final RecipeBookServiceImpl recipeBookService;

    public RecipeBookController(RecipeBookServiceImpl recipeBookService) {
        this.recipeBookService = recipeBookService;
    }

    @PostMapping("/add")
    public ResponseEntity<Recipe> addIngredient(@RequestParam int id, @RequestParam String name, @RequestParam int time, @RequestParam ArrayList<Ingredient> ingredients, @RequestParam ArrayList<String> steps) {
        recipeBookService.add(id, name, time, ingredients, steps);
        return ResponseEntity.ok().body(recipeBookService.get(id));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Recipe> getIngredient(@PathVariable int id) {
        if (recipeBookService.get(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipeBookService.get(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Recipe> putIngredient(@PathVariable int id, @RequestParam String name, @RequestParam int time, @RequestParam ArrayList<Ingredient> ingredients, @RequestParam ArrayList<String> steps) {
        if (recipeBookService.get(id) == null) {
            return ResponseEntity.notFound().build();
        }
        recipeBookService.edit(id, name, time, ingredients, steps);
        return ResponseEntity.ok(recipeBookService.get(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable int id) {
        if (recipeBookService.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get/all")
    public ResponseEntity<String> getIngredient() {
        return ResponseEntity.ok(recipeBookService.getAll());
    }
}
