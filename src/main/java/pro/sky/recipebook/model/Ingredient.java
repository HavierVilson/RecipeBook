package pro.sky.recipebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {
    private final int id;
    private String name;
    private int count;
    private String format;
}
