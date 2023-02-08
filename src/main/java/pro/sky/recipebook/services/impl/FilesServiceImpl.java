package pro.sky.recipebook.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pro.sky.recipebook.services.FilesService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

@Service
public class FilesServiceImpl implements FilesService {
    @Value("${path.to.data.file}")
    private String dataFilePath;

    @Value("${name.of.ingredients.file}")
    private String ingredientsFileName;

    @Value("${name.of.recipes.file}")
    private String recipesFileName;

    @Override
    public boolean saveToIngredientsFile(String json) {
        Path path = Path.of(dataFilePath, ingredientsFileName);
        try {
            Files.writeString(path, json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveToRecipesFile(String json) {
        Path path = Path.of(dataFilePath, recipesFileName);
        try {
            Files.writeString(path, json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String readFromIngredientsFile() {
        Path path = Path.of(dataFilePath, ingredientsFileName);
        try {
            return Files.readString(path);
        } catch (NoSuchFileException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public String readFromRecipesFile() {
        Path path = Path.of(dataFilePath, recipesFileName);
        try {
            return Files.readString(path);
        } catch (NoSuchFileException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean cleanIngredientsFile() {
        Path path = Path.of(dataFilePath, ingredientsFileName);
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean cleanRecipesFile() {
        Path path = Path.of(dataFilePath, recipesFileName);
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public File getIngredientsFile() {
        return new File(dataFilePath + "/" + ingredientsFileName);
    }

    @Override
    public File getRecipesFile() {
        return new File(dataFilePath + "/" + recipesFileName);
    }

    @Override
    public Path createTempFile(String suffix){
        try {
            return Files.createTempFile(Path.of(dataFilePath),"tempFile",suffix);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    
}
