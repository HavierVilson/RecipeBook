package pro.sky.recipebook.services;

public interface FilesService {
    boolean saveToIngredientsFile(String json);

    boolean saveToRecipesFile(String json);

    String readFromIngredientsFile();

    String readFromRecipesFile();

    boolean cleanIngredientsFile();

    boolean cleanRecipesFile();
}
