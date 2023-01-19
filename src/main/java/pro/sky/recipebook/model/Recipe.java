package pro.sky.recipebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Recipe {
    private final int id;
    private String name;
    private int time;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<String> steps;
}
