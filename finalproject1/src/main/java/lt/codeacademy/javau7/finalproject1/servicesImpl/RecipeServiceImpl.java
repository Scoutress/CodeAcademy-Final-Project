package lt.codeacademy.javau7.finalproject1.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lt.codeacademy.javau7.finalproject1.entities.Recipe;
import lt.codeacademy.javau7.finalproject1.repositories.RecipeRepository;
import lt.codeacademy.javau7.finalproject1.services.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

//     @Override
//     public List<Recipe> findAll() {
//         return recipeRepository.findAll();
//     }

//     @Override
//     public Recipe findById(Long recipeId) {
//         Optional<Recipe> optionalRecipe = recipeRepository.findById(recipeId);
//         return optionalRecipe.orElse(null);
//     }

//     @Override
//     public void save(Recipe recipe) {
//         recipeRepository.save(recipe);
//     }

//     @Override
//     public List<Recipe> findByUserId(int userId) {
//         return recipeRepository.findByUserId(userId);
//     }

//     @Override
//     public void deleteAll(List<Recipe> recipes) {
//         recipeRepository.deleteAll(recipes);
//     }

//     @Override
//     public void deleteById(Long recipeId) {
//         recipeRepository.deleteById(recipeId);
//     }

}
