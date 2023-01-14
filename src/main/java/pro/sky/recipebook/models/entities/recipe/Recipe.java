package pro.sky.recipebook.models.entities.recipe;

import pro.sky.recipebook.models.entities.recipe.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class Recipe {
    private String title;

    private int time;

    private ArrayList<Ingredient> ingredients;

    private LinkedList<String> stepsOfCooking;

    public Recipe(String title, int time, ArrayList<Ingredient> ingredients, LinkedList<String> stepsOfCooking){
        this.title = title;
        this.time = time;
        this.ingredients = ingredients;
        this.stepsOfCooking = stepsOfCooking;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public LinkedList<String> getStepsOfCooking() {
        return stepsOfCooking;
    }

    public void setStepsOfCooking(LinkedList<String> stepsOfCooking) {
        this.stepsOfCooking = stepsOfCooking;
    }

    @Override
    public String toString() {
        return title + time + ingredients + stepsOfCooking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe receipe = (Recipe) o;
        return time == receipe.time && Objects.equals(title, receipe.title) && Objects.equals(ingredients, receipe.ingredients) && Objects.equals(stepsOfCooking, receipe.stepsOfCooking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, time, ingredients, stepsOfCooking);
    }
}
