package pro.sky.recipebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;

@Data
@AllArgsConstructor
public class Recipe {
    private final int id;
    private String name;
    private int time;
    private ArrayList<Ingredient> ingredients;
    private LinkedList<String> steps;
}
