package lt.codeacademy.javau7.project.services;

import lt.codeacademy.javau7.project.entities.Ingredient;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IngredientService {

    List<Ingredient> getAllIngredients();
}
