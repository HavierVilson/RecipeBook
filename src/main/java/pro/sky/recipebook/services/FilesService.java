package pro.sky.recipebook.services;

import java.io.File;

public interface FilesService {
    boolean saveToIngredientsFile(String json);

    boolean saveToRecipesFile(String json);

    String readFromIngredientsFile();

    String readFromRecipesFile();

    boolean cleanIngredientsFile();

    boolean cleanRecipesFile();

    File getIngredientsFile();

    File getRecipesFile();
}
