package lt.codeacademy.javau7.finalproject1.services;

import lt.codeacademy.javau7.finalproject1.entities.Ingredient;

import java.util.List;

public interface IngredientService {

    List<Ingredient> getAllIngred();

    void addIngredient(Ingredient ingredient);

    void deleteIngredientById(int theId);

    Ingredient findById(int theId);

    void saveIngredient(Ingredient ingredient);

    Ingredient getIngredientById(Integer ingredientId);
}
