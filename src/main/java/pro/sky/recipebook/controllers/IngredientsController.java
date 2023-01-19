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
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient) {
        ingredientsService.add(ingredient);
        return ResponseEntity.ok().body(ingredient);
    }

    @GetMapping("{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable int id) {
        if (ingredientsService.get(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredientsService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> putIngredient(@PathVariable int id, @RequestBody Ingredient ingredient) {
        if (ingredientsService.get(id) == null) {
            return ResponseEntity.notFound().build();
        }
        ingredientsService.edit(id, ingredient);
        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable int id) {
        if (ingredientsService.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<String> getIngredient() {
        return ResponseEntity.ok(ingredientsService.getAll());
    }
}
