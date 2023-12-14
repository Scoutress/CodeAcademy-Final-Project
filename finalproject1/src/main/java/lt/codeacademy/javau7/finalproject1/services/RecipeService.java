package lt.codeacademy.javau7.finalproject1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lt.codeacademy.javau7.finalproject1.entities.Recipe;

@Service
public interface RecipeService {
    
    public List<Recipe> findAll();

    public Recipe findById(Long recipeId);

    public void save(Recipe recipe);

    public List<Recipe> findByUserId(int id);

    public void deleteAll(List<Recipe> recipes);

    public void deleteById(Long recipeId);
    
}
