package pro.sky.recipebook.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.recipebook.models.entities.recipe.ingredient.Ingredient;
import pro.sky.recipebook.services.impl.IngredientsServiceImpl;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {
    private IngredientsServiceImpl ingredientsService;

    public IngredientsController(IngredientsServiceImpl ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping("/add")
    public void addIngredient(@RequestParam int id, @RequestParam String name, @RequestParam int count, @RequestParam String format){
        ingredientsService.add(id, name, count, format);
    }
    @GetMapping("/get")
    public Ingredient getIngredient(@RequestParam int id, @RequestParam String name){
        return ingredientsService.get(id,name);
    }
}
