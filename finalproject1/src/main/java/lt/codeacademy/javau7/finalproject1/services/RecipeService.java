package lt.codeacademy.javau7.finalproject1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lt.codeacademy.javau7.finalproject1.entities.Recipe;

@Service
public interface RecipeService {

    public List<Recipe> getAllRecipes();

    public void addRecipe(Recipe recipe);

    public void deleteRecipeById(int id);

    public Recipe findById(int theId);

    public void saveRecipe(Recipe recipe);
    
}
