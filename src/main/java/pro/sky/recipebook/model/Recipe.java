package pro.sky.recipebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    private String name;
    private int time;
    private ArrayList<Ingredient> ingredients;
    private LinkedList<String> steps;
}
