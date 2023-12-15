package lt.codeacademy.javau7.finalproject1.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lt.codeacademy.javau7.finalproject1.entities.Recipe;
import lt.codeacademy.javau7.finalproject1.repositories.RecipeRepository;
import lt.codeacademy.javau7.finalproject1.services.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public void addRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public void deleteRecipeById(int id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public Recipe findById(int theId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(theId);
        return recipeOptional.orElse(null);
    }

    @Override
    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }



    
}
