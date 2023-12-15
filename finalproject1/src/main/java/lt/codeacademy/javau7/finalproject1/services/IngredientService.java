package lt.codeacademy.javau7.finalproject1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lt.codeacademy.javau7.finalproject1.entities.Ingredient;

@Service
public interface IngredientService {

    List<Ingredient> getAllIngred();

    void addIngredient(Ingredient ingredient);
}
