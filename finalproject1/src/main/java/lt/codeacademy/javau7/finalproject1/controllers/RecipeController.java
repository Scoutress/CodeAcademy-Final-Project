package lt.codeacademy.javau7.finalproject1.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.codeacademy.javau7.finalproject1.entities.Recipe;
import lt.codeacademy.javau7.finalproject1.services.RecipeService;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
    
    private RecipeService recipeService;

    public RecipeController(RecipeService theRecipeService){
        recipeService = theRecipeService;
    }

    @GetMapping("/list")
    public String getAllRecipes(Model model) {
        List<Recipe> recipes = recipeService.getAllRecipes();
        model.addAttribute("recipes", recipes);
        return "recipes/recipe-list";
    }
}
