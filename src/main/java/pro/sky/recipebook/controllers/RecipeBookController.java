package pro.sky.recipebook.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipebook.model.Recipe;
import pro.sky.recipebook.model.Ingredient;
import pro.sky.recipebook.services.impl.RecipeBookServiceImpl;

import java.util.ArrayList;

@RestController
@RequestMapping("/recipes")
@Tag(name = "Рецепты", description = "CRUD операции и другие эндпоинты для работы с рецептами")
public class RecipeBookController {
    private final RecipeBookServiceImpl recipeBookService;

    public RecipeBookController(RecipeBookServiceImpl recipeBookService) {
        this.recipeBookService = recipeBookService;
    }

    @PostMapping("/add")
    @Operation(summary = "Добавление рецепта", description = "Создает новый рецепт")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Рецепт добавлен",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = Ingredient.class)
                                    )
                            }
                    )
            }
    )
    public ResponseEntity<Recipe> addIngredient(@RequestBody Recipe recipe) {
        recipeBookService.add(recipe);
        return ResponseEntity.ok().body(recipe);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Поиск рецепта", description = "Поиск рецепта поп ID")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Рецепт найден",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = Ingredient.class)
                                    )
                            }
                    )
            }
    )
    public ResponseEntity<Recipe> getIngredient(@PathVariable int id) {
        if (recipeBookService.get(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipeBookService.get(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изминение рецепта", description = "Изменяет рецепт")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Рецепт изменен",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = Ingredient.class)
                                    )
                            }
                    )
            }
    )
    public ResponseEntity<Recipe> putIngredient(@PathVariable int id, @RequestBody Recipe recipe) {
        if (recipeBookService.get(id) == null) {
            return ResponseEntity.notFound().build();
        }
        recipeBookService.edit(id, recipe);
        return ResponseEntity.ok(recipeBookService.get(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление рецепта", description = "Удаляет рецепт")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Рецепт удален",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = Ingredient.class)
                                    )
                            }
                    )
            }
    )
    public ResponseEntity<Void> deleteIngredient(@PathVariable int id) {
        if (recipeBookService.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    @Operation(summary = "Вывод всех рецептов", description = "Выводит все рецепты")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Все рецепты выведены",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = Ingredient.class)
                                    )
                            }
                    )
            }
    )
    public ResponseEntity<String> getIngredient() {
        return ResponseEntity.ok(recipeBookService.getAll());
    }
}
