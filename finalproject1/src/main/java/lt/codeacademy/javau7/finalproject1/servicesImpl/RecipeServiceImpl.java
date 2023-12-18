package lt.codeacademy.javau7.finalproject1.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.javau7.finalproject1.entities.Ingredient;
import lt.codeacademy.javau7.finalproject1.entities.Recipe;
import lt.codeacademy.javau7.finalproject1.entities.RecipeIngredient;
import lt.codeacademy.javau7.finalproject1.repositories.RecipeRepository;
import lt.codeacademy.javau7.finalproject1.services.RecipeIngredientService;
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

    private RecipeIngredientService recipeIngredientService;

    public Recipe saveRecipe(Recipe recipe, List<Integer> ingredientIds, List<Integer> quantities) {
        // Išsaugoti receptą į recipe lentelę
        Recipe savedRecipe = recipeRepository.save(recipe);

        // Išsaugoti ingredientus ir kiekius į recipe_ingredients lentelę
        for (int i = 0; i < ingredientIds.size(); i++) {
            Integer ingredientId = ingredientIds.get(i);
            Integer quantity = quantities.get(i);

            Ingredient ingredient = recipeIngredientService.getIngredientById(ingredientId);

            RecipeIngredient recipeIngredient = new RecipeIngredient();
            recipeIngredient.setRecipe(savedRecipe);
            recipeIngredient.setIngredient(ingredient);
            recipeIngredient.setQuantity(quantity);
            recipeIngredientService.saveRecipeIngredient(recipeIngredient);
        }

        return savedRecipe;
    }



    
}
