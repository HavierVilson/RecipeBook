package pro.sky.recipebook.services;

import pro.sky.recipebook.model.Ingredient;

public interface IngredientsService {
    void add(Ingredient ingredient);

    Ingredient get(int id);


    void edit(int id, Ingredient ingredient);

    boolean delete(int id);

    String getAll();
}
