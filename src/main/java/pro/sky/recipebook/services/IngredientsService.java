package pro.sky.recipebook.services;

import pro.sky.recipebook.model.Ingredient;

public interface IngredientsService {
    void add(int id, String name, int count, String format);

    Ingredient get(int id);


    void edit(int id, String name, int count, String format);

    boolean delete(int id);

    String getAll();
}
