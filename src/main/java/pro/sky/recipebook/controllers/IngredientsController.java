package pro.sky.recipebook.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipebook.model.Ingredient;
import pro.sky.recipebook.services.impl.IngredientsServiceImpl;

@RestController
@RequestMapping("/ingredients")
@Tag(name = "Ингридиетны", description = "CRUD операции и другие эндпоинты для работы с ингридиентами")
public class IngredientsController {
    private final IngredientsServiceImpl ingredientsService;

    public IngredientsController(IngredientsServiceImpl ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @PostMapping("/add")
    @Operation(summary = "Добавление ингридиента", description = "Создает новый ингридиент")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Ингридтиент добавлен",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = Ingredient.class)
                                    )
                            }
                    )
            }
    )
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient) {
        ingredientsService.add(ingredient);
        return ResponseEntity.ok().body(ingredient);
    }

    @GetMapping("{id}")
    @Operation(summary = "Поиск ингридиента", description = "Поиск ингридиента по ID")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Ингридтиент найден",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = Ingredient.class)
                                    )
                            }
                    )
            }
    )
    public ResponseEntity<Ingredient> getIngredient(@PathVariable int id) {
        if (ingredientsService.get(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredientsService.get(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изминение ингридиента", description = "Изминение ингридиента по ID")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Ингридтиент изменен",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = Ingredient.class)
                                    )
                            }
                    )
            }
    )
    public ResponseEntity<Ingredient> putIngredient(@PathVariable int id, @RequestBody Ingredient ingredient) {
        if (ingredientsService.get(id) == null) {
            return ResponseEntity.notFound().build();
        }
        ingredientsService.edit(id, ingredient);
        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление ингридиента", description = "Удаление ингридиента по ID")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Ингридтиент удален",
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
        if (ingredientsService.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    @Operation(summary = "Вывод всех ингридиента", description = "Выводит все ингридиенты")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Ингридтиенты выведены",
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
        return ResponseEntity.ok(ingredientsService.getAll());
    }
}
