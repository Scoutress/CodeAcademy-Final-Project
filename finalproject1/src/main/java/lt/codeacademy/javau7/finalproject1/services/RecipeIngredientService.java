package lt.codeacademy.javau7.finalproject1.services;

import lt.codeacademy.javau7.finalproject1.entities.Ingredient;
import lt.codeacademy.javau7.finalproject1.entities.RecipeIngredient;

public interface RecipeIngredientService {

    Ingredient getIngredientById(Integer ingredientId);

    void saveRecipeIngredient(RecipeIngredient recipeIngredient);
    
}
