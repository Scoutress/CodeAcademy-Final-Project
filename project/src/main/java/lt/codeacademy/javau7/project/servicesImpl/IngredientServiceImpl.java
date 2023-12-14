package lt.codeacademy.javau7.project.servicesImpl;

import lt.codeacademy.javau7.project.entities.Ingredient;
import lt.codeacademy.javau7.project.repositories.IngredientRepository;
import lt.codeacademy.javau7.project.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }
}
