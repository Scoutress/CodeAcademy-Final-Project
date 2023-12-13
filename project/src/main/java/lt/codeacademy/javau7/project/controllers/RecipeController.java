package lt.codeacademy.javau7.project.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.codeacademy.javau7.project.entities.Recipe;
import lt.codeacademy.javau7.project.services.RecipeService;

@Controller
@RequestMapping("/recipes")
public class RecipeController {
    
    private final RecipeService recipeService;
    
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/all")
    public String getAllRecipes(Model model) {
        List<Recipe> recipes = recipeService.findAll();
        model.addAttribute("recipes", recipes);
        return "recipe-list";
    }
}
