package lt.codeacademy.javau7.project.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import lt.codeacademy.javau7.project.entities.Recipe;
import lt.codeacademy.javau7.project.repositories.RecipeRepository;
import lt.codeacademy.javau7.project.services.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }
}
