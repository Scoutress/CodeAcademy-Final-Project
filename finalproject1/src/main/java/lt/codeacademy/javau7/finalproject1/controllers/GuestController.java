package lt.codeacademy.javau7.finalproject1.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lt.codeacademy.javau7.finalproject1.entities.Recipe;
import lt.codeacademy.javau7.finalproject1.services.RecipeService;

@Controller
public class GuestController {

    private final RecipeService recipeService;

    public GuestController(RecipeService theRecipeService) {
        this.recipeService = theRecipeService;
    }

    @GetMapping("")
    public String getAllRecipes(Model model) {
        List<Recipe> recipes = recipeService.findAll();
        model.addAttribute("recipes", recipes);
        return "recipes/recipe-list";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @GetMapping("/recipe/{recipe_id}")
    public String showRecipe(@PathVariable("recipe_id") Long recipeId, Model model) {
        Recipe recipe = recipeService.findById(recipeId);
        model.addAttribute("recipe", recipe);
        return "recipes/recipe-details";
    }
}
