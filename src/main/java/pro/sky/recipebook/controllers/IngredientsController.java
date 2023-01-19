package pro.sky.recipebook.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipebook.model.Ingredient;
import pro.sky.recipebook.services.impl.IngredientsServiceImpl;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {
    private final IngredientsServiceImpl ingredientsService;

    public IngredientsController(IngredientsServiceImpl ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @PostMapping("/add")
    public ResponseEntity<Ingredient> addIngredient(@RequestParam int id, @RequestParam String name, @RequestParam int count, @RequestParam String format) {
        ingredientsService.add(id, name, count, format);
        return ResponseEntity.ok().body(ingredientsService.get(id));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable int id) {
        if (ingredientsService.get(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredientsService.get(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Ingredient> putIngredient(@PathVariable int id, @RequestParam String name, @RequestParam int count, @RequestParam String format) {
        if (ingredientsService.get(id) == null) {
            return ResponseEntity.notFound().build();
        }
        ingredientsService.edit(id, name, count, format);
        return ResponseEntity.ok(ingredientsService.get(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable int id) {
        if (ingredientsService.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get/all")
    public ResponseEntity<String> getIngredient() {
        return ResponseEntity.ok(ingredientsService.getAll());
    }
}