package pro.sky.recipebook.models.entities.recipe.ingredient;

import java.util.Objects;

public class Ingredient {
    private String name;
    private int count;
    private String format;


    public Ingredient(String name, int count, String format){
        this.name=name;
        this.format=format;
        this.count=count;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return count == that.count && Objects.equals(name, that.name) && Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count, format);
    }

    @Override
    public String toString() {
        return  name + " " + count + " " + format;
    }
}
