package lt.codeacademy.javau7.finalproject1.servicesImpl;

import lt.codeacademy.javau7.finalproject1.entities.Ingredient;
import lt.codeacademy.javau7.finalproject1.entities.RecipeIngredient;
import lt.codeacademy.javau7.finalproject1.repositories.RecipeIngredientRepository;
import lt.codeacademy.javau7.finalproject1.services.RecipeIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService {

    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;

    @Override
    public Ingredient getIngredientById(Integer ingredientId) {
        Optional<RecipeIngredient> optionalRecipeIngredient = recipeIngredientRepository.findById(ingredientId);
        return optionalRecipeIngredient.map(RecipeIngredient::getIngredient).orElse(null);
    }

    @Override
    public void saveRecipeIngredient(RecipeIngredient recipeIngredient) {
        recipeIngredientRepository.save(recipeIngredient);
    }
}
