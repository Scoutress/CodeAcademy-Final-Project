package lt.codeacademy.javau7.project.services;

import java.util.List;

import lt.codeacademy.javau7.project.entities.Recipe;

public interface RecipeService {
    
    public List<Recipe> findAll();

    public Recipe findById(Long recipeId);

    public void save(Recipe recipe);

    public List<Recipe> findByUserId(int id);

    public void deleteAll(List<Recipe> recipes);

    public void deleteById(Long recipeId);
    
}
