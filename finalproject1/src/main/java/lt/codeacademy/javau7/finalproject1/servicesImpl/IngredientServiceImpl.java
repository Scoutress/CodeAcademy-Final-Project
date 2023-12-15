package lt.codeacademy.javau7.finalproject1.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import lt.codeacademy.javau7.finalproject1.entities.Ingredient;
import lt.codeacademy.javau7.finalproject1.repositories.IngredientRepository;
import lt.codeacademy.javau7.finalproject1.services.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> getAllIngred() {
        return ingredientRepository.findAll();
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteIngredientById(int theId) {
        ingredientRepository.deleteById(theId);
    }

    @Override
    public void saveIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient findById(int theId) {
        return ingredientRepository.findById(theId).orElse(null);
    }

}
