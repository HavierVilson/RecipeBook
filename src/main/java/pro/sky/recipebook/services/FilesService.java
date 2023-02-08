package pro.sky.recipebook.services;

import java.io.File;
import java.nio.file.Path;

public interface FilesService {
    boolean saveToIngredientsFile(String json);

    boolean saveToRecipesFile(String json);

    String readFromIngredientsFile();

    String readFromRecipesFile();

    boolean cleanIngredientsFile();

    boolean cleanRecipesFile();

    File getIngredientsFile();

    File getRecipesFile();

    Path createTempFile(String suffix);
}
