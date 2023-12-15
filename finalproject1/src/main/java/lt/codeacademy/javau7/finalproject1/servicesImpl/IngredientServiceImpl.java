package lt.codeacademy.javau7.finalproject1.servicesImpl;

import java.util.List;
import lt.codeacademy.javau7.finalproject1.entities.Ingredient;
import lt.codeacademy.javau7.finalproject1.repositories.IngredientRepository;
import lt.codeacademy.javau7.finalproject1.services.IngredientService;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getAllIngred() {
        return ingredientRepository.findAll();
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }
}
