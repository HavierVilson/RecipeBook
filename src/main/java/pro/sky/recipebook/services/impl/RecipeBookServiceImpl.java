package pro.sky.recipebook.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pro.sky.recipebook.model.Ingredient;
import pro.sky.recipebook.model.Recipe;
import pro.sky.recipebook.services.FilesService;
import pro.sky.recipebook.services.RecipeBookService;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
public class RecipeBookServiceImpl implements RecipeBookService {

    final private FilesService filesService;
    private static HashMap<Integer, Recipe> recipeHashMap;
    private static int id = 1;

    public RecipeBookServiceImpl(FilesService filesService) {
        this.filesService = filesService;
    }

    @PostConstruct
    private void init() {
        readFromFile();
    }

    @Override
    public void add(Recipe recipe) {
        recipeHashMap.put(RecipeBookServiceImpl.id++, recipe);
        saveToFile();
    }

    @Override
    public Recipe get(int id) {
        if (recipeHashMap.get(id) != null){
            return recipeHashMap.get(id);
        }
        return null;
    }

    @Override
    public void edit(int id, Recipe recipe) {
        recipeHashMap.replace(id, recipe);
        saveToFile();
    }

    @Override
    public boolean delete(int id) {
        if (recipeHashMap.get(id) != null) {
            recipeHashMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public String getAll() {
        return recipeHashMap.values().iterator().toString();
    }

    private void saveToFile(){
        try {
            String json = new ObjectMapper().writeValueAsString(recipeHashMap);
            filesService.saveToRecipesFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile(){
        try {
            String json = filesService.readFromRecipesFile();
            if (json != null) {
                recipeHashMap = new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Recipe>>(){});
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
