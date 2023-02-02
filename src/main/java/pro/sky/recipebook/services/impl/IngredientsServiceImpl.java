package pro.sky.recipebook.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pro.sky.recipebook.model.Ingredient;
import pro.sky.recipebook.services.FilesService;
import pro.sky.recipebook.services.IngredientsService;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
public class IngredientsServiceImpl implements IngredientsService {

    final private FilesService filesService;

    private IngredientsService ingredientsService;
    private static HashMap<Integer, Ingredient> ingredientHashMap = new HashMap<>();
    private static int id = 1;

    public IngredientsServiceImpl(FilesService filesService) {
        this.filesService = filesService;
    }

    @PostConstruct
    private void init() {
        readFromFile();
    }

    @Override
    public void add(Ingredient ingredient) {
        ingredientHashMap.put(IngredientsServiceImpl.id++, ingredient);
        saveToFile();
    }

    @Override
    public Ingredient get(int id) {
        if (ingredientHashMap.get(id) != null){
            return ingredientHashMap.get(id);
        }
        return null;
    }

    @Override
    public void edit(int id, Ingredient ingredient) {
        ingredientHashMap.replace(id, ingredient);
        saveToFile();
    }

    @Override
    public boolean delete(int id) {
        if (ingredientHashMap.get(id) != null) {
            ingredientHashMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public String getAll() {
        return ingredientHashMap.values().toString();
    }

    private void saveToFile(){
        try {
            String json = new ObjectMapper().writeValueAsString(ingredientHashMap);
            filesService.saveToIngredientsFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile(){
        try {
            String json = filesService.readFromIngredientsFile();
            if (json != null) {
                ingredientHashMap = new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Ingredient>>(){});
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
